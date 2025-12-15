# Judo RDBMS Meta - Project Documentation

## Project Overview

**Repository:** BlackBeltTechnology/judo-meta-rdbms  
**License:** Eclipse Public License 2.0 (EPL-2.0)  
**Java Version:** 21  
**Build System:** Maven 3.9.4+ with Tycho (Eclipse build tooling)

This is an Eclipse/Tycho-based metamodel project that:
1. **Defines** a comprehensive RDBMS (Relational Database Management System) metamodel via EMF/Ecore
2. **Generates** Java code from the model using MWE2 workflows
3. **Provides** both Eclipse plugin and OSGi standalone runtime
4. **Implements** validation using both EVL (Epsilon) and Java (Zeta framework)
5. **Distributes** via both Maven Central and Eclipse P2 repositories

## Directory Structure

```
judo-meta-rdbms/
├── model/                          # Core RDBMS metamodel (Ecore)
│   ├── model/                      # Ecore models and genmodels
│   ├── src/main/java/              # Runtime classes and validation
│   │   └── hu/blackbelt/judo/meta/rdbms/
│   │       ├── runtime/            # RdbmsModel, RdbmsUtils, etc.
│   │       └── validation/         # Java validation framework
│   │           ├── RdbmsValidator.java
│   │           ├── RdbmsValidationConstants.java
│   │           └── rules/          # Validation rule classes
│   └── src/main/epsilon/           # EVL validation rules
├── model-test/                     # Unit tests for metamodel
├── osgi/                           # OSGi bundle repackaging
├── osgi-itest/                     # OSGi integration tests (Pax Exam)
├── feature/                        # Eclipse feature
├── site/                           # Eclipse P2 update site
├── docs/                           # Documentation
│   └── validation/                 # Validation documentation
└── openspec/                       # OpenSpec change management
```

## Core Modules

### Model Definition Layer

| Module | Type | Purpose |
|--------|------|---------|
| `model/` | eclipse-plugin | Core RDBMS metamodel via Ecore. Generates EMF code, builders, helpers. Contains validation rules. |
| `model-test/` | test | Unit tests for RDBMS metamodel using JUnit 5 and Epsilon runtime |

### Runtime/OSGi Layer

| Module | Type | Purpose |
|--------|------|---------|
| `osgi/` | bundle | Repackages model for OSGi environments using Apache Felix Bundle Plugin |
| `osgi-itest/` | test | Pax Exam integration tests for Karaf container (4.4.7) |

### Distribution Layer

| Module | Type | Purpose |
|--------|------|---------|
| `feature/` | eclipse-feature | Bundles model and plugins |
| `site/` | eclipse-repository | P2 update site for Eclipse distribution |

## RDBMS Metamodel Structure

The core metamodel defines these packages:

| Package | Purpose |
|---------|---------|
| `rdbms` | Core RDBMS elements (tables, fields, keys, indexes) |
| `rdbms.rules` | Table mapping rules |
| `rdbms.namemapping` | Name mapping definitions |
| `rdbms.datatypes` | RDBMS data type definitions |

### Key Model Elements

- **RdbmsElement** - Base element with name and UUID
- **RdbmsTable** - Database table definition
- **RdbmsField** - Table field (column)
- **RdbmsIdentifierField** - Primary key field
- **RdbmsValueField** - Data value field
- **RdbmsForeignKey** - Foreign key relationship
- **RdbmsJunctionTable** - Many-to-many junction table
- **RdbmsIndex** - Table index definition

## Validation Framework

The project supports dual validation using both EVL (Epsilon) and Java (Zeta):

### EVL Validation (Epsilon)
- Located in `model/src/main/epsilon/validations/rdbms.evl`
- Interpreted at runtime
- Used by `RdbmsEpsilonValidator`

### Java Validation (Zeta Framework)
- Located in `model/src/main/java/hu/blackbelt/judo/meta/rdbms/validation/`
- Compile-time type safety
- Better IDE support (autocompletion, debugging)
- Better performance through parallel execution
- Used by `RdbmsValidator`

### Validation Classes

| Class | Purpose |
|-------|---------|
| `RdbmsValidator` | Entry point for Java validation |
| `RdbmsValidationConstants` | Constraint name constants |
| `RdbmsElementValidations` | Validation rules for RdbmsElement |
| `RdbmsTableValidations` | Validation rules for RdbmsTable |

