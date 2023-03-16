package hu.blackbelt.judo.meta.rdbms.osgi;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
 * %%
 * Copyright (C) 2018 - 2022 BlackBelt Technology
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.osgi.utils.osgi.api.BundleCallback;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;
import hu.blackbelt.osgi.utils.osgi.api.BundleUtil;
import lombok.extern.slf4j.Slf4j;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.VersionRange;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hu.blackbelt.judo.meta.rdbmsDataTypes.support.RdbmsDataTypesModelResourceSupport.registerRdbmsDataTypesMetamodel;
import static hu.blackbelt.judo.meta.rdbmsNameMapping.support.RdbmsNameMappingModelResourceSupport.registerRdbmsNameMappingMetamodel;
import static hu.blackbelt.judo.meta.rdbmsRules.support.RdbmsTableMappingRulesModelResourceSupport.registerRdbmsTableMappingRulesMetamodel;
import static java.util.Optional.ofNullable;

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
                    // Unpack model
                    try {
                        // Create empty RDBMS model
                        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel().build();

                        // The RDBMS model resourceset have to know the mapping models
                        registerRdbmsNameMappingMetamodel(rdbmsModel.getResourceSet());
                        registerRdbmsDataTypesMetamodel(rdbmsModel.getResourceSet());
                        registerRdbmsTableMappingRulesMetamodel(rdbmsModel.getResourceSet());

                        RdbmsModel.loadRdbmsModel(
                                RdbmsModel.LoadArguments.rdbmsLoadArgumentsBuilder()
                                        .resourceSet(rdbmsModel.getResourceSet())
                                        .inputStream(trackedBundle.getEntry(params.get("file")).openStream()));

                            log.info("Registering Rdbms model: " + rdbmsModel);

                            ServiceRegistration<RdbmsModel> modelServiceRegistration = bundleContext.registerService(RdbmsModel.class, rdbmsModel, rdbmsModel.toDictionary());
                            rdbmsModels.put(key, rdbmsModel);
                            rdbmsModelRegistrations.put(key, modelServiceRegistration);
                    } catch (IOException | RdbmsModel.RdbmsValidationException e) {
                        log.error("Could not load Rdbms model: " + params.get(RdbmsModel.NAME) + " from bundle: " + trackedBundle.getBundleId(), e);
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
