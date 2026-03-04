# osgi Specification

## Purpose

The `osgi` module repackages the RDBMS model as an OSGi bundle and provides dynamic model discovery via bundle tracking. It allows other OSGi components in transformation pipelines to consume RDBMS models without Eclipse dependencies.

## Architecture

The module centers on `RdbmsModelBundleTracker` (in `hu.blackbelt.judo.meta.rdbms.osgi`), an immediate OSGi component that:
- Tracks bundles with `Rdbms-Models` manifest headers
- Loads RDBMS models from bundle entries
- Registers loaded models as OSGi services
- Manages registration lifecycle (register on bundle activation, unregister on deactivation)

Internal data structures:
- `Map<String, ServiceRegistration<RdbmsModel>> rdbmsModelRegistrations` — tracks active OSGi service registrations
- `Map<String, RdbmsModel> rdbmsModels` — caches loaded model instances

## Requirements

### Requirement: Bundle tracking for RDBMS models

RdbmsModelBundleTracker SHALL discover and load RDBMS models from bundles that declare a `Rdbms-Models` manifest header.

#### Scenario: Bundle with RDBMS model installed
- **GIVEN** an OSGi container with the tracker component active
- **WHEN** a bundle with `Rdbms-Models` manifest header is installed and started
- **THEN** the tracker loads the RDBMS model from the bundle entry and registers it as an OSGi service

#### Scenario: Bundle without RDBMS model
- **GIVEN** an OSGi container with the tracker component active
- **WHEN** a bundle without `Rdbms-Models` manifest header is installed
- **THEN** the tracker ignores the bundle

### Requirement: Dependent metamodel registration

RdbmsModelBundleTracker SHALL register dependent metamodel packages (RdbmsNameMapping, RdbmsDataTypes, RdbmsTableMappingRules) alongside the core RDBMS model.

#### Scenario: Register with all metamodels
- **GIVEN** a bundle with a valid RDBMS model
- **WHEN** the model is loaded during bundle tracking
- **THEN** the tracker registers RdbmsNameMapping, RdbmsDataTypes, and RdbmsTableMappingRules metamodels in the model's resource set

### Requirement: Service lifecycle management

RdbmsModelBundleTracker SHALL properly manage OSGi service registrations across the component lifecycle.

#### Scenario: Component deactivation
- **GIVEN** an active tracker with registered RDBMS models
- **WHEN** the tracker component is deactivated
- **THEN** all tracked bundle registrations are cleaned up

#### Scenario: Bundle uninstallation
- **GIVEN** an active tracker with a registered RDBMS model from a specific bundle
- **WHEN** the bundle is uninstalled
- **THEN** the corresponding RDBMS model service registration is unregistered

### Requirement: Error handling during model loading

RdbmsModelBundleTracker SHALL handle model loading errors gracefully without affecting other bundles.

#### Scenario: Corrupt model in bundle
- **GIVEN** a bundle with an invalid or corrupt RDBMS model entry
- **WHEN** the tracker attempts to load the model
- **THEN** the error is logged and the bundle is skipped without affecting tracking of other bundles
