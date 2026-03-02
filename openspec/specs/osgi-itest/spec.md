# osgi-itest Specification

## Purpose

The `osgi-itest` module provides integration tests that verify the RDBMS model's OSGi bundle works correctly inside a real Karaf container, including service registration, bundle lifecycle, and model accessibility.

## Architecture

Tests use Pax Exam 4.13.5 to bootstrap a Karaf 4.4.7 container, deploy the RDBMS OSGi bundle and its dependencies, and verify that models are properly discovered and registered as OSGi services.

## Requirements

### Requirement: OSGi bundle activation

The RDBMS OSGi bundle SHALL activate successfully in a Karaf container with all required dependencies.

#### Scenario: Bundle starts in Karaf
- **GIVEN** a Karaf container with EMF, Epsilon, and OSGi utility bundles installed
- **WHEN** the RDBMS OSGi bundle is installed and started
- **THEN** the bundle reaches ACTIVE state and the `RdbmsModelBundleTracker` component is activated

### Requirement: Model service availability

RDBMS models loaded from bundles SHALL be accessible as OSGi services.

#### Scenario: Retrieve model service
- **GIVEN** a Karaf container with an active RDBMS bundle and a bundle providing an RDBMS model
- **WHEN** a consumer looks up `RdbmsModel` OSGi service
- **THEN** the model service is available and contains the expected table definitions

### Requirement: Metamodel package registration

All dependent metamodel packages SHALL be registered in the OSGi container.

#### Scenario: Verify metamodel availability
- **GIVEN** a Karaf container with an active RDBMS bundle
- **WHEN** the EMF package registry is queried
- **THEN** packages for RdbmsPackage, RdbmsNameMappingPackage, RdbmsDataTypesPackage, and RdbmsTableMappingRulesPackage are registered
