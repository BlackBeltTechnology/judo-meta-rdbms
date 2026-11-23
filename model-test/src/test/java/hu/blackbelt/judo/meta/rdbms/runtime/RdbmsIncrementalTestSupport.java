package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model :: Test
 * %%
 * Copyright (C) 2018 - 2024 BlackBelt Technology
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
import hu.blackbelt.judo.meta.rdbms.RdbmsFactory;
import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.buildRdbmsModel;

/**
 * Test support for the ETL-vs-Java incremental equivalence tests: a small model DSL, the engine runner and the
 * reflective structural comparator of two incremental resources (design D5).
 *
 * <p>The comparator compares every {@link EAttribute} of every object, every containment in order and every
 * non-containment {@link EReference} by the containment path of its targets, so a new attribute or reference can not be
 * missed. The incremental resource contents are compared position by position.
 */
public final class RdbmsIncrementalTestSupport {

    private static final RdbmsFactory F = RdbmsFactory.eINSTANCE;

    private RdbmsIncrementalTestSupport() {
    }

    // ------------------------------------------------------------------------------------------------------------
    // Model DSL
    // ------------------------------------------------------------------------------------------------------------

    public static RdbmsModel model(String name, String version, RdbmsTable... tables) {
        hu.blackbelt.judo.meta.rdbms.RdbmsModel root = F.createRdbmsModel();
        root.setName(name);
        root.setVersion(version);
        RdbmsConfiguration configuration = F.createRdbmsConfiguration();
        configuration.setDialect("hsqldb");
        root.setConfiguration(configuration);
        for (RdbmsTable table : tables) {
            root.getRdbmsTables().add(table);
        }
        RdbmsModel model = buildRdbmsModel().build();
        model.addContent(root);
        return model;
    }

    public static hu.blackbelt.judo.meta.rdbms.RdbmsModel root(RdbmsModel model) {
        return model.getResource().getContents().stream()
                .filter(o -> o instanceof hu.blackbelt.judo.meta.rdbms.RdbmsModel)
                .map(o -> (hu.blackbelt.judo.meta.rdbms.RdbmsModel) o)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No RdbmsModel root"));
    }

    private static <T extends RdbmsField> T field(T f, String uuid, String sqlName, String type, int size, boolean mandatory) {
        f.setUuid(uuid);
        f.setName(uuid);
        f.setSqlName(sqlName);
        f.setRdbmsTypeName(type);
        f.setSize(size);
        f.setMandatory(mandatory);
        return f;
    }

    public static RdbmsValueField value(String uuid, String sqlName, String type, int size, boolean mandatory) {
        return field(F.createRdbmsValueField(), uuid, sqlName, type, size, mandatory);
    }

    public static RdbmsIdentifierField id(String uuid) {
        return field(F.createRdbmsIdentifierField(), uuid, "ID", "UUID", 0, true);
    }

    public static RdbmsForeignKey fk(String uuid, String sqlName, RdbmsIdentifierField referenceKey) {
        RdbmsForeignKey fk = field(F.createRdbmsForeignKey(), uuid, sqlName, "UUID", 0, false);
        fk.setReferenceKey(referenceKey);
        fk.setForeignKeySqlName(sqlName + "_CONSTRAINT");
        return fk;
    }

    public static RdbmsTable table(String uuid, String sqlName, RdbmsField... fields) {
        RdbmsTable table = F.createRdbmsTable();
        initTable(table, uuid, sqlName, fields);
        return table;
    }

    /** A table with the primary key {@code <uuid>#_id} followed by the given fields. */
    public static RdbmsTable tableWithId(String uuid, String sqlName, RdbmsField... fields) {
        RdbmsIdentifierField pk = id(uuid + "#_id");
        RdbmsTable table = F.createRdbmsTable();
        table.setPrimaryKey(pk);
        table.getFields().add(pk);
        initTable(table, uuid, sqlName, fields);
        return table;
    }

    public static RdbmsJunctionTable junction(String uuid, String sqlName, RdbmsIdentifierField ref1, RdbmsIdentifierField ref2) {
        RdbmsJunctionTable table = F.createRdbmsJunctionTable();
        RdbmsIdentifierField pk = id(uuid + "#_id");
        RdbmsForeignKey f1 = fk(uuid + "#field1", "FK_FIELD1", ref1);
        RdbmsForeignKey f2 = fk(uuid + "#field2", "FK_FIELD2", ref2);
        table.setPrimaryKey(pk);
        table.setField1(f1);
        table.setField2(f2);
        table.getFields().add(pk);
        table.getFields().add(f1);
        table.getFields().add(f2);
        initTable(table, uuid, sqlName);
        return table;
    }

