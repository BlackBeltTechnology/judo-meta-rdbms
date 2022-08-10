package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
 * %%
 * Copyright (C) 2018 - 2022 BlackBelt Technology
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

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsForeignKeyBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class RdbmsUtilsTest {

    private static final String TARGET_FOLDER = "target/test-classes";

    private static void saveModel(RdbmsModel rdbmsModel) {
        try {
            rdbmsModel.saveRdbmsModel(RdbmsModel.SaveArguments.rdbmsSaveArgumentsBuilder()
                    .file(new File(TARGET_FOLDER, rdbmsModel.getName() + "-rdbms.model"))
                    .build());
        } catch (RdbmsModel.RdbmsValidationException e) {
            fail(e);
        } catch (IOException e) {
            log.warn("Unable to save model", e);
        }
    }

    @Test
    public void testNewRdbmsTable() {
        RdbmsTable rdbmsTable = newRdbmsTableBuilderInit("Tables.TestTable").build();

        assertEquals("Tables.TestTable", rdbmsTable.getUuid());
        assertEquals("Tables.TestTable", rdbmsTable.getName());
        assertTrue(rdbmsTable.getFields().stream().allMatch(e -> "_id".equals(e.getName())));
        assertEquals(
                rdbmsTable.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsTable.getPrimaryKey()
        );

    }

    @Test
    public void testNewRdbmsJunctionTable() {
        RdbmsTable rdbmsTable = newRdbmsTableBuilderInit("Tables.TestTable1").build();
        RdbmsTable rdbmsTable1 = newRdbmsTableBuilderInit("Tables.TestTable2").build();
        RdbmsJunctionTable rdbmsJunctionTable = RdbmsUtils.newRdbmsJunctionTableBuilderInit("Tables.TestJunctTable", rdbmsTable, rdbmsTable1).build();
        RdbmsJunctionTable rdbmsJunctionTable2 = newRdbmsJunctionTableBuilderInit("Tables.TestJunctTable2").build();

        assertEquals("Tables.TestJunctTable", rdbmsJunctionTable.getUuid());
        assertEquals("Tables.TestJunctTable", rdbmsJunctionTable.getName());
        assertEquals("Tables.TestJunctTable2", rdbmsJunctionTable2.getUuid());
        assertEquals("Tables.TestJunctTable2", rdbmsJunctionTable2.getName());
        assertEquals(
                rdbmsJunctionTable.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsJunctionTable.getPrimaryKey()
        );
        assertEquals(
                rdbmsJunctionTable2.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsJunctionTable2.getPrimaryKey()
        );

        assertEquals(
                rdbmsTable.getPrimaryKey(),
                rdbmsJunctionTable.getField1().getReferenceKey()
        );
        assertEquals(
                rdbmsTable1.getPrimaryKey(),
                rdbmsJunctionTable.getField2().getReferenceKey()
        );

    }

    @Test
    public void testGetRdbmsTables() {
        final String RDBMS_TABLE_NAME = "Tables.TestTable";
        final String RDBMS_MODEL_NAME = "TestGetTableModel";
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsTables().isPresent());
        assertFalse(rdbmsUtils.getRdbmsTable(RDBMS_TABLE_NAME).isPresent());

        rdbmsModel.addContent(newRdbmsTableBuilderInit(RDBMS_TABLE_NAME).build());

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS
        Assertions.assertTrue(rdbmsUtils.getRdbmsTables()
                .orElseThrow(() -> new RuntimeException("No tables were found"))
                .stream().allMatch(e -> RDBMS_TABLE_NAME.equals(e.getName())));
        assertTrue(rdbmsUtils.getRdbmsTable(RDBMS_TABLE_NAME).isPresent());
    }

    @Test
    public void testGetRdbmsFields() {
        final String RDBMS_TABLE_NAME = "Tables.TestTable";
        final String RDBMS_MODEL_NAME = "TestGetFieldModel";
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getAllRdbmsField().isPresent());
        assertFalse(rdbmsUtils.getRdbmsFields(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsField(RDBMS_TABLE_NAME, "_id").isPresent());

        rdbmsModel.addContent(newRdbmsTableBuilderInit(RDBMS_TABLE_NAME).build());

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS
        assertTrue(rdbmsUtils.getAllRdbmsField().isPresent());
        assertTrue(rdbmsUtils.getRdbmsFields(RDBMS_TABLE_NAME).isPresent());
        assertTrue(rdbmsUtils.getRdbmsField(RDBMS_TABLE_NAME, "_id").isPresent());
    }

    @Test
    public void testGetForeignKey() {
        final String RDBMS_TABLE_NAME = "Tables.TestTable";
        final String RDBMS_MODEL_NAME = "TestGetForeignKeyModel";
        final String RDBMS_FOREIGN_KEY = "TestForeignKey";
        final String RDBMS_TABLE_NAME1 = RDBMS_TABLE_NAME + "1";

        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsTable rdbmsTable = newRdbmsTableBuilderInit(RDBMS_TABLE_NAME).build();
        rdbmsModel.addContent(rdbmsTable);

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsForeignKeys(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsForeignKey(RDBMS_TABLE_NAME, RDBMS_FOREIGN_KEY).isPresent());

        RdbmsTable rdbmsTable1 = newRdbmsTableBuilderInit(RDBMS_TABLE_NAME1).build();

        RdbmsForeignKey rdbmsForeignKey = RdbmsForeignKeyBuilder.create()
                .withName(RDBMS_FOREIGN_KEY)
                .withUuid(rdbmsTable1.getUuid() + "#" + RDBMS_FOREIGN_KEY)
                .withReferenceKey(rdbmsTable.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable.getName())
                .build();

        rdbmsTable1.getFields().add(rdbmsForeignKey);

        rdbmsModel.addContent(rdbmsTable1);

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS
        assertEquals(
                rdbmsForeignKey,
                rdbmsUtils.getRdbmsForeignKeys(RDBMS_TABLE_NAME1)
                        .orElseThrow(() -> new RuntimeException(RDBMS_TABLE_NAME1 + " not found"))
                        .get(0)
        );

        assertEquals(
                rdbmsForeignKey,
                rdbmsUtils.getRdbmsForeignKey(RDBMS_TABLE_NAME1, RDBMS_FOREIGN_KEY)
                        .orElseThrow(() -> new RuntimeException(RDBMS_FOREIGN_KEY + " not found"))
        );
    }

    @Test
    public void testGetJunctionTable() {
        final String RDBMS_TABLE_NAME = "Tables.TestTable";
        final String RDBMS_TABLE_NAME1 = RDBMS_TABLE_NAME + "1";
        final String RDBMS_JUNCT_TABLE_NAME = RDBMS_TABLE_NAME + "To" + RDBMS_TABLE_NAME1;
        final String RDBMS_MODEL_NAME = "TestGetJunctionTableModel";

        final RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsJunctionTables().isPresent());
        assertFalse(rdbmsUtils.getRdbmsJunctionTable(RDBMS_JUNCT_TABLE_NAME).isPresent());

        final RdbmsTable rdbmsTable = newRdbmsTableBuilderInit(RDBMS_TABLE_NAME).build();
        final RdbmsTable rdbmsTable1 = newRdbmsTableBuilderInit(RDBMS_TABLE_NAME1).build();

        final RdbmsJunctionTable rdbmsJunctionTable =
                RdbmsUtils.newRdbmsJunctionTableBuilderInit(RDBMS_JUNCT_TABLE_NAME, rdbmsTable, rdbmsTable1).build();

        rdbmsModel.addContent(rdbmsTable);
        rdbmsModel.addContent(rdbmsTable1);
        rdbmsModel.addContent(rdbmsJunctionTable);

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS
        assertEquals(
                rdbmsJunctionTable,
                rdbmsUtils.getRdbmsJunctionTables()
                        .orElseThrow(() -> new RuntimeException("No junction table found")).get(0)
        );

        assertEquals(
                rdbmsJunctionTable,
                rdbmsUtils.getRdbmsJunctionTable(RDBMS_JUNCT_TABLE_NAME)
                        .orElseThrow(() -> new RuntimeException(RDBMS_JUNCT_TABLE_NAME + " not found"))
        );

    }

    @Test
    @DisplayName("Test ValidateUniqueXmiids")
    public void testValidateUniqueXmiids() {
        RdbmsTable table1 = newRdbmsTableBuilderInit("T1").build();
        RdbmsTable table2 = newRdbmsTableBuilderInit("T2").build();

        RdbmsModel m = RdbmsModel.buildRdbmsModel().name("M").build();

        m.addContent(table1);
        m.addContent(table2);

        RdbmsUtils rdbmsUtils = new RdbmsUtils();

        // #1 - no resourceSet
        IllegalStateException exception = assertThrows(IllegalStateException.class, rdbmsUtils::validateUniqueXmiids);
        assertEquals(exception.getMessage(), "Model's ResourceSet is unknown (null)");

        // #2 - non-unique
        rdbmsUtils.setResourceSet(m.getResourceSet());
        setId(table1, "ID");
        setId(table2, "ID");

        IllegalStateException exception2 = assertThrows(IllegalStateException.class, rdbmsUtils::validateUniqueXmiids);
        assertEquals("There are non-unique xmiid-s\nXmiid " + getId(table1) + " must be unique\n", exception2.getMessage());

        // #3 - unique
        setId(table2, "ID2");
        assertDoesNotThrow(rdbmsUtils::validateUniqueXmiids);
    }

}
