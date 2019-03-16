package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.osgi.utils.osgi.api.BundleCallback;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;
import hu.blackbelt.osgi.utils.osgi.api.BundleUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.*;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModelLoader.loadRdbmsModel;

@Component(immediate = true)
@Slf4j
public class RdbmsModelBundleTracker {

    public static final String PSM_MODELS = "Rdbms-Models";

    @Reference
    BundleTrackerManager bundleTrackerManager;

    Map<String, ServiceRegistration<RdbmsModel>> rdbmsModelRegistrations = new ConcurrentHashMap<>();

    Map<String, RdbmsModel> rdbmsModels = new HashMap<>();

    @Activate
    public void activate(final ComponentContext componentContext) {
        bundleTrackerManager.registerBundleCallback(this.getClass().getName(),
                new RdbmsRegisterCallback(componentContext.getBundleContext()),
                new RdbmsUnregisterCallback(componentContext.getBundleContext()),
                new RdbmsBundlePredicate());
    }

    @Deactivate
    public void deactivate(final ComponentContext componentContext) {
        bundleTrackerManager.unregisterBundleCallback(this.getClass().getName());
    }

    private static class RdbmsBundlePredicate implements Predicate<Bundle> {
        @Override
        public boolean test(Bundle trackedBundle) {
            return BundleUtil.hasHeader(trackedBundle, PSM_MODELS);
        }
    }

    private class RdbmsRegisterCallback implements BundleCallback {

        BundleContext bundleContext;

        public RdbmsRegisterCallback(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
        }

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, PSM_MODELS);


            for (Map<String, String> params : entries) {
                String key = params.get(RdbmsModel.NAME);
                if (rdbmsModelRegistrations.containsKey(key)) {
                    log.error("Model already loaded: " + key);
                } else {
                    if (params.containsKey(RdbmsModel.META_VERSION_RANGE)) {
                        VersionRange versionRange = new VersionRange(params.get(RdbmsModel.META_VERSION_RANGE).replaceAll("\"", ""));
                        if (versionRange.includes(bundleContext.getBundle().getVersion())) {
                            // Unpack model
                            try {
                                File file = BundleUtil.copyBundleFileToPersistentStorage(trackedBundle, key + ".judo-meta-rdbms", params.get("file"));
                                Version version = bundleContext.getBundle().getVersion();

                                // TODO: JNG-55 Copy mapping XLSX

                                RdbmsModel rdbmsModel = loadRdbmsModel(
                                        new ResourceSetImpl(),
                                        URI.createURI(file.getAbsolutePath()),
                                        params.get(RdbmsModel.NAME),
                                        version.toString(),
                                        params.get(RdbmsModel.CHECKSUM),
                                        versionRange.toString());

                                log.info("Registering model: " + rdbmsModel);

                                ServiceRegistration<RdbmsModel> modelServiceRegistration = bundleContext.registerService(RdbmsModel.class, rdbmsModel, rdbmsModel.toDictionary());
                                rdbmsModels.put(key, rdbmsModel);
                                rdbmsModelRegistrations.put(key, modelServiceRegistration);

                            } catch (IOException e) {
                                log.error("Could not load model: " + params.get(RdbmsModel.NAME) + " from bundle: " + trackedBundle.getBundleId());
                            }
                        }
                    }
                }
            }
        }

        @Override
        public Thread process(Bundle bundle) {
            return null;
        }
    }

    private class RdbmsUnregisterCallback implements BundleCallback {
        BundleContext bundleContext;

        public RdbmsUnregisterCallback(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
        }

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, PSM_MODELS);
            for (Map<String, String> params : entries) {
                String key = params.get(RdbmsModel.NAME);

                if (rdbmsModels.containsKey(key)) {
                    ServiceRegistration<RdbmsModel> modelServiceRegistration = rdbmsModelRegistrations.get(key);

                    if (modelServiceRegistration != null) {
                        log.info("Unregistering moodel: " + rdbmsModels.get(key));
                        modelServiceRegistration.unregister();
                        rdbmsModelRegistrations.remove(key);
                        rdbmsModels.remove(key);
                    }
                } else {
                    log.error("Model is not registered: " + key);
                }
            }
        }

        @Override
        public Thread process(Bundle bundle) {
            return null;
        }
    }

}
