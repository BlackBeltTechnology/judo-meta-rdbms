# model-test Specification

## Purpose

The `model-test` module provides JUnit 5 unit tests that verify the RDBMS metamodel's runtime behavior, including EVL validation, utility functions, incremental model transformations, and execution context management.

## Architecture

Test classes are located in `hu.blackbelt.judo.meta.rdbms.runtime`:
- `RdbmsValidationTest` — validates RDBMS models using EVL scripts
- `RdbmsUtilsTest` — tests utility methods for querying and manipulating models
- `RdbmsIncrementalTest` — tests incremental model transformation (ETL-based diff)
- `RdbmsExecutionContextTest` — tests Epsilon execution context setup

Test resources include Excel files for data-driven testing and ETL scripts (`createExcelModel.etl`, `createRdbmsModelsFromExcel.etl`, `testIncrementalModel.etl`) that build test models from data.

## Requirements

### Requirement: EVL validation correctness

The test suite SHALL verify that EVL validation scripts correctly detect constraint violations in RDBMS models.

#### Scenario: Run validation on valid model
- **GIVEN** a well-formed RDBMS model loaded from test resources
- **WHEN** `RdbmsEpsilonValidator.validateRdbms()` is called
- **THEN** no unexpected errors or warnings are produced

#### Scenario: Run validation with expected violations
- **GIVEN** an RDBMS model with intentional constraint violations
- **WHEN** `RdbmsEpsilonValidator.validateRdbms()` is called with expected error/warning collections
- **THEN** the validator accepts the expected violations without failing

### Requirement: Utility function correctness

The test suite SHALL verify that `RdbmsUtils` methods correctly query tables, fields, foreign keys, and junction tables from model instances.

#### Scenario: Query table by name
- **GIVEN** an RDBMS model with known tables
- **WHEN** `getRdbmsTable(name)` is called
- **THEN** the correct table is returned

#### Scenario: Validate XMI ID uniqueness
- **GIVEN** an RDBMS model with unique XMI IDs
- **WHEN** `validateUniqueXmiids()` is called
- **THEN** no exception is thrown

### Requirement: Incremental transformation correctness

The test suite SHALL verify that the ETL transformation correctly computes diffs between two RDBMS model versions.

#### Scenario: Transform incremental model
- **GIVEN** a previous RDBMS model and a modified new model
- **WHEN** `RdbmsIncremental.transformRdbmsIncrementalModel()` is called
- **THEN** the incremental model contains the correct create, modify, and delete operations

### Requirement: Execution context setup

The test suite SHALL verify that the Epsilon execution context is correctly initialized with RDBMS model instances.

#### Scenario: Create execution context
- **GIVEN** an RDBMS model resource
- **WHEN** the execution context is created
- **THEN** the model is accessible as a named model context for Epsilon script execution
