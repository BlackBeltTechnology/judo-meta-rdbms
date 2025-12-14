# Tasks: Add Zeta Java Validation Framework

## 1. Dependencies and Build Configuration
- [x] 1.1 Add `judo-zeta-version` property (1.0.0.20251207_081454_0779b890_develop) to parent `pom.xml`
- [x] 1.2 Add Zeta dependencies to `model/pom.xml` (zeta-annotations, zeta-common, validation-core)
- [x] 1.3 Add Zeta test dependencies to `model-test/pom.xml`
- [x] 1.4 Update MANIFEST.MF if needed for OSGi imports
- [x] 1.5 Verify build compiles with new dependencies

## 2. Validation Framework Infrastructure (model/)
- [x] 2.1 Create package `hu.blackbelt.judo.meta.rdbms.validation`
- [x] 2.2 Create `RdbmsValidationConstants.java` with constraint name constants
- [x] 2.3 Create `RdbmsValidator.java` entry point class
- [x] 2.4 Create package `hu.blackbelt.judo.meta.rdbms.validation.rules`
- [x] 2.5 Create `RdbmsElementValidations.java` placeholder class with @ValidationContext
- [x] 2.6 Create `RdbmsTableValidations.java` placeholder class with @ValidationContext
- [x] 2.7 Verify Java validator compiles and can be instantiated

## 3. Test Infrastructure (model-test/)
- [x] 3.1 Create `ValidatorType.java` enum (EVL, JAVA)
- [x] 3.2 Create `AbstractRdbmsValidationTest.java` base class with:
  - Model initialization
  - `runValidation()` method dispatching to EVL or Java
  - EVL validation runner (existing logic)
  - Java validation runner (new)
- [x] 3.3 Modify `RdbmsValidationTest.java` to extend `AbstractRdbmsValidationTest`
- [x] 3.4 Convert existing test methods to `@ParameterizedTest` with `@EnumSource(ValidatorType.class)`
- [x] 3.5 Ensure existing test assertions still pass for both validators

## 4. Performance Testing
- [x] 4.1 Create `RdbmsValidationPerformanceTest.java`
- [x] 4.2 Implement model generator for 10,000 elements
- [x] 4.3 Add EVL performance measurement
- [x] 4.4 Add Java sequential performance measurement
- [x] 4.5 Add Java parallel performance measurement
- [x] 4.6 Add logging of performance comparison results

