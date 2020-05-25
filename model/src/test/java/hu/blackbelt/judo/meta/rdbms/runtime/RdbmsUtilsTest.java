package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsForeignKeyBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils.newRdbmsJunctionTable;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils.newRdbmsTable;
import static org.junit.jupiter.api.Assertions.*;

public class RdbmsUtilsTest {

    private static final Log log = new Slf4jLog();
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
        RdbmsTable rdbmsTable = newRdbmsTable("TestTable");
        RdbmsTable rdbmsTable1 = newRdbmsTable("TestTable", "Alma.");
        RdbmsTable rdbmsTable2 = newRdbmsTable("TestTable", "Alma");

        assertEquals("Tables.TestTable", rdbmsTable.getUuid());
        assertEquals("Alma.TestTable", rdbmsTable1.getUuid());
        assertEquals("Alma.TestTable", rdbmsTable2.getUuid());
        assertEquals("TestTable", rdbmsTable.getName());
        assertTrue(rdbmsTable.getFields().stream().allMatch(e -> "_id".equals(e.getName())));
        assertEquals(
                rdbmsTable.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsTable.getPrimaryKey()
        );

    }

    @Test
    public void testNewRdbmsJunctionTable() {
        RdbmsTable rdbmsTable = newRdbmsTable("TestTable1");
        RdbmsTable rdbmsTable1 = newRdbmsTable("TestTable2");
        RdbmsJunctionTable rdbmsJunctionTable = newRdbmsJunctionTable("TestJunctTable", rdbmsTable, rdbmsTable1);
        RdbmsJunctionTable rdbmsJunctionTable1 = newRdbmsJunctionTable("TestJunctTable", "Alma.", rdbmsTable, rdbmsTable1);
        RdbmsJunctionTable rdbmsJunctionTable2 = newRdbmsJunctionTable("TestJunctTable", "Alma", rdbmsTable, rdbmsTable1);

        assertEquals("Tables.TestJunctTable", rdbmsJunctionTable.getUuid());
        assertEquals("Alma.TestJunctTable", rdbmsJunctionTable1.getUuid());
        assertEquals("Alma.TestJunctTable", rdbmsJunctionTable2.getUuid());
        assertEquals("TestJunctTable", rdbmsJunctionTable.getName());
        assertEquals(
                rdbmsJunctionTable.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsJunctionTable.getPrimaryKey()
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
        final String RDBMS_TABLE_NAME = "TestTable";
        final String RDBMS_MODEL_NAME = "TestGetTableModel";
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsTables().isPresent());
        assertFalse(rdbmsUtils.getRdbmsTable(RDBMS_TABLE_NAME).isPresent());

        rdbmsModel.addContent(newRdbmsTable(RDBMS_TABLE_NAME));

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
        final String RDBMS_TABLE_NAME = "TestTable";
        final String RDBMS_MODEL_NAME = "TestGetFieldModel";
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsFields(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsField(RDBMS_TABLE_NAME, "_id").isPresent());

        rdbmsModel.addContent(newRdbmsTable(RDBMS_TABLE_NAME));

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS
        assertTrue(rdbmsUtils.getRdbmsFields(RDBMS_TABLE_NAME).isPresent());
        assertTrue(rdbmsUtils.getRdbmsField(RDBMS_TABLE_NAME, "_id").isPresent());
    }

    @Test
    public void testGetForeignKey() {
        final String RDBMS_TABLE_NAME = "TestTable";
        final String RDBMS_MODEL_NAME = "TestGetForeignKeyModel";
        final String RDBMS_FOREIGN_KEY = "TestForeignKey";
        final String RDBMS_TABLE_NAME1 = RDBMS_TABLE_NAME + "1";

        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsTable rdbmsTable = newRdbmsTable(RDBMS_TABLE_NAME);
        rdbmsModel.addContent(rdbmsTable);

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        // ASSERTIONS - check optional.empty
        assertFalse(rdbmsUtils.getRdbmsForeignKeys(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsForeignKey(RDBMS_TABLE_NAME, RDBMS_FOREIGN_KEY).isPresent());

        RdbmsTable rdbmsTable1 = newRdbmsTable(RDBMS_TABLE_NAME1);

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
        final String RDBMS_TABLE_NAME = "TestTable";
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

        final RdbmsTable rdbmsTable = newRdbmsTable(RDBMS_TABLE_NAME);
        final RdbmsTable rdbmsTable1 = newRdbmsTable(RDBMS_TABLE_NAME1);

        final RdbmsJunctionTable rdbmsJunctionTable =
                newRdbmsJunctionTable(RDBMS_JUNCT_TABLE_NAME, rdbmsTable, rdbmsTable1);

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

}
