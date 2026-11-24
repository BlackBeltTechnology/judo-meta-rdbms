# osgi-itest Specification Delta

## ADDED Requirements

### Requirement: Compatibility check in Karaf

The Java incremental engine SHALL run in the Karaf container through `CheckRdbmsModelCompatibility`. The container of
this module also installs Epsilon, so this proves only that the Java engine works in OSGi; the no-Epsilon proof is the
class loader isolation test in `model-test`.

#### Scenario: Compatibility check
- **GIVEN** a Karaf container with the RDBMS OSGi bundle
- **WHEN** `isRdbmsModelIdentical(m, m)` and `isRdbmsModelIdentical(m, m + column)` are called
- **THEN** the first returns `true`, the second returns `false` and its report lists the created column
