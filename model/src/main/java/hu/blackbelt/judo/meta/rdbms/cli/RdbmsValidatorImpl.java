package hu.blackbelt.judo.meta.rdbms.cli;

import org.slf4j.Logger;

import hu.blackbelt.judo.cli.api.CliValidationException;
import hu.blackbelt.judo.cli.api.ModelValidator;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsEpsilonValidator;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;

/**
 * RDBMS validator implementation.
 * <p>
 * Implements {@link ModelValidator} from judo-cli-api for type-safe validation.
 * Uses Epsilon (EVL) validation.
 * <p>
 * Note: Zeta validation support was removed - see JNG-6354.
 */
public class RdbmsValidatorImpl implements ModelValidator {

    @Override
    public String getModelType() {
        return "rdbms";
    }

    @Override
    public void validate(Logger logger, Object model) throws CliValidationException {
        if (!(model instanceof RdbmsModel)) {
            throw new IllegalArgumentException(
                "Expected RdbmsModel but got: " + (model == null ? "null" : model.getClass().getName()));
        }
        RdbmsModel rdbmsModel = (RdbmsModel) model;

        try {
            RdbmsEpsilonValidator.validateRdbms(logger, rdbmsModel,
                    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI());
        } catch (Exception e) {
            throw new CliValidationException("rdbms",
                "EVL validation failed: " + e.getMessage(), e);
        }
    }
}
