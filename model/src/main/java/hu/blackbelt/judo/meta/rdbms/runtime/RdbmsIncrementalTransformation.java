package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
 * %%
 * Copyright (C) 2018 - 2022 BlackBelt Technology
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.RdbmsCreateFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsCreateTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsDeleteFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsDeleteTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsFactory;
import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyFieldOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsModifyTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta;
import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Computes the incremental (diff) operation model of two RDBMS models with plain Java and EMF.
 *
 * <p>This is a line-by-line port of {@code transformations/createIncrementalOperationModel.etl}: the produced
 * incremental model is structurally identical to the one created by the ETL ({@link RdbmsIncremental}, which is kept
 * as the equivalence oracle), including operation order, uuid suffixes, review policy and the preserved gaps:
 * <ul>
 *   <li>a junction table whose {@code sqlName} is the only change produces no operation;</li>
 *   <li>index and unique constraint changes produce no operation (both are false "compatible" results, JNG-6448).</li>
 * </ul>
 * Where the ETL fails, this class fails closed with an {@link IllegalStateException} (never a "compatible" result):
 * <ul>
 *   <li>every field rule except the foreign key modification asks for the plain table modify operation, so a field
 *   change on an existing junction table fails;</li>
 *   <li>a created identifier field on an existing table fails (the ETL assigns {@code isIdentifierField}, which the
 *   metamodel does not have);</li>
 *   <li>a plain table with only a {@code sqlName} change fails (the ETL does not create the modify operation on demand
 *   in the rename rule);</li>
 *   <li>a deleted foreign key or identifier field of a table which has no field left fails.</li>
 * </ul>
 * The models are not validated (the ETL validates them when it commits): callers pass valid models.
 * The class loads no Epsilon type.
 */
public final class RdbmsIncrementalTransformation {

    private static final Logger LOG = LoggerFactory.getLogger(RdbmsIncrementalTransformation.class);

    private RdbmsIncrementalTransformation() {
    }

    /**
     * Fills {@code incrementalModel} with the operations that transform {@code previousModel} into {@code newModel}.
     *
     * <p>The root models of {@code previousModel} and {@code newModel} are moved into the resource of
     * {@code incrementalModel} (as the ETL does), so the incremental resource contains: the operation model, the
     * {@link RdbmsOperationMeta}, the previous model and the new model, in this order.
     *
     * @param previousModel    the deployed model
     * @param newModel         the candidate model
     * @param incrementalModel an empty model which receives the operations
     * @param dialect          the dialect copied into the incremental {@code RdbmsConfiguration}
     * @param ignoreReview     when {@code true}, no modify operation requires review
     * @throws NullPointerException  if any argument is {@code null}; nothing is modified in this case
     * @throws IllegalStateException if a model has no {@code RdbmsModel} root, or if the change cannot be expressed
     *                               (a field change on an existing junction table); nothing is modified in this case
     */
    public static void transform(RdbmsModel previousModel,
                                 RdbmsModel newModel,
                                 RdbmsModel incrementalModel,
                                 String dialect,
                                 boolean ignoreReview) {
        Objects.requireNonNull(previousModel, "previousModel");
        Objects.requireNonNull(newModel, "newModel");
        Objects.requireNonNull(incrementalModel, "incrementalModel");
        Objects.requireNonNull(dialect, "dialect");

        Resource incrementalResource = incrementalModel.getResource();
        hu.blackbelt.judo.meta.rdbms.RdbmsModel previousRoot = rootOf(previousModel, "previousModel");
        hu.blackbelt.judo.meta.rdbms.RdbmsModel newRoot = rootOf(newModel, "newModel");

        new Run(previousRoot, newRoot, ignoreReview).run(
                previousModel.getResource(), newModel.getResource(), incrementalResource, dialect);
    }

    private static hu.blackbelt.judo.meta.rdbms.RdbmsModel rootOf(RdbmsModel model, String parameter) {
        Resource resource = model.getResource();
        if (resource != null) {
            java.util.Iterator<EObject> it = resource.getAllContents();
            while (it.hasNext()) {
                EObject object = it.next();
                if (object instanceof hu.blackbelt.judo.meta.rdbms.RdbmsModel) {
                    return (hu.blackbelt.judo.meta.rdbms.RdbmsModel) object;
                }
            }
        }
        throw new IllegalStateException(parameter + " does not contain an RdbmsModel");
    }

