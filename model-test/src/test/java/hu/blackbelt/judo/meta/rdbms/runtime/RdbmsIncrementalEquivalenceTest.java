package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model :: Test
 * %%
 * Copyright (C) 2018 - 2024 BlackBelt Technology
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsIndex;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTableOperation;
import hu.blackbelt.judo.meta.rdbms.RdbmsUniqueConstraint;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsIncrementalTestSupport.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ETL ({@link RdbmsIncremental}, the oracle) vs Java ({@link RdbmsIncrementalTransformation}) equivalence of the
 * incremental model: every attribute and reference of every operation, the operation order, the operation meta and the
 * resource contents are compared by {@link RdbmsIncrementalTestSupport}. Where the ETL fails, the Java engine must fail
 * too ("both threw").
 */
@DisplayName("RDBMS incremental model equivalence tests (ETL vs Java)")
public class RdbmsIncrementalEquivalenceTest {

    // ------------------------------------------------------------------------------------------------------------
    // Base model: plain tables A and B (B references A), junction J(A, B), a table with an index and a constraint
    // ------------------------------------------------------------------------------------------------------------

    static RdbmsModel base(String version) {
        RdbmsTable a = tableWithId("A", "T_A",
                value("A#name", "C_NAME", "TEXT", 100, false),
                value("A#count", "C_COUNT", "INT4", 0, false),
                value("A#price", "C_PRICE", "DECIMAL", 0, true));
        RdbmsTable b = tableWithId("B", "T_B",
                value("B#title", "C_TITLE", "TEXT", 50, true));
        b.getFields().add(fk("B#a", "FK_A", a.getPrimaryKey()));
        RdbmsJunctionTable j = junction("J", "T_J", a.getPrimaryKey(), b.getPrimaryKey());
        j.getFields().add(value("J#v", "C_V", "TEXT", 5, false));
        j.getFields().add(fk("J#x", "FK_X", a.getPrimaryKey()));
        j.getFields().add(id("J#id2"));
        RdbmsTable c = tableWithId("C", "T_C",
                id("C#id2"),
                value("C#x", "C_X", "TEXT", 10, false),
                fk("C#a", "FK_A", a.getPrimaryKey()));
        // a table without own identifier: its primary key is the one of A, so it may lose all of its fields
        RdbmsTable d = table("D", "T_D",
                value("D#x", "C_X", "TEXT", 10, false),
                value("D#y", "C_Y", "TEXT", 10, true));
        d.setPrimaryKey(a.getPrimaryKey());
        RdbmsIndex index = hu.blackbelt.judo.meta.rdbms.RdbmsFactory.eINSTANCE.createRdbmsIndex();
        index.setUuid("A#idx");
        index.setName("A#idx");
        index.getFields().add(fieldOf(a, "A#count"));
        a.getIndexes().add(index);
        return model("M", version, a, b, j, c, d);
    }

    private static RdbmsModel mutated(String version, Consumer<RdbmsModel> mutation) {
        RdbmsModel model = base(version);
        mutation.accept(model);
        return model;
    }

    /** Deletes an object and every reference to it (incl. opposites), keeping the model valid for the ETL commit. */
    private static void delete(EObject object) {
        EcoreUtil.delete(object, true);
    }

    private static void removeField(RdbmsModel m, String table, String field) {
        delete(fieldOf(tableOf(m, table), field));
    }

    private static void removeTable(RdbmsModel m, String table) {
        delete(tableOf(m, table));
    }

    /** All fields removed; the table keeps a valid primary key (the one of A). */
    private static void removeAllFields(RdbmsModel m, String table) {
        RdbmsTable t = tableOf(m, table);
        new ArrayList<>(t.getFields()).forEach(RdbmsIncrementalEquivalenceTest::delete);
        t.setPrimaryKey(tableOf(m, "A").getPrimaryKey());
    }

    private static RdbmsValueField valueOf(RdbmsModel m, String table, String field) {
        return (RdbmsValueField) fieldOf(tableOf(m, table), field);
    }

    private static void replaceField(RdbmsModel m, String table, String field, RdbmsField replacement) {
        RdbmsTable t = tableOf(m, table);
        int idx = t.getFields().indexOf(fieldOf(t, field));
        delete(fieldOf(t, field));
        t.getFields().add(idx, replacement);
    }

    private static final class Scenario {
        final String name;
        final boolean failClosed;
        final Consumer<RdbmsModel> previousMutation;
        final Consumer<RdbmsModel> mutation;
        final boolean ignoreReview;

        Scenario(String name, Consumer<RdbmsModel> mutation, boolean ignoreReview) {
            this(name, m -> { }, mutation, ignoreReview);
        }

        Scenario(String name, Consumer<RdbmsModel> previousMutation, Consumer<RdbmsModel> mutation, boolean ignoreReview) {
            this.failClosed = name.contains("[fail-closed]");
            this.name = name;
            this.previousMutation = previousMutation;
            this.mutation = mutation;
            this.ignoreReview = ignoreReview;
        }
    }

    private static final List<Scenario> SCENARIOS = new ArrayList<>();

    private static void scenario(String name, Consumer<RdbmsModel> mutation) {
        SCENARIOS.add(new Scenario(name, mutation, false));
    }

    private static void scenario(String name, Consumer<RdbmsModel> previousMutation, Consumer<RdbmsModel> mutation) {
        SCENARIOS.add(new Scenario(name, previousMutation, mutation, false));
    }

