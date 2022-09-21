package hu.blackbelt.judo.meta.rdbms.runtime;

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

import com.google.common.collect.ImmutableList;
import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.impl.BufferedSlf4jLogger;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.RdbmsValidationException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.epsilon.common.util.UriUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.contexts.EtlExecutionContext.etlExecutionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.excel.ExcelModelContext.excelModelContextBuilder;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.SaveArguments.rdbmsSaveArgumentsBuilder;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.buildRdbmsModel;
import static java.lang.String.format;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class RdbmsIncrementalTest {

    private static final String ORIGINAL_MODEL_NAME = "OriginalModel";
    private static final String TARGET_TEST_CLASSES = "target/test-classes";

    @Test
    public void executeExcel2RdbmsModel() throws Exception {

        RdbmsModel originalModel = buildRdbmsModel().name(ORIGINAL_MODEL_NAME).build();
        RdbmsModel newModel = buildRdbmsModel().name("NewModel").build();

        // Execution context
        ExecutionContext excelToRdbmsEtlContext;
        try (Log bufferedLog = new BufferedSlf4jLogger(log)) {
            excelToRdbmsEtlContext = executionContextBuilder()
                    .resourceSet(originalModel.getResourceSet())
                    .log(bufferedLog)
                    .modelContexts(ImmutableList.of(
                            excelModelContextBuilder()
                                    .name("EXCEL")
                                    .aliases(singletonList("XLS"))
                                    .excel(getUri(this.getClass(), "RdbmsIncrementalTests.xlsx").toString())
                                    .excelConfiguration(getUri(this.getClass(), "mapping.xml").toString())
                                    .build(),
                            wrappedEmfModelContextBuilder()
                                    .name("ORIGINAL_MODEL")
                                    .aliases(singletonList("ORIGINAL"))
                                    .resource(originalModel.getResource())
                                    .build(),
                            wrappedEmfModelContextBuilder()
                                    .name("NEW_MODEL")
                                    .aliases(singletonList("NEW"))
                                    .resource(newModel.getResource())
                                    .build()))
                    .build();
        }

        excelToRdbmsEtlContext.load();

        URI root = getUri(RdbmsIncrementalTest.class, "/");

        excelToRdbmsEtlContext.executeProgram(etlExecutionContextBuilder().source(UriUtil.resolve("createRdbmsModelsFromExcel.etl", root)).build());

        excelToRdbmsEtlContext.commit();
        excelToRdbmsEtlContext.close();


        saveRdbms(originalModel);
        saveRdbms(newModel);

		RdbmsModel incrementalRdbmsModel = buildRdbmsModel().name("Incremental").build();

        RdbmsIncremental.transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, "hsqldb", true);

        saveRdbms(incrementalRdbmsModel);

        // Execution context
        ExecutionContext testIncrementalModelContext;
        try (Log bufferedLog = new BufferedSlf4jLogger(log)) {
            testIncrementalModelContext = executionContextBuilder()
                    .resourceSet(originalModel.getResourceSet())
                    .log(bufferedLog)
                    .modelContexts(ImmutableList.of(
                            excelModelContextBuilder()
                                    .name("EXCEL")
                                    .aliases(singletonList("XLS"))
                                    .excel(getUri(this.getClass(), "RdbmsIncrementalTests.xlsx").toString())
                                    .excelConfiguration(getUri(this.getClass(), "mapping.xml").toString())
                                    .build(),
                            wrappedEmfModelContextBuilder()
                                    .name("INCREMENTAL")
                                    .resource(incrementalRdbmsModel.getResource())
                                    .build()))
                    .build();
        }

        testIncrementalModelContext.load();


        testIncrementalModelContext.executeProgram(etlExecutionContextBuilder().source(UriUtil.resolve("testIncrementalModel.etl", root)).build());

        testIncrementalModelContext.commit();
        testIncrementalModelContext.close();

    }

    private URI getUri(Class<?> clazz, String file) throws URISyntaxException {
        URI psmRoot = clazz.getProtectionDomain().getCodeSource().getLocation().toURI();
        if (psmRoot.toString().endsWith(".jar")) {
            psmRoot = new URI("jar:" + psmRoot.toString() + "!/" + file);
        } else if (psmRoot.toString().startsWith("jar:bundle:")) {
            psmRoot = new URI(psmRoot.toString().substring(4, psmRoot.toString().indexOf("!")) + file);
        } else {
            psmRoot = new URI(psmRoot.toString() + "/" + file);
        }
        return psmRoot;
    }


    //// EMF Compare experiment
	/*
	 * 		com.google.common.base.Function<EObject, String> idFunction = new com.google.common.base.Function<EObject, String>() {
			@Override
			public @Nullable String apply(@Nullable EObject input) {
				if (input instanceof RdbmsElement) {
					String s = input.getClass().getSimpleName() + 
							((RdbmsElement)input).getUuid();
					System.out.println(s);
					return s;
				} else {
					return null;
				}
			}
		};
		
//		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
//		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, idFunction);
//		 
//		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//		 
//		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
//		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
//		matchEngineFactory.setRanking(20); // default engine ranking is 10, must be higher to override.
//		registry.add(matchEngineFactory);
//
//		
//    	DefaultComparisonScope scope = new DefaultComparisonScope(newModel.getResource(), originalModel.getResource(), null);
//		Comparison comparison = EMFCompare.builder()
//				.setMatchEngineFactoryRegistry(registry)
//					.build().compare(scope);
//		for (Diff diff : comparison.getDifferences()) {
//			System.out.println(diff);
//		}
    

	 */

    private void saveRdbms(RdbmsModel rdbmsModel) {
        File incrementalRdbmsFile = new File(TARGET_TEST_CLASSES, String.format("testContents-%s-rdbms.model", rdbmsModel.getName()));
        try {
            rdbmsModel.saveRdbmsModel(rdbmsSaveArgumentsBuilder().file(incrementalRdbmsFile));
        } catch (RdbmsValidationException | IOException ex) {
            fail(format("Model:\n%s\nDiagnostic:\n%s", rdbmsModel.asString(), rdbmsModel.getDiagnosticsAsString()));
        }

    }

}
