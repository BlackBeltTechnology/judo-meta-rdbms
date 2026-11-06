# Change: Add Zeta Java Validation Framework with Dual EVL/Java Testing

**Status: IMPLEMENTED**

## Why

The current RDBMS metamodel validation relies solely on EVL (Epsilon Validation Language). While EVL is functional, it lacks IDE support, debugging capabilities, and has performance limitations with large models. Adding a native Java validation framework using Zeta provides:
- Full IDE support (autocompletion, refactoring, debugging)
- Better performance through parallel execution
- Type-safe validation rules with compile-time checking
- Consistent pattern with ESM module (already using Zeta)

## What Changes

### Core Infrastructure
- Add Zeta framework dependencies (`judo-zeta-version: 1.0.0.20251207_081454_0779b890_develop`)
- Create Java validator entry point (`RdbmsValidator.java`)
- Create validation rule classes using Zeta annotations
- Use constants for all constraint names, guard methods, and validation messages

### Validation Rules Implementation
Implement 13 validation rules defined in `RdbmsValidationConstants.java`:

**Constraints (ERROR level) - 11 rules:**
| Constant | Target | Description |
|----------|--------|-------------|
| RdbmsElementNameNotEmpty | RdbmsElement | Element name must not be empty |
| RdbmsElementUuidNotEmpty | RdbmsElement | Element UUID must not be empty |
| RdbmsElementNameIsUnique | RdbmsElement | Element name must be unique |
| RdbmsTableHasPrimaryKey | RdbmsTable | Table must have a primary key |
| RdbmsTablePrimaryKeyNotNull | RdbmsTable | Primary key must not be null |
| RdbmsFieldHasValidType | RdbmsField | Field must have a valid type |
| RdbmsForeignKeyHasReference | RdbmsForeignKey | Foreign key must reference a table |
| RdbmsIndexHasFields | RdbmsIndex | Index must have fields defined |
| RdbmsUniqueConstraintHasFields | RdbmsUniqueConstraint | Unique constraint must have fields |
| RdbmsJunctionTableHasBothFields | RdbmsJunctionTable | Junction table must have both fields |
| RdbmsConfigurationHasDialect | RdbmsConfiguration | Configuration must specify dialect |

**Critiques (WARNING level) - 2 rules:**
| Constant | Target | Description |
|----------|--------|-------------|
| RdbmsTableNameConvention | RdbmsTable | Table name follows naming convention |
| RdbmsFieldNameConvention | RdbmsField | Field name follows naming convention |

### Test Infrastructure
- Add `ValidatorType` enum (EVL, JAVA) for test parametrization
- Modify `RdbmsValidationTest` base class for dual validation support
- Convert existing tests to `@ParameterizedTest` with `@EnumSource(ValidatorType.class)`
- Add performance test with 10,000 element model

### Documentation
- Update `docs/` with Zeta validation references
- Add validation method documentation
- Update `README.adoc` with new validation information

## Impact

- **Affected specs**: validation (new capability)
- **Affected code**:
  - `model/pom.xml` - Add Zeta dependencies
  - `model/src/main/java/hu/blackbelt/judo/meta/rdbms/validation/` - New validation classes
  - `model-test/pom.xml` - Add test dependencies
  - `model-test/src/test/java/` - Modified tests with dual validation
  - `docs/` - Updated documentation
  - `README.adoc` - Updated documentation

## Dependencies

- Zeta framework: `hu.blackbelt.judo.zeta` version `1.0.0.20251207_081454_0779b890_develop`
- Reference implementation: ESM module (`/Users/robson/Project/judo-ng/models/judo-meta-esm`)

## Non-Goals

- Removing EVL validation (both systems run in parallel)
- Changing validation semantics (Java must produce identical results to EVL)
