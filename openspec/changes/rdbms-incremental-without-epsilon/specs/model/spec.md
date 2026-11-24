# model Specification Delta

## MODIFIED Requirements

### Requirement: Incremental model transformation

`RdbmsIncrementalTransformation` SHALL compute the difference between two RDBMS model versions with plain Java and EMF
(no Epsilon) and produce an incremental model containing create, modify, and delete operations. The result SHALL be
structurally identical to the one of the ETL `RdbmsIncremental`, which is deprecated and kept as the equivalence oracle.

#### Scenario: Detect new table
- **GIVEN** a previous model without table "Inventory" and a new model with table "Inventory"
- **WHEN** `RdbmsIncrementalTransformation.transform(previous, new, incremental, dialect, ignoreReview)` is called
- **THEN** the incremental model contains an `RdbmsCreateTableOperation` for "Inventory"

#### Scenario: Detect deleted table
- **GIVEN** a previous model with table "Legacy" and a new model without it
- **WHEN** `transform(previous, new, incremental, dialect, ignoreReview)` is called
- **THEN** the incremental model contains an `RdbmsDeleteTableOperation` for "Legacy"

#### Scenario: Detect modified field
- **GIVEN** a previous model where table "Customer" has field "name" with size 100, and a new model where size is 200
- **WHEN** `transform(previous, new, incremental, dialect, ignoreReview)` is called
- **THEN** the incremental model contains an `RdbmsModifyTableOperation` with an `RdbmsModifyFieldOperation` where `sizeChanged` is true

#### Scenario: Identical models
- **GIVEN** a previous and a new model with the same content
- **WHEN** `transform(previous, new, incremental, dialect, ignoreReview)` is called
- **THEN** the incremental model has no table operation, one `RdbmsOperationMeta`, version `<previous>_<new>` and the previous and new model are moved into the incremental resource

#### Scenario: Unsupported change fails closed
- **GIVEN** a change the ETL cannot express (a field change on an existing junction table other than a foreign key
  modification, a created identifier field on an existing table, a `sqlName`-only change of a plain table)
- **WHEN** `transform(previous, new, incremental, dialect, ignoreReview)` is called
- **THEN** an `IllegalStateException` naming the table (and the field) is thrown and the incremental resource is not modified

#### Scenario: Null argument
- **GIVEN** a `null` previous model, new model, incremental model or dialect
- **WHEN** `transform` is called
- **THEN** a `NullPointerException` naming the parameter is thrown

### Requirement: Model compatibility checking

CheckRdbmsModelCompatibility SHALL compare two RDBMS models with the Java incremental engine (no Epsilon class is
loaded) and determine if they are structurally identical, providing a detailed change report when they differ. The
report SHALL list create, delete and modify table operations and their field operations.

#### Scenario: Identical models
- **GIVEN** two structurally identical RdbmsModel instances
- **WHEN** `isRdbmsModelIdentical(current, candidate, dialect, reportBuilder, useXmiId)` is called
- **THEN** the method returns `true` and the report builder is empty

#### Scenario: Models with changes
- **GIVEN** two RdbmsModel instances with structural differences
- **WHEN** `isRdbmsModelIdentical(current, candidate, dialect, reportBuilder, useXmiId)` is called
- **THEN** the method returns `false` and the report builder contains details of create/modify/delete operations

#### Scenario: Deleted table is reported
- **GIVEN** a stored model with a table the candidate model lacks
- **WHEN** `isRdbmsModelIdentical(current, candidate, dialect, reportBuilder, useXmiId)` is called
- **THEN** the method returns `false` and the report contains `Delete table operation: <name> - <sqlName>`

#### Scenario: Epsilon is not on the class path
- **GIVEN** a class loader which throws `ClassNotFoundException` for `org.eclipse.epsilon.*` and `hu.blackbelt.epsilon.*`
- **WHEN** `isRdbmsModelIdentical` is called through it
- **THEN** it returns the same results as with Epsilon and no `NoClassDefFoundError` occurs
