# model-test Specification Delta

## ADDED Requirements

### Requirement: Incremental engine equivalence

The test suite SHALL verify that `RdbmsIncrementalTransformation` (Java) and `RdbmsIncremental` (ETL oracle) produce
structurally identical incremental models, comparing reflectively every attribute, every reference (by containment
path), the operation order, the `RdbmsOperationMeta` and the resource contents. Where the ETL fails, the Java engine
SHALL fail too.

#### Scenario: Excel matrix
- **GIVEN** the pair of models built from `RdbmsIncrementalTests.xlsx`
- **WHEN** both engines transform the pair
- **THEN** the incremental models are structurally identical, and `RdbmsIncrementalTest` passes for both engines

#### Scenario: Partitions of the diff rules
- **GIVEN** pairs covering table create/delete/rename, field create/delete/modify per field type, junction tables,
  zero-field boundaries, the review policy (with and without `ignoreReview`) and the index / unique constraint gap
- **WHEN** both engines transform each pair
- **THEN** the results are identical, or both engines fail (junction field changes, created identifier field,
  rename-only plain table, delete of every field of a table with identifier or foreign key)

#### Scenario: Fixture and rackinspect shaped models
- **GIVEN** the judo-rdbms-schema fixtures (`initial` to `applyable` / `reviewable`, hsqldb and postgresql) and a
  rackinspect shaped generated model with scripted mutations
- **WHEN** both engines transform each pair
- **THEN** the results are identical

#### Scenario: Deterministic
- **GIVEN** one pair with creates, deletes, modifies and a rename
- **WHEN** the Java engine runs twice
- **THEN** both runs serialize identically and the operation order equals the ETL order
