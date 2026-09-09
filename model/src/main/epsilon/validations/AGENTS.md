# `model/src/main/epsilon/validations` — EVL rule set for `RdbmsModel`, mirror of the Java validator

| File | Purpose |
|---|---|
| `rdbms-plugin-validation.evl` | Entry script for the Tycho/plugin validation path. Imports `rdbms.evl` and its `pre` block binds `rdbmsUtils` to a `Native("hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils")` constructed over `RDBMS.resource.resourceSet` with `false`. Callers must register the model under the `RDBMS` alias or the `pre` block fails. |
| `rdbms.evl` | Nine constraints and two critiques over `RdbmsElement`, `RdbmsTable`, `RdbmsField`, `RdbmsForeignKey`, `RdbmsIndex`, `RdbmsUniqueConstraint`, `RdbmsJunctionTable`, `RdbmsConfiguration`; header binds them to stay result-identical with `hu.blackbelt.judo.meta.rdbms.validation.rules`. → see `rdbms.evl.AGENTS.md` |
