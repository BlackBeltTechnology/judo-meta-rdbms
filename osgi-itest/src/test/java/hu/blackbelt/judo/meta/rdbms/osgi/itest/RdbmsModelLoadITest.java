package hu.blackbelt.judo.meta.rdbms.osgi.itest;

import hu.blackbelt.epsilon.runtime.execution.impl.StringBuilderLogger;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.RdbmsValidationException;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.SaveArguments;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.osgi.utils.osgi.api.BundleTrackerManager;

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
import org.osgi.service.log.LogService;

import javax.inject.Inject;
import java.io.*;

import static hu.blackbelt.judo.meta.rdbms.osgi.itest.RdbmsKarafFeatureProvider.*;
import static org.junit.Assert.assertFalse;
import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.OptionUtils.combine;
import static org.ops4j.pax.tinybundles.core.TinyBundles.bundle;
import static org.ops4j.pax.tinybundles.core.TinyBundles.withBnd;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class RdbmsModelLoadITest {

    private static final String DEMO = "northwind-rdbms";

    @Inject
    LogService log;

    @Inject
    protected BundleTrackerManager bundleTrackerManager;

    @Inject
    BundleContext bundleContext;

    @Inject
    RdbmsModel rdbmsModel;

    @Configuration
    public Option[] config() throws IOException, RdbmsValidationException {

        return combine(getRuntimeFeaturesForMetamodel(this.getClass()),
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
    			.name(DEMO)
    			.uri(URI.createFileURI("test.model"))
    			.build();
    	
    	ByteArrayOutputStream os = new ByteArrayOutputStream();
    	
    	measureModel.saveRdbmsModel(SaveArguments.rdbmsSaveArgumentsBuilder().outputStream(os));
    	
        return bundle()
                .add( "model/" + DEMO + ".judo-meta-rdbms",
                		new ByteArrayInputStream(os.toByteArray()))
                .set( Constants.BUNDLE_MANIFESTVERSION, "2")
                .set( Constants.BUNDLE_SYMBOLICNAME, DEMO + "-rdbms" )
                .set( "Rdbms-Models", "file=model/" + DEMO + ".judo-meta-rdbms;version=1.0.0;name=" + DEMO + ";checksum=notset;meta-version-range=\"[1.0.0,2)\"")
                .build( withBnd());
    }

    @Test
    public void testModelValidation() {
        StringBuilderLogger logger = new StringBuilderLogger(StringBuilderLogger.LogLevel.DEBUG);
        try {
            RdbmsEpsilonValidator.validateRdbms(logger,
                    rdbmsModel,
                    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI());

        } catch (Exception e) {
            log.log(LogService.LOG_ERROR, logger.getBuffer());
            assertFalse(true);
        }
    }
}
