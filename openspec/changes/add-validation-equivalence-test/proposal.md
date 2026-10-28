# Change: Add Validation Equivalence Test

**Status: PROPOSED**

## Why

The existing `RdbmsRealWorldPerformanceTest` generates a model with approximate characteristics matching production patterns, but:
- Does not verify that EVL and Zeta (Java) validators produce **identical results**
- Uses simplified field type distribution (6 types) vs real distribution (9 types)
- Lacks assertion that both validators find the same errors/warnings
- Missing validation of edge cases (parent tables, inheritance)

Ensuring EVL and Zeta validators produce equivalent results is critical for the migration from EVL to Java validation.

## What Changes

### Enhanced Model Generator
Update the model generator to match exact rackinspect characteristics:

| Element | Rackinspect | Current Test | Updated |
|---------|-------------|--------------|---------|
| Tables | 83 | 80 | 83 |
| Value Fields | 883 | ~800 | 883 |
| Identifier Fields | 83 | 80 | 83 |
| Foreign Keys | 137 | ~130 | 137 |
| Junction Tables | 12 | ~12 | 12 |
| Indexes | 11 | ~10 | 11 |
| Field Type Distribution | 9 types | 6 types | 9 types |

**Exact Field Type Distribution (from rackinspect):**
- TEXT: 364 fields (33%)
- UUID: 362 fields (33%)
- TIMESTAMP: 150 fields (14%)
- INT4: 103 fields (9%)
- BOOLEAN: 70 fields (6%)
- DECIMAL: 30 fields (3%)
- FLOAT8: 15 fields (1%)
- DATE: 8 fields (1%)
- TIME: 1 field (0.1%)

### New Equivalence Test
Add `RdbmsValidationEquivalenceTest.java` that:
1. Generates a model with exact rackinspect characteristics
2. Runs EVL validation and collects all errors/warnings
3. Runs Zeta (Java) validation and collects all errors/warnings
4. **Asserts both validators produce identical constraint violations**
5. Reports any discrepancies with detailed diff

### Test Scenarios
- **Valid Model**: Both validators should report zero errors
- **Invalid Model (missing names)**: Both should detect `RdbmsElementNameNotEmpty`
- **Invalid Model (missing UUID)**: Both should detect `RdbmsElementUuidNotEmpty`
- **Invalid Model (duplicate names)**: Both should detect `RdbmsElementNameIsUnique`
- **Invalid Model (missing primary key)**: Both should detect `RdbmsTableHasPrimaryKey`

## Impact

- **Affected specs**: testing
- **Affected code**:
  - `model-test/src/test/java/.../RdbmsValidationEquivalenceTest.java` - New test
  - `model-test/src/test/java/.../RdbmsRealWorldPerformanceTest.java` - Update field types

## Design Decisions

1. **Exact Matching**: Test must fail if EVL and Java produce different results
2. **Deterministic Generation**: Use fixed random seed for reproducible tests
3. **Comprehensive Coverage**: Test both valid and invalid model scenarios
4. **Clear Reporting**: Log detailed diff when validators disagree

## Non-Goals

- Changing validation rule semantics
- Adding new validation rules
- Performance optimization (covered by existing test)
