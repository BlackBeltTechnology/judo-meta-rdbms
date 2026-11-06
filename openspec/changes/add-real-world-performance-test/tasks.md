# Tasks: Add Real-World Model Performance Test

## 1. Model Generator Implementation
- [x] 1.1 Create `RdbmsRealWorldPerformanceTest.java` in `model-test/src/test/java/.../runtime/`
- [x] 1.2 Add configurable parameters via system properties (`rdbms.perf.tables`, `rdbms.perf.fieldsPerTable`)
- [x] 1.3 Implement `createStandardAuditFields()` helper for common audit fields
- [x] 1.4 Implement `createTableWithFields()` helper for realistic table structure
- [x] 1.5 Implement `createForeignKey()` helper for table relationships
- [x] 1.6 Implement `createJunctionTable()` helper for many-to-many relationships
- [x] 1.7 Implement `createIndex()` helper for indexes
- [x] 1.8 Implement `generateRealWorldModel()` that creates configurable tables with relationships

## 2. Performance Test Implementation
- [x] 2.1 Add element count logging (tables, fields, foreign keys, junction tables, indexes)
- [x] 2.2 Implement EVL validation timing
- [x] 2.3 Implement Java sequential validation timing
- [x] 2.4 Implement Java parallel validation timing
- [x] 2.5 Add detailed performance report logging with comparisons

## 3. Verification
- [x] 3.1 Run `mvn test -Dtest=RdbmsRealWorldPerformanceTest`
- [x] 3.2 Verify model has expected element counts (~80 tables, ~1884 fields, ~130+ FKs)
- [x] 3.3 Verify EVL and Java validators produce matching results
- [x] 3.4 Document performance comparison in test output

## Dependencies Between Tasks
- 1.x can proceed independently
- 2.x depends on 1.7 completion
- 3.x depends on all 2.x completion

## Notes
- Model generated programmatically (no external file dependencies)
- Test uses `@Tag("performance")` - run with `mvn test -Dgroups=performance`
- Model size configurable via system properties:
  - `-Drdbms.perf.tables=80` (default)
  - `-Drdbms.perf.fieldsPerTable=12` (default)
- Generated model is fully valid (no intentional violations)
- Target structure based on rackinspect model semantics:
  - Each table has: id, type, version, audit fields (create/update), business fields
  - Foreign keys reference other tables' identifier fields
  - Junction tables have field1/field2 pointing to related tables
  - Indexes on commonly queried fields
