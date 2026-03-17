# judo-meta-rdbms

[![Build](https://github.com/BlackBeltTechnology/judo-meta-rdbms/actions/workflows/build.yml/badge.svg?branch=develop)](https://github.com/BlackBeltTechnology/judo-meta-rdbms/actions/workflows/build.yml)

## Introduction

judo-meta-rdbms is an EMF (Eclipse Modeling Framework) metamodel that describes relational database schemas within the JUDO ecosystem. It defines the structural elements of an RDBMS — tables, fields, foreign keys, indexes, constraints, and junction tables — and provides tooling for incremental schema evolution, model validation, and DDL generation via Liquibase.

The metamodel is packaged as an Eclipse plugin (with features and update sites), but also works standalone and in standard OSGi containers without Eclipse.

## Context

This project is a building block of the [judo-community](https://github.com/BlackBeltTechnology/judo-community) aggregator project. It sits in the model layer of the JUDO architecture, providing the RDBMS schema representation that downstream modules (like the Liquibase DDL generator) consume.

## Module Overview

```mermaid
graph TD
    subgraph "Core"
        MODEL["model/<br/>Ecore metamodel + generated Java + runtime code"]
        TEST["model-test/<br/>JUnit 5 unit tests"]
    end

    subgraph "OSGi Layer"
        OSGI["osgi/<br/>OSGi bundle repackaging"]
        ITEST["osgi-itest/<br/>Karaf integration tests"]
    end

    subgraph "Eclipse Packaging"
        FEATURE["feature/<br/>Eclipse feature"]
        SITE["site/<br/>Eclipse update site"]
    end

    TEST -.->|tests| MODEL
    OSGI --> MODEL
    ITEST -.->|tests| OSGI
    FEATURE --> MODEL
    SITE --> FEATURE
```

## Metamodel Structure

The core metamodel (`model/model/rdbms.ecore`) defines the following key types:

```mermaid
classDiagram
    class RdbmsModel {
        +name: String
        +version: String
        +rdbmsTables: RdbmsTable[*]
        +configuration: RdbmsConfiguration
        +tableOperations: RdbmsTableOperation[*]
    }

    class RdbmsTable {
        +primaryKey: RdbmsIdentifierField
        +parents: RdbmsTable[*]
        +fields: RdbmsField[*]
        +indexes: RdbmsIndex[*]
        +uniqueConstraints: RdbmsUniqueConstraint[*]
    }

    class RdbmsJunctionTable {
        +field1: RdbmsForeignKey
        +field2: RdbmsForeignKey
    }

    class RdbmsField {
        <<abstract>>
        +mandatory: boolean
        +rdbmsTypeName: String
        +size: int
        +precision: int
        +scale: int
    }

    class RdbmsValueField {
        +technical: boolean
    }

    class RdbmsIdentifierField {
        +foreignKeys: RdbmsForeignKey[*]
    }

    class RdbmsForeignKey {
        +referenceKey: RdbmsIdentifierField
        +deleteOnCascade: boolean
        +deferred: boolean
    }

    class RdbmsConfiguration {
        +dialect: String
        +features: RdbmsFeature[*]
    }

    RdbmsModel *-- RdbmsTable
    RdbmsModel *-- RdbmsConfiguration
    RdbmsTable <|-- RdbmsJunctionTable
    RdbmsTable *-- RdbmsField
    RdbmsField <|-- RdbmsValueField
    RdbmsField <|-- RdbmsIdentifierField
    RdbmsIdentifierField <|-- RdbmsForeignKey
    RdbmsForeignKey --> RdbmsIdentifierField : referenceKey
```

Four Ecore files compose the full metamodel:

| Ecore File | Purpose |
|------------|---------|
| `rdbms.ecore` | Core model: tables, fields, keys, indexes, constraints, and incremental operations |
| `rdbms-datatypes.ecore` | Type mapping configuration (ASM types to RDBMS types with size/precision/JDBC info) |
| `rdbms-namemapping.ecore` | FQN-to-SQL name resolution mappings |
| `rdbms-tablemappingrules.ecore` | Rules for table relationship mapping (foreign keys, join tables, cascading) |

## Runtime Flow

The project provides three main runtime capabilities: model loading, validation, and incremental transformation.

```mermaid
sequenceDiagram
    participant Client
    participant RdbmsModel
    participant Validator as RdbmsEpsilonValidator
    participant Incremental as RdbmsIncremental
    participant ETL as createIncrementalOperationModel.etl

    Client->>RdbmsModel: buildRdbmsModel() / loadRdbmsModel()
    RdbmsModel-->>Client: model instance

    Client->>Validator: validateRdbms(model)
    Validator->>Validator: Execute rdbms.evl rules
    Validator-->>Client: errors / warnings

    Client->>Incremental: transformRdbmsIncrementalModel(previous, new, incremental, dialect)
    Incremental->>ETL: Execute ETL with 3 model contexts
    ETL-->>Incremental: RdbmsOperationMeta (create/modify/delete operations)
    Incremental-->>Client: incremental model with table operations
```

## Build Commands

```sh
mvn clean install          # Full build
mvn clean test             # Run tests only
mvn clean install -DskipTests  # Build without tests
```

> **Note:** Maven wrapper is available (`./mvnw`).

## External Dependencies

```mermaid
graph LR
    subgraph "External"
        EMF["Eclipse EMF 2.38+<br/>Modeling framework"]
        EPS["Epsilon Runtime 2.8+<br/>EVL/ETL execution"]
        OSGI_FW["OSGi 7.0.0<br/>Modularity"]
        LOMBOK["Lombok 1.18<br/>Code generation"]
        CLI["judo-cli-api<br/>CLI integration"]
    end

    subgraph "Project"
        MODEL_RT["Runtime Code"] --> EMF
        MODEL_RT --> EPS
        OSGI_B["OSGi Bundle"] --> OSGI_FW
        OSGI_B --> MODEL_RT
        CLI_IMPL["CLI Validators"] --> CLI
        CLI_IMPL --> MODEL_RT
    end
```

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for development setup, code structure, and submission guidelines.

## License

This project is licensed under the [Eclipse Public License 2.0](https://www.eclipse.org/legal/epl-2.0/).
