# Change: Add Real-World Model Performance Test

**Status: IMPLEMENTED**

## Why

The current `RdbmsValidationPerformanceTest` generates synthetic models with simple, repetitive tables. While useful for baseline measurements, this doesn't reflect real-world RDBMS models which have:
- Complex relationships (foreign keys, junction tables)
- Various field types and constraints
- Indexes and unique constraints
- Realistic table structures with multiple field types
- Tables referencing each other via foreign keys

Generating a model programmatically with real-world semantics (based on rackinspect patterns) provides:
- Realistic validation performance benchmarks
- Coverage of all RDBMS element types
- Self-contained test (no external file dependencies)
- Reproducible and configurable model generation

## What Changes

### New Performance Test
- Add `RdbmsRealWorldPerformanceTest.java` that generates a complex model programmatically
- Model generator creates structures matching real-world patterns from rackinspect:
  - Tables with audit fields (_id, _type, _version, _create_*, _update_*)
  - Value fields with various types (TEXT, BOOLEAN, UUID, TIMESTAMP, INT4, DECIMAL)
  - Foreign key relationships between tables
  - Junction tables for many-to-many relationships
  - Indexes on commonly queried fields
- Measure EVL vs Java validation times
- Log detailed element counts and performance metrics

### Target Model Statistics (matching rackinspect semantics)
- **~80 Tables** with realistic structure:
  - Identifier field (primary key)
  - Type discriminator field
  - Version field
  - Audit fields (create/update username, user_id, timestamp)
  - ~10-15 business value fields per table
- **~800+ Value Fields** across all tables
- **~130+ Foreign Keys** linking tables
- **~12 Junction Tables** for many-to-many relationships
- **~10 Indexes** on key fields

### Model Generator Design
```java
// Example structure per table
RdbmsTable table = newRdbmsTableBuilder()
    .withName("entities.User")
    .withSqlName("T_ENTITIES_USER")
    .withPrimaryKey(identifierField)
    .withFields(
        typeField,           // _type (TEXT)
        versionField,        // _version (INT4)
        createUsernameField, // _create_username (TEXT)
        createUserIdField,   // _create_user_id (UUID)
        createTimestampField,// _create_timestamp (TIMESTAMP)
        updateUsernameField, // _update_username (TEXT)
        updateUserIdField,   // _update_user_id (UUID)
        updateTimestampField,// _update_timestamp (TIMESTAMP)
        // Business fields...
        emailField,          // c_email (TEXT)
        nameField,           // c_name (TEXT)
        activeField          // c_active (BOOLEAN)
    )
    .build();
```

## Impact

- **Affected specs**: None (enhancement to testing)
- **Affected code**:
  - `model-test/src/test/java/.../RdbmsRealWorldPerformanceTest.java` - New test class

## Design Decisions

1. **Model Validity**: Generated model is fully valid (passes all validation rules) - measures performance on clean production-like models
2. **Test Execution**: Uses `@Tag("performance")` - only runs when explicitly requested via `mvn test -Dgroups=performance`
3. **Configurable Scale**: Model size controlled via system properties:
   - `-Drdbms.perf.tables=80` (default: 80)
   - `-Drdbms.perf.fieldsPerTable=12` (default: 12)

## Non-Goals

- Loading external model files
- Modifying the validation rules
- Adding new validation constraints
- Testing invalid models or error detection performance
