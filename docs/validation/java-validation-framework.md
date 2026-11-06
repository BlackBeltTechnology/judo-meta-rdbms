# Java Validation Framework Reference

> Source: [JUDO Meta RDBMS](https://github.com/BlackBeltTechnology/judo-meta-rdbms)

## Overview

The Java validation framework provides a native Java alternative to EVL (Epsilon Validation Language) validation using the Zeta validation framework. It offers better IDE integration, debugging support, and performance.

**Key Features:**
- Native Java implementation with full IDE support
- Compile-time type safety
- No interpretation overhead
- Parallel execution support
- Built-in caching for `satisfies()` and extension methods
- Standard Java code that can be unit tested

For complete Zeta framework documentation, see:
- [Judo Zeta Framework](https://github.com/BlackBeltTechnology/judo-zeta)

## Key Concepts

| Concept | EVL Equivalent | Description |
|---------|----------------|-------------|
| `@Constraint` | `constraint` | Error-level rule (must fix) |
| `@Critique` | `critique` | Warning-level rule (recommendation) |
| `@Guard` | `guard:` | Conditional execution predicate |
| `@Satisfies` | `satisfies()` | Constraint dependency declaration |
| `ValidationContext` | `context` | Runtime validation context |

## Package Structure

```
hu.blackbelt.judo.meta.rdbms.validation/
├── RdbmsValidator.java           # Entry point
├── RdbmsValidationConstants.java # Constraint name constants
└── rules/
    ├── RdbmsElementValidations.java  # RdbmsElement rules
    └── RdbmsTableValidations.java    # RdbmsTable rules
```

## Constraint Name Constants

All constraint names are defined in `RdbmsValidationConstants`:

```java
public final class RdbmsValidationConstants {
    // Constraint names
    public static final String CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY = "RdbmsTableHasPrimaryKey";
    public static final String CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY = "RdbmsElementNameNotEmpty";
    
    // Guard method names
    public static final String GUARD_HAS_CONTAINER = "hasContainer";
    
    // Critique names
    public static final String CRITIQUE_RDBMS_TABLE_NAME_CONVENTION = "RdbmsTableNameConvention";
}
```

## Writing Validation Rules

### Basic Structure

```java
@ValidationContext(RdbmsTable.class)
public class RdbmsTableValidations {

    // Guard method
    public boolean hasContainer(EObject element, ValidationContext ctx) {
        return element.eContainer() != null;
    }

    // Constraint (error-level)
    @Constraint(name = RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY,
                message = "RDBMS table must have a primary key")
    public ValidationRule rdbmsTableHasPrimaryKey() {
        return (element, ctx) -> {
            RdbmsTable self = (RdbmsTable) element;
            if (self.getPrimaryKey() != null) {
                return ValidationResult.pass();
            }
            return ValidationResult.fail(
                RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY,
                "RDBMS table '" + self.getName() + "' must have a primary key",
                Severity.ERROR,
                self
            );
        };
    }

    // Critique (warning-level)
    @Critique(name = RdbmsValidationConstants.CRITIQUE_RDBMS_TABLE_NAME_CONVENTION,
              message = "Table name should follow naming convention")
    public ValidationRule rdbmsTableNameConvention() {
        return (element, ctx) -> {
            RdbmsTable self = (RdbmsTable) element;
            // Warning-level logic
            return ValidationResult.pass();
        };
    }
}
```

### Annotations

| Annotation | Description |
|------------|-------------|
| `@ValidationContext(EClass.class)` | Class-level, declares target EClass |
| `@Constraint(name, message)` | Method-level, error-level rule |
| `@Critique(name, message)` | Method-level, warning-level rule |
| `@Guard(method = "name")` | Method-level, conditional execution |
| `@Satisfies(constraints = {...})` | Method-level, constraint dependencies |

### ValidationResult Factory Methods

```java
ValidationResult.pass()                              // Passing
ValidationResult.fail("Error message")               // Error
ValidationResult.warn("Warning message")             // Warning
ValidationResult.fail(name, message, severity, elem) // Full metadata
```

## Running Validation

```java
// Simple validation
RdbmsValidator.validateRdbms(log, rdbmsModel);

// With expected errors/warnings (testing)
RdbmsValidator.validateRdbms(log, rdbmsModel,
    ImmutableList.of("ExpectedError1"),
    ImmutableList.of("ExpectedWarning1"));

// With parallel execution
RdbmsValidator.validateRdbms(log, rdbmsModel,
    expectedErrors, expectedWarnings, true);
```

| Mode | Description | Use Case |
|------|-------------|----------|
| Sequential | Single-threaded | Debugging, deterministic |
| Parallel | Multi-threaded | Production, large models |

## Dual Validation Testing

The test infrastructure supports running both EVL and Java validators:

```java
public enum ValidatorType {
    EVL,   // Epsilon Validation Language
    JAVA   // Zeta Java framework
}

@ParameterizedTest(name = "testConstraint [{0}]")
@EnumSource(ValidatorType.class)
void testConstraint(ValidatorType type) throws Exception {
    this.validatorType = type;
    initModel();
    
    // Build model that triggers constraint
    RdbmsTable table = newRdbmsTableBuilder()
        .withName("TestTable")
        // Missing primary key
        .build();
    rdbmsModel.getResource().getContents().add(table);
    
    runValidation(
        ImmutableList.of("RdbmsTableHasPrimaryKey"),
        ImmutableList.of()
    );
}
```

## EVL to Java Migration

### Translation Patterns

| EOL | Java |
|-----|------|
| `self.property` | `self.getProperty()` |
| `self.property.isDefined()` | `self.getProperty() != null` |
| `collection.exists(x \| cond)` | `collection.stream().anyMatch(x -> cond)` |
| `collection.forAll(x \| cond)` | `collection.stream().allMatch(x -> cond)` |
| `RDBMS!Type.all` | `ctx.getAllInstances(Type.class)` |
| `self.satisfies("Constraint")` | `ctx.satisfies("Constraint")` |

## Best Practices

1. **Use Constants**: Define all constraint names in `RdbmsValidationConstants`
2. **Clear Messages**: Include element name and context in error messages
3. **Reuse Guards**: Share guard methods across multiple constraints
4. **Document EVL**: Comment the original EVL if migrating
5. **Test Both**: Run parameterized tests with both validators

## See Also

- [Validation README](README.md) - General validation documentation
- [Judo Zeta Framework](https://github.com/BlackBeltTechnology/judo-zeta) - Zeta validation framework
- [Epsilon Documentation](https://eclipse.dev/epsilon/) - Official Epsilon platform documentation
