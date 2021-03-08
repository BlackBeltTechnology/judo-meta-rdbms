package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.contexts.ProgramParameter;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import org.eclipse.epsilon.common.util.UriUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.contexts.EtlExecutionContext.etlExecutionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static java.util.Arrays.asList;

public class RdbmsIncremental {

    private static final Logger log = LoggerFactory.getLogger(RdbmsIncremental.class);

    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      String dialect,
                                                      boolean mergeModels) throws Exception {
        transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, new Slf4jLog(log), calculateRdbmsTransformationScriptURI(), dialect, mergeModels);
    }

    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      Log log,
                                                      String dialect,
                                                      boolean mergeModels) throws Exception {
        transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, log, calculateRdbmsTransformationScriptURI(), dialect, mergeModels);
    }


    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      Log log,
                                                      URI scriptUri,
                                                      String dialect, boolean mergeModels) throws Exception {

        // Execution context
        ExecutionContext executionContext = executionContextBuilder()
                .log(log)
                .resourceSet(incrementalRdbmsModel.getResourceSet())
                .modelContexts(Arrays.asList(
                        wrappedEmfModelContextBuilder()
                                .name("PREVIOUS")
                                .aliases(asList("SOURCE", "RDBMS"))
                                .resource(originalModel.getResource())
                                .build(),
                        wrappedEmfModelContextBuilder()
                                .name("NEW")
                                .aliases(asList("SOURCE", "RDBMS"))
                                .resource(newModel.getResource())
                                .build(),
                        wrappedEmfModelContextBuilder()
                                .name("INCREMENTAL")
                                .resource(incrementalRdbmsModel.getResource())
                                .build()))
                .build();

        // run the model / metadata loading
        executionContext.load();

        // Transformation script
        executionContext.executeProgram(
                etlExecutionContextBuilder()
                        .source(UriUtil.resolve("createIncrementalOperationModel.etl", scriptUri))
                        .parameters(Arrays.asList(
                                ProgramParameter.programParameterBuilder().name("dialect").value(dialect).build(),
                                ProgramParameter.programParameterBuilder().name("mergeModels").value(Boolean.toString(mergeModels)).build()))
                        .build());

        executionContext.commit();
        executionContext.close();

    }

    public static URI calculateRdbmsTransformationScriptURI() throws URISyntaxException {
        URI rdbmsRoot = RdbmsModel.class.getProtectionDomain().getCodeSource().getLocation().toURI();
        if (rdbmsRoot.toString().endsWith(".jar")) {
            rdbmsRoot = new URI("jar:" + rdbmsRoot.toString() + "!/transformations/");
        } else if (rdbmsRoot.toString().startsWith("jar:bundle:")) {
            // bundle://37.0:0/validations/
            // jar:bundle://37.0:0/!/validations/esm.evl
            rdbmsRoot = new URI(rdbmsRoot.toString().substring(4, rdbmsRoot.toString().indexOf("!")) + "transformations/");
        } else {
            rdbmsRoot = new URI(rdbmsRoot.toString() + "/transformations/");
        }
        return rdbmsRoot;

    }

}
