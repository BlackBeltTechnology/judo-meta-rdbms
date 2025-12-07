package hu.blackbelt.judo.meta.rdbms.validation;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
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

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils;
import hu.blackbelt.judo.meta.rdbms.validation.rules.RdbmsElementValidations;
import hu.blackbelt.judo.meta.rdbms.validation.rules.RdbmsTableValidations;
import hu.blackbelt.judo.zeta.common.ExtensionMethodRegistry;
import hu.blackbelt.judo.zeta.common.ModelProvider;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.ValidationExecutor;
import hu.blackbelt.judo.zeta.validation.core.ValidationRegistry;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Entry point for Java-based RDBMS model validation using the Zeta validation framework.
 *
 * <p>This validator provides an alternative to EVL (Epsilon Validation Language) validation
 * with better IDE support, debugging capabilities, and performance through parallel execution.</p>
 *
 * <p>Usage:</p>
 * <pre>{@code
 * RdbmsValidator.validateRdbms(log, rdbmsModel);
 * // or with expected results for testing:
 * RdbmsValidator.validateRdbms(log, rdbmsModel, expectedErrors, expectedWarnings, parallel);
 * }</pre>
 *
 * @see RdbmsValidationConstants
 * @see hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator
 */
public class RdbmsValidator {

    private RdbmsValidator() {
        // Prevent instantiation
    }

    /**
     * Validate RDBMS model using Java validation rules.
     *
     * @param log Logger for validation output
     * @param rdbmsModel The RDBMS model to validate
     * @throws RdbmsModel.RdbmsValidationException if validation errors are found
     */
    public static void validateRdbms(Logger log, RdbmsModel rdbmsModel)
            throws RdbmsModel.RdbmsValidationException {
        validateRdbms(log, rdbmsModel, null, null, false);
    }

    /**
     * Validate RDBMS model with expected errors and warnings (for testing).
     *
     * @param log Logger for validation output
     * @param rdbmsModel The RDBMS model to validate
     * @param expectedErrors Collection of expected error constraint names (null to not check)
     * @param expectedWarnings Collection of expected warning constraint names (null to not check)
     * @throws RdbmsModel.RdbmsValidationException if validation results don't match expectations
     */
    public static void validateRdbms(
            Logger log,
            RdbmsModel rdbmsModel,
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) throws RdbmsModel.RdbmsValidationException {
        validateRdbms(log, rdbmsModel, expectedErrors, expectedWarnings, false);
    }

    /**
     * Validate RDBMS model with all options.
     *
     * @param log Logger for validation output
     * @param rdbmsModel The RDBMS model to validate
     * @param expectedErrors Collection of expected error constraint names (null to not check)
     * @param expectedWarnings Collection of expected warning constraint names (null to not check)
     * @param parallel Whether to use parallel validation execution
     * @throws RdbmsModel.RdbmsValidationException if validation results don't match expectations
     */
    public static void validateRdbms(
            Logger log,
            RdbmsModel rdbmsModel,
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings,
            boolean parallel) throws RdbmsModel.RdbmsValidationException {

        log.info("Starting Java-based RDBMS validation (parallel={})...", parallel);

        // Create validation infrastructure
        ValidationRegistry registry = new ValidationRegistry();
        ExtensionMethodRegistry extensionRegistry = new ExtensionMethodRegistry();

        // Register validation rule classes
        registerValidators(registry);

        // Create model provider adapter for RdbmsUtils
        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet(), false);
        ModelProvider modelProvider = new RdbmsModelProvider(rdbmsUtils, rdbmsModel.getResourceSet());

        // Create validation context
        ValidationContext context = new ValidationContext(
                modelProvider,
                rdbmsModel.getResourceSet(),
                extensionRegistry
        );
        context.setValidationRegistry(registry);

        // Create executor
        ValidationExecutor executor = new ValidationExecutor(registry, context, parallel);

