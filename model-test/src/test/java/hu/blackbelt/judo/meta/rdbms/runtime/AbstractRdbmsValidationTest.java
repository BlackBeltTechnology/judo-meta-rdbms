package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model :: Test
 * %%
 * Copyright (C) 2018 - 2024 BlackBelt Technology
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

import hu.blackbelt.epsilon.runtime.execution.exceptions.EvlScriptExecutionException;
import hu.blackbelt.epsilon.runtime.execution.impl.BufferedSlf4jLogger;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidator;
import org.eclipse.emf.common.util.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

/**
 * Abstract base class for RDBMS validation tests supporting dual EVL/Java validation.
 *
 * <p>This class provides infrastructure for running the same test cases against both
 * EVL (Epsilon Validation Language) and Java (Zeta framework) validators. Subclasses
 * should use JUnit 5 parameterized tests with {@link ValidatorType} enum to run tests
 * with both validators.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * @ParameterizedTest(name = "testMyConstraint [{0}]")
 * @EnumSource(ValidatorType.class)
 * void testMyConstraint(ValidatorType type) throws Exception {
 *     this.validatorType = type;
 *     initModel();
 *
 *     // Build model that violates constraint
 *     // ...
 *
 *     runValidation(
 *         ImmutableList.of("MyConstraintName"),
 *         ImmutableList.of()
 *     );
 * }
 * }</pre>
 *
 * @see ValidatorType
 * @see RdbmsValidator
 * @see RdbmsEpsilonValidator
 */
public abstract class AbstractRdbmsValidationTest {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected final String createdSourceModelName = "urn:Rdbms.model";

    protected RdbmsModelResourceSupport rdbmsModelSupport;
    protected RdbmsModel rdbmsModel;
    protected ValidatorType validatorType;

    /**
     * Initialize a fresh RdbmsModel for testing.
     * Call this at the start of each parameterized test method.
     */
    protected void initModel() {
        rdbmsModelSupport = rdbmsModelResourceSupportBuilder()
                .uri(URI.createFileURI(createdSourceModelName))
                .build();

        rdbmsModel = RdbmsModel.buildRdbmsModel()
                .rdbmsModelResourceSupport(rdbmsModelSupport)
                .build();
    }

    /**
     * Run validation using the selected validator type.
     * Dispatches to EVL or Java validator based on {@link #validatorType}.
     *
     * @param expectedErrors Collection of expected error constraint names
     * @param expectedWarnings Collection of expected warning constraint names
     * @throws Exception if validation fails unexpectedly
     */
    protected void runValidation(
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) throws Exception {

        switch (validatorType) {
            case EVL:
                log.info("Running EVL validation...");
                runEvlValidation(expectedErrors, expectedWarnings);
                break;
            case JAVA:
                log.info("Running Java validation...");
                runJavaValidation(expectedErrors, expectedWarnings);
                break;
            default:
                throw new IllegalStateException("Unknown validator type: " + validatorType);
        }
    }

    /**
     * Run EVL (Epsilon) validation.
     */
    protected void runEvlValidation(
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) throws Exception {

        try (BufferedSlf4jLogger bufferedLog = new BufferedSlf4jLogger(log)) {
            RdbmsEpsilonValidator.validateRdbms(bufferedLog,
                    rdbmsModel,
                    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI(),
                    expectedErrors,
                    expectedWarnings);
        } catch (EvlScriptExecutionException ex) {
            log.error("EVL failed", ex);
            log.error("\u001B[31m - expected errors: {}\u001B[0m", expectedErrors);
            log.error("\u001B[31m - unexpected errors: {}\u001B[0m", ex.getUnexpectedErrors());
            log.error("\u001B[31m - errors not found: {}\u001B[0m", ex.getErrorsNotFound());
            log.error("\u001B[33m - expected warnings: {}\u001B[0m", expectedWarnings);
            log.error("\u001B[33m - unexpected warnings: {}\u001B[0m", ex.getUnexpectedWarnings());
            log.error("\u001B[33m - warnings not found: {}\u001B[0m", ex.getWarningsNotFound());
            throw ex;
        }
    }

    /**
     * Run Java (Zeta framework) validation.
     */
    protected void runJavaValidation(
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) throws Exception {

        try (BufferedSlf4jLogger bufferedLog = new BufferedSlf4jLogger(log)) {
            RdbmsValidator.validateRdbms(bufferedLog,
                    rdbmsModel,
                    expectedErrors,
                    expectedWarnings,
                    false); // Sequential for deterministic test results
        }
    }

    /**
     * Run Java validation with parallel execution option.
     *
     * @param expectedErrors Collection of expected error constraint names
     * @param expectedWarnings Collection of expected warning constraint names
     * @param parallel Whether to use parallel validation
     * @throws Exception if validation fails unexpectedly
     */
    protected void runJavaValidation(
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings,
            boolean parallel) throws Exception {

        try (BufferedSlf4jLogger bufferedLog = new BufferedSlf4jLogger(log)) {
            RdbmsValidator.validateRdbms(bufferedLog,
                    rdbmsModel,
                    expectedErrors,
                    expectedWarnings,
                    parallel);
        }
    }
}
