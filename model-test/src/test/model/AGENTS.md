# `model-test/src/test/model` — checked-in RDBMS model instance used as a load fixture

| File | Purpose |
|---|---|
| `test.rdbms` | XMI instance of namespace `http://blackbelt.hu/judo/meta/rdbms`, `xmi:version="2.0"`. Holds an `RdbmsModel` root with no `rdbmsTables` at all — its only content is a `configuration` element with `dialect="postgresql"`. Empty by design: exercises model load/save round-trips without any table, field or constraint present. |
| `incremental/*.model` | Six checked-in RDBMS models copied unchanged from `judo-rdbms-schema-incremental/src/test/resources`: `initial`, `applyable` and `reviewable` for `hsqldb` and `postgresql` (`<name>-rdbms_<dialect>.model`; XMI with the name-mapping / data-type / rules roots next to the `RdbmsModel`). Inputs of the ETL-vs-Java incremental equivalence tests and the Epsilon-hiding compatibility test, loaded by `RdbmsIncrementalTestSupport.loadFixture`. See change: rdbms-incremental-without-epsilon. |
