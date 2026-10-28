# judo-meta-rdbms — module agent doctrine

## Module purpose

`judo-meta-rdbms` owns the estate's *relational* metamodel: the typed, persisted
description of the physical schema a JUDO application runs on. An `RdbmsTable`
is not hand-authored — it is derived, by the `judo-tatami-asm2rdbms`
transformation, from the entity types of an ASM model; an `RdbmsValueField`
comes from an ASM attribute, an `RdbmsForeignKey` (an `RdbmsIdentifierField`
carrying `referenceKey`, `inheritenceBased`, `deleteOnCascade`, `deferred`) from
an ASM reference, and an `RdbmsJunctionTable` (`field1`/`field2`) from the
many-to-many references that cannot live in either endpoint's table. Which of
those shapes a reference collapses into is decided by data, not by code:
`rdbms-tablemappingrules.ecore` holds `Rule` rows keyed on containment,
container, opposite presence and multiplicity bounds, and
`Rules.getRuleFromReference` looks the reference up in that table.

The metamodel deliberately carries the *dialect* concerns that a logical model
refuses to: `RdbmsConfiguration` pins a `dialect` plus a set of named
`RdbmsFeature` flags; `rdbms-datatypes.ecore` maps an `asmType` onto a concrete
`rdbmsType` with `rdbmsSize`, `rdbmsPrecision`, `rdbmsScale`, `rdbmsJdbcType`
and the numeric `rdbmsSqlType`, so the same logical `String` lands as the right
column type per database; and `rdbms-namemapping.ecore` maps a model
`fullyQualifiedName` to a database-legal `rdbmsName`, which is why every
`RdbmsElement` carries both `name`/`fullName` and `sqlName`/`originalName` —
identifier-length and casing limits are a first-class modelled fact here.

Two consumers read the result. Schema generation: `judo-tatami-rdbms2liquibase`
turns an `RdbmsModel` into a Liquibase changelog, so DDL is a projection of this
model rather than a separate source of truth. Runtime data access: the
`judo-runtime-core` RDBMS DAO resolves ASM elements onto these tables and
columns when it builds SQL. Because the schema of a deployed application must
evolve rather than be recreated, the metamodel also models its own diff:
`RdbmsOperationMeta` links `previousModel`, `currentModel` and
`incrementalModel`, and the ETL transformation
`model/src/main/epsilon/transformations/createIncrementalOperationModel.etl`
computes the `RdbmsCreate/Modify/DeleteTableOperation` and
`RdbmsCreate/Modify/DeleteFieldOperation` instances that describe the migration.

**Repository:** BlackBeltTechnology/judo-meta-rdbms ·
**Artifact:** `hu.blackbelt.judo.meta:hu.blackbelt.judo.meta.rdbms`
(packaging `pom`, version `${revision}` = `1.0.2-SNAPSHOT`) ·
**License:** EPL-2.0 · **Java:** 21 · **Build:** Maven 3.9.4+ / Eclipse Tycho 4.0.13.

## Reactor map

The root `pom.xml` declares its `<modules>` inside the `modules` profile, which
is active unless `-DskipModules=true` is passed. Build order is the declared
order — `model` produces the artifact every other module consumes.

<modules>
  <module>model</module>
  <module>model-test</module>
  <module>osgi</module>
  <module>osgi-itest</module>
  <module>feature</module>
  <module>site</module>
</modules>

| Module | Artifact / packaging | What it contributes |
|---|---|---|
| `model` | `…rdbms.model`, `eclipse-plugin` | The metamodel and everything derived from it: the four Ecore/GenModel pairs plus `rdbms.aird`, the MWE2 workflow that regenerates `src-gen/`, the EVL validation and ETL incremental-diff scripts, and the hand-written runtime and CLI code under `src/main/java/`. Every other reactor module consumes or repackages this one. |
| `model-test` | `…rdbms.model.test`, `jar` | JUnit 5 proof that the published API behaves: EVL validation outcomes, model querying, incremental transformation, and execution-context wiring. Depends on `model`, so it exercises the artifact rather than internals. Its fixture models and Epsilon fixtures have their own directory `AGENTS.md` records. |
| `osgi` | `…rdbms.osgi`, `bundle` (Felix) | Repackages `model` for non-Eclipse OSGi containers via `maven-bundle-plugin`, embedding the models and Epsilon scripts and marking the Epsilon runtime imports optional. Ships the bundle tracker that discovers models through the `Rdbms-Models` manifest header and registers them as OSGi services. |
| `osgi-itest` | `…rdbms.osgi.itest`, `jar` | Pax Exam 4.13.5 tests booting an Apache Karaf 4.4.7 container to assert the bundle really resolves there — model loading, service registration and bundle lifecycle, the check unit tests structurally cannot make. |
| `feature` | `…rdbms.feature`, `eclipse-feature` | The installable Eclipse feature (`hu.blackbelt.judo.meta.rdbms.feature`) grouping the plugin for P2 installation into an IDE workspace. Pure descriptor module — no sources. |
| `site` | `…rdbms.site`, `eclipse-repository` | Builds the P2 update site published for "Install New Software" and consumed as a P2 repository by downstream Tycho builds. Its category P2 URLs carry hardcoded versions — see the `update-category-versions` profile. |

