# `rdbms.evl`

EVL rule set over `RdbmsModel`. Its header states the binding contract: these rules must produce
results identical to the Java rules in `hu.blackbelt.judo.meta.rdbms.validation.rules`. Changing one
side without the other breaks the dual-engine equivalence tests.

Contexts and rules:

- `RDBMS!RdbmsElement`
  - `RdbmsElementNameNotEmpty` — `name` defined and non-blank after `trim()`.
  - `RdbmsElementUuidNotEmpty` — `uuid` defined and non-blank after `trim()`.
  - `RdbmsElementNameIsUnique` — guarded on `satisfies("RdbmsElementNameNotEmpty")`, so a blank name
    is reported once, not twice. Returns true when `eResource()` is undefined; otherwise scans
    `resource.getAllContents()` for every `RdbmsElement` and fails when any other element shares the
    name. Uniqueness is resource-wide, not per-table, and is O(n) per element.
- `RDBMS!RdbmsTable`
  - `RdbmsTableHasPrimaryKey` and `RdbmsTablePrimaryKeyNotNull` — both check `primaryKey.isDefined()`;
    a table without a primary key therefore raises two diagnostics, not one.
  - critique `RdbmsTableNameConvention` — matches `^[A-Z][A-Z0-9_]*$` against `sqlName`, falling back
    to `name` when `sqlName` is blank, and passes when both are blank. Critique, not constraint: it
    does not fail validation.
- `RDBMS!RdbmsField`
  - `RdbmsFieldHasValidType` — `rdbmsTypeName` defined and non-blank.
  - critique `RdbmsFieldNameConvention` — same `sqlName`→`name` fallback, but requires lowercase
    `^[a-z][a-z0-9_]*$`. Table and field conventions are deliberately opposite cases.
- `RDBMS!RdbmsForeignKey.RdbmsForeignKeyHasReference` — `referenceKey` must be defined.
- `RDBMS!RdbmsIndex.RdbmsIndexHasFields` and
  `RDBMS!RdbmsUniqueConstraint.RdbmsUniqueConstraintHasFields` — `fields` defined and `size() > 0`.
- `RDBMS!RdbmsJunctionTable.RdbmsJunctionTableHasBothFields` — both `field1` and `field2` required;
  the `message` block names which one (or `"field1 and field2"`) is missing.
- `RDBMS!RdbmsConfiguration.RdbmsConfigurationHasDialect` — `dialect` defined and non-blank.

Messages are part of the contract: the equivalence tests compare rendered message text, so message
strings cannot be reworded independently of the Java rules.
