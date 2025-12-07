# Design: Zeta Java Validation Framework for RDBMS

## Context

The RDBMS metamodel currently has an empty EVL validation file (`rdbms.evl`). This change introduces the Zeta Java validation framework infrastructure, mirroring the ESM module's approach. The design enables:
- Future validation rules to be written in Java
- Dual validation testing (EVL and Java produce identical results)
- Performance testing for large models

## Goals

- Establish Zeta validation framework infrastructure
- Create test base class supporting dual EVL/Java validation
- Enable parameterized tests that run both validators
- Add performance benchmarking capability
- Document validation patterns

## Non-Goals

- Implement specific validation rules (framework only)
- Remove or deprecate EVL validation
- Change existing test assertions

## Architecture

### Package Structure

```
model/src/main/java/hu/blackbelt/judo/meta/rdbms/
├── runtime/
│   ├── RdbmsUtils.java                    # Existing utilities
│   ├── RdbmsEpsilonValidator.java         # Existing EVL validator
│   └── RdbmsModel.java                    # Existing model wrapper
└── validation/
    ├── RdbmsValidator.java                # Java validator entry point
    ├── RdbmsValidationConstants.java      # Constraint name constants
    └── rules/
        └── RdbmsElementValidations.java   # Validation rules (placeholder)

model-test/src/test/java/hu/blackbelt/judo/meta/rdbms/
├── ValidatorType.java                     # EVL/JAVA enum
├── AbstractRdbmsValidationTest.java       # Dual validation base class
├── RdbmsValidationTest.java               # Existing tests (modified)
└── RdbmsValidationPerformanceTest.java    # Performance tests
```

### Validation Framework Components

#### 1. ValidatorType Enum
```java
public enum ValidatorType {
    EVL,   // Epsilon Validation Language
    JAVA   // Zeta Java framework
}
```

#### 2. Constants Class Pattern
```java
public final class RdbmsValidationConstants {
    private RdbmsValidationConstants() {}
    
    // Constraint names
    public static final String CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY = "RdbmsTableHasPrimaryKey";
    public static final String CONSTRAINT_RDBMS_ELEMENT_NAME_NOT_EMPTY = "RdbmsElementNameNotEmpty";
    
    // Guard method names
    public static final String GUARD_HAS_CONTAINER = "hasContainer";
    
    // Critique names
    public static final String CRITIQUE_RDBMS_TABLE_NAME_CONVENTION = "RdbmsTableNameConvention";
}
```

#### 3. Validation Rule Class Pattern
```java
@ValidationContext(RdbmsTable.class)
public class RdbmsTableValidations {
    
    @Constraint(
        name = RdbmsValidationConstants.CONSTRAINT_RDBMS_TABLE_HAS_PRIMARY_KEY,
        message = "RDBMS table must have a primary key"
    )
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
}
```

#### 4. Java Validator Entry Point
```java
public class RdbmsValidator {
    
    public static void validateRdbms(
        Logger log,
        RdbmsModel rdbmsModel,
        Collection<String> expectedErrors,
        Collection<String> expectedWarnings,
        boolean parallel
    ) throws RdbmsModel.RdbmsValidationException {
        ValidationRegistry registry = new ValidationRegistry();
        // Register all validation classes
        registry.register(RdbmsTableValidations.class);
        registry.register(RdbmsElementValidations.class);
        // ... more registrations
        
        ValidationContext context = new ValidationContext(
            new RdbmsUtils(rdbmsModel.getResourceSet(), false),
            rdbmsModel.getResourceSet(),
            new ExtensionMethodRegistry()
        );
        
        ValidationExecutor executor = new ValidationExecutor(registry, context, parallel);
        List<ValidationResult> failures = executor.validate(getAllElements(rdbmsModel));
        
        // Compare with expected results...
    }
}
```

#### 5. Test Base Class Pattern
```java
public abstract class AbstractRdbmsValidationTest {
    protected RdbmsModel rdbmsModel;
    protected ValidatorType validatorType;
    
    protected void initModel() {
        rdbmsModel = RdbmsModel.buildRdbmsModel()
            .rdbmsModelResourceSupport(rdbmsModelResourceSupportBuilder()
                .uri(URI.createFileURI("urn:Rdbms.model"))
                .build())
            .build();
    }
    
    protected void runValidation(
        Collection<String> expectedErrors,
        Collection<String> expectedWarnings
    ) throws Exception {
        switch (validatorType) {
            case EVL:
                runEvlValidation(expectedErrors, expectedWarnings);
                break;
            case JAVA:
                RdbmsValidator.validateRdbms(
                    log, rdbmsModel, expectedErrors, expectedWarnings, false);
                break;
        }
    }
}
```

