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

import hu.blackbelt.judo.meta.rdbms.RdbmsElement;
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidationConstants;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;
import org.eclipse.emf.ecore.EObject;

/**
 * Validation rules for {@link RdbmsElement} and its subclasses.
 *
 * <p>This class contains placeholder validation rules that can be expanded
 * as actual validation requirements are defined in rdbms.evl.</p>
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsElement.class)
public class RdbmsElementValidations {

    // Currently no validation rules are defined in rdbms.evl
    // This class serves as a placeholder for future validation rules

    // Example of how to add a constraint when needed:
    //
    // @Constraint(
    //     name = RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY,
    //     message = "RDBMS element name must not be empty"
    // )
    // public ValidationRule rdbmsElementNameNotEmpty() {
    //     return (element, ctx) -> {
    //         RdbmsElement self = (RdbmsElement) element;
    //         if (self.getName() != null && !self.getName().trim().isEmpty()) {
    //             return ValidationResult.pass();
    //         }
    //         return ValidationResult.fail(
    //             RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY,
    //             "RDBMS element name must not be empty",
    //             Severity.ERROR,
    //             self
    //         );
    //     };
    // }

    /**
     * Guard method: checks if element has a container.
     *
     * @param element The element to check
     * @param ctx The validation context
     * @return true if element has a container
     */
    public boolean hasContainer(EObject element, hu.blackbelt.judo.zeta.validation.core.ValidationContext ctx) {
        return element.eContainer() != null;
    }

    /**
     * Guard method: checks if element has a non-empty name.
     *
     * @param element The element to check
     * @param ctx The validation context
     * @return true if element has a name
     */
    public boolean hasName(EObject element, hu.blackbelt.judo.zeta.validation.core.ValidationContext ctx) {
        if (element instanceof RdbmsElement) {
            RdbmsElement rdbmsElement = (RdbmsElement) element;
            return rdbmsElement.getName() != null && !rdbmsElement.getName().trim().isEmpty();
        }
        return false;
    }
}
