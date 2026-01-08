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
import hu.blackbelt.judo.meta.rdbms.validation.RdbmsValidator;
import hu.blackbelt.judo.zeta.annotation.Constraint;
import hu.blackbelt.judo.zeta.annotation.ValidationContext;
import hu.blackbelt.judo.zeta.validation.core.Severity;
import hu.blackbelt.judo.zeta.validation.core.ValidationResult;
import hu.blackbelt.judo.zeta.validation.core.ValidationRule;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Validation rules for {@link RdbmsElement} and its subclasses.
 *
 * @see RdbmsValidationConstants
 */
@ValidationContext(RdbmsElement.class)
public class RdbmsElementValidations {

    /**
     * Constraint: Element name must not be empty.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY,
        message = "RDBMS element name must not be empty"
    )
    public ValidationRule rdbmsElementNameNotEmpty() {
        return (element, ctx) -> {
            RdbmsElement self = (RdbmsElement) element;
            if (self.getName() != null && !self.getName().trim().isEmpty()) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY,
                "RDBMS element name must not be empty",
                Severity.ERROR,
                self
            );
        };
    }

    /**
     * Constraint: Element UUID must not be empty.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_UUID_NOT_EMPTY,
        message = "RDBMS element UUID must not be empty"
    )
    public ValidationRule rdbmsElementUuidNotEmpty() {
        return (element, ctx) -> {
            RdbmsElement self = (RdbmsElement) element;
            if (self.getUuid() != null && !self.getUuid().trim().isEmpty()) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_UUID_NOT_EMPTY,
                "RDBMS element '" + self.getName() + "' UUID must not be empty",
                Severity.ERROR,
                self
            );
        };
    }

    /**
     * Constraint: Element name must be unique within the model.
     * <p>
     * Uses a pre-built name index for O(1) lookup instead of O(n) iteration.
     * The index is built once by {@link RdbmsValidator#buildNameIndex} before validation.
     *
     * @return validation rule
     */
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_IS_UNIQUE,
        message = "RDBMS element name must be unique"
    )
    public ValidationRule rdbmsElementNameIsUnique() {
        return (element, ctx) -> {
            RdbmsElement self = (RdbmsElement) element;
            String selfName = self.getName();

            // Skip if name is null or empty (handled by other constraint)
            if (selfName == null || selfName.trim().isEmpty()) {
                return ValidationResult.pass();
            }

            // Use cached name index for O(1) lookup instead of O(n) iteration
            @SuppressWarnings("unchecked")
            Map<String, List<RdbmsElement>> nameIndex = ctx.getAttribute(RdbmsValidator.NAME_INDEX_KEY);

            if (nameIndex != null) {
                // Fast path: use pre-built index
                List<RdbmsElement> elementsWithSameName = nameIndex.get(selfName);
                if (elementsWithSameName != null && elementsWithSameName.size() > 1) {
                    return ValidationResult.fail(
                        RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_IS_UNIQUE,
                        "RDBMS element name '" + selfName + "' is not unique",
                        Severity.ERROR,
                        self
                    );
                }
            } else {
                // Fallback: iterate all elements (O(n) per element = O(n²) total)
                Resource resource = self.eResource();
                if (resource != null) {
                    Iterator<EObject> it = resource.getAllContents();
                    while (it.hasNext()) {
                        EObject obj = it.next();
                        if (obj instanceof RdbmsElement && obj != self) {
                            RdbmsElement other = (RdbmsElement) obj;
                            if (selfName.equals(other.getName())) {
                                return ValidationResult.fail(
                                    RdbmsValidationConstants.CONSTRAINT_RDBMS_ELEMENT_NAME_IS_UNIQUE,
                                    "RDBMS element name '" + selfName + "' is not unique",
                                    Severity.ERROR,
                                    self
                                );
                            }
                        }
                    }
                }
            }

            return ValidationResult.pass();
        };
    }

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
