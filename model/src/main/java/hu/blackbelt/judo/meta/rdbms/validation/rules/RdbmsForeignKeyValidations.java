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

import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;

/**
 * Validation rules for {@link RdbmsForeignKey}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsForeignKey.class)
public class RdbmsForeignKeyValidations {

    /**
     * Constraint: Foreign key must reference a table (via referenceKey).
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_FOREIGN_KEY_HAS_REFERENCE,
        message = "RDBMS foreign key must reference a table"
    )
    public ValidationRule rdbmsForeignKeyHasReference() {
        return (element, ctx) -> {
            RdbmsForeignKey self = (RdbmsForeignKey) element;

            // Foreign key must have a reference key pointing to another table's identifier
            if (self.getReferenceKey() != null) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_FOREIGN_KEY_HAS_REFERENCE,
                "RDBMS foreign key '" + self.getName() + "' must reference a table",
                Severity.ERROR,
                self
            );
        };
    }
}
