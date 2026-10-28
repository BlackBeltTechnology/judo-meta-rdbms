# `field.eol`

Per-attribute diff predicates on `RDBMS!RdbmsField`, plus the manual-review policy used by the
incremental transformation.

- Change predicates: `isSqlNameChanged`, `isMandatoryChanged`, `isSqlTypeChanged`, `isSizeChanged`,
  `isPrecisionChanged`, `isScaleChanged`, `isStorageByteChanged`. Each is a plain `<>` comparison of
  one attribute against the argument field.
- `isAnyChanged(field)` ORs all seven — it is the single "field differs" entry point.
- `isSameFieldType(field)` accepts only exact `isTypeOf` matches of `RdbmsIdentifierField` or
  `RdbmsValueField`. `RdbmsForeignKey` never matches, and a subtype pair is NOT the same type.
- Review policy — a change needs manual review only when it NARROWS the column:
  - `isMandatoryReviewRequired` — true only for optional→mandatory, never mandatory→optional.
  - `isSqlTypeReviewRequired` — true for any `rdbmsTypeName` change.
  - `isSizeReviewRequired`, `isPrecisionReviewRequired`, `isScaleReviewRequired`,
    `isStorageByteReviewRequired` — true only when the previous value is strictly greater than the
    new one; widening passes silently.
- `isReviewRequired(previousField, newField)` ORs the six above and is short-circuited by the global
  `ignoreReview` variable. Callers must bind `ignoreReview` before invoking; an unbound variable
  aborts the script.
- Argument order matters: every `*ReviewRequired` operation takes `(previousField, newField)`.
  Swapping them inverts every narrowing test.
