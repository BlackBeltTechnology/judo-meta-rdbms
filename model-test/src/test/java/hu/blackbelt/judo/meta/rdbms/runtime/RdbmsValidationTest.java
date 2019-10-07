package hu.blackbelt.judo.meta.rdbms.runtime;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.exceptions.EvlScriptExecutionException;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Collection;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;


public class RdbmsValidationTest {

    private final String createdSourceModelName = "urn:Rdbms.model";
    private Resource rdbmsResource;
    private ExecutionContext executionContext;
    RdbmsModelResourceSupport rdbmsModelSupport;

    private RdbmsModel rdbmsModel;
    private RdbmsUtils rdbmsUtils;
    
    Logger logger = LoggerFactory.getLogger(RdbmsValidationTest.class);
    
    private Log log = new Slf4jLog();

    @BeforeEach
    void setUp() {

        rdbmsModelSupport = rdbmsModelResourceSupportBuilder()
                .uri(URI.createFileURI(createdSourceModelName))
                .build();
        rdbmsResource = rdbmsModelSupport.getResource();

        rdbmsUtils = new RdbmsUtils(rdbmsResource.getResourceSet(), false);
        
        rdbmsModel = RdbmsModel.buildRdbmsModel()
        		.rdbmsModelResourceSupport(rdbmsModelSupport)
                .uri(URI.createURI(createdSourceModelName))
                .name("test")
                .build();


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


    private void runEpsilon (Collection<String> expectedErrors, Collection<String> expectedWarnings) throws Exception {
        try {
            RdbmsEpsilonValidator.validateRdbms(log,
                    rdbmsModel,
                    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI(),
                    expectedErrors,
                    expectedWarnings);
        } catch (EvlScriptExecutionException ex) {
            logger.error("EVL failed", ex);
            logger.error("\u001B[31m - expected errors: {}\u001B[0m", expectedErrors);
            logger.error("\u001B[31m - unexpected errors: {}\u001B[0m", ex.getUnexpectedErrors());
            logger.error("\u001B[31m - errors not found: {}\u001B[0m", ex.getErrorsNotFound());
            logger.error("\u001B[33m - expected warnings: {}\u001B[0m", expectedWarnings);
            logger.error("\u001B[33m - unexpected warnings: {}\u001B[0m", ex.getUnexpectedWarnings());
            logger.error("\u001B[33m - warnings not found: {}\u001B[0m", ex.getWarningsNotFound());
            throw ex;
        }
    }
}
