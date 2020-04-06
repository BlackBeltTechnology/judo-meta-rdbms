package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class RdbmsUtils {

    private static final Logger log = LoggerFactory.getLogger(RdbmsUtils.class);

    private boolean failOnError;

    private ResourceSet resourceSet;

    //@Getter
    private RdbmsModelResourceSupport rdbmsModelResourceSupport;
    public RdbmsModelResourceSupport getRdbmsModelResourceSupport() { return rdbmsModelResourceSupport; }

    //@Getter
    private RdbmsModel rdbmsModel;
    public RdbmsModel getRdbmsModel() { return rdbmsModel; }

    //////////////////////////////////////////////////
    ////////////////// CONSTRUCTORS //////////////////

    public RdbmsUtils() { }

    /**
     * Create RdbmsUtils by passing the RdbmsModel itself
     * @param rdbmsModel Rdbms model to "build" utils on
     */
    public RdbmsUtils(RdbmsModel rdbmsModel) {
        this.rdbmsModel = rdbmsModel;
        rdbmsModelResourceSupport = RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder()
                .resourceSet(rdbmsModel.getResourceSet())
                .uri(rdbmsModel.getUri())
                .build();
    }

    public RdbmsUtils(final ResourceSet resourceSet) {
        this(resourceSet, false);
    }

    public RdbmsUtils(final ResourceSet resourceSet, final boolean failOnError) {
        this.resourceSet = resourceSet;
        this.failOnError = failOnError;

        // TODO: Processes here
    }

    //////////////////////////////////////////////////
    ///////////////// OTHER METHODS //////////////////

    public void setFailOnError(final boolean failOnError) {
        this.failOnError = failOnError;
    }

    //////////////////////////////////////////////////
    //////////////////// TABLES //////////////////////

    /**
     * Get all RdbmsTable from RdbmsModel
     * @return all RdbmsTable if exists
     */
    public Optional<EList<RdbmsTable>> getRdbmsTables() {
        //TODO: Tests
        BasicEList<RdbmsTable> rdbmsTables = new BasicEList<>();
        rdbmsModelResourceSupport.getStreamOfRdbmsRdbmsTable().forEach(rdbmsTables::add);
        return !(rdbmsTables.isEmpty())
                ? Optional.of(rdbmsTables)
                : Optional.empty();
    }

    /**
     * Get certain RdbmsTable
     * @param rdbmsTableName RdbmsTable's name to search for (packagename.classname)
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
     * @param rdbmsTableName RdbmsTable's name to get all RdbmsField from (packagename.classname)
     * @return All RdbmsField if exists
     */
    public Optional<EList<RdbmsField>> getRdbmsFields(String rdbmsTableName) {
        //TODO: Tests
        return getRdbmsTable(rdbmsTableName).isPresent() && !(getRdbmsTable(rdbmsTableName).get().getFields().isEmpty())
                ? Optional.of(getRdbmsTable(rdbmsTableName).get().getFields())
                : Optional.empty();
    }

    /**
     * Get certain RdbmsField from given RdbmsTable
     * @param rdbmsTableName RdbmsTable's name to search in (packagename.classname)
     * @param rdbmsFieldName RdbmsField's name to search for
     * @param concatNames true if during search, rdbmsTableName and rdbmsFieldName will be concatenated with '#' between them
     * @return RdbmsField if exists
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Optional<RdbmsField> getRdbmsField(String rdbmsTableName, String rdbmsFieldName, boolean concatNames) {
        //TODO: Tests
        final String finalRdbmsFieldName =
                concatNames
                        ? rdbmsTableName + "#" + rdbmsFieldName
                        : rdbmsFieldName;
        return (getRdbmsFields(rdbmsTableName).isPresent() && getRdbmsFields(rdbmsTableName).get().stream().anyMatch(o -> finalRdbmsFieldName.equals(o.getName())))
                ? Optional.of(getRdbmsFields(rdbmsTableName).get().stream().filter(o -> finalRdbmsFieldName.equals(o.getName())).findAny().get())
                : Optional.empty();
    }

}
