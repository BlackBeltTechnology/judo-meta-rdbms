## ADDED Requirements

### Requirement: Java Validation Framework Infrastructure

The RDBMS model module SHALL provide a Java-based validation framework using the Zeta validation library as an alternative to EVL validation.

#### Scenario: Validator entry point exists
- **GIVEN** the model module is built
- **WHEN** a consumer imports the validation package
- **THEN** `RdbmsValidator` class is available with `validateRdbms()` method

#### Scenario: Validation constants are centralized
- **GIVEN** validation rules are defined
- **WHEN** constraint names are referenced
- **THEN** all names are defined as `public static final String` constants in `RdbmsValidationConstants`

#### Scenario: Validation context classes exist
- **GIVEN** the validation framework is initialized
- **WHEN** validators are registered
- **THEN** classes annotated with `@ValidationContext` are discovered for RDBMS element types

---

### Requirement: Dual Validation Testing Support

The test module SHALL support running the same test cases against both EVL and Java validators using JUnit 5 parameterized tests.

#### Scenario: ValidatorType enum selection
- **GIVEN** a validation test class
- **WHEN** test method is annotated with `@ParameterizedTest` and `@EnumSource(ValidatorType.class)`
- **THEN** the test runs twice: once with EVL validator and once with Java validator

#### Scenario: Identical expected results
- **GIVEN** a model that triggers validation errors
- **WHEN** validated by EVL validator
- **AND** validated by Java validator
- **THEN** both validators report the same constraint names as failures

#### Scenario: Base test class provides dual validation
- **GIVEN** a test class extends `AbstractRdbmsValidationTest`
- **WHEN** `runValidation(expectedErrors, expectedWarnings)` is called
- **THEN** the appropriate validator (EVL or Java) is invoked based on `validatorType` field

---

### Requirement: Performance Testing Capability

The test module SHALL include performance tests comparing EVL and Java validation execution times.

#### Scenario: Large model generation
- **GIVEN** a performance test method
- **WHEN** test setup is executed
- **THEN** a model with 10,000 RDBMS elements is generated

#### Scenario: Performance measurement and reporting
- **GIVEN** a 10,000 element model
- **WHEN** validation is executed
- **THEN** execution times are logged for:
  - EVL validation
  - Java sequential validation
  - Java parallel validation

---

### Requirement: Zeta Dependency Management

The project SHALL use a centralized version property for all Zeta framework dependencies.

#### Scenario: Version property defined
- **GIVEN** the parent `pom.xml`
- **WHEN** Zeta dependencies are declared
- **THEN** all use `${judo-zeta-version}` property set to `1.0.0.20251207_081454_0779b890_develop`

#### Scenario: Dependencies in model module
- **GIVEN** `model/pom.xml`
- **WHEN** dependencies are resolved
- **THEN** `zeta-annotations` and `validation-core` are available at compile scope

#### Scenario: Dependencies in test module
- **GIVEN** `model-test/pom.xml`
- **WHEN** test dependencies are resolved
- **THEN** Zeta validation runtime is available at test scope

---

### Requirement: Validation Documentation

The project documentation SHALL describe the Java validation framework usage and reference Zeta documentation.

#### Scenario: Validation overview document
- **GIVEN** the `docs/validation/` directory
- **WHEN** a developer reads `README.md`
- **THEN** they understand the dual validation approach and where to find detailed documentation

#### Scenario: Framework documentation references Zeta
- **GIVEN** `docs/validation/java-validation-framework.md`
- **WHEN** a developer reads the document
- **THEN** they find links to Zeta documentation without duplicated content

#### Scenario: Constraint documentation
- **GIVEN** validation rules exist
- **WHEN** a developer consults documentation
- **THEN** they find a list of all constraint names with their purposes

#### Scenario: README includes validation section
- **GIVEN** the project `README.adoc`
- **WHEN** a developer reads it
- **THEN** they find a section describing validation capabilities with links to detailed docs

---

### Requirement: RdbmsElement Validation Rules

