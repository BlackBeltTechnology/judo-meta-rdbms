package hu.blackbelt.judo.meta.rdbms.cli;

import org.slf4j.Logger;
import hu.blackbelt.judo.cli.api.ModelValidator;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidator;

/**
 * RDBMS validator implementation.
 * <p>
 * Implements {@link ModelValidator} from model-cli-api for type-safe validation.
 */
public class RdbmsValidatorImpl implements ModelValidator {

    /**
     * Returns the model type identifier.
     *
     * @return "rdbms"
     */
    public String getModelType() {
        return "rdbms";
    }

    @Override
    public void validate(Logger logger, Object model) throws Exception {
        if (!(model instanceof RdbmsModel)) {
            throw new IllegalArgumentException(
                "Expected RdbmsModel but got: " + (model == null ? "null" : model.getClass().getName()));
        }
        RdbmsValidator.validateRdbms(logger, (RdbmsModel) model);
    }

    /**
     * Validates the RDBMS model directly (type-safe convenience method).
     *
     * @param logger     the logger for validation messages
     * @param rdbmsModel the RDBMS model to validate
     * @throws RdbmsModel.RdbmsValidationException if validation fails
     */
    public void validateModel(Logger logger, RdbmsModel rdbmsModel) throws RdbmsModel.RdbmsValidationException {
        RdbmsValidator.validateRdbms(logger, rdbmsModel);
    }
}
