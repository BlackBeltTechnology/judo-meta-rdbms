# `model-test/src/test/model` — checked-in RDBMS model instance used as a load fixture

| File | Purpose |
|---|---|
| `test.rdbms` | XMI instance of namespace `http://blackbelt.hu/judo/meta/rdbms`, `xmi:version="2.0"`. Holds an `RdbmsModel` root with no `rdbmsTables` at all — its only content is a `configuration` element with `dialect="postgresql"`. Empty by design: exercises model load/save round-trips without any table, field or constraint present. |