### Zeta Annotations Used

```java
@ValidationContext(RdbmsElement.class)  // Target EClass
@Constraint(name = "...", message = "...")  // Error-level rule
@Critique(name = "...", message = "...")    // Warning-level rule
@Guard(method = "guardMethodName")          // Guard predicate
@Satisfies(constraints = {"..."})           // Dependencies
```

## Technology Stack

### Core Technologies
- **Eclipse Modeling Framework (EMF)** 2.38.0+ - Metamodel foundation
- **Ecore** - Model definition language
- **MWE2** (Model Workflow Engine) 2.13.0 - Code generation workflows
- **Epsilon** 2.8.0 - Model validation (EVL)
- **Zeta** 1.0.0 - Java validation framework
- **Tycho** 4.0.13 - Eclipse plugin build

### Runtime
- **Apache Karaf** 4.4.7 - OSGi container
- **Apache Felix** 6.0.0 - OSGi bundle plugin
- **Pax Exam** 4.13.5 - OSGi testing

### Build & Quality
- **Maven** 3.9.4+
- **JaCoCo** 0.8.12 - Code coverage
- **Lombok** 1.18.34 - Annotation processing

## Build Commands

```bash
# Standard build
mvn clean install

# Skip tests
mvn clean install -DskipTests

# Run specific test module
mvn test -pl model-test

# Run only validation tests
mvn test -pl model-test -Dtest=RdbmsValidationTest

# Run performance tests
mvn test -pl model-test -Dtest=RdbmsValidationPerformanceTest
```

## Testing

### Test Classes

| Class | Purpose |
|-------|---------|
| `RdbmsValidationTest` | Dual EVL/Java validation tests |
| `RdbmsValidationPerformanceTest` | Performance comparison |
| `AbstractRdbmsValidationTest` | Base class for validation tests |
| `ValidatorType` | Enum for EVL/JAVA selection |
| `RdbmsUtilsTest` | Utility class tests |
| `RdbmsIncrementalTest` | Incremental model tests |

### Dual Validation Testing Pattern

```java
@ParameterizedTest(name = "testConstraint [{0}]")
@EnumSource(ValidatorType.class)
void testConstraint(ValidatorType type) throws Exception {
    this.validatorType = type;
    initModel();
    
    // Build model...
    
    runValidation(
        ImmutableList.of("ExpectedError"),
        ImmutableList.of()
    );
}
```

## Key Configuration Files

| File | Purpose |
|------|---------|
| `pom.xml` | Parent POM with module definitions |
| `model/META-INF/MANIFEST.MF` | OSGi bundle manifest |
| `model/model/rdbms.ecore` | Core metamodel definition |
| `model/model/rdbms.genmodel` | EMF code generation model |

## Dependencies

### Zeta Validation Framework
```xml
<judo-zeta-version>1.0.0.20251207_081454_0779b890_develop</judo-zeta-version>

<!-- Annotations -->
<dependency>
    <groupId>hu.blackbelt.judo.zeta</groupId>
    <artifactId>hu.blackbelt.judo.zeta.annotations</artifactId>
</dependency>

<!-- Common (ModelProvider, ExtensionMethodRegistry) -->
<dependency>
    <groupId>hu.blackbelt.judo.zeta</groupId>
    <artifactId>hu.blackbelt.judo.zeta.common</artifactId>
</dependency>

<!-- Validation Core -->
<dependency>
    <groupId>hu.blackbelt.judo.zeta</groupId>
    <artifactId>hu.blackbelt.judo.zeta.validation-core</artifactId>
</dependency>
```

## Development Guidelines

1. **Understand EMF/Ecore patterns** before modifying model code
2. **Respect Tycho build constraints** when modifying Eclipse plugins
3. **Validation rules** - Two implementations available:
   - **EVL (Epsilon):** Located in `model/src/main/epsilon/validations/`
   - **Java (Zeta):** Located in `model/src/main/java/hu/blackbelt/judo/meta/rdbms/validation/`
4. **Use constants** for constraint names (see `RdbmsValidationConstants`)
5. **Use OpenSpec** for significant changes - See `openspec/AGENTS.md`

## Related Documentation

- `README.adoc` - Project overview
- `openspec/AGENTS.md` - OpenSpec workflow for spec-driven development
- `docs/validation/README.md` - Validation rules overview
- `docs/validation/java-validation-framework.md` - Java validation framework