    private static void reviewScenario(String name, Consumer<RdbmsModel> mutation) {
        SCENARIOS.add(new Scenario(name + " [review]", mutation, false));
        SCENARIOS.add(new Scenario(name + " [ignoreReview]", mutation, true));
    }

    private static Stream<Arguments> scenarios(String prefix) {
        return SCENARIOS.stream().filter(s -> s.name.startsWith(prefix)).map(s -> Arguments.of(s.name, s));
    }

    private static void assertEquivalent(Scenario scenario) {
        Outcome etl = run(IncrementalEngine.ETL, () -> mutated("1", scenario.previousMutation),
                () -> mutated("2", scenario.mutation), scenario.ignoreReview);
        Outcome java = run(IncrementalEngine.JAVA, () -> mutated("1", scenario.previousMutation),
                () -> mutated("2", scenario.mutation), scenario.ignoreReview);
        List<String> diffs = compare(etl, java);
        assertTrue(diffs.isEmpty(), scenario.name + ": ETL != Java:\n" + String.join("\n", diffs));
        if (scenario.failClosed) {
            // the ETL fails on this partition and Java must fail closed (it never reports "compatible")
            assertTrue(etl.threw() && java.threw(), scenario.name + ": both engines must fail");
            assertTrue(java.failure instanceof IllegalStateException, scenario.name + ": " + java.failure);
        } else {
            assertFalse(etl.threw(), scenario.name + ": the ETL must not fail: " + etl.failure);
            assertFalse(java.threw(), scenario.name + ": Java must not fail: " + java.failure);
        }
    }

    // ------------------------------------------------------------------------------------------------------------
    // Scenarios
    // ------------------------------------------------------------------------------------------------------------