## Build commands

```sh
mvn clean install                    # Full build (all modules)
mvn clean test                       # Run tests only
mvn clean install -DskipTests        # Build without tests
mvn clean install -Dmaven.test.skip  # Skip test compilation and execution
```

Single test:
```sh
mvn -pl model-test test -Dtest=RdbmsValidationTest
```

Maven wrapper is available and preferred over a repo-root `mvn`:
```sh
./mvnw clean install
```

Update the site category P2 URLs after a dependency version change:
```sh
mvn clean install -P update-category-versions
```

### Maven profiles

| Profile | Purpose |
|---------|---------|
| `modules` | Activates all submodules (default, unless `-DskipModules=true`) |
| `sign-artifacts` | GPG-signs artifacts for release deployment |
| `release-dummy` | Deploys to local `/tmp/` directory for testing |
| `release-judong` | Deploys to internal JUDO Nexus (`nexus.judo.technology`) |
| `release-central` | Deploys to Maven Central via Sonatype OSSRH |
| `update-category-versions` | Updates site category P2 repository URLs |
| `generate-github-asciidoc-diagrams` | Generates PlantUML diagrams from documentation |
| `update-source-code-license` | Updates EPL-2.0 license headers across source files |

## Technology stack

### Core technologies
- **EMF (Eclipse Modeling Framework) 2.38+** — Ecore metamodel definition, XMI serialization, code generation
- **Epsilon Runtime 2.8+** — EVL for model validation, ETL for model-to-model transformations, EOL for shared operations
- **MWE2 (Modeling Workflow Engine)** — orchestrates code generation from Ecore/GenModel files
- **Tycho 4.0.13** — Maven integration for Eclipse plugin builds (MANIFEST.MF, P2, features, update sites)
- **OSGi 7.0.0** — runtime modularity framework

### Build & quality
- **Maven 3.9.4+** with `${revision}` CI-friendly versioning and flatten-maven-plugin
- **JUnit 5 (Jupiter) 5.9.1** — unit testing
- **Pax Exam 4.13.5 + Karaf 4.4.7** — OSGi integration testing
- **JaCoCo 0.8.12** — code coverage
- **SonarQube 3.9.1** — static analysis
- **Lombok 1.18.34** — annotation processing (not used in Eclipse plugin modules due to Tycho incompatibility)

### Code generation pipeline
- **EMF GenModel Generator 1.1.1+** — generates Helper and Builder classes from GenModels
- **JUDO GenModel Generator 1.1.2+** — generates RuntimeModel support classes with model name/version resolvers
- **XText 2.39.0** — language infrastructure for MWE2 workflow execution

## Architecture pointers

