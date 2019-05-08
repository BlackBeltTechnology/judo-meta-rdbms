package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.RdbmsPackage;
import hu.blackbelt.judo.meta.rdbms.util.RdbmsResourceFactoryImpl;
import hu.blackbelt.judo.meta.rdbms.util.RdbmsResourceImpl;
import hu.blackbelt.judo.meta.rdbmsDataTypes.RdbmsDataTypesPackage;
import hu.blackbelt.judo.meta.rdbmsNameMapping.RdbmsNameMappingPackage;
import hu.blackbelt.judo.meta.rdbmsRules.RdbmsRulesPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RdbmsModelLoader {

    public static void registerRdbmsMetamodel(ResourceSet resourceSet) {
        resourceSet.getPackageRegistry().put(RdbmsPackage.eINSTANCE.getNsURI(), RdbmsPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(RdbmsDataTypesPackage.eINSTANCE.getNsURI(), RdbmsDataTypesPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(RdbmsNameMappingPackage.eINSTANCE.getNsURI(), RdbmsNameMappingPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(RdbmsRulesPackage.eINSTANCE.getNsURI(), RdbmsRulesPackage.eINSTANCE);
    }


    public static Resource.Factory getRdbmsFactory() {
        return new RdbmsResourceFactoryImpl() {
            @Override
            public Resource createResource(URI uri) {
                Resource result = new RdbmsResourceImpl(uri) {
                    @Override
                    protected boolean useUUIDs() {
                        return true;
                    }
                };
                return result;
            }
        };
    }

    public static ResourceSet createRdbmsResourceSet() {
        return createRdbmsResourceSet(null);
    }

    public static ResourceSet createRdbmsResourceSet(URIHandler uriHandler) {
        ResourceSet resourceSet = new ResourceSetImpl();
        registerRdbmsMetamodel(resourceSet);
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(ResourceFactoryRegistryImpl.DEFAULT_EXTENSION, getRdbmsFactory());
        if (uriHandler != null) {
            resourceSet.getURIConverter().getURIHandlers().add(0, uriHandler);
        }
        return resourceSet;
    }

    public static void setupRelativeUriRoot(ResourceSet resourceSet, URI uri) {
        EList<URIHandler> uriHandlers = resourceSet.getURIConverter().getURIHandlers();
        EList<ContentHandler> contentHandlers = resourceSet.getURIConverter().getContentHandlers();

        // Set custom URI handler where URL without base part replaced with the base URI
        resourceSet.setURIConverter(new ExtensibleURIConverterImpl() {
            @Override
            public URI normalize(URI uriPar) {

                String fragment = uriPar.fragment();
                String query = uriPar.query();
                URI trimmedURI = uriPar.trimFragment().trimQuery();
                URI result = getInternalURIMap().getURI(trimmedURI);
                String scheme = result.scheme();
                if (scheme == null) {
                    result = uri;
                }

                if (result == trimmedURI) {
                    return uriPar;
                }

                if (query != null) {
                    result = result.appendQuery(query);
                }
                if (fragment != null) {
                    result = result.appendFragment(fragment);
                }
                return normalize(result);
            }
        });

        resourceSet.getURIConverter().getURIHandlers().clear();
        resourceSet.getURIConverter().getURIHandlers().addAll(uriHandlers);
        resourceSet.getURIConverter().getContentHandlers().clear();
        resourceSet.getURIConverter().getContentHandlers().addAll(contentHandlers);

    }


    public static RdbmsModel loadRdbmsModel(URI uri, String name, String version) throws IOException {
        return loadRdbmsModel(createRdbmsResourceSet(), uri, name, version, null, null);
    }

    public static RdbmsModel loadRdbmsModel(ResourceSet resourceSet, URI uri, String name, String version) throws IOException {
        return loadRdbmsModel(resourceSet, uri, name, version, null, null);
    }

    public static RdbmsModel loadRdbmsModel(ResourceSet resourceSet, URI uri, String name, String version, String checksum, String acceptedMetaVersionRange) throws IOException {
        registerRdbmsMetamodel(resourceSet);
        Resource resource = resourceSet.createResource(uri);
        Map<Object, Object> loadOptions = new HashMap<>();
        //loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
        //loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
        loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
        loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
        loadOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
        resource.load(loadOptions);

        RdbmsModel.RdbmsModelBuilder b = RdbmsModel.buildRdbmsModel();

        b.name(name)
                .version(version)
                .uri(uri)
                .checksum(checksum)
                .resourceSet(resourceSet);

        if (checksum != null) {
            b.checksum(checksum);
        }

        if (acceptedMetaVersionRange != null)  {
            b.metaVersionRange(acceptedMetaVersionRange);
        }
        return b.build();
    }

    public static Map<Object, Object> getRdbmsModelDefaultSaveOptions() {
        Map<Object, Object> saveOptions = new HashMap<>();
        saveOptions.put("DECLARE_XML", Boolean.TRUE);
        saveOptions.put("PROCESS_DANGLING_HREF", "DISCARD");
        saveOptions.put("URI_HANDLER", new URIHandlerImpl() {
            public URI deresolve(URI uri) {
                return uri.hasFragment() && uri.hasOpaquePart() && this.baseURI.hasOpaquePart() && uri.opaquePart().equals(this.baseURI.opaquePart()) ? URI.createURI("#" + uri.fragment()) : super.deresolve(uri);
            }
        });
        saveOptions.put("SCHEMA_LOCATION", Boolean.TRUE);
        saveOptions.put("DEFER_IDREF_RESOLUTION", Boolean.TRUE);
        saveOptions.put("SKIP_ESCAPE_URI", Boolean.FALSE);
        saveOptions.put("ENCODING", "UTF-8");
        return saveOptions;
    }

    public static void saveRdbmssModel(RdbmsModel rdbmsModel) throws IOException {
        rdbmsModel.getResourceSet().getResource(rdbmsModel.getUri(), false).save(getRdbmsModelDefaultSaveOptions());
    }

}
