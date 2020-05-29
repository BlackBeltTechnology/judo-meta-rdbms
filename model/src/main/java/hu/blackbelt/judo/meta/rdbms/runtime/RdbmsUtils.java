package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsJunctionTableBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsTableBuilder;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;
import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

public class RdbmsUtils {
    private static final Logger log = LoggerFactory.getLogger(RdbmsUtils.class);
    private boolean failOnError;
    private ResourceSet resourceSet;
    private RdbmsModelResourceSupport rdbmsModelResourceSupport;

    //////////////////////////////////////////////////
    ////////////////// CONSTRUCTORS //////////////////
    //////////////////////////////////////////////////

    public RdbmsUtils() {
    }

    public RdbmsUtils(final ResourceSet resourceSet) {
        this(resourceSet, false);
    }

    public RdbmsUtils(final ResourceSet resourceSet, final boolean failOnError) {
        this.resourceSet = resourceSet;
        this.failOnError = failOnError;

        rdbmsModelResourceSupport = rdbmsModelResourceSupportBuilder()
                .resourceSet(resourceSet)
                .build();
    }

    //////////////////////////////////////////////////
    ///////////////// OTHER METHODS //////////////////
    //////////////////////////////////////////////////

    public void setFailOnError(final boolean failOnError) {
        this.failOnError = failOnError;
    }

    public RdbmsModelResourceSupport getRdbmsModelResourceSupport() {
        return rdbmsModelResourceSupport;
    }

    //////////////////////////////////////////////////
    //////////////////// TABLES //////////////////////
    //////////////////////////////////////////////////

