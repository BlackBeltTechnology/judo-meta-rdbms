# Project Context

## Purpose

**Judo RDBMS Meta** is an Eclipse/Tycho-based metamodel project that:
- Defines a comprehensive RDBMS (Relational Database) metamodel via EMF/Ecore
- Generates Java code from the model using MWE2 workflows
- Provides OSGi standalone runtime
- Supports incremental database schema migrations
- Distributes via both Maven Central and Eclipse P2 repositories

## Tech Stack

### Core Technologies
- **Java 21** - Primary language
- **Eclipse Modeling Framework (EMF)** 2.38.0+ - Metamodel foundation
- **Ecore** - Model definition language
- **MWE2** (Model Workflow Engine) 2.13.0 - Code generation workflows
- **Epsilon** 2.8.0 - Model validation (EVL) and transformation (ETL)
- **Tycho** 4.0.13 - Eclipse plugin build

### Runtime
- **Apache Karaf** 4.4.7 - OSGi container
- **Apache Felix** 6.0.0 - OSGi bundle plugin

### Build & Testing
- **Maven** 3.9.4+ with wrapper
- **JUnit 5** - Unit testing
- **Pax Exam** 4.13.5 - OSGi integration testing

## Project Conventions

### Code Style
- Java 21 language features (records, pattern matching, sealed classes where applicable)
- Use Lombok for boilerplate reduction (`@Getter`, `@Setter`, `@Builder`, `@Slf4j`)
- EMF-generated code follows GenModel conventions
- Immutable objects preferred for validation results and cache keys
- Functional interfaces for validation rules and guards

### Architecture Patterns
- **EMF/Ecore patterns** for metamodel definition and manipulation
- **Annotation-based configuration** for validation rules (Zeta framework)
- **Functional interfaces** for validation logic (lambdas supported)
- **Registry pattern** for scanning and discovering validators
- **Phased execution** for dependency resolution (satisfies)
- **Caching** for expensive operations (extension methods, satisfies results)

### Testing Strategy
- Unit tests in `model-test/` module using JUnit 5
- Parameterized tests with `ValidatorType` enum for dual EVL/Java validation
- Expected errors/warnings passed to validator for assertion
- Model fixtures created using EMF builders
- OSGi integration tests via Pax Exam in `osgi-itest/`

### Git Workflow
- **Main Branch:** `develop`
- **Versioning:** SNAPSHOT-based development (currently 1.0.2-SNAPSHOT)
- Feature branches for significant changes
- OpenSpec proposals for architectural changes

## Domain Context

### RDBMS Metamodel Classes

| Class | Purpose |
|-------|---------|
| `RdbmsModel` | Root container for RDBMS model |
| `RdbmsTable` | Database table definition with primary key, fields, indexes |
| `RdbmsElement` | Abstract base for all RDBMS elements (name, uuid, sqlName) |
| `RdbmsField` | Abstract base for table fields (mandatory, type, size, precision) |
| `RdbmsIdentifierField` | Primary key field with foreign key references |
| `RdbmsValueField` | Data column with technical flag |
| `RdbmsForeignKey` | Foreign key reference with cascade options |
| `RdbmsJunctionTable` | Many-to-many junction table |
| `RdbmsConfiguration` | Database configuration (dialect, features) |
| `RdbmsIndex` | Database index definition |
| `RdbmsUniqueConstraint` | Unique constraint definition |

### Table Operations (Incremental Migrations)

| Class | Purpose |
|-------|---------|
| `RdbmsTableOperation` | Abstract base for table operations |
| `RdbmsCreateTableOperation` | Create new table |
| `RdbmsDeleteTableOperation` | Delete existing table |
| `RdbmsModifyTableOperation` | Modify table (add/modify/delete fields) |

### Validation System

Current validation uses **Epsilon Validation Language (EVL)**:
- Rules in `model/src/main/epsilon/validations/`
- Entry point: `rdbms-plugin-validation.evl`
- Helper: `rdbms.evl` (currently empty - no rules defined)
- Two severity levels: Constraint (ERROR) and Critique (WARNING)

**Planned: Java Validation Framework (Zeta)**
- Native Java alternative to EVL
- Annotation-driven: `@ValidationContext`, `@Constraint`, `@Critique`, `@Guard`, `@Satisfies`
- Better IDE support, debugging, and performance
- Parallel execution support for large models

### Key Validation Concepts
- **Constraint**: Error-level rule that must pass
- **Critique**: Warning-level rule (advisory)
- **Guard**: Condition that determines if rule should evaluate
- **Satisfies**: Dependency on another constraint's result (cached)
- **Context**: EClass type the rule applies to

## Important Constraints

### Build Constraints
- Tycho build requires Eclipse plugin structure
- OSGi bundle manifests must be maintained
- P2 update site structure for Eclipse distribution

### Validation Constraints
- EVL rules must remain functional during Java framework migration
- Test parity: Java tests must mirror EVL tests exactly
- Dual validation: tests run both EVL and Java validators with same expectations

### Code Generation Constraints
- MWE2 workflows for EMF code generation
- GenModel conventions for generated Java classes

## External Dependencies

### Eclipse Platform
- EMF Runtime 2.38.0+

### Epsilon Runtime
- EVL (Epsilon Validation Language) for model validation
- EOL (Epsilon Object Language) for helper operations
- ETL (Epsilon Transformation Language) for model transformations
- EMC (Epsilon Model Connectivity) for EMF integration

### Zeta Validation Framework
- `hu.blackbelt.judo.zeta:zeta-annotations` - Validation annotations
- `hu.blackbelt.judo.zeta:validation-core` - Core validation runtime

### Build Infrastructure
- Maven Central for artifact publication
- Eclipse P2 for plugin distribution

## Module Overview

| Module | Purpose |
|--------|---------|
| `model/` | Core RDBMS metamodel, EMF code, Epsilon validation, Java validation |
| `model-test/` | Unit tests for metamodel and validation |
| `osgi/` | OSGi bundle repackaging |
| `osgi-itest/` | OSGi integration tests |
| `feature/` | Eclipse feature packaging |
| `site/` | P2 update site |

## Key File Locations

| File | Purpose |
|------|---------|
| `model/model/rdbms.ecore` | Core RDBMS metamodel definition |
| `model/model/rdbms.genmodel` | EMF code generation model |
| `model/src/main/epsilon/validations/rdbms.evl` | EVL validation rules |
| `model/src/main/java/.../runtime/RdbmsUtils.java` | RDBMS utility methods |
| `model/src/main/java/.../runtime/RdbmsEpsilonValidator.java` | EVL validator entry point |
| `model-test/src/test/java/.../RdbmsValidationTest.java` | Validation test base class |

## Active Changes

See `openspec/changes/` for in-progress proposals.
