package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model :: Test
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

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Validation tests for RDBMS metamodel using dual EVL/Java validation.
 *
 * <p>This test class runs the same test cases against both EVL (Epsilon Validation Language)
 * and Java (Zeta framework) validators to ensure parity between implementations.</p>
 *
 * <p>Currently, the RDBMS metamodel has no validation rules defined in rdbms.evl,
 * so these tests verify that an empty/valid model passes validation with both engines.</p>
 *
 * @see AbstractRdbmsValidationTest
 * @see ValidatorType
 */
@DisplayName("RDBMS Validation Tests")
public class RdbmsValidationTest extends AbstractRdbmsValidationTest {

    @ParameterizedTest(name = "testEmptyModelPassesValidation [{0}]")
    @EnumSource(ValidatorType.class)
    @DisplayName("Empty model passes validation")
    void testEmptyModelPassesValidation(ValidatorType type) throws Exception {
        this.validatorType = type;
        initModel();

        // Empty model should pass validation (no rules defined in rdbms.evl)
        runValidation(
                ImmutableList.of(),  // No expected errors
                ImmutableList.of()   // No expected warnings
        );
    }

    // Future test methods can be added here following this pattern:
    //
    // @ParameterizedTest(name = "testConstraintName [{0}]")
    // @EnumSource(ValidatorType.class)
    // @DisplayName("Description of what is being tested")
    // void testConstraintName(ValidatorType type) throws Exception {
    //     this.validatorType = type;
    //     initModel();
    //
    //     // Build model that triggers the constraint
    //     RdbmsTable table = newRdbmsTableBuilderInit()
    //             .withName("TestTable")
    //             .build();
    //     rdbmsModel.addContent(table);
    //
    //     runValidation(
    //             ImmutableList.of("ExpectedConstraintName"),
    //             ImmutableList.of()
    //     );
    // }
}
