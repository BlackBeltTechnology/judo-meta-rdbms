# JUDO Meta RDBMS - Project Documentation

## Project Overview

**Repository:** BlackBeltTechnology/judo-meta-rdbms
**License:** Eclipse Public License 2.0 (EPL-2.0)
**Java Version:** 21
**Build System:** Maven 3.9.4+ with Tycho 4.0.13

1. Defines an EMF (Eclipse Modeling Framework) metamodel for relational database schemas — tables, fields, foreign keys, indexes, constraints, and junction tables
2. Provides incremental schema evolution tracking via operation models (create/modify/delete table and field operations) using Epsilon ETL transformations
3. Validates RDBMS models using Epsilon EVL (validation language) scripts with CLI integration
4. Packages as both an Eclipse plugin (with feature/update site) and a standalone OSGi bundle for use in transformation pipelines
5. Generates Java code (builders, helpers, runtime support) from Ecore models via MWE2 workflows

## Directory Structure

```
judo-meta-rdbms/
├── model/                    # Core Eclipse plugin: Ecore metamodel + generated + runtime code
│   ├── model/                # 4 Ecore files + GenModels defining the RDBMS metamodel
│   ├── src/main/java/        # Hand-written runtime code (utils, validation, CLI, incremental)
│   ├── src-gen/              # EMF-generated Java code (DO NOT EDIT)
│   ├── src/main/epsilon/     # EVL validation + ETL transformation scripts
│   └── src/workflow/         # MWE2 code generation workflow
├── model-test/               # JUnit 5 unit tests
├── osgi/                     # OSGi bundle repackaging with bundle tracking
├── osgi-itest/               # Karaf/Pax Exam integration tests
├── feature/                  # Eclipse feature definition
├── site/                     # Eclipse update site
├── .github/workflows/        # CI/CD pipelines (build, release, merge)
└── openspec/                 # OpenSpec configuration and specifications
```

## Core Modules

### Model Layer

| Module | Type | Purpose |
|--------|------|---------|
| `model/` | Eclipse plugin | Contains the Ecore metamodel definitions (`rdbms.ecore`, `rdbms-datatypes.ecore`, `rdbms-namemapping.ecore`, `rdbms-tablemappingrules.ecore`), EMF-generated Java code in `src-gen/`, hand-written runtime support in `src/main/java/`, Epsilon validation/transformation scripts, and MWE2 code generation workflow |
| `model-test/` | Test module | JUnit 5 tests covering EVL validation (`RdbmsValidationTest`), utility functions (`RdbmsUtilsTest`), incremental model transformation (`RdbmsIncrementalTest`), and execution context (`RdbmsExecutionContextTest`) |

### OSGi Layer

| Module | Type | Purpose |
|--------|------|---------|
| `osgi/` | OSGi bundle | Repackages the model as an OSGi bundle. Provides `RdbmsModelBundleTracker` that dynamically loads RDBMS models from bundles with `Rdbms-Models` manifest headers and registers them as OSGi services |
| `osgi-itest/` | Integration test | Runs tests inside a Karaf 4.4.7 container using Pax Exam 4.13.5 to verify OSGi service registration and bundle lifecycle |

### Eclipse Packaging

| Module | Type | Purpose |
|--------|------|---------|
| `feature/` | Eclipse feature | Eclipse feature definition for P2 installation |
| `site/` | Eclipse update site | Compiles all versions as an update site. Versions are encoded in URLs; use profile `update-category-versions` to update |

## Technology Stack

### Core Technologies
- **EMF (Eclipse Modeling Framework) 2.38+** — Ecore metamodel definition, XMI serialization, code generation
- **Epsilon Runtime 2.8+** — EVL for model validation, ETL for model-to-model transformations, EOL for utility scripts
- **MWE2 (Modeling Workflow Engine)** — Orchestrates code generation from Ecore/GenModel files
- **Tycho 4.0.13** — Maven integration for Eclipse plugin builds (handles MANIFEST.MF, P2, features, update sites)
- **OSGi 7.0.0** — Runtime modularity framework

### Build & Quality
- **Maven 3.9.4+** with `${revision}` CI-friendly versioning and flatten-maven-plugin
- **JUnit 5 (Jupiter) 5.9.1** — Unit testing
- **Pax Exam 4.13.5 + Karaf 4.4.7** — OSGi integration testing
- **JaCoCo 0.8.12** — Code coverage
- **SonarQube 3.9.1** — Static analysis
- **Lombok 1.18.34** — Annotation processing (not used in Eclipse plugin modules due to Tycho incompatibility)

### Code Generation Pipeline
- **EMF GenModel Generator 1.1.1+** — Generates Helper and Builder classes from GenModels
- **JUDO GenModel Generator 1.1.2+** — Generates RuntimeModel support classes with model name/version resolvers
- **XText 2.39.0** — Language infrastructure for MWE2 workflow execution

## Build Commands

```sh
mvn clean install                # Full build (all modules)
mvn clean test                   # Run tests only
mvn clean install -DskipTests    # Build without tests
mvn clean install -Dmaven.test.skip  # Skip test compilation and execution
```

Single test:
```sh
mvn -pl model-test test -Dtest=RdbmsValidationTest
```

Maven wrapper is available:
```sh
./mvnw clean install
```