- `model/model/rdbms.ecore` — the core metamodel: `RdbmsModel`, `RdbmsTable`, `RdbmsField`/`RdbmsValueField`/`RdbmsIdentifierField`, `RdbmsForeignKey`, `RdbmsJunctionTable`, `RdbmsIndex`, `RdbmsUniqueConstraint`, `RdbmsConfiguration`/`RdbmsFeature`, and the table/field operation classes plus `RdbmsOperationMeta`.
- `model/model/rdbms-datatypes.ecore` — `TypeMapping` rows mapping an ASM type onto an SQL/JDBC type with size, precision and scale.
- `model/model/rdbms-namemapping.ecore` — `NameMapping` rows binding a fully qualified model name to a database-legal `rdbmsName`.
- `model/model/rdbms-tablemappingrules.ecore` — `Rule` rows plus `Rules.getRuleFromReference`, deciding how an ASM reference lands in the schema.
- `model/src/workflow/generateModel.mwe2` — the MWE2 workflow that regenerates `src-gen/` from the GenModels.
- `model/src/main/epsilon/validations/` — `rdbms.evl` carries the core constraints, `rdbms-plugin-validation.evl` the plugin-side set.
- `model/src/main/epsilon/transformations/` — `createIncrementalOperationModel.etl` computes the schema diff; the `rdbms/utils/*.eol` scripts (`table`, `field`, `id`, `model`) hold the operations it shares.
- `model/src/main/java/.../runtime/` — the hand-written model-facing runtime: query and builder entry points over tables, fields, foreign keys and junction tables; ETL-driven incremental diff execution; EVL validation launching; two-model compatibility reporting; deep model cloning; and stream serialization of a model.
- `model/src/main/java/.../cli/` — the CLI adapters implementing the shared `ModelValidator` and `FqnResolver` contracts and delegating into the runtime validator and the name mapping.
- `model/src/main/java/.../validation/` — the Zeta Java validation rules, one class per metamodel concept (table, field, foreign key, index, unique constraint, junction table, configuration, element) plus the shared constants.
- `osgi/` — the `Rdbms-Models` manifest header contract and the bundle tracker that acts on it.
- The root `pom.xml` is the parent POM: dependency versions, plugin management, and every profile above. Test logging is driven by the repo-root `logback-test.xml`; the Maven wrapper is pinned by `.mvn/wrapper/maven-wrapper.properties`.
- [README.md](README.md) — project overview with metamodel and runtime flow diagrams.
- [CONTRIBUTING.md](CONTRIBUTING.md) — development setup, code generation, build lifecycle, submission guidelines.
- [.github/CIFLOW.md](.github/CIFLOW.md) — branching strategy, version numbering, CI/CD workflow diagrams.

## Development environment

**Required:** Java 21 JDK · Maven 3.9.4+ (or `./mvnw`).

**Eclipse IDE (optional):** m2e, Epsilon, Modeling Tools plugins; XTend, XText,
MWE, MWE2 for code generation.

## Git workflow

- **Main branch:** `develop` · **Release branch:** `master` (latest released sources)
- **Versioning:** `${revision}` property in `pom.xml`, currently `1.0.2-SNAPSHOT`
- **Branch naming:** `feature/JNG-NUMBER_summary`, `bugfix/JNG-NUMBER_summary`, `release/X.Y.Z`
- **Rule:** every commit must reference a JIRA ticket (`JNG-xxx`)
- **CI:** GitHub Actions on the `judong` runner with JDK 21 (Zulu distribution)

## Scope guard — invariants an edit must not break

1. **Never edit `src-gen/`** — it is regenerated by the MWE2 workflow from the Ecore models on every build. Hand-written code belongs in `model/src/main/java/`.
2. **Tycho version duality is tooling-owned** — Maven uses `-SNAPSHOT`, Eclipse uses `.qualifier`; the Tycho Versions Plugin converts at build time. Never hand-sync them.
3. **Lombok cannot be used in Eclipse plugin modules** — Tycho does not support it. Code in the plugin modules is generated or plain Java.
4. **The incremental model is a contract** — schema evolution is tracked through `RdbmsOperationMeta` linking previous, current and incremental models, with `createIncrementalOperationModel.etl` computing the diff. Changing the operation classes changes what downstream migration consumes.
5. **Four Ecore files compose the metamodel** — `rdbms.ecore` (core), `rdbms-datatypes.ecore` (type mappings), `rdbms-namemapping.ecore` (name resolution), `rdbms-tablemappingrules.ecore` (relationship mapping). A change to one usually implies a change to the others.
6. **`Rdbms-Models` manifest header is a contract** — the `osgi` bundle tracker discovers and registers models through it; downstream bundles rely on the header name.
7. **P2 category URLs contain hardcoded versions** — Tycho resolves repository definitions before Maven property substitution, so run `update-category-versions` after a dependency version change.

## Code instructions