    /** One execution; holds the state the ETL keeps in its transformation trace. */
    private static final class Run {
        private final hu.blackbelt.judo.meta.rdbms.RdbmsModel previous;
        private final hu.blackbelt.judo.meta.rdbms.RdbmsModel current;
        private final boolean ignoreReview;
        private final RdbmsFactory factory = RdbmsFactory.eINSTANCE;

        private final List<hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation> tableOperations = new ArrayList<>();
        /** Lazy rule traces: new table to its modify operation (one map per ETL lazy rule). */
        private final Map<RdbmsTable, RdbmsModifyTableOperation> plainModifyOperations = new IdentityHashMap<>();
        private final Map<RdbmsTable, RdbmsModifyTableOperation> junctionModifyOperations = new IdentityHashMap<>();

        private Run(hu.blackbelt.judo.meta.rdbms.RdbmsModel previous,
                    hu.blackbelt.judo.meta.rdbms.RdbmsModel current,
                    boolean ignoreReview) {
            this.previous = previous;
            this.current = current;
            this.ignoreReview = ignoreReview;
        }

        void run(Resource previousResource, Resource newResource, Resource incrementalResource, String dialect) {
            List<RdbmsTable> newTables = allOfType(newResource, RdbmsPackage.Literals.RDBMS_TABLE, RdbmsTable.class);
            List<RdbmsJunctionTable> newJunctions =
                    allOfType(newResource, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE, RdbmsJunctionTable.class);
            List<RdbmsTable> previousTables = allOfType(previousResource, RdbmsPackage.Literals.RDBMS_TABLE, RdbmsTable.class);
            List<RdbmsJunctionTable> previousJunctions =
                    allOfType(previousResource, RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE, RdbmsJunctionTable.class);

            // Rules in ETL declaration order.
            for (RdbmsTable s : newTables) {
                createTable(s);
            }
            for (RdbmsJunctionTable s : newJunctions) {
                createTable(s);
            }
            for (RdbmsTable s : previousTables) {
                deleteTable(s);
            }
            for (RdbmsJunctionTable s : previousJunctions) {
                deleteTable(s);
            }

            for (RdbmsValueField f : allOfType(newResource, RdbmsPackage.Literals.RDBMS_VALUE_FIELD, RdbmsValueField.class)) {
                createField(f, "-CreateValueField", false);
            }
            for (RdbmsValueField f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_VALUE_FIELD, RdbmsValueField.class)) {
                deleteField(f, "-DeleteValueField", true);
            }
            for (RdbmsForeignKey f : allOfType(newResource, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY, RdbmsForeignKey.class)) {
                createField(f, "-CreateForeignKey", false);
            }
            for (RdbmsForeignKey f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY, RdbmsForeignKey.class)) {
                deleteField(f, "-DeleteForeignKey", false);
            }
            for (RdbmsIdentifierField f : allOfType(newResource, RdbmsPackage.Literals.RDBMS_IDENTIFIER_FIELD, RdbmsIdentifierField.class)) {
                createField(f, "-CreateIdentifierField", true);
            }
            for (RdbmsIdentifierField f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_IDENTIFIER_FIELD, RdbmsIdentifierField.class)) {
                deleteField(f, "-DeleteIdentifierField", false);
            }

            for (RdbmsValueField f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_VALUE_FIELD, RdbmsValueField.class)) {
                modifyField(f, RdbmsPackage.Literals.RDBMS_VALUE_FIELD, false);
            }
            for (RdbmsIdentifierField f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_IDENTIFIER_FIELD, RdbmsIdentifierField.class)) {
                modifyField(f, RdbmsPackage.Literals.RDBMS_IDENTIFIER_FIELD, false);
            }
            for (RdbmsForeignKey f : allOfType(previousResource, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY, RdbmsForeignKey.class)) {
                modifyField(f, RdbmsPackage.Literals.RDBMS_FOREIGN_KEY, true);
            }

            for (RdbmsTable s : newTables) {
                renameTable(s);
            }

            // post: drop the empty modify operations which are not renames.
            tableOperations.removeIf(op -> op instanceof RdbmsModifyTableOperation
                    && ((RdbmsModifyTableOperation) op).getDeleteFieldOperations().isEmpty()
                    && ((RdbmsModifyTableOperation) op).getCreateFieldOperations().isEmpty()
                    && ((RdbmsModifyTableOperation) op).getModifyFieldOperations().isEmpty()
                    && !((RdbmsModifyTableOperation) op).isNameChanged());

            // Everything succeeded: touch the incremental resource only now.
            hu.blackbelt.judo.meta.rdbms.RdbmsModel operationModel = factory.createRdbmsModel();
            operationModel.setVersion(previous.getVersion() + "_" + current.getVersion());
            operationModel.setName(previous.getName());
            RdbmsConfiguration configuration = factory.createRdbmsConfiguration();
            configuration.setDialect(dialect);
            operationModel.setConfiguration(configuration);
            operationModel.getTableOperations().addAll(tableOperations);

            RdbmsOperationMeta operationMeta = factory.createRdbmsOperationMeta();
            operationMeta.setPreviousModel(previous);
            operationMeta.setCurrentModel(current);
            operationMeta.setIncrementalModel(operationModel);

            incrementalResource.getContents().add(operationModel);
            incrementalResource.getContents().add(operationMeta);
            incrementalResource.getContents().add(previous);
            incrementalResource.getContents().add(current);
            LOG.info("Created operation model: {}", operationModel.getVersion());
        }

        // ----------------------------------------------------------------------------------------------------------
        // Table rules
        // ----------------------------------------------------------------------------------------------------------

        private void createTable(RdbmsTable s) {
            // create table only if not yet exists and has at least one field
            if (!tableExists(previous, s) && s.getFields().size() > 0) {
                RdbmsCreateTableOperation t = factory.createRdbmsCreateTableOperation();
                tableOperations.add(t);
                t.setName("Create " + s.getName());
                t.setUuid(s.getUuid() + "-CreateTable");
                t.setTable(s);
                LOG.debug("Created table: {}", s.getUuid());
            }
        }

        private void deleteTable(RdbmsTable s) {
            if (!tableExists(current, s) || tableOf(current, s).getFields().size() == 0) {
                RdbmsDeleteTableOperation t = factory.createRdbmsDeleteTableOperation();
                tableOperations.add(t);
                t.setName("Delete " + s.getName());
                t.setUuid(s.getUuid() + "-DeleteTable");
                t.setTable(s);
                LOG.debug("Deleted table: {}", s.getUuid());
            }
        }

        private void renameTable(RdbmsTable s) {
            // RenameExistingTable extends the lazy ModifyTableOperationForExistingTable rule: the parent guard,
            // the parent body (an own empty operation, removed by the post step) and then the own body. The own
            // body sets nameChanged on the modify operation requested with equivalent(); the ETL does not create
            // that operation on demand here, it fails when no field rule asked for it before (rename-only table).
            if (s.getFields().size() > 0
                    && tableExists(previous, s)
                    && !Objects.equals(tableOf(previous, s).getSqlName(), s.getSqlName())) {
                RdbmsModifyTableOperation own = factory.createRdbmsModifyTableOperation();
                tableOperations.add(own);
                fillModifyTableOperation(own, s);
                RdbmsModifyTableOperation requested = plainModifyOperations.get(s);
                if (requested == null) {
                    throw new IllegalStateException("Unsupported incremental change: table '" + s.getName()
                            + "' (" + s.getUuid() + ") changed its sqlName without any field change");
                }
                requested.setNameChanged(true);
                LOG.debug("Sql name changed: {} -> {}", tableOf(previous, s).getSqlName(), s.getSqlName());
            }
        }

        // ----------------------------------------------------------------------------------------------------------
        // Field rules
        // ----------------------------------------------------------------------------------------------------------

        private void createField(RdbmsField f, String uuidSuffix, boolean identifier) {
            EObject container = f.eContainer();
            if (container instanceof RdbmsTable
                    && tableExists(previous, (RdbmsTable) container)
                    && !fieldExists(tableOf(previous, (RdbmsTable) container), f)) {
                RdbmsCreateFieldOperation t = factory.createRdbmsCreateFieldOperation();
                modifyOperationOf(tableOf(current, (RdbmsTable) container), false, f).getCreateFieldOperations().add(t);
                t.setUuid(f.getUuid() + uuidSuffix);
                t.setName("Create " + f.getName());
                t.setField(f);
                if (identifier) {
                    // the ETL assigns t.isIdentifierField = true, but RdbmsCreateFieldOperation has no such feature,
                    // so the ETL fails with "Property 'isIdentifierField' not found": fail closed in the same partition
                    throw new IllegalStateException("Unsupported incremental change: identifier field '" + f.getName()
                            + "' (" + f.getUuid() + ") created on the existing table '"
                            + ((RdbmsTable) container).getName() + "'");
                }
                t.setReviewRequired(f.isMandatory());
                LOG.debug("Create new field on existing table: {}", f.getUuid());
            }
        }

        private void deleteField(RdbmsField f, String uuidSuffix, boolean requireFieldsInTable) {
            EObject container = f.eContainer();
            if (container instanceof RdbmsTable && tableExists(current, (RdbmsTable) container)) {
                RdbmsTable newTable = tableOf(current, (RdbmsTable) container);
                if ((!requireFieldsInTable || newTable.getFields().size() > 0) && !fieldExists(newTable, f)) {
                    RdbmsDeleteFieldOperation t = factory.createRdbmsDeleteFieldOperation();
                    modifyOperationOf(newTable, false, f).getDeleteFieldOperations().add(t);
                    t.setUuid(f.getUuid() + uuidSuffix);
                    t.setName("Delete " + f.getName());
                    t.setField(f);
                    LOG.debug("Delete field on existing table: {}", f.getUuid());
                }
            }
        }

        private void modifyField(RdbmsField f, EClass ruleType, boolean foreignKeyRule) {
            EObject container = f.eContainer();
            if (!(container instanceof RdbmsTable) || !tableExists(current, (RdbmsTable) container)) {
                return;
            }
            RdbmsTable newTable = tableOf(current, (RdbmsTable) container);
            if (!fieldExists(newTable, f)) {
                return;
            }
            RdbmsField n = fieldOf(newTable, f);
            boolean sameType = n.eClass() == ruleType;
            if (!(isAnyChanged(f, n) || !sameType)) {
                return;
            }

            RdbmsModifyFieldOperation t = factory.createRdbmsModifyFieldOperation();
            RdbmsModifyTableOperation modifyTable;
            if (foreignKeyRule && newTable.eClass() != RdbmsPackage.Literals.RDBMS_TABLE) {
                modifyTable = modifyOperationOf(newTable, true, f);
            } else {
                modifyTable = modifyOperationOf(newTable, false, f);
            }
            modifyTable.getModifyFieldOperations().add(t);
            t.setUuid(f.getUuid() + "-ModifyField");
            t.setField(n);
            t.setPreviousField(f);
            t.setName("Modify " + f.getName());

            if (!sameType) {
                if (ruleType == RdbmsPackage.Literals.RDBMS_VALUE_FIELD) {
                    t.setChangedValueFieldToForeignKey(true);
                } else if (ruleType == RdbmsPackage.Literals.RDBMS_FOREIGN_KEY) {
                    t.setChangedForeignKeyToValueField(true);
                }
            }

            if (isSqlTypeChanged(f, n)) {
                t.setTypeChanged(true);
            } else if (isSizeChanged(f, n) || isPrecisionChanged(f, n) || isScaleChanged(f, n) || isStorageByteChanged(f, n)) {
                t.setSizeChanged(true);
            }
            if (isSqlNameChanged(f, n)) {
                t.setNameChanged(true);
            }
            if (isMandatoryChanged(f, n)) {
                t.setMandatoryChanged(true);
            }
            if (!sameType) {
                t.setReviewRequired(true);
            } else {
                t.setReviewRequired(isReviewRequired(f, n));
            }
            LOG.debug("Modify field: {}", f.getUuid());
        }

        // ----------------------------------------------------------------------------------------------------------
        // Lazy modify table operation rules
        // ----------------------------------------------------------------------------------------------------------

        /**
         * Returns the memoised modify operation of a new table, creating (and appending) it at the first request.
         * The ETL lazy rules apply to the exact type of the table only, with the guard {@code fields.size() > 0};
         * where the rule does not apply the ETL fails on the property access, so this fails closed (naming the table
         * and the field that asked for the operation).
         */
        private RdbmsModifyTableOperation modifyOperationOf(RdbmsTable table, boolean junctionRule, RdbmsField field) {
            EClass expected = junctionRule ? RdbmsPackage.Literals.RDBMS_JUNCTION_TABLE : RdbmsPackage.Literals.RDBMS_TABLE;
            if (table.eClass() != expected || table.getFields().size() == 0) {
                throw new IllegalStateException("Unsupported incremental change: field '" + field.getName()
                        + "' (" + field.getUuid() + ") of table '" + table.getName()
                        + "' (" + table.getUuid() + ", " + table.eClass().getName() + ") cannot be put into a "
                        + (junctionRule ? "junction" : "plain") + " table modify operation"
                        + (table.getFields().size() == 0 ? " (the table has no field)" : ""));
            }
            Map<RdbmsTable, RdbmsModifyTableOperation> trace = junctionRule ? junctionModifyOperations : plainModifyOperations;
            RdbmsModifyTableOperation op = trace.get(table);
            if (op == null) {
                op = factory.createRdbmsModifyTableOperation();
                tableOperations.add(op);
                fillModifyTableOperation(op, table);
                trace.put(table, op);
            }
            return op;
        }

        private void fillModifyTableOperation(RdbmsModifyTableOperation t, RdbmsTable s) {
            t.setName("Modify " + s.getName());
            t.setUuid(s.getUuid() + "-ModifyTable");
            t.setTable(s);
            t.setPreviousTable(tableOf(previous, s));
            LOG.debug("Modified table: {}", s.getUuid());
        }

        // ----------------------------------------------------------------------------------------------------------
        // Helpers (model.eol, table.eol, field.eol)
        // ----------------------------------------------------------------------------------------------------------

        private static RdbmsTable tableOf(hu.blackbelt.judo.meta.rdbms.RdbmsModel model, RdbmsTable table) {
            for (RdbmsTable t : model.getRdbmsTables()) {
                if (Objects.equals(t.getUuid(), table.getUuid())) {
                    return t;
                }
            }
            return null;
        }

        private static boolean tableExists(hu.blackbelt.judo.meta.rdbms.RdbmsModel model, RdbmsTable table) {
            return tableOf(model, table) != null;
        }

        private static RdbmsField fieldOf(RdbmsTable table, RdbmsField field) {
            for (RdbmsField f : table.getFields()) {
                if (Objects.equals(f.getUuid(), field.getUuid())) {
                    return f;
                }
            }
            return null;
        }

        private static boolean fieldExists(RdbmsTable table, RdbmsField field) {
            return fieldOf(table, field) != null;
        }

        private static boolean isSqlNameChanged(RdbmsField a, RdbmsField b) {
            return !Objects.equals(a.getSqlName(), b.getSqlName());
        }

        private static boolean isMandatoryChanged(RdbmsField a, RdbmsField b) {
            return a.isMandatory() != b.isMandatory();
        }

        private static boolean isSqlTypeChanged(RdbmsField a, RdbmsField b) {
            return !Objects.equals(a.getRdbmsTypeName(), b.getRdbmsTypeName());
        }

        private static boolean isSizeChanged(RdbmsField a, RdbmsField b) {
            return a.getSize() != b.getSize();
        }

        private static boolean isPrecisionChanged(RdbmsField a, RdbmsField b) {
            return a.getPrecision() != b.getPrecision();
        }

        private static boolean isScaleChanged(RdbmsField a, RdbmsField b) {
            return a.getScale() != b.getScale();
        }

        private static boolean isStorageByteChanged(RdbmsField a, RdbmsField b) {
            return a.getStorageByte() != b.getStorageByte();
        }

        private static boolean isAnyChanged(RdbmsField a, RdbmsField b) {
            return isSqlNameChanged(a, b)
                    || isMandatoryChanged(a, b)
                    || isSqlTypeChanged(a, b)
                    || isSizeChanged(a, b)
                    || isPrecisionChanged(a, b)
                    || isScaleChanged(a, b)
                    || isStorageByteChanged(a, b);
        }

        private boolean isReviewRequired(RdbmsField a, RdbmsField b) {
            return !ignoreReview
                    && ((isMandatoryChanged(a, b) && !a.isMandatory() && b.isMandatory())
                    || isSqlTypeChanged(a, b)
                    || (isSizeChanged(a, b) && a.getSize() > b.getSize())
                    || (isPrecisionChanged(a, b) && a.getPrecision() > b.getPrecision())
                    || (isScaleChanged(a, b) && a.getScale() > b.getScale())
                    || (isStorageByteChanged(a, b) && a.getStorageByte() > b.getStorageByte()));
        }

        /** Instances of exactly the given type, in model containment order (what an ETL non-greedy rule iterates). */
        private static <T extends EObject> List<T> allOfType(Resource resource, EClass type, Class<T> javaType) {
            List<T> result = new ArrayList<>();
            java.util.Iterator<EObject> it = resource.getAllContents();
            while (it.hasNext()) {
                EObject object = it.next();
                if (object.eClass() == type) {
                    result.add(javaType.cast(object));
                }
            }
            return result;
        }
    }
}
