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

import hu.blackbelt.epsilon.runtime.execution.ExecutionContext;
import org.slf4j.Logger;
import hu.blackbelt.epsilon.runtime.execution.contexts.ProgramParameter;
import hu.blackbelt.epsilon.runtime.execution.impl.BufferedSlf4jLogger;
import org.eclipse.epsilon.common.util.UriUtil;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static hu.blackbelt.epsilon.runtime.execution.ExecutionContext.executionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.contexts.EtlExecutionContext.etlExecutionContextBuilder;
import static hu.blackbelt.epsilon.runtime.execution.model.emf.WrappedEmfModelContext.wrappedEmfModelContextBuilder;
import static java.util.Arrays.asList;

public class RdbmsIncremental {

    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      String dialect,
                                                      boolean mergeModels) throws Exception {
        try (BufferedSlf4jLogger bufferedLog = new BufferedSlf4jLogger(LoggerFactory.getLogger(RdbmsIncremental.class))) {
            transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, bufferedLog, calculateRdbmsTransformationScriptURI(), dialect, mergeModels);
        }
    }

    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      Logger log,
                                                      String dialect,
                                                      boolean mergeModels) throws Exception {
        transformRdbmsIncrementalModel(originalModel, newModel, incrementalRdbmsModel, log, calculateRdbmsTransformationScriptURI(), dialect, mergeModels);
    }


    public static void transformRdbmsIncrementalModel(RdbmsModel originalModel,
                                                      RdbmsModel newModel,
                                                      RdbmsModel incrementalRdbmsModel,
                                                      Logger log,
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
