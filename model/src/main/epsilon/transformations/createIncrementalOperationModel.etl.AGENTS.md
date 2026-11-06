# `createIncrementalOperationModel.etl`

Diffs a `PREVIOUS` and a `NEW` `RdbmsModel` into an `INCREMENTAL` operation model. Imports
`rdbms/utils/id.eol`, `field.eol`, `model.eol`, `table.eol`.

## Bindings the caller must provide

- Model aliases `PREVIOUS`, `NEW`, `INCREMENTAL`, and `RDBMS` (the lazy modify rules and typed
  locals are declared against `RDBMS!`).
- Global variables `dialect` (copied into the incremental `RdbmsConfiguration`) and `ignoreReview`
  (read by `isReviewRequired` in `field.eol`).

`pre` picks the single first `RdbmsModel` from `PREVIOUS` and `NEW`; a resource holding more than
one model root is silently ignored past the first.

## Rules

- `OperationModel` — the `INCREMENTAL!RdbmsModel` root. `version` is `previous.version + "_" +
  new.version`; `name` is carried from the PREVIOUS model, not the new one.
- `CreateOperationMeta` — `RdbmsOperationMeta` wiring `previousModel`/`currentModel`.
- `CreateNewTable` / `CreateNewJunctionTable` — emit `RdbmsCreateTableOperation` only when the table
  is absent from PREVIOUS **and** has at least one field. A fieldless new table produces nothing.
- `DeletePreviousTable` / `DeletePreviousJunctionTable` — emit `RdbmsDeleteTableOperation` when the
  table is absent from NEW **or** its NEW counterpart has zero fields. Emptying a table is therefore
  modelled as a drop, not a modify.
- `@lazy ModifyTableOperationForExistingTable` / `ModifyJunctionTableOperationForExistingTable` —
  the shared parent operation every field-level rule attaches to via `.equivalent(...)`. Lazy: it
  materialises only when a field rule asks for it.
- Field create/delete rules exist per concrete type — `RdbmsValueField`, `RdbmsForeignKey`,
  `RdbmsIdentifierField` — and are keyed on the containing table existing on the other side. Each
  stamps a distinct uuid suffix (`-CreateValueField`, `-DeleteForeignKey`,
  `-CreateIdentifierField`, …). Creates set `reviewRequired = field.mandatory`; the identifier
  create additionally sets `isIdentifierField = true`.
- `ModifyExistingValueField` / `ModifyExistingIdentifierField` / `ModifyExistingForeignKey` — fire
  when the field exists on both sides and either `isAnyChanged` or the field changed concrete type.
  They set `typeChanged` **or** `sizeChanged` (mutually exclusive `else if`: a sql-type change masks
  a size change), plus `nameChanged` and `mandatoryChanged` independently. A cross-type change sets
  `changedValueFieldToForeignKey` / `changedForeignKeyToValueField` and forces
  `reviewRequired = true`, bypassing the `ignoreReview` gate; otherwise `reviewRequired` comes from
  `isReviewRequired(previous, new)`.
- `ModifyExistingForeignKey` picks its parent operation by runtime type of the container table —
  `ModifyTableOperationForExistingTable` for `RdbmsTable`, else the junction-table variant.
- `RenameExistingTable extends ModifyTableOperationForExistingTable` — sets `nameChanged` on the
  existing modify operation when `sqlName` differs.

## `post` — pruning and packaging

Assigns `operationMeta.incrementalModel`, then removes every `RdbmsModifyTableOperation` that has no
create/delete/modify field operations and no `nameChanged`. Empty modify operations therefore never
reach the output. Finally the PREVIOUS and NEW model roots are **added into the INCREMENTAL
resource** contents — the output resource holds three model roots, and callers reading it must not
assume a single root.
