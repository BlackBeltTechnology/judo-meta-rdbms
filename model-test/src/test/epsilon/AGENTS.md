# `model-test/src/test/epsilon` — Epsilon transformation driving the incremental-model test fixtures

| File | Purpose |
|---|---|
| `createExcelModel.etl` | Builds two `RdbmsModel` roots from an `XLS` workbook: `ORIGINAL` version `1.0`, `NEW` version `2.0`, both `hsqldb`. Rules split `CasesOriginal`/`CasesNew` by the `type` cell — `value`→`RdbmsValueField`, `id`→`RdbmsIdentifierField` (also assigned to `table.primaryKey`), anything else→`RdbmsForeignKey` with `referenceKey` resolved by matching `type` against a case `uuid`. Local `setId` writes the `uuid` cell into the EMF resource id; null-`uuid` table rows are guarded out. `foreignKeySqlName` is always `"FK_" + sqlName`. |
