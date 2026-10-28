# Testing Capability Delta

## ADDED Requirements

### Requirement: Real-World Model Performance Testing

The test suite SHALL support performance benchmarking with programmatically generated RDBMS models that match real-world semantics.

#### Scenario: Generate realistic RDBMS model for performance testing
- **GIVEN** a model generator that creates structures matching production patterns
- **WHEN** the performance test generates the model
- **THEN** the model contains ~80 tables with realistic field structures
- **AND** tables have audit fields (_id, _type, _version, _create_*, _update_*)
- **AND** tables have business fields with various types (TEXT, BOOLEAN, UUID, TIMESTAMP, INT4, DECIMAL)
- **AND** tables are linked via foreign key relationships
- **AND** many-to-many relationships use junction tables
- **AND** key fields have indexes defined

#### Scenario: Compare EVL vs Java validation performance
- **GIVEN** a generated real-world model with ~80 tables and ~800+ fields
- **WHEN** validation is executed using both EVL and Java validators
- **THEN** execution times are logged for comparison
- **AND** both validators produce consistent results

#### Scenario: Log detailed element statistics
- **GIVEN** a generated real-world model
- **WHEN** the performance test analyzes the model
- **THEN** element counts are logged (tables, fields, foreign keys, junction tables, indexes)
- **AND** generation time is logged
- **AND** validation times are compared (EVL vs Java sequential vs Java parallel)