The validation framework SHALL enforce constraints on RdbmsElement instances.

#### Scenario: Element name must not be empty
- **GIVEN** an RdbmsElement with empty or null name
- **WHEN** validation is executed
- **THEN** constraint `RdbmsElementNameNotEmpty` fails with ERROR severity

#### Scenario: Element UUID must not be empty
- **GIVEN** an RdbmsElement with empty or null UUID
- **WHEN** validation is executed
- **THEN** constraint `RdbmsElementUuidNotEmpty` fails with ERROR severity

#### Scenario: Element name must be unique
- **GIVEN** two RdbmsElements with the same name
- **WHEN** validation is executed
- **THEN** constraint `RdbmsElementNameIsUnique` fails with ERROR severity

---

### Requirement: RdbmsTable Validation Rules

The validation framework SHALL enforce constraints on RdbmsTable instances.

#### Scenario: Table must have a primary key
- **GIVEN** an RdbmsTable without a primary key defined
- **WHEN** validation is executed
- **THEN** constraint `RdbmsTableHasPrimaryKey` fails with ERROR severity

#### Scenario: Primary key must not be null
- **GIVEN** an RdbmsTable with primary key set to null
- **WHEN** validation is executed
- **THEN** constraint `RdbmsTablePrimaryKeyNotNull` fails with ERROR severity

#### Scenario: Table name follows naming convention
- **GIVEN** an RdbmsTable with name not following convention (e.g., lowercase, no spaces)
- **WHEN** validation is executed
- **THEN** critique `RdbmsTableNameConvention` fails with WARNING severity

---

### Requirement: RdbmsField Validation Rules

The validation framework SHALL enforce constraints on RdbmsField instances.

#### Scenario: Field must have a valid type
- **GIVEN** an RdbmsField without a type or with invalid type
- **WHEN** validation is executed
- **THEN** constraint `RdbmsFieldHasValidType` fails with ERROR severity

#### Scenario: Field name follows naming convention
- **GIVEN** an RdbmsField with name not following convention
- **WHEN** validation is executed
- **THEN** critique `RdbmsFieldNameConvention` fails with WARNING severity

---

### Requirement: RdbmsForeignKey Validation Rules

The validation framework SHALL enforce constraints on RdbmsForeignKey instances.

#### Scenario: Foreign key must reference a table
- **GIVEN** an RdbmsForeignKey without a reference table
- **WHEN** validation is executed
- **THEN** constraint `RdbmsForeignKeyHasReference` fails with ERROR severity

---

### Requirement: RdbmsIndex Validation Rules

The validation framework SHALL enforce constraints on RdbmsIndex instances.

#### Scenario: Index must have fields defined
- **GIVEN** an RdbmsIndex with no fields
- **WHEN** validation is executed
- **THEN** constraint `RdbmsIndexHasFields` fails with ERROR severity

---

### Requirement: RdbmsUniqueConstraint Validation Rules

The validation framework SHALL enforce constraints on RdbmsUniqueConstraint instances.

#### Scenario: Unique constraint must have fields
- **GIVEN** an RdbmsUniqueConstraint with no fields defined
- **WHEN** validation is executed
- **THEN** constraint `RdbmsUniqueConstraintHasFields` fails with ERROR severity

---

### Requirement: RdbmsJunctionTable Validation Rules

The validation framework SHALL enforce constraints on RdbmsJunctionTable instances.

#### Scenario: Junction table must have both fields
- **GIVEN** an RdbmsJunctionTable missing one or both foreign key fields
- **WHEN** validation is executed
- **THEN** constraint `RdbmsJunctionTableHasBothFields` fails with ERROR severity

---

### Requirement: RdbmsConfiguration Validation Rules

The validation framework SHALL enforce constraints on RdbmsConfiguration instances.

#### Scenario: Configuration must specify dialect
- **GIVEN** an RdbmsConfiguration without a dialect specified
- **WHEN** validation is executed
- **THEN** constraint `RdbmsConfigurationHasDialect` fails with ERROR severity
