package hu.blackbelt.judo.meta.rdbms.tracker;

import hu.blackbelt.judo.meta.rdbms.RdbmsMetaModel;
import hu.blackbelt.judo.meta.rdbms.RdbmsModelInfo;
import hu.blackbelt.osgi.utils.osgi.api.BundleCallback;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;
import hu.blackbelt.osgi.utils.osgi.api.BundleUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.Version;
import org.osgi.framework.VersionRange;
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

@Component(immediate = true)
@Slf4j
public class RdbmsModelBundleTracker {

    public static final String RDBMS_MODELS = "Rdbms-Models";

    @Reference
    BundleTrackerManager bundleTrackerManager;

    @Reference
    RdbmsMetaModel rdbmsMetaModel;

    Map<String, ServiceRegistration<RdbmsModelInfo>> rdbmsRegistrations = new ConcurrentHashMap<>();
    Map<String, RdbmsModelInfo> rdbmsModels = new HashMap<>();

    @Activate
    public void activate(final ComponentContext componentContext) {
        bundleTrackerManager.registerBundleCallback(this.getClass().getName(),
                new PsmRegisterCallback(componentContext.getBundleContext()),
                new PsmUnregisterCallback(componentContext.getBundleContext()),
                new PsmBundlePredicate());
    }

    @Deactivate
    public void deactivate(final ComponentContext componentContext) {
        bundleTrackerManager.unregisterBundleCallback(this.getClass().getName());
    }

    private static class PsmBundlePredicate implements Predicate<Bundle> {
        @Override
        public boolean test(Bundle bundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(bundle, RDBMS_MODELS);
            if (entries == null) {
                return false;
            }
            return true;
        }
    }

    private class PsmRegisterCallback implements BundleCallback {

        BundleContext bundleContext;

        public PsmRegisterCallback(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
        }

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, RDBMS_MODELS);
            for (Map<String, String> params : entries) {
                if (params.containsKey(RdbmsModelInfo.META_VERSION)) {
                    VersionRange versionRange = new VersionRange(params.get(RdbmsModelInfo.META_VERSION).replaceAll("\"", ""));
                    if (versionRange.includes(bundleContext.getBundle().getVersion())) {

                        // Unpack model
                        try {
                            String key = trackedBundle.getBundleId() + "-" + params.get(RdbmsModelInfo.NAME);

                            File file = BundleUtil.copyBundleFileToPersistentStorage(trackedBundle, key + ".model", params.get(RdbmsModelInfo.FILE));

                            RdbmsModelInfo rdbmsModelInfo = new RdbmsModelInfo(
                                    file,
                                    params.get(RdbmsModelInfo.NAME),
                                    new Version(params.get(RdbmsModelInfo.VERSION)),
                                    URI.createURI(file.getAbsolutePath()),
                                    params.get(RdbmsModelInfo.CHECKSUM),
                                    versionRange);

                            log.info("Registering model: " + rdbmsModelInfo);

                            ServiceRegistration<RdbmsModelInfo> modelServiceRegistration = bundleContext.registerService(RdbmsModelInfo.class, rdbmsModelInfo, rdbmsModelInfo.toDictionary());
                            rdbmsModels.put(key, rdbmsModelInfo);
                            rdbmsRegistrations.put(key, modelServiceRegistration);


                        } catch (IOException e) {
                            log.error("Could not load model: " + params.get(RdbmsModelInfo.NAME) + " from bundle: " + trackedBundle.getBundleId());
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

    private class PsmUnregisterCallback implements BundleCallback {
        BundleContext bundleContext;

        public PsmUnregisterCallback(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
        }

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, RDBMS_MODELS);
            for (Map<String, String> params : entries) {
                VersionRange versionRange = new VersionRange(params.get(RdbmsModelInfo.META_VERSION).replaceAll("\"", ""));
                if (params.containsKey(RdbmsModelInfo.META_VERSION)) {
                    if (versionRange.includes(bundleContext.getBundle().getVersion())) {
                        String key = trackedBundle.getBundleId() + "-" + params.get(RdbmsModelInfo.NAME);
                        ServiceRegistration<RdbmsModelInfo> modelServiceRegistration = rdbmsRegistrations.get(key);

                        if (modelServiceRegistration != null) {
                            log.info("Unregistering moodel: " + rdbmsModels.get(key));
                            modelServiceRegistration.unregister();
                            rdbmsRegistrations.remove(key);
                            rdbmsModels.remove(key);
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
}
