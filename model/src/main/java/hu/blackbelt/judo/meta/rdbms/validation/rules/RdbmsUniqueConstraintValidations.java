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

import hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;

/**
 * Validation rules for {@link RdbmsUniqueConstraint}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsUniqueConstraint.class)
public class RdbmsUniqueConstraintValidations {

    /**
     * Constraint: Unique constraint must have fields defined.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_UNIQUE_CONSTRAINT_HAS_FIELDS,
        message = "RDBMS unique constraint must have fields defined"
    )
    public ValidationRule rdbmsUniqueConstraintHasFields() {
        return (element, ctx) -> {
            RdbmsUniqueConstraint self = (RdbmsUniqueConstraint) element;

            // Unique constraint must have at least one field
            if (self.getFields() != null && !self.getFields().isEmpty()) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_UNIQUE_CONSTRAINT_HAS_FIELDS,
                "RDBMS unique constraint '" + self.getName() + "' must have at least one field",
                Severity.ERROR,
                self
            );
        };
    }
}
