package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;

import java.io.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@ToString
@Getter
@Builder(builderMethodName = "buildRdbmsModel")
public class RdbmsModel {

    public static final String NAME = "name";
    public static final String VERSION = "version";
    public static final String CHECKSUM = "checksum";
    public static final String META_VERSION_RANGE = "meta-version-range";
    public static final String URI = "uri";
    public static final String RESOURCESET = "resourceset";

    String name;

    String version;

    URI uri;

    String checksum;

    String metaVersionRange;

    RdbmsModelResourceSupport rdbmsModelResourceSupport;

    public Dictionary<String, Object> toDictionary() {
        Dictionary<String, Object> ret = new Hashtable<>();
        ret.put(NAME, name);
        ret.put(VERSION, version);
        ret.put(URI, uri);
        ret.put(CHECKSUM, checksum);
        ret.put(META_VERSION_RANGE, metaVersionRange);
        ret.put(RESOURCESET, rdbmsModelResourceSupport.getResourceSet());
        return ret;
    }

    public ResourceSet getResourceSet() {
        return rdbmsModelResourceSupport.getResourceSet();
    }

    public static RdbmsModel loadRdbmsModel(LoadArguments loadArguments) throws IOException {

        RdbmsModelResourceSupport rdbmsModelResourceSupport = loadArguments.rdbmsModelResourceSupport
                .orElseGet(() -> RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder()
                        .resourceSet(loadArguments.resourceSet.orElse(null))
                        .rootUri(loadArguments.rootUri)
                        .uriHandler(loadArguments.uriHandler)
                        .build()
                );

        RdbmsModelBuilder b = RdbmsModel.buildRdbmsModel();

        b.name(loadArguments.name)
                .version(loadArguments.version.orElse("1.0.0"))
                .uri(loadArguments.uri)
                .checksum(loadArguments.checksum.orElse("NON-DEFINED"))
                .rdbmsModelResourceSupport(rdbmsModelResourceSupport)
                .metaVersionRange(loadArguments.acceptedMetaVersionRange.orElse("[0,9999)"));
        RdbmsModel rdbmsModel = b.build();
        Resource resource = rdbmsModel.getResourceSet().createResource(loadArguments.uri);
        resource.load(loadArguments.loadOptions);
        return rdbmsModel;
    }

    public void saveRdbmsModel() throws IOException {
        getResourceSet()
                .getResource(getUri(), false)
                .save(RdbmsModelResourceSupport.getRdbmsModelDefaultSaveOptions());
    }

    public void saveRdbmsModel(SaveArguments saveArguments) throws IOException {
        try {
            OutputStream outputStream = saveArguments.outputStream
                    .orElseGet(() -> saveArguments.file.map(f -> {
                        try {
                            return new FileOutputStream(f);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }).orElse(null));

            getResourceSet()
                    .getResource(getUri(), false)
                    .save(outputStream, saveArguments.saveOptions
                            .orElseGet(() -> RdbmsModelResourceSupport.getRdbmsModelDefaultSaveOptions()));

        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw (IOException) e.getCause();
            } else  {
                throw e;
            }
        }
    }


    @Builder(builderMethodName = "loadArgumentsBuilder")
    @AllArgsConstructor
    public static class LoadArguments {
        URI uri;

        String name;

        @Builder.Default
        Optional<RdbmsModelResourceSupport> rdbmsModelResourceSupport = Optional.empty();

        @Builder.Default
        Optional<URI> rootUri = Optional.empty();

        @Builder.Default
        Optional<URIHandler> uriHandler = Optional.empty();

        @Builder.Default
        Optional<ResourceSet> resourceSet = Optional.empty();

        @Builder.Default
        Optional<String> version = Optional.empty();

        @Builder.Default
        Optional<String> checksum = Optional.empty();

        @Builder.Default
        Optional<String> acceptedMetaVersionRange = Optional.empty();

        @Builder.Default
        Map<Object, Object> loadOptions = RdbmsModelResourceSupport.getRdbmsModelDefaultLoadOptions();
    }


    @Builder(builderMethodName = "saveArgumentsBuilder")
    @AllArgsConstructor
    public static class SaveArguments {
        @Builder.Default
        Optional<OutputStream> outputStream = Optional.empty();

        @Builder.Default
        Optional<File> file = Optional.empty();

        @Builder.Default
        Optional<Map<Object, Object>> saveOptions = Optional.empty();
    }

}
