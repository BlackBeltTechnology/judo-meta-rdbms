package hu.blackbelt.judo.meta.rdbms.validation.rules;

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

import hu.blackbelt.judo.meta.rdbms.RdbmsConfiguration;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;

/**
 * Validation rules for {@link RdbmsConfiguration}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsConfiguration.class)
public class RdbmsConfigurationValidations {

    /**
     * Constraint: Configuration must specify a dialect.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_CONFIGURATION_HAS_DIALECT,
        message = "RDBMS configuration must specify a dialect"
    )
    public ValidationRule rdbmsConfigurationHasDialect() {
        return (element, ctx) -> {
            RdbmsConfiguration self = (RdbmsConfiguration) element;

            // Configuration must have a dialect specified
            if (self.getDialect() != null && !self.getDialect().trim().isEmpty()) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_CONFIGURATION_HAS_DIALECT,
                "RDBMS configuration must specify a dialect",
                Severity.ERROR,
                self
            );
        };
    }
}
