package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

public class RdbmsUtils {
    private static final Logger log = LoggerFactory.getLogger(RdbmsUtils.class);
    private boolean failOnError;
    private ResourceSet resourceSet;
    private RdbmsModelResourceSupport rdbmsModelResourceSupport;

    //////////////////////////////////////////////////
    ////////////////// CONSTRUCTORS //////////////////

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

    public void setFailOnError(final boolean failOnError) {
        this.failOnError = failOnError;
    }

    public RdbmsModelResourceSupport getRdbmsModelResourceSupport() {
        return rdbmsModelResourceSupport;
    }

    //////////////////////////////////////////////////
    //////////////////// TABLES //////////////////////

    public static RdbmsTable newRdbmsTable(final String name) {
        // TODO: test
        final String uuid = "Tables." + name;

        final RdbmsIdentifierField id = RdbmsBuilders.newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(uuid + "#_id")
                .build();

        return RdbmsBuilders.newRdbmsTableBuilder()
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
        //TODO: Tests
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
        //TODO: Tests
        return getRdbmsTables().isPresent()
                ? getRdbmsTables().get().stream().filter(o -> rdbmsTableName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    //////////////////// FIELDS //////////////////////

    /**
     * Get all RdbmsField from certain RdbmsTable
     *
     * @param rdbmsTableName RdbmsTable's name to get all RdbmsField from
     * @return All RdbmsField if exists
     */
    public Optional<EList<RdbmsField>> getRdbmsFields(String rdbmsTableName) {
        //TODO: Tests
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
        //TODO: Tests
        return getRdbmsFields(rdbmsTableName).isPresent()
                ? getRdbmsFields(rdbmsTableName).get().stream().filter(o -> rdbmsFieldName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    ///////////////// FOREIGN KEYS ///////////////////

    /**
     * Get all RdbmsForeignKey in given table
     *
     * @param rdbmsTableName RdbmsTable's name to list RdbmsForeignKeys from
     * @return all RdbmsForeignKey if exists
     */
    public Optional<EList<RdbmsForeignKey>> getRdbmsForeignKeys(String rdbmsTableName) {
        //TODO: Tests
        BasicEList<RdbmsForeignKey> rdbmsForeignKeys = new BasicEList<>();
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
        //TODO: Tests
        return getRdbmsForeignKeys(rdbmsTableName).isPresent()
                ? getRdbmsForeignKeys(rdbmsTableName).get().stream().filter(o -> rdbmsForeignKeyName.equals(o.getName())).findAny()
                : Optional.empty();
    }

    //////////////////////////////////////////////////
    //////////////// JUNCTION TABLES /////////////////

    /**
     * Get all RdbmsJunctionTable from RdbmsModel
     *
     * @return all RdbmsJunctionTable if exists
     */
    public Optional<EList<RdbmsJunctionTable>> getRdbmsJunctionTables() {
        //TODO: Tests
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
        //TODO: Tests
        return getRdbmsJunctionTables().isPresent()
                ? getRdbmsJunctionTables().get().stream().filter(o -> rdbmsJunctionTableName.equals(o.getName())).findAny()
                : Optional.empty();
    }

}