    static {
        // TP-4 plain/junction tables
        scenario("table: created", m -> root(m).getRdbmsTables().add(tableWithId("N", "T_N", value("N#v", "C_V", "TEXT", 5, false))));
        scenario("table: created, 3 tables", m -> {
            root(m).getRdbmsTables().add(tableWithId("N1", "T_N1", value("N1#v", "C_V", "TEXT", 5, false)));
            root(m).getRdbmsTables().add(tableWithId("N2", "T_N2"));
            root(m).getRdbmsTables().add(tableWithId("N3", "T_N3", value("N3#v", "C_V", "TEXT", 5, true)));
        });
        scenario("table: junction created", m -> root(m).getRdbmsTables().add(
                junction("J2", "T_J2", tableOf(m, "A").getPrimaryKey(), tableOf(m, "C").getPrimaryKey())));
        scenario("table: deleted", m -> removeTable(m, "D"));
        scenario("table: with FK deleted", m -> removeTable(m, "C"));
        scenario("table: junction deleted", m -> removeTable(m, "J"));
        scenario("table: junction and referenced tables deleted", m -> {
            removeTable(m, "J");
            removeTable(m, "B");
        });
        scenario("table: all deleted", m -> {
            removeTable(m, "J");
            removeTable(m, "D");
            removeTable(m, "C");
            removeTable(m, "B");
            removeTable(m, "A");
        });
        // TP-5 boundaries
        scenario("boundary: new table with 0 fields", m -> {
            RdbmsTable z = table("Z", "T_Z");
            z.setPrimaryKey(tableOf(m, "A").getPrimaryKey());
            root(m).getRdbmsTables().add(z);
        });
        scenario("boundary: existing table drops to 0 fields", m -> removeAllFields(m, "D"));
        scenario("boundary: existing table with identifier and FK drops to 0 fields [fail-closed]", m -> removeAllFields(m, "C"));
        scenario("boundary: table gains first field", m -> removeAllFields(m, "D"), m -> {
            removeAllFields(m, "D");
            tableOf(m, "D").getFields().add(value("D#first", "C_FIRST", "TEXT", 5, false));
        });
        scenario("boundary: table loses its last field", m -> {
            removeAllFields(m, "D");
            tableOf(m, "D").getFields().add(value("D#first", "C_FIRST", "TEXT", 5, false));
        }, m -> removeAllFields(m, "D"));
        scenario("boundary: both tables empty", m -> removeAllFields(m, "D"), m -> removeAllFields(m, "D"));
        // fields on plain table
        scenario("field: value created", m -> tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, false)));
        scenario("field: value created mandatory", m -> tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, true)));
        scenario("field: value deleted", m -> removeField(m, "A", "A#name"));
        scenario("field: value deleted and created", m -> {
            removeField(m, "A", "A#name");
            tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, true));
            tableOf(m, "B").getFields().add(value("B#new", "C_NEW", "TEXT", 5, false));
            removeField(m, "C", "C#x");
            tableOf(m, "C").getFields().add(value("C#y", "C_Y", "TEXT", 5, false));
        });
        scenario("field: FK created", m -> tableOf(m, "A").getFields().add(fk("A#b", "FK_B", tableOf(m, "B").getPrimaryKey())));
        scenario("field: FK created mandatory", m -> {
            RdbmsForeignKey f = fk("A#b", "FK_B", tableOf(m, "B").getPrimaryKey());
            f.setMandatory(true);
            tableOf(m, "A").getFields().add(f);
        });
        scenario("field: FK deleted", m -> removeField(m, "B", "B#a"));
        scenario("field: identifier created [fail-closed]", m -> tableOf(m, "A").getFields().add(id("A#id2")));
        scenario("field: identifier deleted", m -> removeField(m, "C", "C#id2"));
        scenario("field: identifier modified sqlName", m -> fieldOf(tableOf(m, "C"), "C#id2").setSqlName("PK"));
        scenario("field: identifier modified type", m -> fieldOf(tableOf(m, "C"), "C#id2").setRdbmsTypeName("INT8"));
        scenario("field: identifier modified size", m -> fieldOf(tableOf(m, "C"), "C#id2").setSize(10));
        scenario("field: identifier modified mandatory", m -> fieldOf(tableOf(m, "C"), "C#id2").setMandatory(false));
        scenario("field: primary key modified sqlName", m -> fieldOf(tableOf(m, "A"), "A#_id").setSqlName("PK"));
        scenario("field: identifier changed to value", m -> replaceField(m, "C", "C#id2", value("C#id2", "ID", "UUID", 0, true)));
        scenario("field: value modified sqlName", m -> valueOf(m, "A", "A#name").setSqlName("C_NAME2"));
        scenario("field: FK modified sqlName", m -> fieldOf(tableOf(m, "B"), "B#a").setSqlName("FK_A2"));
        scenario("field: FK modified type", m -> fieldOf(tableOf(m, "B"), "B#a").setRdbmsTypeName("INT8"));
        scenario("field: FK changed to value", m -> replaceField(m, "B", "B#a", value("B#a", "FK_A", "UUID", 0, false)));
        scenario("field: value changed to FK", m -> replaceField(m, "A", "A#name",
                fk("A#name", "C_NAME", tableOf(m, "B").getPrimaryKey())));
        scenario("field: value changed to identifier", m -> replaceField(m, "A", "A#name", id("A#name")));
        scenario("field: FK changed to identifier", m -> replaceField(m, "B", "B#a", id("B#a")));
        scenario("field: identifier changed to FK", m -> replaceField(m, "C", "C#id2", fk("C#id2", "ID", tableOf(m, "A").getPrimaryKey())));
        // review policy (TP-6)
        reviewScenario("review: mandatory false to true", m -> valueOf(m, "A", "A#name").setMandatory(true));
        reviewScenario("review: mandatory true to false", m -> valueOf(m, "A", "A#price").setMandatory(false));
        reviewScenario("review: sqlType changed", m -> valueOf(m, "A", "A#name").setRdbmsTypeName("VARCHAR"));
        reviewScenario("review: sqlType and size changed", m -> {
            valueOf(m, "A", "A#name").setRdbmsTypeName("VARCHAR");
            valueOf(m, "A", "A#name").setSize(10);
        });
        reviewScenario("review: size decreased", m -> valueOf(m, "A", "A#name").setSize(10));
        reviewScenario("review: size increased", m -> valueOf(m, "A", "A#name").setSize(1000));
        reviewScenario("review: precision decreased", m -> valueOf(m, "A", "A#price").setPrecision(-5));
        reviewScenario("review: precision increased", m -> valueOf(m, "A", "A#price").setPrecision(10));
        reviewScenario("review: scale decreased", m -> valueOf(m, "A", "A#price").setScale(-5));
        reviewScenario("review: scale increased", m -> valueOf(m, "A", "A#price").setScale(3));
        reviewScenario("review: storageByte decreased", m -> valueOf(m, "A", "A#price").setStorageByte(-1));
        reviewScenario("review: storageByte increased", m -> valueOf(m, "A", "A#price").setStorageByte(8));
        reviewScenario("review: equal (sqlName only)", m -> valueOf(m, "A", "A#name").setSqlName("C_X"));
        reviewScenario("review: mandatory and size increased", m -> {
            valueOf(m, "A", "A#name").setMandatory(true);
            valueOf(m, "A", "A#name").setSize(1000);
        });
        reviewScenario("review: FK mandatory", m -> fieldOf(tableOf(m, "B"), "B#a").setMandatory(true));
        reviewScenario("review: FK size decreased", m -> fieldOf(tableOf(m, "B"), "B#a").setSize(-3));
        reviewScenario("review: identifier size decreased", m -> fieldOf(tableOf(m, "C"), "C#id2").setSize(-3));
        reviewScenario("review: created mandatory field", m -> tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, true)));
        reviewScenario("review: value to FK", m -> replaceField(m, "A", "A#name",
                fk("A#name", "C_NAME", tableOf(m, "B").getPrimaryKey())));
        // TP-7 rename
        scenario("rename: plain table without other change [fail-closed]", m -> tableOf(m, "C").setSqlName("T_C2"));
        scenario("rename: plain table with field change", m -> {
            tableOf(m, "A").setSqlName("T_A2");
            valueOf(m, "A", "A#name").setSize(10);
        });
        scenario("rename: plain table with field added", m -> {
            tableOf(m, "A").setSqlName("T_A2");
            tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, false));
        });
        scenario("rename: two plain tables, both with field changes", m -> {
            tableOf(m, "A").setSqlName("T_A2");
            valueOf(m, "A", "A#name").setSize(10);
            tableOf(m, "C").setSqlName("T_C2");
            tableOf(m, "C").getFields().add(value("C#new", "C_NEW", "TEXT", 5, false));
        });
        scenario("rename: two plain tables, one rename-only [fail-closed]", m -> {
            tableOf(m, "A").setSqlName("T_A2");
            valueOf(m, "A", "A#name").setSize(10);
            tableOf(m, "C").setSqlName("T_C2");
        });
        scenario("rename: junction table", m -> tableOf(m, "J").setSqlName("T_J2"));
        scenario("rename: junction table with FK modified", m -> {
            tableOf(m, "J").setSqlName("T_J2");
            fieldOf(tableOf(m, "J"), "J#x").setSqlName("FK_Y");
        });
        scenario("rename: plain table dropping to 0 fields", m -> {
            tableOf(m, "D").setSqlName("T_D2");
            removeAllFields(m, "D");
        });
        scenario("rename: plain table and deleted fields only", m -> {
            tableOf(m, "D").setSqlName("T_D2");
            removeField(m, "D", "D#y");
        });
        // junction table fields
        scenario("junction: FK modified", m -> fieldOf(tableOf(m, "J"), "J#x").setSqlName("FK_Y"));
        scenario("junction: field1 modified", m -> fieldOf(tableOf(m, "J"), "J#field1").setSqlName("FK_X1"));
        scenario("junction: both FK modified", m -> {
            fieldOf(tableOf(m, "J"), "J#field1").setSqlName("FK_X1");
            fieldOf(tableOf(m, "J"), "J#field2").setSqlName("FK_X2");
        });
        scenario("junction: FK modified with plain table change", m -> {
            fieldOf(tableOf(m, "J"), "J#x").setSqlName("FK_Y");
            valueOf(m, "A", "A#name").setSize(10);
        });
        scenario("junction: FK changed to value", m -> replaceField(m, "J", "J#x", value("J#x", "FK_X", "UUID", 0, false)));
        scenario("junction: value changed to FK [fail-closed]", m -> replaceField(m, "J", "J#v", fk("J#v", "C_V", tableOf(m, "A").getPrimaryKey())));
        scenario("junction: FK created [fail-closed]", m -> tableOf(m, "J").getFields().add(fk("J#extra", "FK_E", tableOf(m, "A").getPrimaryKey())));
        scenario("junction: FK deleted [fail-closed]", m -> removeField(m, "J", "J#x"));
        scenario("junction: value created [fail-closed]", m -> tableOf(m, "J").getFields().add(value("J#new", "C_NEW", "TEXT", 5, false)));
        scenario("junction: value deleted [fail-closed]", m -> removeField(m, "J", "J#v"));
        scenario("junction: value modified [fail-closed]", m -> valueOf(m, "J", "J#v").setSize(1));
        scenario("junction: identifier created [fail-closed]", m -> tableOf(m, "J").getFields().add(id("J#id3")));
        scenario("junction: identifier deleted [fail-closed]", m -> removeField(m, "J", "J#id2"));
        scenario("junction: identifier modified [fail-closed]", m -> fieldOf(tableOf(m, "J"), "J#id2").setSqlName("PK"));
        // TP-38 gaps
        scenario("gap: index added", m -> {
            RdbmsIndex index = hu.blackbelt.judo.meta.rdbms.RdbmsFactory.eINSTANCE.createRdbmsIndex();
            index.setUuid("B#idx");
            index.setName("B#idx");
            index.getFields().add(fieldOf(tableOf(m, "B"), "B#title"));
            tableOf(m, "B").getIndexes().add(index);
        });
        scenario("gap: index removed", m -> tableOf(m, "A").getIndexes().clear());
        scenario("gap: unique constraint added", m -> {
            RdbmsUniqueConstraint uc = hu.blackbelt.judo.meta.rdbms.RdbmsFactory.eINSTANCE.createRdbmsUniqueConstraint();
            uc.setUuid("B#uc");
            uc.setName("B#uc");
            uc.getFields().add(fieldOf(tableOf(m, "B"), "B#title"));
            tableOf(m, "B").getUniqueConstraints().add(uc);
        });
        scenario("gap: index added on junction", m -> {
            RdbmsIndex index = hu.blackbelt.judo.meta.rdbms.RdbmsFactory.eINSTANCE.createRdbmsIndex();
            index.setUuid("J#idx");
            index.setName("J#idx");
            index.getFields().add(fieldOf(tableOf(m, "J"), "J#v"));
            tableOf(m, "J").getIndexes().add(index);
        });
        // TP-8 combined
        scenario("order: creates, deletes, modifies, rename", m -> {
            root(m).getRdbmsTables().add(tableWithId("N1", "T_N1", value("N1#v", "C_V", "TEXT", 5, false)));
            root(m).getRdbmsTables().add(tableWithId("N2", "T_N2", value("N2#v", "C_V", "TEXT", 5, false)));
            root(m).getRdbmsTables().add(tableWithId("N3", "T_N3", value("N3#v", "C_V", "TEXT", 5, false)));
            root(m).getRdbmsTables().add(junction("J2", "T_J2", tableOf(m, "A").getPrimaryKey(), tableOf(m, "B").getPrimaryKey()));
            removeTable(m, "D");
            tableOf(m, "B").setSqlName("T_B2");
            tableOf(m, "B").getFields().add(value("B#new", "C_NEW", "TEXT", 5, false));
            valueOf(m, "A", "A#name").setSize(10);
            valueOf(m, "A", "A#count").setMandatory(true);
            removeField(m, "A", "A#price");
            tableOf(m, "A").getFields().add(value("A#new", "C_NEW", "TEXT", 5, true));
            tableOf(m, "A").getFields().add(fk("A#b", "FK_B", tableOf(m, "B").getPrimaryKey()));
            fieldOf(tableOf(m, "J"), "J#x").setSqlName("FK_Y");
            replaceField(m, "C", "C#a", value("C#a", "FK_A", "UUID", 0, false));
        });
        scenario("order: rename before and after modified tables", m -> {
            tableOf(m, "A").setSqlName("T_A2");
            valueOf(m, "A", "A#name").setSize(10);
            valueOf(m, "B", "B#title").setSize(5);
            tableOf(m, "C").setSqlName("T_C2");
            tableOf(m, "C").getFields().add(value("C#new", "C_NEW", "TEXT", 5, false));
        });
        scenario("order: modified table order differs from rule order", m -> {
            // the delete rules run before the modify rules and ask for the lazy operations first
            tableOf(m, "C").getFields().add(value("C#new", "C_NEW", "TEXT", 5, false));
            valueOf(m, "A", "A#name").setSize(10);
            removeField(m, "B", "B#title");
        });
    }

    static Stream<Arguments> tableScenarios() {
        return scenarios("table:");
    }

    static Stream<Arguments> boundaryScenarios() {
        return scenarios("boundary:");
    }

    static Stream<Arguments> fieldScenarios() {
        return scenarios("field:");
    }

    static Stream<Arguments> reviewScenarios() {
        return scenarios("review:");
    }

    static Stream<Arguments> renameScenarios() {
        return scenarios("rename:");
    }

    static Stream<Arguments> junctionScenarios() {
        return scenarios("junction:");
    }

    static Stream<Arguments> gapScenarios() {
        return scenarios("gap:");
    }

    static Stream<Arguments> orderScenarios() {
        return scenarios("order:");
    }

    @Test
    @DisplayName("TP-1/TP-5: identical models and empty models give no operation")
    void identicalAndEmptyModels() {
        assertEquivalent(new Scenario("identical", m -> { }, false));
        List<String> diffs = compareEngines(() -> model("E", "1"), () -> model("E", "2"), false);
        assertTrue(diffs.isEmpty(), String.join("\n", diffs));
    }

    @ParameterizedTest(name = "table partition: {0}")
    @MethodSource("tableScenarios")
    void tablePartitions(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "boundary: {0}")
    @MethodSource("boundaryScenarios")
    void boundaries(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "field partition: {0}")
    @MethodSource("fieldScenarios")
    void fieldPartitions(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "review policy: {0}")
    @MethodSource("reviewScenarios")
    void reviewPolicy(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "rename: {0}")
    @MethodSource("renameScenarios")
    void rename(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "junction: {0}")
    @MethodSource("junctionScenarios")
    void junctionPartitions(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "gap parity: {0}")
    @MethodSource("gapScenarios")
    void gaps(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @ParameterizedTest(name = "order: {0}")
    @MethodSource("orderScenarios")
    void order(String name, Scenario scenario) {
        assertEquivalent(scenario);
    }

    @Test
    @DisplayName("TP-4: Java fails closed naming the junction table and the field")
    void junctionFieldFailureNamesTableAndField() {
        Outcome java = run(IncrementalEngine.JAVA, () -> base("1"),
                () -> mutated("2", m -> tableOf(m, "J").getFields().add(value("J#new", "C_NEW", "TEXT", 5, false))), false);
        assertTrue(java.failure instanceof IllegalStateException, String.valueOf(java.failure));
        assertTrue(java.failure.getMessage().contains("J#new"), java.failure.getMessage());
        assertTrue(java.failure.getMessage().contains("'J'"), java.failure.getMessage());
        // nothing was written to the incremental resource
        assertTrue(java.incremental.getResource().getContents().isEmpty());
    }

    // ------------------------------------------------------------------------------------------------------------
    // TP-2: Excel matrix
    // ------------------------------------------------------------------------------------------------------------

    @Test
    @DisplayName("TP-2: Excel matrix pair gives the same incremental model with both engines")
    void excelMatrix() throws Exception {
        RdbmsModel[] etlModels = RdbmsIncrementalTest.loadExcelModels();
        Outcome etl = run(IncrementalEngine.ETL, () -> etlModels[0], () -> etlModels[1], false);
        RdbmsModel[] javaModels = RdbmsIncrementalTest.loadExcelModels();
        Outcome java = run(IncrementalEngine.JAVA, () -> javaModels[0], () -> javaModels[1], false);
        assertFalse(etl.threw(), String.valueOf(etl.failure));
        assertFalse(java.threw(), String.valueOf(java.failure));
        assertTrue(compare(etl, java).isEmpty(), String.join("\n", compare(etl, java)));
        assertTrue(root(java.incremental) != null);
        assertTrue(operationModel(java.incremental).getTableOperations().size() > 0);
    }

    static hu.blackbelt.judo.meta.rdbms.RdbmsModel operationModel(RdbmsModel incremental) {
        return (hu.blackbelt.judo.meta.rdbms.RdbmsModel) incremental.getResource().getContents().get(0);
    }

    // ------------------------------------------------------------------------------------------------------------
    // TP-8: determinism and operation order
    // ------------------------------------------------------------------------------------------------------------

    @Test
    @DisplayName("TP-8: Java is deterministic and keeps the ETL operation order")
    void determinismAndOrder() {
        Scenario scenario = SCENARIOS.stream().filter(s -> s.name.equals("order: creates, deletes, modifies, rename"))
                .findFirst().orElseThrow(IllegalStateException::new);
        Outcome java1 = run(IncrementalEngine.JAVA, () -> base("1"), () -> mutated("2", scenario.mutation), false);
        Outcome java2 = run(IncrementalEngine.JAVA, () -> base("1"), () -> mutated("2", scenario.mutation), false);
        Outcome etl = run(IncrementalEngine.ETL, () -> base("1"), () -> mutated("2", scenario.mutation), false);
        assertFalse(java1.threw(), String.valueOf(java1.failure));
        assertEquals(dump(java1.incremental), dump(java2.incremental));
        assertTrue(diff(java1.incremental, java2.incremental).isEmpty());

        List<String> javaOrder = operationModel(java1.incremental).getTableOperations().stream()
                .map(op -> op.getClass().getSimpleName().replace("Impl", "") + ":" + op.getUuid()).collect(Collectors.toList());
        List<String> etlOrder = operationModel(etl.incremental).getTableOperations().stream()
                .map(op -> op.getClass().getSimpleName().replace("Impl", "") + ":" + op.getUuid()).collect(Collectors.toList());
        assertEquals(etlOrder, javaOrder);
        // creates (tables, then junction tables), deletes, then the modify operations in lazy request order
        assertEquals(Arrays.asList(
                "RdbmsCreateTableOperation:N1-CreateTable",
                "RdbmsCreateTableOperation:N2-CreateTable",
                "RdbmsCreateTableOperation:N3-CreateTable",
                "RdbmsCreateTableOperation:J2-CreateTable",
                "RdbmsDeleteTableOperation:D-DeleteTable"), javaOrder.subList(0, 5));
        assertTrue(javaOrder.size() >= 9, javaOrder.toString());
    }

    // ------------------------------------------------------------------------------------------------------------
    // TP-9: judo-rdbms-schema fixtures
    // ------------------------------------------------------------------------------------------------------------

    static Stream<Arguments> fixturePairs() {
        List<Arguments> args = new ArrayList<>();
        for (String dialect : new String[]{"hsqldb", "postgresql"}) {
            for (String target : new String[]{"applyable", "reviewable"}) {
                for (boolean ignoreReview : new boolean[]{false, true}) {
                    args.add(Arguments.of(dialect, target, ignoreReview));
                }
            }
        }
        return args.stream();
    }

    @ParameterizedTest(name = "rdbms-schema fixtures initial -> {1} ({0}, ignoreReview={2})")
    @MethodSource("fixturePairs")
    void rdbmsSchemaFixtures(String dialect, String target, boolean ignoreReview) {
        Outcome etl = run(IncrementalEngine.ETL, () -> loadFixture("initial-rdbms_" + dialect),
                () -> loadFixture(target + "-rdbms_" + dialect), ignoreReview);
        Outcome java = run(IncrementalEngine.JAVA, () -> loadFixture("initial-rdbms_" + dialect),
                () -> loadFixture(target + "-rdbms_" + dialect), ignoreReview);
        assertFalse(etl.threw(), String.valueOf(etl.failure));
        assertFalse(java.threw(), String.valueOf(java.failure));
        List<String> diffs = compare(etl, java);
        assertTrue(diffs.isEmpty(), String.join("\n", diffs));
        assertTrue(operationModel(java.incremental).getTableOperations().size() > 0, "the fixture pair has changes");
    }

    @ParameterizedTest(name = "rdbms-schema fixture initial -> initial ({0})")
    @org.junit.jupiter.params.provider.ValueSource(strings = {"hsqldb", "postgresql"})
    void rdbmsSchemaIdenticalFixtures(String dialect) {
        Outcome java = run(IncrementalEngine.JAVA, () -> loadFixture("initial-rdbms_" + dialect),
                () -> loadFixture("initial-rdbms_" + dialect), false);
        assertFalse(java.threw(), String.valueOf(java.failure));
        assertEquals(0, operationModel(java.incremental).getTableOperations().size());
        assertTrue(compare(run(IncrementalEngine.ETL, () -> loadFixture("initial-rdbms_" + dialect),
                () -> loadFixture("initial-rdbms_" + dialect), false), java).isEmpty());
    }

    // ------------------------------------------------------------------------------------------------------------
    // TP-10: rackinspect shaped model with scripted mutations
    // ------------------------------------------------------------------------------------------------------------

    /** The rackinspect production shape. */
    private static final int RACKINSPECT_TABLES = 83;
    private static final int RACKINSPECT_CORE_TABLES = 40;
    private static final int RACKINSPECT_FOREIGN_KEYS = 137;
    private static final int RACKINSPECT_JUNCTION_TABLES = 12;
    private static final int RACKINSPECT_INDEXES = 11;
    private static final String[] FIELD_TYPES_WEIGHTED = {
            "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT",
            "UUID", "UUID", "UUID", "UUID", "UUID", "UUID", "UUID",
            "TIMESTAMP", "TIMESTAMP", "TIMESTAMP", "INT4", "INT4", "BOOLEAN", "DECIMAL", "FLOAT8", "DATE", "TIME"
    };

    /** Core (referenced) tables of a rackinspect shaped model with {@code tableCount} tables. */
    private static int coreTables(int tableCount) {
        return tableCount * RACKINSPECT_CORE_TABLES / RACKINSPECT_TABLES;
    }

    /**
     * Rackinspect shaped model (83 tables, 137 FKs, 12 junction tables, 11 indexes, weighted field types as the
     * generator of RdbmsValidationEquivalenceTest), scaled by {@code tableCount} and generated from a fixed seed. Only
     * the first {@link #coreTables(int)} tables are referenced, so the others can be dropped.
     */
    static RdbmsModel rackinspect(String version, int tableCount) {
        final int TABLE_COUNT = tableCount;
        final int CORE_TABLE_COUNT = coreTables(tableCount);
        final int FOREIGN_KEY_COUNT = tableCount * RACKINSPECT_FOREIGN_KEYS / RACKINSPECT_TABLES;
        final int JUNCTION_TABLE_COUNT = Math.max(3, tableCount * RACKINSPECT_JUNCTION_TABLES / RACKINSPECT_TABLES);
        final int INDEX_COUNT = Math.max(3, tableCount * RACKINSPECT_INDEXES / RACKINSPECT_TABLES);
        java.util.Random random = new java.util.Random(42);
        List<RdbmsTable> tables = new ArrayList<>();
        for (int i = 0; i < TABLE_COUNT; i++) {
            String name = "app.entities.Entity" + i;
            RdbmsTable table = tableWithId(name, "T_ENTITIES_ENTITY" + i);
            String[] audit = {"_type:TEXT:true", "_version:INT4:false", "_create_username:TEXT:false",
                    "_create_user_id:UUID:false", "_create_timestamp:TIMESTAMP:false", "_update_username:TEXT:false",
                    "_update_user_id:UUID:false", "_update_timestamp:TIMESTAMP:false"};
            for (String a : audit) {
                String[] p = a.split(":");
                table.getFields().add(value(name + "#" + p[0], p[0].toUpperCase(), p[1], p[1].equals("TEXT") ? 255 : -1,
                        Boolean.parseBoolean(p[2])));
            }
            int fieldCount = 8 + random.nextInt(5);
            for (int f = 0; f < fieldCount; f++) {
                String type = FIELD_TYPES_WEIGHTED[random.nextInt(FIELD_TYPES_WEIGHTED.length)];
                RdbmsValueField field = value(name + "#field" + f, "C_FIELD" + f, type, type.equals("TEXT") ? 255 : -1, f < 2);
                field.setPrecision(type.equals("DECIMAL") ? 30 : -1);
                field.setScale(type.equals("DECIMAL") ? 4 : -1);
                table.getFields().add(field);
            }
            tables.add(table);
        }
        for (int n = 0; n < FOREIGN_KEY_COUNT; n++) {
            RdbmsTable source = tables.get(random.nextInt(TABLE_COUNT));
            RdbmsTable target = tables.get(random.nextInt(CORE_TABLE_COUNT));
            if (source != target) {
                source.getFields().add(fk(source.getUuid() + "#fk_" + n, "FK_" + n, target.getPrimaryKey()));
            }
        }
        List<RdbmsTable> all = new ArrayList<>(tables);
        for (int n = 0; n < JUNCTION_TABLE_COUNT; n++) {
            RdbmsTable t1 = tables.get(random.nextInt(CORE_TABLE_COUNT));
            RdbmsTable t2 = tables.get(random.nextInt(CORE_TABLE_COUNT));
            all.add(junction("app.junctions.Junction" + n, "T_JUNCTION_" + n, t1.getPrimaryKey(), t2.getPrimaryKey()));
        }
        for (int n = 0; n < INDEX_COUNT; n++) {
            RdbmsTable table = tables.get(random.nextInt(TABLE_COUNT));
            RdbmsIndex index = hu.blackbelt.judo.meta.rdbms.RdbmsFactory.eINSTANCE.createRdbmsIndex();
            index.setUuid(table.getUuid() + "#idx_" + n);
            index.setName(index.getUuid());
            index.setSqlName("IDX_" + n);
            index.getFields().add(fieldOf(table, table.getUuid() + "#field0"));
            table.getIndexes().add(index);
        }
        return model("rackinspect", version, all.toArray(new RdbmsTable[0]));
    }

    private static String entity(int i) {
        return "app.entities.Entity" + i;
    }

    /** The first FK of a table at or after {@code from}, skipping the given tables. */
    private static RdbmsForeignKey firstForeignKey(RdbmsModel m, int from, int to, int... skip) {
        for (int i = from; i < to; i++) {
            final int index = i;
            if (Arrays.stream(skip).anyMatch(x -> x == index)) {
                continue;
            }
            for (RdbmsField f : tableOf(m, entity(i)).getFields()) {
                if (f instanceof RdbmsForeignKey) {
                    return (RdbmsForeignKey) f;
                }
            }
        }
        throw new IllegalStateException("No FK");
    }

    /** Scripted mutations of a rackinspect shaped model with {@code n} tables (all valid for the ETL). */
    private static List<Scenario> rackinspectScenarios(int n) {
        int core = coreTables(n);
        int leaf1 = n - 1;
        int leaf2 = n - 2;
        int dropFieldTable = n - 3;
        int renamed = core + 2;
        List<Scenario> list = new ArrayList<>();
        Map<String, Consumer<RdbmsModel>> mutations = new java.util.LinkedHashMap<>();
        mutations.put("tables added", m -> {
            RdbmsTable t = tableWithId("app.entities.New1", "T_NEW1", value("app.entities.New1#a", "C_A", "TEXT", 10, true));
            t.getFields().add(fk("app.entities.New1#fk", "FK_NEW", tableOf(m, entity(3)).getPrimaryKey()));
            root(m).getRdbmsTables().add(t);
            root(m).getRdbmsTables().add(tableWithId("app.entities.New2", "T_NEW2"));
            root(m).getRdbmsTables().add(junction("app.junctions.New", "T_JUNCTION_NEW",
                    tableOf(m, entity(1)).getPrimaryKey(), tableOf(m, entity(2)).getPrimaryKey()));
        });
        mutations.put("tables dropped", m -> {
            removeTable(m, entity(leaf1));
            removeTable(m, entity(leaf2));
            removeTable(m, "app.junctions.Junction1");
        });
        mutations.put("table renamed with field change", m -> {
            tableOf(m, entity(renamed)).setSqlName("T_RENAMED");
            valueOf(m, entity(renamed), entity(renamed) + "#field1").setSize(10);
        });
        mutations.put("fields added and dropped", m -> {
            tableOf(m, entity(core - 1)).getFields().add(value(entity(core - 1) + "#new", "C_NEW", "TEXT", 20, true));
            tableOf(m, entity(core + 1)).getFields().add(value(entity(core + 1) + "#new", "C_NEW", "INT4", -1, false));
            removeField(m, entity(core - 2), entity(core - 2) + "#field3");
            removeField(m, entity(dropFieldTable), entity(dropFieldTable) + "#_create_username");
        });
        mutations.put("fields modified", m -> {
            valueOf(m, entity(5), entity(5) + "#_type").setRdbmsTypeName("VARCHAR");
            valueOf(m, entity(6), entity(6) + "#_type").setSize(100);
            valueOf(m, entity(7), entity(7) + "#_version").setMandatory(true);
            valueOf(m, entity(8), entity(8) + "#_create_username").setSqlName("CREATOR");
            valueOf(m, entity(9), entity(9) + "#_create_username").setSize(500);
        });
        mutations.put("foreign key changed", m -> {
            RdbmsForeignKey fk = firstForeignKey(m, core, n, leaf1, leaf2, dropFieldTable, renamed);
            fk.setSqlName("FK_RENAMED");
            fk.setMandatory(true);
        });
        mutations.put("foreign key changed to value", m -> {
            RdbmsForeignKey fk = firstForeignKey(m, core + 3, n, leaf1, leaf2, dropFieldTable, renamed);
            replaceField(m, ((RdbmsTable) fk.eContainer()).getUuid(), fk.getUuid(),
                    value(fk.getUuid(), fk.getSqlName(), "UUID", -1, false));
        });
        list.add(new Scenario("rackinspect: no change", m -> { }, false));
        mutations.forEach((name, mutation) -> list.add(new Scenario("rackinspect: " + name, mutation, false)));
        return list;
    }

    private static void assertRackinspectEquivalent(String name, int tableCount, Consumer<RdbmsModel> mutation, boolean ignoreReview) {
        Supplier<RdbmsModel> next = () -> {
            RdbmsModel m = rackinspect("2", tableCount);
            mutation.accept(m);
            return m;
        };
        Outcome etl = run(IncrementalEngine.ETL, () -> rackinspect("1", tableCount), next, ignoreReview);
        Outcome java = run(IncrementalEngine.JAVA, () -> rackinspect("1", tableCount), next, ignoreReview);
        assertFalse(etl.threw(), name + ": " + etl.failure);
        assertFalse(java.threw(), name + ": " + java.failure);
        List<String> diffs = compare(etl, java);
        assertTrue(diffs.isEmpty(), name + " (ignoreReview=" + ignoreReview + "):\n" + String.join("\n", diffs));
        if (!name.endsWith("no change")) {
            assertTrue(operationModel(java.incremental).getTableOperations().size() > 0, name);
        }
    }

    static Stream<Arguments> scaledRackinspectScenarios() {
        return rackinspectScenarios(SCALED_TABLES).stream().map(s -> Arguments.of(s.name, s));
    }

    /** Scaled down for the single mutations: the ETL needs half a minute for the production size model. */
    private static final int SCALED_TABLES = 25;

    @ParameterizedTest(name = "{0}")
    @MethodSource("scaledRackinspectScenarios")
    void rackinspectMutations(String name, Scenario scenario) {
        assertRackinspectEquivalent(name, SCALED_TABLES, scenario.mutation, false);
        if (name.endsWith("fields modified")) {
            // the review policy is the only rule which reads ignoreReview
            assertRackinspectEquivalent(name, SCALED_TABLES, scenario.mutation, true);
        }
    }

    @Test
    @DisplayName("TP-10: production size rackinspect model, all scripted mutations together")
    void rackinspectAllMutations() {
        Consumer<RdbmsModel> all = m -> rackinspectScenarios(RACKINSPECT_TABLES).stream()
                .filter(s -> !s.name.endsWith("no change") && !s.name.endsWith("foreign key changed to value"))
                .forEach(s -> s.mutation.accept(m));
        assertRackinspectEquivalent("rackinspect: all mutations", RACKINSPECT_TABLES, all, false);
    }
}
