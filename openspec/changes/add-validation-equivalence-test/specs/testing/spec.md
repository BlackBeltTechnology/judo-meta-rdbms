# Testing Capability Delta

## ADDED Requirements

### Requirement: EVL and Zeta Validation Equivalence

The test suite SHALL verify that EVL and Zeta (Java) validators produce identical results for the same model.

#### Scenario: Valid model produces no errors from either validator
- **GIVEN** a programmatically generated RDBMS model with rackinspect characteristics
- **AND** the model is structurally valid (all required fields set)
- **WHEN** validation is executed using EVL validator
- **AND** validation is executed using Zeta (Java) validator
- **THEN** both validators report zero errors
- **AND** both validators report equivalent warnings (if any)

#### Scenario: Invalid model with missing names detected by both validators
- **GIVEN** an RDBMS model with elements having empty names
- **WHEN** validation is executed using both EVL and Zeta validators
- **THEN** both validators detect `RdbmsElementNameNotEmpty` constraint violation
- **AND** both report the same number of violations
- **AND** violations reference the same elements

#### Scenario: Invalid model with duplicate names detected by both validators
- **GIVEN** an RDBMS model with duplicate element names
- **WHEN** validation is executed using both EVL and Zeta validators
- **THEN** both validators detect `RdbmsElementNameIsUnique` constraint violation
- **AND** both report the same elements as duplicates

#### Scenario: Invalid model with missing primary key detected by both validators
- **GIVEN** an RDBMS model with tables missing primary keys
- **WHEN** validation is executed using both EVL and Zeta validators
- **THEN** both validators detect `RdbmsTableHasPrimaryKey` constraint violation
- **AND** both report the same tables as invalid

### Requirement: Model Generator Matches Production Characteristics

The model generator SHALL create models matching exact production (rackinspect) characteristics.

#### Scenario: Generated model has correct element counts
- **GIVEN** default model generation parameters
- **WHEN** the model is generated
- **THEN** the model contains exactly 83 tables
- **AND** the model contains approximately 883 value fields
- **AND** the model contains exactly 137 foreign keys
- **AND** the model contains exactly 12 junction tables
- **AND** the model contains exactly 11 indexes

#### Scenario: Generated model has correct field type distribution
- **GIVEN** default model generation parameters
- **WHEN** the model is generated
- **THEN** field types are distributed as:
  - TEXT: ~33% of value fields
  - UUID: ~33% of value fields
  - TIMESTAMP: ~14% of value fields
  - INT4: ~9% of value fields
  - BOOLEAN: ~6% of value fields
  - DECIMAL: ~3% of value fields
  - FLOAT8: ~1% of value fields
  - DATE: ~1% of value fields
  - TIME: ~0.1% of value fields

### Requirement: Equivalence Test Reports Detailed Differences

When validators produce different results, the test SHALL provide detailed diagnostics.

#### Scenario: Report constraint name differences
- **GIVEN** EVL and Zeta validators produce different constraint violations
- **WHEN** the equivalence test runs
- **THEN** the test fails with a clear message
- **AND** logs constraints found only by EVL
- **AND** logs constraints found only by Zeta
- **AND** logs constraints found by both

#### Scenario: Report element differences for same constraint
- **GIVEN** EVL and Zeta detect the same constraint but on different elements
- **WHEN** the equivalence test runs
- **THEN** the test logs elements detected only by EVL
- **AND** the test logs elements detected only by Zeta