### Maven Profiles

| Profile | Purpose |
|---------|---------|
| `modules` | Activates all submodules (default, unless `-DskipModules=true`) |
| `sign-artifacts` | GPG-signs artifacts for release deployment |
| `release-dummy` | Deploys to local `/tmp/` directory for testing |
| `release-judong` | Deploys to internal JUDO Nexus (`nexus.judo.technology`) |
| `release-central` | Deploys to Maven Central via Sonatype OSSRH |
| `generate-github-asciidoc-diagrams` | Generates PlantUML diagrams from documentation |
| `update-source-code-license` | Updates EPL-2.0 license headers across source files |

## Key Configuration Files

| File | Purpose |
|------|---------|
| `pom.xml` | Parent POM with all dependency versions, plugin configurations, and profiles |
| `model/model/rdbms.ecore` | Core RDBMS metamodel (tables, fields, keys, operations) |
| `model/model/rdbms-datatypes.ecore` | ASM-to-RDBMS type mapping model |
| `model/model/rdbms-namemapping.ecore` | FQN-to-SQL name mapping model |
| `model/model/rdbms-tablemappingrules.ecore` | Table relationship mapping rules |
| `model/src/workflow/generateModel.mwe2` | MWE2 code generation workflow |
| `model/src/main/epsilon/validations/rdbms.evl` | Core EVL validation rules |
| `model/src/main/epsilon/transformations/createIncrementalOperationModel.etl` | ETL for incremental schema diff |
| `logback-test.xml` | Test logging configuration |
| `.mvn/wrapper/maven-wrapper.properties` | Maven wrapper configuration |

## Key Runtime Classes

| Class | Package | Purpose |
|-------|---------|---------|
| `RdbmsUtils` | `runtime` | Model querying: get tables, fields, foreign keys, junction tables; ID management; builder initialization |
| `RdbmsIncremental` | `runtime` | Executes ETL transformation to compute schema diffs between model versions |
| `RdbmsEpsilonValidator` | `runtime` | Runs EVL validation scripts against RDBMS models |
| `CheckRdbmsModelCompatibility` | `runtime` | Compares two models and generates compatibility reports |
| `RdbmsCloneUtil` | `runtime` | Deep-clones RDBMS models |
| `RdbmsModelStreamProvider` | `runtime` | Serializes models to InputStreams |
| `RdbmsValidatorImpl` | `cli` | CLI integration — implements `ModelValidator` interface, delegates to `RdbmsEpsilonValidator` |
| `RdbmsFqnResolverImpl` | `cli` | CLI integration — implements `FqnResolver` for FQN-to-model-element resolution |
| `RdbmsModelBundleTracker` | `osgi` | OSGi bundle tracker — loads models from bundles with `Rdbms-Models` manifest header |

## Development Environment

**Required:**
- Java 21 JDK
- Maven 3.9.4+

**Eclipse IDE (optional):**
- m2e, Epsilon, Modeling Tools plugins
- XTend, XText, MWE, MWE2 (for code generation)

## Git Workflow

- **Main Branch:** `develop`
- **Release Branch:** `master` (contains latest released sources)
- **Versioning:** `${revision}` property in pom.xml, currently `1.0.2-SNAPSHOT`
- **Branch naming:** `feature/JNG-NUMBER_summary`, `bugfix/JNG-NUMBER_summary`, `release/X.Y.Z`
- **Rule:** Every commit must reference a JIRA ticket (`JNG-xxx`)
- **CI:** GitHub Actions on `judong` runner with JDK 21 (Zulu distribution)

## Important Notes

1. **Never edit `src-gen/` files** — they are regenerated by the MWE2 workflow from Ecore models. All hand-written code belongs in `model/src/main/java/`
2. **Tycho version duality** — Maven uses `-SNAPSHOT`, Eclipse uses `.qualifier`. The Tycho Versions Plugin handles conversion automatically at build time
3. **Lombok restriction** — Tycho does not support Lombok directly. No Lombok is used in Eclipse plugin modules; all code there is generated
4. **Incremental model** — The project tracks schema evolution through `RdbmsOperationMeta` linking previous, current, and incremental models. The ETL transformation (`createIncrementalOperationModel.etl`) computes diffs
5. **Four Ecore files** compose the full metamodel: `rdbms.ecore` (core), `rdbms-datatypes.ecore` (type mappings), `rdbms-namemapping.ecore` (name resolution), `rdbms-tablemappingrules.ecore` (relationship mapping)
6. **OSGi bundle tracking** — The `RdbmsModelBundleTracker` in the `osgi` module dynamically discovers and loads RDBMS models from bundles via the `Rdbms-Models` manifest header
7. **Epsilon scripts** — Validation rules are in `rdbms.evl` and `rdbms-plugin-validation.evl`; incremental transformation is in `createIncrementalOperationModel.etl`; utility operations are in various `.eol` files

## Related Documentation

- [README.md](README.md) — Project overview with metamodel and runtime flow diagrams
- [CONTRIBUTING.md](CONTRIBUTING.md) — Development setup, code generation, build lifecycle, and submission guidelines
- [.github/CIFLOW.md](.github/CIFLOW.md) — Git branching strategy, version numbering, and CI/CD workflow diagrams
