package hu.blackbelt.judo.meta.rdbms.runtime;

import com.google.common.collect.ImmutableList;
import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.RdbmsValidationException;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsIndexBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsUniqueConstraintBuilder;
import org.eclipse.epsilon.common.util.UriUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
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

public class RdbmsIncrementalTest {

    private static final String ORIGINAL_MODEL_NAME = "OriginalModel";
    private static final String TARGET_TEST_CLASSES = "target/test-classes";

    @Test
    public void executeExcel2RdbmsModel() throws Exception {

        RdbmsModel originalModel = buildRdbmsModel().name(ORIGINAL_MODEL_NAME).build();
        RdbmsModel newModel = buildRdbmsModel().name("NewModel").build();

        // Execution context
        ExecutionContext excelToRdbmsEtlContext = executionContextBuilder()
                .resourceSet(originalModel.getResourceSet())
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

        excelToRdbmsEtlContext.load();

        URI root = getUri(RdbmsIncrementalTest.class, "/");

        excelToRdbmsEtlContext.executeProgram(etlExecutionContextBuilder().source(UriUtil.resolve("createRdbmsModelsFromExcel.etl", root)).build());

        excelToRdbmsEtlContext.commit();
        excelToRdbmsEtlContext.close();

        /* 
        final RdbmsUtils rdbmsUtils = new RdbmsUtils(originalModel.getResourceSet());
        final RdbmsTable rdbmsTable = rdbmsUtils.getRdbmsTables().get().get(0);
        rdbmsTable.getIndexes().add(
                RdbmsIndexBuilder.create()
                        .withName("TestIndex")
                        .withUuid(rdbmsTable.getUuid() + ".TestIndex")
                        .withFields(rdbmsTable.getFields().get(0), rdbmsTable.getFields().get(1))
                        .withSqlName("TestIndex".toUpperCase())
                        .build());
        rdbmsTable.getUniqueConstraints().add(
                RdbmsUniqueConstraintBuilder.create()
                        .withName("TestUniqueConstraint")
                        .withUuid(rdbmsTable.getUuid() + ".TestUniqueConstraint")
                        .withFields(rdbmsTable.getFields().get(2), rdbmsTable.getFields().get(3))
                        .withSqlName("TestUniqueConstraint".toUpperCase())
                        .build());

        final RdbmsUtils rdbmsUtils2 = new RdbmsUtils(newModel.getResourceSet());
        final RdbmsTable rdbmsTable2 = rdbmsUtils2.getRdbmsTables().get().get(0);
        rdbmsTable2.getIndexes().add(
                RdbmsIndexBuilder.create()
                        .withName("TestIndex")
                        .withUuid(rdbmsTable2.getUuid() + ".TestIndex")
                        .withFields(rdbmsTable2.getFields().get(0), rdbmsTable2.getFields().get(1))
                        .withSqlName("TestIndex".toUpperCase())
                        .build());
        rdbmsTable2.getUniqueConstraints().add(
                RdbmsUniqueConstraintBuilder.create()
                        .withName("TestUniqueConstraint")
                        .withUuid(rdbmsTable2.getUuid() + ".TestUniqueConstraint")
                        .withFields(rdbmsTable2.getFields().get(2), rdbmsTable2.getFields().get(3))
                        .withSqlName("TestUniqueConstraint".toUpperCase())
                        .build());
		*/
        
        File originalRdbmsFile = new File(TARGET_TEST_CLASSES, String.format("testContents-%s-rdbms.model", originalModel.getName()));
        try {
            originalModel.saveRdbmsModel(rdbmsSaveArgumentsBuilder().file(originalRdbmsFile));
        } catch (RdbmsValidationException ex) {
            fail(format("Model:\n%s\nDiagnostic:\n%s", originalModel.asString(), originalModel.getDiagnosticsAsString()));
        }

        File newRdbmsFile = new File(TARGET_TEST_CLASSES, String.format("testContents-%s-rdbms.model", newModel.getName()));
        try {
            newModel.saveRdbmsModel(rdbmsSaveArgumentsBuilder().file(newRdbmsFile));
        } catch (RdbmsValidationException ex) {
            fail(format("Model:\n%s\nDiagnostic:\n%s", newModel.asString(), newModel.getDiagnosticsAsString()));
        }

		RdbmsModel incrementalRdbmsModel = buildRdbmsModel().name("Incremental").build();

        RdbmsInremental.transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, "hsqldb", true);

        File incrementalRdbmsFile = new File(TARGET_TEST_CLASSES, String.format("testContents-%s-rdbms.model", incrementalRdbmsModel.getName()));
        try {
        	incrementalRdbmsModel.saveRdbmsModel(rdbmsSaveArgumentsBuilder().file(incrementalRdbmsFile));
        } catch (RdbmsValidationException ex) {
            fail(format("Model:\n%s\nDiagnostic:\n%s", incrementalRdbmsModel.asString(), incrementalRdbmsModel.getDiagnosticsAsString()));
        }
        
        

        // Execution context
        ExecutionContext testIncrementalModelContext = executionContextBuilder()
                .resourceSet(originalModel.getResourceSet())
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

        testIncrementalModelContext.load();


        testIncrementalModelContext.executeProgram(etlExecutionContextBuilder().source(UriUtil.resolve("testIncrementalModel.etl", root)).build());

        testIncrementalModelContext.commit();
        testIncrementalModelContext.close();

    }

    private URI getUri(Class clazz, String file) throws URISyntaxException {
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
}