        try {
            // Collect all elements to validate
            List<EObject> allElements = getAllElements(rdbmsModel);
            log.info("Validating {} elements...", allElements.size());

            // Execute validation
            List<ValidationResult> failures = executor.validate(allElements);

            // Separate errors and warnings
            List<ValidationResult> errors = failures.stream()
                    .filter(r -> r.getSeverity() == Severity.ERROR)
                    .collect(Collectors.toList());

            List<ValidationResult> warnings = failures.stream()
                    .filter(r -> r.getSeverity() == Severity.WARNING)
                    .collect(Collectors.toList());

            log.info("Validation complete: {} errors, {} warnings", errors.size(), warnings.size());

            // Check against expected results if provided
            boolean hasUnexpected = false;
            if (expectedErrors != null || expectedWarnings != null) {
                hasUnexpected = checkExpectedResults(log, errors, warnings, expectedErrors, expectedWarnings);
            }

            // Log failures
            if (!errors.isEmpty()) {
                logFailures(log, errors, "ERRORS");
            }
            if (!warnings.isEmpty()) {
                logFailures(log, warnings, "WARNINGS");
            }

            // Throw exception if there are unexpected failures
            if (hasUnexpected) {
                throw new RdbmsModel.RdbmsValidationException(rdbmsModel);
            }
            if (!errors.isEmpty() && expectedErrors == null) {
                throw new RdbmsModel.RdbmsValidationException(rdbmsModel);
            }

        } finally {
            executor.shutdown();
        }
    }

    /**
     * Register all validation rule classes with the registry.
     */
    private static void registerValidators(ValidationRegistry registry) {
        registry.register(RdbmsElementValidations.class);
        registry.register(RdbmsTableValidations.class);
        // Add more validation classes as they are created
    }

    /**
     * Collect all EObjects from the model for validation.
     */
    private static List<EObject> getAllElements(RdbmsModel rdbmsModel) {
        List<EObject> allElements = new ArrayList<>();

        for (Resource resource : rdbmsModel.getResourceSet().getResources()) {
            Iterator<EObject> it = resource.getAllContents();
            while (it.hasNext()) {
                allElements.add(it.next());
            }
            // Also add root elements
            allElements.addAll(resource.getContents());
        }

        return allElements;
    }

    /**
     * Check validation results against expected errors and warnings.
     *
     * @return true if there are unexpected results or missing expected results
     */
    private static boolean checkExpectedResults(
            Logger log,
            List<ValidationResult> errors,
            List<ValidationResult> warnings,
            Collection<String> expectedErrors,
            Collection<String> expectedWarnings) {

        Set<String> actualErrors = errors.stream()
                .map(ValidationResult::getConstraintName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        Set<String> actualWarnings = warnings.stream()
                .map(ValidationResult::getConstraintName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        Set<String> expectedErrorSet = expectedErrors != null
                ? new HashSet<>(expectedErrors)
                : Collections.emptySet();
        Set<String> expectedWarningSet = expectedWarnings != null
                ? new HashSet<>(expectedWarnings)
                : null; // null means "don't check warnings"

        // Find unexpected and missing errors
        Set<String> unexpectedErrors = new HashSet<>(actualErrors);
        unexpectedErrors.removeAll(expectedErrorSet);

        Set<String> missingErrors = new HashSet<>(expectedErrorSet);
        missingErrors.removeAll(actualErrors);

        // Only check warnings if expectedWarnings was explicitly provided (not null)
        Set<String> unexpectedWarnings = Collections.emptySet();
        Set<String> missingWarnings = Collections.emptySet();
        if (expectedWarningSet != null) {
            unexpectedWarnings = new HashSet<>(actualWarnings);
            unexpectedWarnings.removeAll(expectedWarningSet);
            missingWarnings = new HashSet<>(expectedWarningSet);
            missingWarnings.removeAll(actualWarnings);
        }

        boolean hasUnexpected = !unexpectedErrors.isEmpty()
                || !missingErrors.isEmpty()
                || !unexpectedWarnings.isEmpty()
                || !missingWarnings.isEmpty();

        if (hasUnexpected) {
            log.error("Validation result mismatch:");
            log.error("  Actual errors: {}", actualErrors);
            log.error("  Expected errors: {}", expectedErrorSet);
            log.error("  Actual warnings: {}", actualWarnings);
            log.error("  Expected warnings: {}", expectedWarningSet);
            if (!unexpectedErrors.isEmpty()) {
                log.error("  Unexpected errors: {}", unexpectedErrors);
            }
            if (!missingErrors.isEmpty()) {
                log.error("  Missing errors: {}", missingErrors);
            }
            if (!unexpectedWarnings.isEmpty()) {
                log.error("  Unexpected warnings: {}", unexpectedWarnings);
            }
            if (!missingWarnings.isEmpty()) {
                log.error("  Missing warnings: {}", missingWarnings);
            }
        }

        return hasUnexpected;
    }

    /**
     * Log validation failures with details.
     */
    private static void logFailures(Logger log, List<ValidationResult> failures, String label) {
        log.info("{}: {}", label, failures.size());
        for (ValidationResult failure : failures) {
            String elementInfo = "";
            if (failure.getContext() != null) {
                elementInfo = " on " + failure.getContext().eClass().getName();
            }
            log.info("  [{}] {}: {}{}",
                    failure.getSeverity(),
                    failure.getConstraintName(),
                    failure.getMessage(),
                    elementInfo);
        }
    }

    /**
     * ModelProvider implementation that adapts RdbmsUtils for the Zeta validation framework.
     */
    private static class RdbmsModelProvider implements ModelProvider {
        private final RdbmsUtils rdbmsUtils;
        private final ResourceSet resourceSet;

        RdbmsModelProvider(RdbmsUtils rdbmsUtils, ResourceSet resourceSet) {
            this.rdbmsUtils = rdbmsUtils;
            this.resourceSet = resourceSet;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T extends EObject> Collection<T> getAllContents(ResourceSet rs, Class<T> clazz) {
            List<T> result = new ArrayList<>();
            for (Resource resource : rs.getResources()) {
                Iterator<EObject> it = resource.getAllContents();
                while (it.hasNext()) {
                    EObject obj = it.next();
                    if (clazz.isInstance(obj)) {
                        result.add((T) obj);
                    }
                }
            }
            return result;
        }

        @Override
        public String getName(EObject element) {
            // Try to get name via reflection for RdbmsElement types
            try {
                java.lang.reflect.Method getName = element.getClass().getMethod("getName");
                Object result = getName.invoke(element);
                return result != null ? result.toString() : null;
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public String getTypeName(EObject element) {
            return element.eClass().getName();
        }
    }
}