#### 6. Parameterized Test Pattern
```java
@ParameterizedTest(name = "testRdbmsTableHasPrimaryKey [{0}]")
@EnumSource(ValidatorType.class)
void testRdbmsTableHasPrimaryKey(ValidatorType type) throws Exception {
    this.validatorType = type;
    initModel();
    
    // Create model violating constraint
    RdbmsTable table = newRdbmsTableBuilderInit()
        .withName("TestTable")
        // Missing primary key
        .build();
    
    rdbmsModel.addContent(table);
    
    runValidation(
        ImmutableList.of("RdbmsTableHasPrimaryKey"),
        ImmutableList.of()
    );
}
```

### Performance Test Design

```java
@Test
void testPerformanceWith10000Elements() {
    initModel();
    
    // Generate 10,000 elements
    for (int i = 0; i < 10000; i++) {
        RdbmsTable table = newRdbmsTableBuilderInit()
            .withName("Table" + i)
            .withPrimaryKey(newRdbmsIdentifierFieldBuilder()
                .withName("id" + i)
                .build())
            .build();
        rdbmsModel.addContent(table);
    }
    
    // Time EVL validation
    long evlStart = System.currentTimeMillis();
    runEvlValidation(Collections.emptyList(), Collections.emptyList());
    long evlTime = System.currentTimeMillis() - evlStart;
    
    // Time Java validation (sequential)
    long javaSeqStart = System.currentTimeMillis();
    RdbmsValidator.validateRdbms(log, rdbmsModel, 
        Collections.emptyList(), Collections.emptyList(), false);
    long javaSeqTime = System.currentTimeMillis() - javaSeqStart;
    
    // Time Java validation (parallel)
    long javaParStart = System.currentTimeMillis();
    RdbmsValidator.validateRdbms(log, rdbmsModel, 
        Collections.emptyList(), Collections.emptyList(), true);
    long javaParTime = System.currentTimeMillis() - javaParStart;
    
    log.info("Performance results for 10,000 elements:");
    log.info("  EVL: {}ms", evlTime);
    log.info("  Java (sequential): {}ms", javaSeqTime);
    log.info("  Java (parallel): {}ms", javaParTime);
}
```

## Decisions

### Decision 1: Use Zeta Framework
**Choice**: Use Zeta validation framework from judo-zeta repository
**Alternatives**:
- Custom validation framework - More work, less tested
- Bean Validation (JSR-380) - Not designed for EMF models
**Rationale**: Zeta is already proven in ESM, designed for EMF, supports parallel execution

### Decision 2: Dual Validation Testing
**Choice**: Run both EVL and Java validators in same test suite
**Alternatives**:
- Separate test suites - Harder to maintain parity
- Java-only tests - Loses EVL regression coverage
**Rationale**: Ensures both validators produce identical results

### Decision 3: Constants for All Names
**Choice**: Use `public static final String` constants for constraint names, guard names, messages
**Alternatives**:
- Inline strings - Error-prone, hard to refactor
- Enums - Less flexible for message interpolation
**Rationale**: Compile-time safety, easy refactoring, grep-friendly

### Decision 4: Framework-Only Initial Implementation
**Choice**: Set up framework without implementing actual rules
**Alternatives**:
- Implement all rules immediately - Larger change scope
- Wait for rules to be needed - Delays infrastructure
**Rationale**: Empty `rdbms.evl` means no rules to migrate yet; framework enables future work

## Risks and Mitigations

| Risk | Impact | Mitigation |
|------|--------|------------|
| Zeta version incompatibility | Build failures | Pin exact version, test in CI |
| EVL/Java result mismatch | Test failures | Dual testing catches mismatches |
| Performance regression | Slow builds | Performance test monitors times |

## Migration Plan

1. Add Zeta dependencies to `model/pom.xml` and `model-test/pom.xml`
2. Create validation package structure in `model/`
3. Create `ValidatorType` enum and base test class in `model-test/`
4. Modify existing `RdbmsValidationTest` to extend new base class
5. Add performance test class
6. Update documentation
7. Run full test suite to verify no regressions

## Open Questions

None - design follows established ESM patterns.
