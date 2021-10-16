package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsJunctionTableBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsTableBuilder;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;
import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

public class RdbmsUtils {
    private static final Logger log = LoggerFactory.getLogger(RdbmsUtils.class);
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
        rdbmsModelResourceSupport = rdbmsModelResourceSupportBuilder()
                .resourceSet(resourceSet)
                .build();
    }

    //////////////////////////////////////////////////
    ///////////////// OTHER METHODS //////////////////
    //////////////////////////////////////////////////

    public void setFailOnError(final boolean failOnError) {
    }

    public void setResourceSet(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
    }

    public RdbmsModelResourceSupport getRdbmsModelResourceSupport() {
        return rdbmsModelResourceSupport;
    }

    public static boolean isSqlScriptPathValid(String sqlScriptPath) {
        return (new File(sqlScriptPath)).exists();
    }

    public static boolean isSqlScriptEmpty(String sqlScriptPath) throws IOException {
        if (isSqlScriptPathValid(sqlScriptPath)) {
            File file = new File(sqlScriptPath);
            Path filePath = Paths.get(file.toURI());
            return Files.readAllLines(filePath).stream().map(l -> l.trim()).allMatch(l -> l.isEmpty());
        }
        return true;
    }

    public static String getSqlScriptAbsolutePath(String sqlScriptPath) {
        return (new File(sqlScriptPath)).getAbsolutePath();
    }

    //////////////////////////////////////////////////
    //////////////////// TABLES //////////////////////
    //////////////////////////////////////////////////

    /**
     * <p>Creates a new RdbmsTableBuilder.</p>
     * <p>Filled attributes are:</p>
     * <ol>
     *     <li>ID field:</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *          </ul>
     *     <li>Table:</li>
     *          <ul>
     *              <li>Primary key</li>
     *              <li>Name</li>
     *              <li>UUID</li>
     *          </ul>
     * </ol>
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
                .build();

        return newRdbmsTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
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
     * Get all RdbmsField from RdbmsModel
     *
     * @return Optional list of RdbmsFields
     */
    public Optional<List<RdbmsField>> getAllRdbmsField() {
        final List<RdbmsField> rdbmsFields = rdbmsModelResourceSupport.getStreamOfRdbmsRdbmsField().collect(Collectors.toList());
        return !rdbmsFields.isEmpty()
               ? Optional.of(rdbmsFields)
               : Optional.empty();
    }

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
     * <p>Creates a new RdbmsJunctionTableBuilder</p>
     * <ol>
     *     <li>ID field:</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *          </ul>
     *     <li>rdbmsForeignKey1 and rdbmsForeignKey2</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *              <li>ReferenceKey</li>
     *              <li>ForeignKeySqlName</li>
     *          </ul>
     *     <li>RdbmsJunctionTable</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *              <li>PrimaryKey</li>
     *              <li>Field1</li>
     *              <li>Field2</li>
     *          </ul>
     * </ol>
     *
     * @param tableName   RdbmsJunctionTable's name
     * @param rdbmsTable1
     * @param rdbmsTable2
     * @return RdbmsJunctionTableBuilder
     */
    public static RdbmsJunctionTableBuilder newRdbmsJunctionTableBuilderInit(String tableName, final RdbmsTable rdbmsTable1, final RdbmsTable rdbmsTable2) {
        if (tableName == null || rdbmsTable1 == null || rdbmsTable2 == null)
            throw new IllegalArgumentException("Arguments cannot be null");

        final RdbmsIdentifierField id = newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid(tableName + "#_id")
                .build();

        final RdbmsForeignKey rdbmsForeignKey = newRdbmsForeignKeyBuilder()
                .withName(rdbmsTable1.getName() + "_fk1")
                .withUuid(tableName + "#" + rdbmsTable1.getName() + "_fk1")
                .withReferenceKey(rdbmsTable1.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable1.getName())
                .build();

        final RdbmsForeignKey rdbmsForeignKey1 = newRdbmsForeignKeyBuilder()
                .withName(rdbmsTable2.getName() + "_fk2")
                .withUuid(tableName + "#" + rdbmsTable2.getName() + "_fk2")
                .withReferenceKey(rdbmsTable2.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable2.getName())
                .build();

        return newRdbmsJunctionTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
                .withFields(Arrays.asList(id, rdbmsForeignKey, rdbmsForeignKey1))
                .withPrimaryKey(id)
                .withField1(rdbmsForeignKey)
                .withField2(rdbmsForeignKey1);
    }

    /**
     * <p>Creates a new RdbmsJunctionTableBuilder</p>
     * <ol>
     *     <li>ID field:</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *          </ul>
     *     <li>RdbmsJunctionTable</li>
     *          <ul>
     *              <li>Name</li>
     *              <li>UUID</li>
     *              <li>PrimaryKey</li>
     *          </ul>
     * </ol>
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
                .build();

        return newRdbmsJunctionTableBuilder()
                .withName(tableName)
                .withUuid(tableName)
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

    /**
     * Get id of {@link EObject} in XML if it has a resource
     *
     * @param eObject {@link EObject} with id
     * @return <i>eObject's</i> id if it has a resource, null otherwise
     */
    public static String getId(EObject eObject) {
        XMLResource xmlResource = (XMLResource) eObject.eResource();
        return xmlResource == null
               ? null
               : xmlResource.getID(eObject);
    }

    /**
     * Set id of {@link EObject} in XML if it has a resource
     *
     * @param eObject {@link EObject} with id
     * @param id      new id
     * @throws IllegalStateException if <i>eObject</i> does not have a resource
     */
    public static void setId(EObject eObject, String id) {
        XMLResource xmlResource = (XMLResource) eObject.eResource();
        if (xmlResource == null) {
            throw new IllegalStateException("Id " + id + " cannot be set: target object " + eObject + " does not have a resource");
        }
        xmlResource.setID(eObject, id);
    }

    /**
     * Check if all {@link EObject}s' xmiid-s are unique
     *
     * @throws IllegalStateException if model's ResourceSet is unknown (null) or duplicates were found
     * @see RdbmsUtils#RdbmsUtils(ResourceSet)
     */
    public void validateUniqueXmiids() {
        if (resourceSet == null) {
            throw new IllegalStateException("Model's ResourceSet is unknown (null)");
        }

        log.debug("Xmiid validation started...");
        final List<String> ids = all()
                .filter(o -> o instanceof EObject)
                .map(o -> getId((EObject) o))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        final Set<String> nonUniqueXmiids = ids.stream()
                .filter(id -> {
                    log.debug("Checking id: " + id);
                    return ids.stream().filter(id::equals).count() > 1;
                })
                .collect(Collectors.toSet());

        if (nonUniqueXmiids.size() != 0) {
            final StringBuilder builder = new StringBuilder();
            nonUniqueXmiids.forEach(id -> builder.append("Xmiid ").append(id).append(" must be unique\n"));
            throw new IllegalStateException("There are non-unique xmiid-s\n" + builder.toString());
        }
    }

    /**
     * Get stream of source iterator.
     *
     * @param sourceIterator source iterator
     * @param parallel       flag controlling returned stream (serial or parallel)
     * @param <T>            type of source iterator
     * @return return serial (parallel = <code>false</code>) or parallel (parallel = <code>true</code>) stream
     */
    static <T> Stream<T> asStream(Iterator<T> sourceIterator, boolean parallel) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    /**
     * Get all model elements.
     *
     * @param <T> generic type of model elements
     * @return model elements
     */
    @SuppressWarnings("unchecked")
	<T> Stream<T> all() {
        return asStream((Iterator<T>) resourceSet.getAllContents(), false);
    }

    /**
     * Get model elements with specific type
     *
     * @param clazz class of model element types
     * @param <T>   specific type
     * @return all elements with clazz type
     */
    @SuppressWarnings("unchecked")
	public <T> Stream<T> all(final Class<T> clazz) {
        return all().filter(e -> clazz.isAssignableFrom(e.getClass())).map(e -> (T) e);
    }

}
