# `model/src/main/epsilon/transformations/rdbms/utils` — EOL operation libraries imported by the incremental transformation

| File | Purpose |
|---|---|
| `field.eol` | Per-attribute diff predicates on `RDBMS!RdbmsField` (`isAnyChanged`, `isSameFieldType`) plus the narrowing-only manual-review policy (`isReviewRequired`, gated by the global `ignoreReview`). → see `field.eol.AGENTS.md` |
| `id.eol` | Redefines `setId`/`getId` on `Any`. `setId` delegates to `eResource.setId(self, id)`. `getId` falls back to `self.uuid` when the element has no resource or the resource has no id — so an element outside a resource still yields a stable key instead of failing. |
| `model.eol` | Table lookup on `RDBMS!RdbmsModel`: `tableOf(table)` selects the first `rdbmsTables` entry whose `uuid` equals the argument's, `tableExists(table)` is the defined-ness test over it. Matching is by `uuid` only — `name`/`sqlName` are ignored, so a renamed table is still found. |
| `table.eol` | Field lookup on `RDBMS!RdbmsTable`: `fieldOf(field)` selects the `fields` entry with the matching `uuid`, `fieldExists(field)` its defined-ness test. Also declares `isSqlNameChanged(RdbmsTable)`, comparing `sqlName` between two tables. |
