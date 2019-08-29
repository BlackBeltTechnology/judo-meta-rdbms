package hu.blackbelt.judo.meta.rdbms.runtime;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.contexts.EvlExecutionContext.evlExecutionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.eclipse.epsilon.common.util.UriUtil;

import java.util.Arrays;

import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.exceptions.ScriptExecutionException;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;

public class RdbmsEpsilonValidator {
	
	public static void validateRdbms(Log log,
            RdbmsModel rdbmsModel,
            URI scriptRoot) throws ScriptExecutionException, URISyntaxException
	{
		validateRdbms(log, rdbmsModel, scriptRoot, emptyList(), emptyList());
	}
	
	public static void validateRdbms(Log log,
            RdbmsModel rdbmsModel,
            URI scriptRoot,
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) throws ScriptExecutionException, URISyntaxException
	{
		ExecutionContext executionContext = executionContextBuilder()
                .log(log)
                .resourceSet(rdbmsModel.getResourceSet())
                .metaModels(emptyList())
                .modelContexts(Arrays.asList(
                        wrappedEmfModelContextBuilder()
                                .log(log)
                                .name("RDBMS")
                                .validateModel(false)
                                .resource(rdbmsModel.getResource())
                                .build()))
                .injectContexts(singletonMap("rdbmsUtils", new RdbmsUtils()))
                .build();
		
		 try {
	            // run the model / metadata loading
	            executionContext.load();

	            // Transformation script
	            executionContext.executeProgram(
	                    evlExecutionContextBuilder()
	                            .source(UriUtil.resolve("rdbms.evl", scriptRoot))
	                            .expectedErrors(expectedErrors)
	                            .expectedWarnings(expectedWarnings)
	                            .build());

	        } finally {
	            executionContext.commit();
	            try {
	                executionContext.close();
	            } catch (Exception e) {}
	        }
	}

}
