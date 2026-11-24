# Change: Incremental RDBMS diff without Epsilon

**Status: IMPLEMENTED (judo-meta-rdbms slice of the superproject change `rdbms-incremental-without-epsilon`, JNG-6446)**

## Why

`CheckRdbmsModelCompatibility` linked the Epsilon ETL (`RdbmsIncremental`), so every Karaf runtime that wanted the
platform compatibility check had to ship Epsilon. The diff is a uuid keyed comparison of two models and needs no
transformation language.

## What Changes

- `model`: new `RdbmsIncrementalTransformation.transform(previous, new, incremental, dialect, ignoreReview)`, plain Java
  and EMF, reproducing `createIncrementalOperationModel.etl` (same operations, attributes, order and resource
  contents, including the ETL failures as `IllegalStateException` and the known false-compatible gaps).
- `model`: `CheckRdbmsModelCompatibility` uses the Java engine only (no Epsilon class is loaded) and its report now lists
  delete-table operations.
- `model`: `RdbmsIncremental` (ETL) is `@Deprecated`, kept as the equivalence oracle; its `Logger` overload passes
  `ignoreReview` through and the execution context is closed in `finally`.
- `model-test`: reflective ETL-vs-Java comparator, `RdbmsIncrementalEquivalenceTest`, engine parameterised
  `RdbmsIncrementalTest`, Epsilon-hiding class loader test.
- `osgi-itest`: compatibility check probe with the Java engine in Karaf.

## Impact

Additive API. No public signature is removed. Rollback: switch the call in `CheckRdbmsModelCompatibility.getIncremental`
back to `RdbmsIncremental`.