1. First think through the problem, read the codebase for relevant files.
2. Before you make any major changes, check in with me and I will verify the plan.
3. Please every step of the way just give me a high level explanation of what changes you made.
4. Make every task and code change you do as simple as possible. We want to avoid making any massive or complex changes. Every change should impact as little code as possible. Everything is about simplicity.
5. Maintain a documentation file that describes how the architecture of the app works inside and out.
6. Never speculate about code you have not opened. If the user references a specific file, you MUST read the file before answering. Make sure to investigate and read relevant files BEFORE answering questions about the codebase. Never make any claims about code before investigating unless you are certain of the correct answer - give grounded and hallucination-free answers.
7. For implementation use TDD (Test-Driven Development): write or update tests first to define the expected behaviour, verify they fail, then write the minimal implementation to make them pass.
8. Use DRY (Don't Repeat Yourself): extract reusable logic into separate classes, utilities, or components. If the same pattern appears in multiple places, refactor it into a shared helper.

<!-- dox-doctrine -->
## Documentation Update Protocol (WRITE discipline)

Per-directory `AGENTS.md` files form a tree. Each directory `AGENTS.md` is the
per-file record for the files in that directory. This module-root `AGENTS.md`
holds doctrine + architecture pointers only — never a per-file index.

**Keep the root lean.** This file loads into every agent turn — every byte costs
tokens on every turn. A verbose root file buries the rules the model must follow
(signal dilution) and measurably degrades adherence; a lean file keeps doctrine
salient. Default assumption: your update does NOT belong in the root — route it
by the table below.

**Route every doc update by kind:**

| Kind of update | Goes in |
|---|---|
| New file in a directory, or its per-file detail / change history | Nearest directory `AGENTS.md`. Add a `` | `<basename>` | <purpose> | `` row, path-alphabetical. |
| Data flow, protocol, architecture rationale | `docs/architecture.md` or a `docs/<topic>.md` |
| End-user / developer setup | `README.md` |
| Cross-cutting rule every agent needs every turn (rare) | this module-root `AGENTS.md` |

**Read before editing (chain walk).** Before editing a file, read the nearest
`AGENTS.md` chain root→leaf so you know the file's recorded purpose, contracts,
and change history. Do not edit blind.

**Update after editing (closeout pass).** After changing a file, update its row
in the nearest directory `AGENTS.md`: find the file's row, update its purpose in
place; if absent, add it in path-alphabetical order. New directory → scaffold
its `AGENTS.md`. One row per file. The purpose carries a one-line summary, key
exported symbols, contracts/invariants, and `See change: <id>` history.

**Row style (caveman).** Short declarative fragments. Drop articles. Subject →
verb → object, present tense. One fact per row. Prefer concrete tokens (paths,
symbols, env vars) over prose. Keep identifiers verbatim.

**Size rule — split an over-large directory `AGENTS.md` file-based.** pi
auto-injects a directory `AGENTS.md` on every turn when cwd sits at/below it, so
an over-large directory `AGENTS.md` is not supported. Split it file-based: a row
exceeding the length threshold promotes to a per-file `<File>.AGENTS.md`
sidecar carrying that file's full detail (including every `See change:`). The
sidecar is pull-only — its name is not `AGENTS.md`, so pi never auto-injects it
— yet it stays search-indexed (`agents` doc_type). The directory `AGENTS.md`
keeps a one-line summary plus a `→ see `<File>.AGENTS.md`` pointer. Rows within
the threshold stay verbatim (lossless).

## Finding docs (READ discipline)

`kb_*` tools are faster and cheaper than raw search — they return a one-line
purpose + key exports per file, not raw bytes. **This fires on the ACTION, not
the intent** — before you `grep`/`rg` for a symbol, `cat`/read a file to learn
what it does, or chase an import, the kb call goes first. It fires **even
mid-task when you already know the file**; knowing the file does not exempt you.
When your reflex is the left column, run the right column instead:

| You're about to… | Do this FIRST instead |
|---|---|
| `grep -rn "SymbolName" src/` — find where a fn / type / const lives | `kb_search --doc-type agents "SymbolName"` — tree indexes key exports per file |
| `grep -rn "feature\|topic" src/` — how does X work / where's X handled | `kb_search "feature topic"` |
| `cat` / read a file just to learn its purpose before editing | `kb agents <path>` — one-line purpose + exports + change history |
| chase imports / callers across files | `kb_neighbors <path\|heading>` |
| read one doc section in full | `kb_get <path> <section>` |

**Fall-through (explicit):** if the kb call returns nothing relevant, `rg` /
source read is allowed — then add the missing directory `AGENTS.md` row per the
WRITE discipline. kb does NOT replace grep; it goes first.