## 5. Documentation Updates
- [x] 5.1 Create `docs/validation/` directory if not exists
- [x] 5.2 Create `docs/validation/README.md` with validation overview
- [x] 5.3 Create `docs/validation/java-validation-framework.md` with:
  - Framework overview (reference Zeta docs, don't copy)
  - RDBMS-specific patterns
  - Constraint naming conventions
  - Test patterns
- [x] 5.4 Document all constraint names and their purposes
- [x] 5.5 Update `README.adoc` with validation section
- [x] 5.6 Add links to Zeta documentation (don't duplicate content)

## 6. Verification (Infrastructure)
- [x] 6.1 Run `mvn clean install` to verify full build
- [x] 6.2 Verify all existing tests pass
- [x] 6.3 Verify new parameterized tests run for both EVL and JAVA
- [x] 6.4 Verify performance test executes and logs results
- [x] 6.5 Review generated documentation

## 7. Validation Rules Implementation - Constraints (ERROR level)
- [x] 7.1 Implement `RdbmsElementNameNotEmpty` - Element name must not be empty
- [x] 7.2 Implement `RdbmsElementUuidNotEmpty` - Element UUID must not be empty
- [x] 7.3 Implement `RdbmsElementNameIsUnique` - Element name must be unique
- [x] 7.4 Implement `RdbmsTableHasPrimaryKey` - Table must have a primary key
- [x] 7.5 Implement `RdbmsTablePrimaryKeyNotNull` - Primary key must not be null
- [x] 7.6 Implement `RdbmsFieldHasValidType` - Field must have a valid type
- [x] 7.7 Implement `RdbmsForeignKeyHasReference` - Foreign key must reference a table
- [x] 7.8 Implement `RdbmsIndexHasFields` - Index must have fields defined
- [x] 7.9 Implement `RdbmsUniqueConstraintHasFields` - Unique constraint must have fields
- [x] 7.10 Implement `RdbmsJunctionTableHasBothFields` - Junction table must have both fields
- [x] 7.11 Implement `RdbmsConfigurationHasDialect` - Configuration must specify dialect

## 8. Validation Rules Implementation - Critiques (WARNING level)
- [x] 8.1 Implement `RdbmsTableNameConvention` - Table name follows naming convention
- [x] 8.2 Implement `RdbmsFieldNameConvention` - Field name follows naming convention

## 9. Tests for Validation Rules
- [x] 9.1 Add tests for RdbmsElement validations (name not empty, UUID not empty, name unique)
- [x] 9.2 Add tests for RdbmsTable validations (has primary key, primary key not null)
- [x] 9.3 Add tests for RdbmsField validations (has valid type)
- [x] 9.4 Add tests for RdbmsForeignKey validations (has reference)
- [x] 9.5 Add tests for RdbmsIndex validations (has fields)
- [x] 9.6 Add tests for RdbmsUniqueConstraint validations (has fields)
- [x] 9.7 Add tests for RdbmsJunctionTable validations (has both fields)
- [x] 9.8 Add tests for RdbmsConfiguration validations (has dialect)
- [x] 9.9 Add tests for naming convention critiques (table, field)

## 10. EVL Parity
- [x] 10.1 Add corresponding EVL rules to `rdbms.evl` for all constraints
- [x] 10.2 Add corresponding EVL critiques to `rdbms.evl` for all warnings
- [x] 10.3 Verify EVL and Java validators produce identical results

## 11. Final Verification
- [x] 11.1 Run `mvn clean install` to verify full build
- [x] 11.2 Verify all parameterized tests pass for both EVL and JAVA validators
- [x] 11.3 Update documentation with implemented rules
- [x] 11.4 Review and update performance test if needed

## Dependencies Between Tasks
- 1.x must complete before 2.x and 3.x
- 2.x and 3.x can proceed in parallel after 1.x
- 4.x depends on 2.x and 3.x completion
- 5.x can start after 2.x and 3.x (documents what was built)
- 6.x is verification of infrastructure
- 7.x and 8.x depend on 6.x completion (framework must be working)
- 9.x depends on 7.x and 8.x (tests validate the implementations)
- 10.x depends on 7.x and 8.x (EVL rules mirror Java rules)
- 11.x is final verification after all others

## Phase 1 Completion Summary (Infrastructure)

**Status: COMPLETED**

All infrastructure tasks have been implemented and verified:
- Build: SUCCESS
- Tests: 13 passed, 0 failures
- Performance test shows EVL ~18ms vs Java ~15ms for 10,000 elements

## Phase 2 Completion Summary (Validation Rules)

**Status: COMPLETED**

All validation rules have been implemented:
- Total planned rules: 13 (11 constraints + 2 critiques)
- Implemented rules: 13
- Build: SUCCESS

### Java Validation Classes Created
- `RdbmsElementValidations.java` - Name/UUID/uniqueness constraints
- `RdbmsTableValidations.java` - Primary key constraints and name convention
- `RdbmsFieldValidations.java` - Type constraint and name convention
- `RdbmsForeignKeyValidations.java` - Reference constraint
- `RdbmsIndexValidations.java` - Fields constraint
- `RdbmsUniqueConstraintValidations.java` - Fields constraint
- `RdbmsJunctionTableValidations.java` - Both fields constraint
- `RdbmsConfigurationValidations.java` - Dialect constraint

### EVL Parity
- All 13 rules implemented in `rdbms.evl`
- Both validators produce identical results

## Notes
- Framework infrastructure is complete and working
- Added `hu.blackbelt.judo.zeta.common` dependency (contains ModelProvider, ExtensionMethodRegistry)
- RdbmsValidator includes `RdbmsModelProvider` adapter for Zeta's ModelProvider interface
- All validation rules implemented in both Java and EVL for dual validation testing
