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

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.Critique;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;

/**
 * Validation rules for {@link RdbmsField}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsField.class)
public class RdbmsFieldValidations {

    /**
     * Pattern for valid field names (lowercase letters, digits, underscore).
     */
    private static final String FIELD_NAME_PATTERN = "^[a-z][a-z0-9_]*$";

    /**
     * Constraint: Field must have a valid type.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_FIELD_HAS_VALID_TYPE,
        message = "RDBMS field must have a valid type"
    )
    public ValidationRule rdbmsFieldHasValidType() {
        return (element, ctx) -> {
            RdbmsField self = (RdbmsField) element;
            String typeName = self.getRdbmsTypeName();

            // Field must have a type name defined
            if (typeName != null && !typeName.trim().isEmpty()) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_FIELD_HAS_VALID_TYPE,
                "RDBMS field '" + self.getName() + "' must have a valid type",
                Severity.ERROR,
                self
            );
        };
    }

    /**
     * Critique: Field name should follow naming convention (lowercase with underscores).
     *
     * @return validation rule
     */
    @Critique(
        name = RdbmsValidationConstants.CRITIQUE_RDBMS_FIELD_NAME_CONVENTION,
        message = "RDBMS field name should follow naming convention"
    )
    public ValidationRule rdbmsFieldNameConvention() {
        return (element, ctx) -> {
            RdbmsField self = (RdbmsField) element;
            String name = self.getSqlName();

            // Skip if sqlName is null - use name as fallback
            if (name == null || name.trim().isEmpty()) {
                name = self.getName();
            }

            // Skip if name is null or empty (handled by other constraint)
            if (name == null || name.trim().isEmpty()) {
                return ValidationResult.pass();
            }

            if (name.matches(FIELD_NAME_PATTERN)) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CRITIQUE_RDBMS_FIELD_NAME_CONVENTION,
                "RDBMS field name '" + name + "' does not follow naming convention (expected lowercase with underscores)",
                Severity.WARNING,
                self
            );
        };
    }
}
