package hu.blackbelt.judo.meta.rdbms.osgi.itest;

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

import org.slf4j.Logger;
import hu.blackbelt.epsilon.runtime.execution.impl.BufferedSlf4jLogger;
import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.RdbmsValidationException;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.SaveArguments;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsConfigurationBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsModelBuilder;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import javax.inject.Inject;
import java.io.*;

import static hu.blackbelt.judo.meta.rdbms.osgi.itest.KarafFeatureProvider.karafConfig;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator.validateRdbms;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.OptionUtils.combine;
import static org.ops4j.pax.tinybundles.core.TinyBundles.bundle;
import static org.ops4j.pax.tinybundles.core.TinyBundles.withBnd;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
@Slf4j
public class RdbmsModelLoadITest {

    private static final String DEMO = "northwind-rdbms";

    @Inject
    protected BundleTrackerManager bundleTrackerManager;

    @Inject
    BundleContext bundleContext;

    @Inject
    RdbmsModel rdbmsModel;

    @Configuration
    public Option[] config() throws IOException, RdbmsValidationException {

        return combine(karafConfig(this.getClass()),
                mavenBundle(maven()
                        .groupId("hu.blackbelt.judo.meta")
                        .artifactId("hu.blackbelt.judo.meta.rdbms.osgi")
                        .versionAsInProject()),
                getProvisonModelBundle());
    }

    public Option getProvisonModelBundle() throws IOException, RdbmsValidationException {
        return provision(
                getRdbmsModelBundle()
        );
    }

    private InputStream getRdbmsModelBundle() throws IOException, RdbmsValidationException {

        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .uri(URI.createFileURI("test.model"))
                .build();

        rdbmsModel.getRdbmsModelResourceSupport().addContent(RdbmsModelBuilder.create()
                        .withName("test")
                        .withVersion("1.0.0")
                        .withConfiguration(RdbmsConfigurationBuilder.create()
                                .withDialect("hsqldb")
                                .build())
                .build());

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        rdbmsModel.saveRdbmsModel(SaveArguments.rdbmsSaveArgumentsBuilder().outputStream(os));

        return bundle()
                .add( "model/" + rdbmsModel.getName() + "-rdbms.model",
                        new ByteArrayInputStream(os.toByteArray()))
                .set( Constants.BUNDLE_MANIFESTVERSION, "2")
                .set( Constants.BUNDLE_SYMBOLICNAME, rdbmsModel.getName() + "-rdbms" )
                .set( "Rdbms-Models", "name=" + rdbmsModel.getName() + ";file=model/" + rdbmsModel.getName() + "-rdbms.model")
                .build( withBnd());
    }

    @Test
    public void testModelValidation() throws Exception {
        try (BufferedSlf4jLogger bufferedLog = new BufferedSlf4jLogger(log)) {
            validateRdbms(bufferedLog, rdbmsModel, calculateRdbmsValidationScriptURI());
        }
    }
}
