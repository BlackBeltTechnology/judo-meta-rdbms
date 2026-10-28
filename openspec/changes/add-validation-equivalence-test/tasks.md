# Tasks: Add Validation Equivalence Test

## 1. Update Model Generator
- [ ] 1.1 Update `FIELD_TYPES` array to include all 9 types: TEXT, UUID, TIMESTAMP, INT4, BOOLEAN, DECIMAL, FLOAT8, DATE, TIME
- [ ] 1.2 Add weighted distribution matching rackinspect percentages
- [ ] 1.3 Update default constants: TABLE_COUNT=83, add exact field counts
- [ ] 1.4 Add support for table inheritance (parents reference)

## 2. Create Equivalence Test Class
- [ ] 2.1 Create `RdbmsValidationEquivalenceTest.java` extending `AbstractRdbmsValidationTest`
- [ ] 2.2 Implement `runBothValidators()` helper that collects results from both EVL and Java
- [ ] 2.3 Implement `assertEquivalentResults()` that compares error/warning sets
- [ ] 2.4 Implement detailed diff reporting for failures

## 3. Valid Model Tests
- [ ] 3.1 Add `testValidModelEquivalence()` - both validators should pass
- [ ] 3.2 Assert zero errors from both validators
- [ ] 3.3 Compare warning counts (if any)

## 4. Invalid Model Tests
- [ ] 4.1 Add `testMissingNameEquivalence()` - both detect empty names
- [ ] 4.2 Add `testMissingUuidEquivalence()` - both detect empty UUIDs
- [ ] 4.3 Add `testDuplicateNameEquivalence()` - both detect duplicates
- [ ] 4.4 Add `testMissingPrimaryKeyEquivalence()` - both detect missing PK
- [ ] 4.5 Add `testMissingForeignKeyReferenceEquivalence()` - both detect missing FK ref

## 5. Verification
- [ ] 5.1 Run `mvn test -Dtest=RdbmsValidationEquivalenceTest`
- [ ] 5.2 Verify all tests pass (EVL and Java produce same results)
- [ ] 5.3 Document any intentional differences between validators

## Dependencies
- 1.x can proceed independently
- 2.x depends on 1.x completion
- 3.x and 4.x depend on 2.x completion
- 5.x depends on all above

## Notes
- Test uses fixed random seed (42) for reproducibility
- Model characteristics extracted from `/Users/robson/Project/rackinspect/application/model/target/generated-resources/model/rackinspect-rdbms_postgresql.model`
- Both validators must produce **identical** constraint names for failures
