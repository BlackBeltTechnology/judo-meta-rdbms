package hu.blackbelt.judo.meta.rdbms.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import hu.blackbelt.judo.cli.api.CliValidationException;
import hu.blackbelt.judo.cli.api.ModelValidator;
import hu.blackbelt.judo.cli.api.ValidationType;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidator;

/**
 * RDBMS validator implementation.
 * <p>
 * Implements {@link ModelValidator} from model-cli-api for type-safe validation.
 * Supports both Epsilon (EVL) and Zeta (Java) validation engines.
 */
public class RdbmsValidatorImpl implements ModelValidator {

    @Override
    public String getModelType() {
        return "rdbms";
    }

    @Override
    public Set<ValidationType> getSupportedTypes() {
        return Set.of(ValidationType.EPSILON, ValidationType.ZETA, ValidationType.BOTH);
    }

    @Override
    public void validate(Logger logger, Object model) throws CliValidationException {
        // Default to EPSILON validation
        validate(logger, model, ValidationType.EPSILON);
    }

    @Override
    public void validate(Logger logger, Object model, ValidationType type) throws CliValidationException {
        if (!(model instanceof RdbmsModel)) {
            throw new IllegalArgumentException(
                "Expected RdbmsModel but got: " + (model == null ? "null" : model.getClass().getName()));
        }
        
        RdbmsModel rdbmsModel = (RdbmsModel) model;
        List<CliValidationException> exceptions = new ArrayList<>();

        // Run EPSILON validation
        if (type == ValidationType.EPSILON || type == ValidationType.BOTH) {
            try {
                validateWithEpsilon(logger, rdbmsModel);
            } catch (CliValidationException e) {
                exceptions.add(e);
            }
        }

        // Run ZETA validation
        if (type == ValidationType.ZETA || type == ValidationType.BOTH) {
            try {
                validateWithZeta(logger, rdbmsModel);
            } catch (CliValidationException e) {
                exceptions.add(e);
            }
        }

        // If there were any exceptions, combine and throw
        if (!exceptions.isEmpty()) {
            if (exceptions.size() == 1) {
                throw exceptions.get(0);
            }
            // Combine all errors from multiple validators
            List<String> allErrors = new ArrayList<>();
            for (CliValidationException e : exceptions) {
                for (String error : e.getErrors()) {
                    String prefix = e.getValidationType() != null 
                        ? "[" + e.getValidationType().name() + "] " 
                        : "";
                    allErrors.add(prefix + error);
                }
            }
            throw new CliValidationException("rdbms", type, allErrors);
        }
    }

    private void validateWithEpsilon(Logger logger, RdbmsModel rdbmsModel) throws CliValidationException {
        try {
            RdbmsEpsilonValidator.validateRdbms(logger, rdbmsModel,
                    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI());
        } catch (Exception e) {
            throw new CliValidationException("rdbms", ValidationType.EPSILON, 
                "Epsilon validation failed: " + e.getMessage(), e);
        }
    }

    private void validateWithZeta(Logger logger, RdbmsModel rdbmsModel) throws CliValidationException {
        try {
            RdbmsValidator.validateRdbms(logger, rdbmsModel);
        } catch (RdbmsModel.RdbmsValidationException e) {
            throw new CliValidationException("rdbms", ValidationType.ZETA, e.getMessage(), e);
        }
    }
}