    /**
     * <p>Creates a new RdbmsTableBuilder with id field pre-added.</p>
     *
     * @param tableName RdbmsTable's name
     * @return RdbmsTableBuilder
     */
    public static RdbmsTableBuilder newRdbmsTableBuilderInit(String tableName) {
        if (tableName == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        final RdbmsIdentifierField id = RdbmsBuilders.newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(tableName + "#_id")
                .withSqlName("id")
                .build();

        return newRdbmsTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
                .withSqlName(tableName)
                .withFields(id)
                .withPrimaryKey(id);
    }

    /**
     * Get all RdbmsTable from RdbmsModel
     *
     * @return all RdbmsTable if exists
     */
    public Optional<EList<RdbmsTable>> getRdbmsTables() {
        BasicEList<RdbmsTable> rdbmsTables = new BasicEList<>();
        rdbmsModelResourceSupport.getStreamOfRdbmsRdbmsTable().forEach(rdbmsTables::add);
        return !rdbmsTables.isEmpty()
                ? Optional.of(rdbmsTables)
                : Optional.empty();
    }

    /**
     * Get certain RdbmsTable
     *
     * @param rdbmsTableName RdbmsTable's name to search for
     * @return RdbmsTable if exists
     */
    public Optional<RdbmsTable> getRdbmsTable(String rdbmsTableName) {
        return getRdbmsTables().isPresent()
                ? getRdbmsTables().get().stream().filter(o -> rdbmsTableName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    //////////////////// FIELDS //////////////////////
    //////////////////////////////////////////////////

    /**
     * Get all RdbmsField from certain RdbmsTable
     *
     * @param rdbmsTableName RdbmsTable's name to get all RdbmsField from
     * @return All RdbmsField if exists
     */
    public Optional<EList<RdbmsField>> getRdbmsFields(String rdbmsTableName) {
        return getRdbmsTable(rdbmsTableName).isPresent() && !getRdbmsTable(rdbmsTableName).get().getFields().isEmpty()
                ? Optional.of(getRdbmsTable(rdbmsTableName).get().getFields())
                : Optional.empty();
    }

    /**
     * Get certain RdbmsField from given RdbmsTable
     *
     * @param rdbmsTableName RdbmsTable's name to search in
     * @param rdbmsFieldName RdbmsField's name to search for
     * @return RdbmsField if exists
     */
    public Optional<RdbmsField> getRdbmsField(String rdbmsTableName, String rdbmsFieldName) {
        return getRdbmsFields(rdbmsTableName).isPresent()
                ? getRdbmsFields(rdbmsTableName).get().stream().filter(o -> rdbmsFieldName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    ///////////////// FOREIGN KEYS ///////////////////
    //////////////////////////////////////////////////

    /**
     * Get all RdbmsForeignKey in given table
     *
     * @param rdbmsTableName RdbmsTable's name to list RdbmsForeignKeys from
     * @return all RdbmsForeignKey if exists
     */
    public Optional<EList<RdbmsForeignKey>> getRdbmsForeignKeys(String rdbmsTableName) {
        BasicEList<RdbmsForeignKey> rdbmsForeignKeys = new BasicEList<>();
        if (!getRdbmsFields(rdbmsTableName).isPresent())
            return Optional.empty();
        getRdbmsFields(rdbmsTableName).get().forEach(o -> {
            if (o instanceof RdbmsForeignKey) {
                rdbmsForeignKeys.add((RdbmsForeignKey) o);
            }
        });
        return getRdbmsFields(rdbmsTableName).isPresent() && !rdbmsForeignKeys.isEmpty()
                ? Optional.of(rdbmsForeignKeys)
                : Optional.empty();
    }

    /**
     * Get certain RdbmsForeignKey from given RdbmsTable
     *
     * @param rdbmsTableName      RdbmsTable's name to search in
     * @param rdbmsForeignKeyName RdbmsForeignKey's name to search for
     * @return RdbmsForeignKey if exists
     */
    public Optional<RdbmsForeignKey> getRdbmsForeignKey(String rdbmsTableName, String rdbmsForeignKeyName) {
        return getRdbmsForeignKeys(rdbmsTableName).isPresent()
                ? getRdbmsForeignKeys(rdbmsTableName).get().stream().filter(o -> rdbmsForeignKeyName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    //////////////// JUNCTION TABLES /////////////////
    //////////////////////////////////////////////////

    /**
     * <p>Creates a new RdbmsJunctionTableBuilder with id, field1 and field2 pre-added</p>
     *
     * @param tableName   RdbmsJunctionTable's name
     * @param rdbmsTable1 Field1
     * @param rdbmsTable2 Field2
     * @return RdbmsJunctionTableBuilder
     */
    public static RdbmsJunctionTableBuilder newRdbmsJunctionTableBuilderInit(String tableName, final RdbmsTable rdbmsTable1, final RdbmsTable rdbmsTable2) {
        if (tableName == null || rdbmsTable1 == null || rdbmsTable2 == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        final RdbmsIdentifierField id = newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(tableName + "#_id")
                .withSqlName("_id")
                .build();

        final String rdbmsForeignKeyName = rdbmsTable1.getName() + "_fk1";
        final RdbmsForeignKey rdbmsForeignKey = newRdbmsForeignKeyBuilder()
                .withName(rdbmsForeignKeyName)
                .withUuid(tableName + "#" + rdbmsForeignKeyName)
                .withReferenceKey(rdbmsTable1.getPrimaryKey())
                .withSqlName(rdbmsForeignKeyName)
                .withForeignKeySqlName(rdbmsForeignKeyName)
                .build();

        final String rdbmsForeignKeyName2 = rdbmsTable2.getName() + "_fk2";
        final RdbmsForeignKey rdbmsForeignKey1 = newRdbmsForeignKeyBuilder()
                .withName(rdbmsForeignKeyName2)
                .withUuid(tableName + "#" + rdbmsForeignKeyName2)
                .withReferenceKey(rdbmsTable2.getPrimaryKey())
                .withForeignKeySqlName(rdbmsForeignKeyName2)
                .withSqlName(rdbmsForeignKeyName2)
                .build();

        return newRdbmsJunctionTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
                .withSqlName(tableName)
                .withFields(Arrays.asList(id, rdbmsForeignKey, rdbmsForeignKey1))
                .withPrimaryKey(id)
                .withField1(rdbmsForeignKey)
                .withField2(rdbmsForeignKey1);
    }

    /**
     * <p>Creates a new RdbmsJunctionTableBuilder with id field pre-added</p>
     *
     * @param tableName RdbmsJunctionTable's name
     * @return RdbmsJunctionTableBuilder
     */
    public static RdbmsJunctionTableBuilder newRdbmsJunctionTableBuilderInit(final String tableName) {
        if (tableName == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        final RdbmsIdentifierField id = newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(tableName + "#_id")
                .withSqlName("_id")
                .build();

        return newRdbmsJunctionTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
                .withSqlName(tableName)
                .withFields(id)
                .withPrimaryKey(id);
    }


    /**
     * Get all RdbmsJunctionTable from RdbmsModel
     *
     * @return all RdbmsJunctionTable if exists
     */
    public Optional<EList<RdbmsJunctionTable>> getRdbmsJunctionTables() {
        BasicEList<RdbmsJunctionTable> rdbmsJunctionTables = new BasicEList<>();
        rdbmsModelResourceSupport.getStreamOfRdbmsRdbmsTable().forEach(o -> {
            if (o instanceof RdbmsJunctionTable) {
                rdbmsJunctionTables.add((RdbmsJunctionTable) o);
            }
        });
        return !rdbmsJunctionTables.isEmpty()
                ? Optional.of(rdbmsJunctionTables)
                : Optional.empty();
    }

    /**
     * Get certain RdbmsJunctionTable
     *
     * @param rdbmsJunctionTableName RdbmsJunctionTable's name to search for
     * @return RdbmsJunctionTable if exists
     */
    public Optional<RdbmsJunctionTable> getRdbmsJunctionTable(String rdbmsJunctionTableName) {
        return getRdbmsJunctionTables().isPresent()
                ? getRdbmsJunctionTables().get().stream().filter(o -> rdbmsJunctionTableName.equals(o.getName())).findAny()
                : Optional.empty();
    }

}
