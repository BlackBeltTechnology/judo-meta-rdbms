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

import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;

/**
 * Validation rules for {@link RdbmsJunctionTable}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsJunctionTable.class)
public class RdbmsJunctionTableValidations {

    /**
     * Constraint: Junction table must have both foreign key fields (field1 and field2).
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_JUNCTION_TABLE_HAS_BOTH_FIELDS,
        message = "RDBMS junction table must have both foreign key fields"
    )
    public ValidationRule rdbmsJunctionTableHasBothFields() {
        return (element, ctx) -> {
            RdbmsJunctionTable self = (RdbmsJunctionTable) element;

            // Junction table must have both field1 and field2
            if (self.getField1() != null && self.getField2() != null) {
                return ValidationResult.pass();
            }

            String missingFields = "";
            if (self.getField1() == null && self.getField2() == null) {
                missingFields = "field1 and field2";
            } else if (self.getField1() == null) {
                missingFields = "field1";
            } else {
                missingFields = "field2";
            }

            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_JUNCTION_TABLE_HAS_BOTH_FIELDS,
                "RDBMS junction table '" + self.getName() + "' is missing " + missingFields,
                Severity.ERROR,
                self
            );
        };
    }
}
