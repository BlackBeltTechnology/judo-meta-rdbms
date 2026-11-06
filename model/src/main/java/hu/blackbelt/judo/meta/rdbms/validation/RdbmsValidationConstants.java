package hu.blackbelt.judo.meta.rdbms.validation;

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

/**
 * Constants for RDBMS validation constraint names, guard method names, and critique names.
 *
 * <p>All validation-related string constants should be defined here to ensure
 * consistency between EVL and Java validation implementations.</p>
 */
public final class RdbmsValidationConstants {

    private RdbmsValidationConstants() {
        // Prevent instantiation
    }

    // ========================================================================
    // Constraint Names (ERROR level)
    // ========================================================================

    // RdbmsElement constraints
    public static final String CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY = "RdbmsElementNameNotEmpty";
    public static final String CONSTRAINT_RDBMS_ELEMENT_UUID_NOT_EMPTY = "RdbmsElementUuidNotEmpty";
    public static final String CONSTRAINT_RDBMS_ELEMENT_NAME_IS_UNIQUE = "RdbmsElementNameIsUnique";

    // RdbmsTable constraints
    public static final String CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY = "RdbmsTableHasPrimaryKey";
    public static final String CONSTRAINT_RDBMS_TABLE_PRIMARY_KEY_NOT_NULL = "RdbmsTablePrimaryKeyNotNull";

    // RdbmsField constraints
    public static final String CONSTRAINT_RDBMS_FIELD_HAS_VALID_TYPE = "RdbmsFieldHasValidType";

    // RdbmsForeignKey constraints
    public static final String CONSTRAINT_RDBMS_FOREIGN_KEY_HAS_REFERENCE = "RdbmsForeignKeyHasReference";

    // RdbmsIndex constraints
    public static final String CONSTRAINT_RDBMS_INDEX_HAS_FIELDS = "RdbmsIndexHasFields";

    // RdbmsUniqueConstraint constraints
    public static final String CONSTRAINT_RDBMS_UNIQUE_CONSTRAINT_HAS_FIELDS = "RdbmsUniqueConstraintHasFields";

    // RdbmsJunctionTable constraints
    public static final String CONSTRAINT_RDBMS_JUNCTION_TABLE_HAS_BOTH_FIELDS = "RdbmsJunctionTableHasBothFields";

    // RdbmsConfiguration constraints
    public static final String CONSTRAINT_RDBMS_CONFIGURATION_HAS_DIALECT = "RdbmsConfigurationHasDialect";

    // ========================================================================
    // Critique Names (WARNING level)
    // ========================================================================

    public static final String CRITIQUE_RDBMS_TABLE_NAME_CONVENTION = "RdbmsTableNameConvention";
    public static final String CRITIQUE_RDBMS_FIELD_NAME_CONVENTION = "RdbmsFieldNameConvention";

    // ========================================================================
    // Guard Method Names
    // ========================================================================

    public static final String GUARD_HAS_CONTAINER = "hasContainer";
    public static final String GUARD_HAS_NAME = "hasName";
    public static final String GUARD_IS_NOT_ABSTRACT = "isNotAbstract";
}
