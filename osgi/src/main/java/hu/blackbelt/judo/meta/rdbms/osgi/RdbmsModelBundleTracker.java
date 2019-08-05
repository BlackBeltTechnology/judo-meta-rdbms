package hu.blackbelt.judo.meta.rdbms.osgi;

import hu.blackbelt.epsilon.runtime.osgi.BundleURIHandler;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.osgi.utils.osgi.api.BundleCallback;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;
import hu.blackbelt.osgi.utils.osgi.api.BundleUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.VersionRange;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

@Component(immediate = true)
@Slf4j
public class RdbmsModelBundleTracker {

    public static final String RDBMS_MODELS = "Rdbms-Models";

    @Reference
    BundleTrackerManager bundleTrackerManager;

    Map<String, ServiceRegistration<RdbmsModel>> rdbmsModelRegistrations = new ConcurrentHashMap<>();

    Map<String, RdbmsModel> rdbmsModels = new HashMap<>();

    @Activate
    public void activate(final ComponentContext componentContext) {
        bundleTrackerManager.registerBundleCallback(this.getClass().getName(),
                new RdbmsRegisterCallback(componentContext.getBundleContext()),
                new RdbmsUnregisterCallback(),
                new RdbmsBundlePredicate());
    }

    @Deactivate
    public void deactivate(final ComponentContext componentContext) {
        bundleTrackerManager.unregisterBundleCallback(this.getClass().getName());
    }

    private static class RdbmsBundlePredicate implements Predicate<Bundle> {
        @Override
        public boolean test(Bundle trackedBundle) {
            return BundleUtil.hasHeader(trackedBundle, RDBMS_MODELS);
        }
    }

    private class RdbmsRegisterCallback implements BundleCallback {

        BundleContext bundleContext;

        public RdbmsRegisterCallback(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
        }

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, RDBMS_MODELS);


            for (Map<String, String> params : entries) {
                String key = params.get(RdbmsModel.NAME);
                if (rdbmsModelRegistrations.containsKey(key)) {
                    log.error("Rdbms model already loaded: " + key);
                } else {
                    if (params.containsKey(RdbmsModel.META_VERSION_RANGE)) {
                        VersionRange versionRange = new VersionRange(params.get(RdbmsModel.META_VERSION_RANGE).replaceAll("\"", ""));
                        if (versionRange.includes(bundleContext.getBundle().getVersion())) {
                            // Unpack model
                            try {
                                        RdbmsModel rdbmsModel = RdbmsModel.loadRdbmsModel(
                                        RdbmsModel.LoadArguments.rdbmsLoadArgumentsBuilder()
                                                .uriHandler(new BundleURIHandler(trackedBundle.getSymbolicName(), "", trackedBundle))
                                                .uri(URI.createURI(trackedBundle.getSymbolicName() + ":" + params.get("file")))
                                                .name(params.get(RdbmsModel.NAME))
                                                .version(trackedBundle.getVersion().toString())
                                                .checksum(Optional.ofNullable(params.get(RdbmsModel.CHECKSUM)).orElse("notset"))
                                                .acceptedMetaVersionRange(Optional.of(versionRange.toString()).orElse("[0,99)")));

                                log.info("Registering Rdbms model: " + rdbmsModel);

                                ServiceRegistration<RdbmsModel> modelServiceRegistration = bundleContext.registerService(RdbmsModel.class, rdbmsModel, rdbmsModel.toDictionary());
                                rdbmsModels.put(key, rdbmsModel);
                                rdbmsModelRegistrations.put(key, modelServiceRegistration);

                            } catch (IOException e) {
                                log.error("Could not load Rdbms model: " + params.get(RdbmsModel.NAME) + " from bundle: " + trackedBundle.getBundleId());
                            } catch (RdbmsModel.RdbmsValidationException e) {
                                log.error("Could not load Rdbms model: " + params.get(RdbmsModel.NAME) + " from bundle: " + trackedBundle.getBundleId(), e);
                            }                        }
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

        @Override
        public void accept(Bundle trackedBundle) {
            List<Map<String, String>> entries = BundleUtil.getHeaderEntries(trackedBundle, RDBMS_MODELS);
            for (Map<String, String> params : entries) {
                String key = params.get(RdbmsModel.NAME);

                if (rdbmsModels.containsKey(key)) {
                    ServiceRegistration<RdbmsModel> modelServiceRegistration = rdbmsModelRegistrations.get(key);

                    if (modelServiceRegistration != null) {
                        log.info("Unregistering Rdbms model: " + rdbmsModels.get(key));
                        modelServiceRegistration.unregister();
                        rdbmsModelRegistrations.remove(key);
                        rdbmsModels.remove(key);
                    }
                } else {
                    log.error("Rdbms Model is not registered: " + key);
                }
            }
        }

        @Override
        public Thread process(Bundle bundle) {
            return null;
        }
    }

}
