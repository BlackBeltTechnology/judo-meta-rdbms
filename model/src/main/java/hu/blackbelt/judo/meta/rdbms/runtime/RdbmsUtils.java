package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;
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
    private static final String DEFAULT_PREFIX = "Tables";

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
     * <p>Create simple RdbmsTable with given name and default prefix.</p>
     * <p>Default prefix: {@value DEFAULT_PREFIX}</p>
     * <p>UUID of the created RdbmsTable will be generated from name and default prefix.</p>
     *
     * @return new RdbmsTable
     * @see #newRdbmsTable(String name, String prefix)
     */
    public static RdbmsTable newRdbmsTable(String name) {
        return newRdbmsTable(name, DEFAULT_PREFIX);
    }

    /**
     * <p>Create simple RdbmsTable with given name and prefix.</p>
     * <p>UUID of the created RdbmsTable will be generated from name and prefix.</p>
     *
     * @return new RdbmsTable
     * @see #newRdbmsTable(String name)
     */
    public static RdbmsTable newRdbmsTable(String name, String prefix) {
        if (name == null || prefix == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        name = name.trim().replace(" ", "_");
        prefix = prefix.trim().replace(" ", "_");

        if (!prefix.endsWith("."))
            prefix += ".";

        final String uuid = prefix + name;

        final RdbmsIdentifierField id = RdbmsBuilders.newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(uuid + "#_id")
                .build();

        return newRdbmsTableBuilder()
                .withName(name)
                .withUuid(uuid)
                .withFields(id)
                .withPrimaryKey(id)
                .build();
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
     * <p>Create simple RdbmsJunctionTable with given name and the tables that will be connected.</p>
     * <p>Default prefix: {@value DEFAULT_PREFIX}.</p>
     *
     * @return new RdbmsJunctionTable with default prefix
     * @see #newRdbmsJunctionTable(String name, String prefix, RdbmsTable rdbmsTable1, RdbmsTable rdbmsTable2)
     */
    public static RdbmsJunctionTable newRdbmsJunctionTable(
            final String name, final RdbmsTable rdbmsTable1, final RdbmsTable rdbmsTable2) {
        return newRdbmsJunctionTable(name, DEFAULT_PREFIX, rdbmsTable1, rdbmsTable2);
    }

    /**
     * <p>Create simple RdbmsJunctionTable with given name, prefix and the tables that will be connected.</p>
     * <p>UUID of the created RdbmsJunctionTable will be generated from name and prefix.</p>
     *
     * @return new RdbmsJunctionTable
     * @see #newRdbmsJunctionTable(String name, RdbmsTable rdbmsTable1, RdbmsTable rdbmsTable2)
     */
    public static RdbmsJunctionTable newRdbmsJunctionTable(String name, String prefix,
                                                           final RdbmsTable rdbmsTable1, final RdbmsTable rdbmsTable2) {
        if (name == null || prefix == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        name = name.trim().replace(" ", "_");
        prefix = prefix.trim().replace(" ", "_");

        if (!prefix.endsWith("."))
            prefix += ".";

        final String uuid = prefix + name;

        final RdbmsIdentifierField id = newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(uuid + "#_id")
                .build();

        final RdbmsForeignKey rdbmsForeignKey = newRdbmsForeignKeyBuilder()
                .withName(rdbmsTable1.getName() + "_fk1")
                .withUuid(uuid + "#" + rdbmsTable1.getName() + "_fk1")
                .withReferenceKey(rdbmsTable1.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable1.getName())
                .build();

        final RdbmsForeignKey rdbmsForeignKey1 = newRdbmsForeignKeyBuilder()
                .withName(rdbmsTable2.getName() + "_fk2")
                .withUuid(uuid + "#" + rdbmsTable2.getName() + "_fk2")
                .withReferenceKey(rdbmsTable2.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable2.getName())
                .build();

        return newRdbmsJunctionTableBuilder()
                .withName(name)
                .withUuid(uuid)
                .withFields(Arrays.asList(id, rdbmsForeignKey, rdbmsForeignKey1))
                .withPrimaryKey(id)
                .withField1(rdbmsForeignKey)
                .withField2(rdbmsForeignKey1)
                .build();
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
