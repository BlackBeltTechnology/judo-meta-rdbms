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

## 6. Verification
- [x] 6.1 Run `mvn clean install` to verify full build
- [x] 6.2 Verify all existing tests pass
- [x] 6.3 Verify new parameterized tests run for both EVL and JAVA
- [x] 6.4 Verify performance test executes and logs results
- [x] 6.5 Review generated documentation

## Dependencies Between Tasks
- 1.x must complete before 2.x and 3.x
- 2.x and 3.x can proceed in parallel after 1.x
- 4.x depends on 2.x and 3.x completion
- 5.x can start after 2.x and 3.x (documents what was built)
- 6.x is final verification after all others

## Completion Summary

**Status: COMPLETED**

All tasks have been implemented and verified:
- Build: SUCCESS
- Tests: 13 passed, 0 failures
- Performance test shows EVL ~18ms vs Java ~15ms for 10,000 elements

## Notes
- Current `rdbms.evl` is empty - no actual validation rules to migrate
- Framework setup enables future rule additions
- Both validators produce empty results for valid models
- Added `hu.blackbelt.judo.zeta.common` dependency (contains ModelProvider, ExtensionMethodRegistry)
- RdbmsValidator includes `RdbmsModelProvider` adapter for Zeta's ModelProvider interface
