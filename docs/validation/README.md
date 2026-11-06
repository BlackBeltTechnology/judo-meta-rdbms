# RDBMS Model Validation Reference

> Source: [JUDO Meta RDBMS](https://github.com/BlackBeltTechnology/judo-meta-rdbms)

## Overview

The RDBMS (Relational Database Model Schema) validation system ensures models conform to metamodel semantics and database schema rules. It provides validation for table definitions, field constraints, foreign key integrity, index configurations, and naming conventions.

**Key Features:**
- Dual implementation: EVL (Epsilon) and native Java (Zeta framework)
- Constraint dependencies with `satisfies()` mechanism
- Guard conditions for conditional evaluation
- Error (Constraint) and Warning (Critique) severity levels
- Parallel execution support in Java implementation

## Validation Implementations

| Implementation | Description | Benefits |
|----------------|-------------|----------|
| **EVL** | Epsilon-based validation | Declarative, concise syntax |
| **Java** | Native Java with Zeta annotations | IDE support, type safety, better performance |

The Java validation framework provides identical semantics with:
- Full IDE support (autocomplete, refactoring, debugging)
- Compile-time type safety
- No interpretation overhead
- Parallel execution support
- Built-in result caching

## Constraint vs Critique

### Constraints (Errors)

Hard validation rules that must be satisfied. Violations produce errors requiring fixes.

```java
@Constraint(name = "RdbmsTableHasPrimaryKey",
            message = "RDBMS table must have a primary key")
public ValidationRule rdbmsTableHasPrimaryKey() {
    return (element, ctx) -> {
        RdbmsTable self = (RdbmsTable) element;
        return self.getPrimaryKey() != null
            ? ValidationResult.pass()
            : ValidationResult.fail("Table " + self.getName() + " must have a primary key");
    };
}
```

### Critiques (Warnings)

Soft validation rules representing recommendations. Violations produce warnings.

```java
@Critique(name = "RdbmsTableNameConvention",
          message = "Table name should follow naming convention")
public ValidationRule rdbmsTableNameConvention() {
    return (element, ctx) -> {
        // Warning-level logic
    };
}
```

## Validation Architecture

### EVL Structure

```
rdbms-plugin-validation.evl (entry point)
└── rdbms.evl (main validation rules - currently empty)
```

### Java Structure

```
hu.blackbelt.judo.meta.rdbms.validation/
├── RdbmsValidator.java           # Entry point
├── RdbmsValidationConstants.java # Constraint name constants
└── rules/
    ├── RdbmsElementValidations.java
    └── RdbmsTableValidations.java
```

## RdbmsUtils Helper Methods

| Method | Description |
|--------|-------------|
| `getRdbmsTables()` | Get all RDBMS tables |
| `getRdbmsTable(name)` | Get table by name |
| `getAllRdbmsField()` | Get all fields |
| `getRdbmsFields(tableName)` | Get fields for a table |
| `getRdbmsForeignKeys()` | Get all foreign keys |
| `getRdbmsJunctionTables()` | Get all junction tables |
| `validateUniqueXmiids()` | Validate unique XMI IDs |

## Running Validation

### EVL Validation

```java
RdbmsEpsilonValidator.validateRdbms(log, rdbmsModel,
    RdbmsEpsilonValidator.calculateRdbmsValidationScriptURI(),
    expectedErrors, expectedWarnings);
```

### Java Validation

```java
RdbmsValidator.validateRdbms(log, rdbmsModel);

// With expected errors/warnings (testing)
RdbmsValidator.validateRdbms(log, rdbmsModel,
    ImmutableList.of("ExpectedError1"),
    ImmutableList.of("ExpectedWarning1"));

// With parallel execution
RdbmsValidator.validateRdbms(log, rdbmsModel,
    expectedErrors, expectedWarnings, true);
```

## Dual Validation Testing

Tests run both EVL and Java validators using parameterized tests:

```java
@ParameterizedTest(name = "testConstraint [{0}]")
@EnumSource(ValidatorType.class)
void testConstraint(ValidatorType type) throws Exception {
    this.validatorType = type;
    initModel();
    
    // Build model
    RdbmsTable table = newRdbmsTableBuilder()
        .withName("TestTable")
        .build();
    rdbmsModel.getResource().getContents().add(table);
    
    runValidation(
        ImmutableList.of("ExpectedConstraintName"),
        ImmutableList.of()
    );
}
```

## Documentation

| Document | Description |
|----------|-------------|
| [java-validation-framework.md](java-validation-framework.md) | Complete Java framework documentation |

## See Also

- [Judo Zeta Framework](https://github.com/BlackBeltTechnology/judo-zeta) - Zeta validation framework
- [Epsilon Documentation](https://eclipse.dev/epsilon/) - Official Epsilon platform documentation
