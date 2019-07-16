package hu.blackbelt.judo.meta.rdbms.runtime;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.contexts.EvlExecutionContext.evlExecutionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;


public class RdbmsValidationTest {

    private static final Logger log = LoggerFactory.getLogger(RdbmsValidationTest.class);
    private final String createdSourceModelName = "urn:Rdbms.model";
    private Resource rdbmsResource;
    private ExecutionContext executionContext;
    RdbmsModelResourceSupport rdbmsModelSupport;

    private RdbmsUtils rdbmsUtils;

    @BeforeEach
    void setUp() {

        rdbmsModelSupport = rdbmsModelResourceSupportBuilder().build();
        rdbmsResource = rdbmsModelSupport.getResourceSet().createResource(
                URI.createFileURI(createdSourceModelName));

        Log log = new Slf4jLog();

        rdbmsUtils = new RdbmsUtils(rdbmsResource.getResourceSet(), false);

        // Execution context
        executionContext = executionContextBuilder()
                .log(log)
                .resourceSet(rdbmsModelSupport.getResourceSet())
                .metaModels(ImmutableList.of())
                .modelContexts(ImmutableList.of(
                        wrappedEmfModelContextBuilder()
                                .log(log)
                                .name("RDBMS")
                                .resource(rdbmsResource)
                                .build()))
                .injectContexts(ImmutableMap.of("rdbmsUtils", rdbmsUtils))
                .build();
    }

    @AfterEach
    void tearDown() {
        executionContext = null;
        rdbmsResource = null;
    }

    @Test
    public void test() throws Exception {
        runEpsilon(ImmutableList.of(), null);
    }

    private void runEpsilon(Collection<String> expectedErrors, Collection<String> expectedWarnings) throws Exception {
        // run the model / metadata loading
        executionContext.load();

        // Transformation script
        executionContext.executeProgram(
                evlExecutionContextBuilder()
                        .source(new File("../model/src/main/epsilon/validations/rdbms.evl").toURI())
                        .expectedErrors(expectedErrors)
                        .expectedWarnings(expectedWarnings)
                        .build());

        executionContext.commit();
        executionContext.close();
    }
}