    private static void initTable(RdbmsTable table, String uuid, String sqlName, RdbmsField... fields) {
        table.setUuid(uuid);
        table.setName(uuid);
        table.setSqlName(sqlName);
        for (RdbmsField field : fields) {
            table.getFields().add(field);
        }
    }

    public static RdbmsTable tableOf(RdbmsModel model, String uuid) {
        return root(model).getRdbmsTables().stream().filter(t -> uuid.equals(t.getUuid())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No table " + uuid));
    }

    public static RdbmsField fieldOf(RdbmsTable table, String uuid) {
        return table.getFields().stream().filter(f -> uuid.equals(f.getUuid())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No field " + uuid));
    }

    /**
     * Loads one of the {@code src/test/model/incremental/<name>.model} fixtures (copied from
     * judo-rdbms-schema-incremental). Every call returns a new, independent model.
     */
    public static RdbmsModel loadFixture(String name) {
        java.io.File file = new java.io.File("src/test/model/incremental", name + ".model");
        try (java.io.InputStream stream = new java.io.FileInputStream(file)) {
            RdbmsModel model = buildRdbmsModel().build();
            // the resource set has to know the mapping models stored next to the RDBMS model
            hu.blackbelt.judo.meta.rdbmsNameMapping.support.RdbmsNameMappingModelResourceSupport
                    .registerRdbmsNameMappingMetamodel(model.getResourceSet());
            hu.blackbelt.judo.meta.rdbmsDataTypes.support.RdbmsDataTypesModelResourceSupport
                    .registerRdbmsDataTypesMetamodel(model.getResourceSet());
            hu.blackbelt.judo.meta.rdbmsRules.support.RdbmsTableMappingRulesModelResourceSupport
                    .registerRdbmsTableMappingRulesMetamodel(model.getResourceSet());
            model.loadResource(RdbmsModel.LoadArguments.rdbmsLoadArgumentsBuilder().inputStream(stream).validateModel(false).build());
            return model;
        } catch (Exception e) {
            throw new IllegalStateException("Could not load fixture " + name, e);
        }
    }

    /** Deterministic text dump of an incremental resource (what a serialization without generated ids would give). */
    public static String dump(RdbmsModel model) {
        StringBuilder sb = new StringBuilder();
        for (EObject root : model.getResource().getContents()) {
            dump(root, "contents[" + model.getResource().getContents().indexOf(root) + "]", sb);
        }
        return sb.toString();
    }

    private static void dump(EObject object, String path, StringBuilder sb) {
        sb.append(path).append(' ').append(object.eClass().getName()).append('\n');
        for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
            Object value = object.eGet(feature);
            String featurePath = path + "." + feature.getName();
            if (feature instanceof EAttribute) {
                sb.append(featurePath).append('=').append(value).append('\n');
            } else if (((EReference) feature).isContainment()) {
                if (feature.isMany()) {
                    List<?> list = (List<?>) value;
                    for (int i = 0; i < list.size(); i++) {
                        dump((EObject) list.get(i), featurePath + "[" + i + "]", sb);
                    }
                } else if (value != null) {
                    dump((EObject) value, featurePath, sb);
                }
            } else if (feature.isMany()) {
                sb.append(featurePath).append("->").append(paths((List<?>) value)).append('\n');
            } else {
                sb.append(featurePath).append("->").append(value == null ? null : pathOf((EObject) value)).append('\n');
            }
        }
    }

    // ------------------------------------------------------------------------------------------------------------
    // Engine runner
    // ------------------------------------------------------------------------------------------------------------

    /** Result of one engine run: the incremental model (untouched on failure) and the failure, if any. */
    public static final class Outcome {
        public final RdbmsModel incremental;
        public final Throwable failure;

        Outcome(RdbmsModel incremental, Throwable failure) {
            this.incremental = incremental;
            this.failure = failure;
        }

        public boolean threw() {
            return failure != null;
        }
    }

    /** Runs one engine on fresh models, as models are moved into the incremental resource by the transformation. */
    public static Outcome run(IncrementalEngine engine,
                              Supplier<RdbmsModel> previous,
                              Supplier<RdbmsModel> current,
                              boolean ignoreReview) {
        RdbmsModel incremental = buildRdbmsModel().build();
        try {
            engine.transform(previous.get(), current.get(), incremental, "hsqldb", ignoreReview);
            return new Outcome(incremental, null);
        } catch (Throwable t) {
            return new Outcome(incremental, t);
        }
    }

    /**
     * Runs both engines and returns the differences ("both threw" counts as equal; an engine failing alone is a
     * difference). An empty list means equivalent.
     */
    public static List<String> compareEngines(Supplier<RdbmsModel> previous, Supplier<RdbmsModel> current, boolean ignoreReview) {
        Outcome etl = run(IncrementalEngine.ETL, previous, current, ignoreReview);
        Outcome java = run(IncrementalEngine.JAVA, previous, current, ignoreReview);
        return compare(etl, java);
    }

    public static List<String> compare(Outcome etl, Outcome java) {
        List<String> diffs = new ArrayList<>();
        if (etl.threw() && java.threw()) {
            return diffs;
        }
        if (etl.threw()) {
            diffs.add("only ETL threw: " + etl.failure);
            return diffs;
        }
        if (java.threw()) {
            diffs.add("only Java threw: " + java.failure);
            return diffs;
        }
        return diff(etl.incremental, java.incremental);
    }

    // ------------------------------------------------------------------------------------------------------------
    // Structural comparator
    // ------------------------------------------------------------------------------------------------------------

    /** Differences of two incremental resources; empty when structurally identical. */
    public static List<String> diff(RdbmsModel expected, RdbmsModel actual) {
        List<String> diffs = new ArrayList<>();
        List<EObject> e = expected.getResource().getContents();
        List<EObject> a = actual.getResource().getContents();
        if (e.size() != a.size()) {
            diffs.add("resource contents size: " + e.size() + " != " + a.size());
            return diffs;
        }
        for (int i = 0; i < e.size(); i++) {
            compareObject(e.get(i), a.get(i), "contents[" + i + "]", diffs);
        }
        return diffs;
    }

    private static void compareObject(EObject e, EObject a, String path, List<String> diffs) {
        if (diffs.size() > 50) {
            return;
        }
        if (e.eClass() != a.eClass()) {
            diffs.add(path + ": class " + e.eClass().getName() + " != " + a.eClass().getName());
            return;
        }
        for (EStructuralFeature feature : e.eClass().getEAllStructuralFeatures()) {
            String featurePath = path + "." + feature.getName();
            Object ev = e.eGet(feature);
            Object av = a.eGet(feature);
            if (feature instanceof EAttribute) {
                if (!Objects.equals(ev, av)) {
                    diffs.add(featurePath + ": " + ev + " != " + av);
                }
            } else if (((EReference) feature).isContainment()) {
                if (feature.isMany()) {
                    List<?> el = (List<?>) ev;
                    List<?> al = (List<?>) av;
                    if (el.size() != al.size()) {
                        diffs.add(featurePath + ": size " + el.size() + " != " + al.size());
                        continue;
                    }
                    for (int i = 0; i < el.size(); i++) {
                        compareObject((EObject) el.get(i), (EObject) al.get(i), featurePath + "[" + i + "]", diffs);
                    }
                } else if (ev == null || av == null) {
                    if (ev != av) {
                        diffs.add(featurePath + ": " + ev + " != " + av);
                    }
                } else {
                    compareObject((EObject) ev, (EObject) av, featurePath, diffs);
                }
            } else if (feature.isMany()) {
                List<String> el = paths((List<?>) ev);
                List<String> al = paths((List<?>) av);
                if (!el.equals(al)) {
                    diffs.add(featurePath + ": " + el + " != " + al);
                }
            } else {
                String ep = ev == null ? null : pathOf((EObject) ev);
                String ap = av == null ? null : pathOf((EObject) av);
                if (!Objects.equals(ep, ap)) {
                    diffs.add(featurePath + ": -> " + ep + " != -> " + ap);
                }
            }
        }
    }

    private static List<String> paths(List<?> objects) {
        List<String> result = new ArrayList<>();
        for (Object o : objects) {
            result.add(pathOf((EObject) o));
        }
        return result;
    }

    /** Containment path of an object from its resource: contents[i]/feature[j]/... */
    static String pathOf(EObject object) {
        EObject container = object.eContainer();
        if (container == null) {
            Resource resource = object.eResource();
            return resource == null ? "detached:" + object.eClass().getName()
                    : "contents[" + resource.getContents().indexOf(object) + "]";
        }
        EStructuralFeature feature = object.eContainingFeature();
        Object value = container.eGet(feature);
        String index = feature.isMany() ? "[" + ((List<?>) value).indexOf(object) + "]" : "";
        return pathOf(container) + "/" + feature.getName() + index;
    }
}
