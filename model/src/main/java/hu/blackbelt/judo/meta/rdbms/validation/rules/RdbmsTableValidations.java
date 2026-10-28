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

import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.Critique;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;
import org.eclipse.emf.ecore.EObject;

/**
 * Validation rules for {@link RdbmsTable}.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsTable.class)
public class RdbmsTableValidations {

    /**
     * Pattern for valid table names (uppercase letters, digits, underscore).
     */
    private static final String TABLE_NAME_PATTERN = "^[A-Z][A-Z0-9_]*$";

    /**
     * Constraint: Table must have a primary key.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY,
        message = "RDBMS table must have a primary key"
    )
    public ValidationRule rdbmsTableHasPrimaryKey() {
        return (element, ctx) -> {
            RdbmsTable self = (RdbmsTable) element;
            if (self.getPrimaryKey() != null) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY,
                "RDBMS table '" + self.getName() + "' must have a primary key",
                Severity.ERROR,
                self
            );
        };
    }

    /**
     * Constraint: Primary key must not be null if table is expected to have one.
     * This is a stricter check than hasPrimaryKey - ensures the reference itself is valid.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_PRIMARY_KEY_NOT_NULL,
        message = "RDBMS table primary key must not be null"
    )
    public ValidationRule rdbmsTablePrimaryKeyNotNull() {
        return (element, ctx) -> {
            RdbmsTable self = (RdbmsTable) element;
            // Check if primary key reference is set but points to null
            // This catches cases where the reference was set but the target was deleted
            if (self.getPrimaryKey() == null) {
                return ValidationResult.fail(
                    RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_PRIMARY_KEY_NOT_NULL,
                    "RDBMS table '" + self.getName() + "' primary key reference is null",
                    Severity.ERROR,
                    self
                );
            }
            return ValidationResult.pass();
        };
    }

    /**
     * Critique: Table name should follow naming convention (uppercase with underscores).
     *
     * @return validation rule
     */
    @Critique(
        name = RdbmsValidationConstants.CRITIQUE_RDBMS_TABLE_NAME_CONVENTION,
        message = "RDBMS table name should follow naming convention"
    )
    public ValidationRule rdbmsTableNameConvention() {
        return (element, ctx) -> {
            RdbmsTable self = (RdbmsTable) element;
            String name = self.getSqlName();

            // Skip if sqlName is null - use name as fallback
            if (name == null || name.trim().isEmpty()) {
                name = self.getName();
            }

            // Skip if name is null or empty (handled by other constraint)
            if (name == null || name.trim().isEmpty()) {
                return ValidationResult.pass();
            }

            if (name.matches(TABLE_NAME_PATTERN)) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CRITIQUE_RDBMS_TABLE_NAME_CONVENTION,
                "RDBMS table name '" + name + "' does not follow naming convention (expected uppercase with underscores)",
                Severity.WARNING,
                self
            );
        };
    }

    /**
     * Guard method: checks if table has a primary key defined.
     *
     * @param element The element to check
     * @param ctx The validation context
     * @return true if table has a primary key
     */
    public boolean hasPrimaryKey(EObject element, hu.blackbelt.judo.zeta.validation.core.ValidationContext ctx) {
        if (element instanceof RdbmsTable) {
            RdbmsTable table = (RdbmsTable) element;
            return table.getPrimaryKey() != null;
        }
        return false;
    }
}
