package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsJunctionTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsForeignKeyBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsJunctionTableBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

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

        assertEquals("Tables.TestTable", rdbmsTable.getUuid());
        assertEquals("TestTable", rdbmsTable.getName());
        assertTrue(rdbmsTable.getFields().stream().allMatch(e -> "_id".equals(e.getName())));
        assertEquals(
                rdbmsTable.getFields().stream().filter(e -> "_id".equals(e.getName())).findFirst()
                        .orElseThrow(() -> new RuntimeException("_id field not found")),
                rdbmsTable.getPrimaryKey()
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
        assertFalse(rdbmsUtils.getRdbmsTables().isPresent());
        assertFalse(rdbmsUtils.getRdbmsTable(RDBMS_TABLE_NAME).isPresent());

        rdbmsModel.addContent(newRdbmsTable(RDBMS_TABLE_NAME));

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

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
        assertFalse(rdbmsUtils.getRdbmsFields(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsField(RDBMS_TABLE_NAME, "_id").isPresent());

        rdbmsModel.addContent(newRdbmsTable(RDBMS_TABLE_NAME));

        saveModel(rdbmsModel);

        rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());
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
        assertFalse(rdbmsUtils.getRdbmsForeignKeys(RDBMS_TABLE_NAME).isPresent());
        assertFalse(rdbmsUtils.getRdbmsForeignKey(RDBMS_TABLE_NAME, RDBMS_FOREIGN_KEY).isPresent());

        RdbmsTable rdbmsTable1 = newRdbmsTable(RDBMS_TABLE_NAME1);
        rdbmsModel.addContent(rdbmsTable1);

        RdbmsForeignKey rdbmsForeignKey = RdbmsForeignKeyBuilder.create()
                .withName(RDBMS_FOREIGN_KEY)
                .withUuid(rdbmsTable1.getUuid() + "#" + RDBMS_FOREIGN_KEY)
                .withReferenceKey(rdbmsTable.getPrimaryKey())
                .withForeignKeySqlName(rdbmsTable.getName())
                .build();

        rdbmsTable1.getFields().add(rdbmsForeignKey);

        saveModel(rdbmsModel);

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
    @Disabled
    public void testGetJunctionTable() {
        final String RDBMS_TABLE_NAME = "TestTable";
        final String RDBMS_TABLE_NAME1 = RDBMS_TABLE_NAME + "1";
        final String RDBMS_JUNCT_TABLE_NAME = RDBMS_TABLE_NAME + "to" + RDBMS_TABLE_NAME1;
        final String RDBMS_MODEL_NAME = "TestGetJunctionTableModel";

        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        RdbmsTable rdbmsTable = newRdbmsTable(RDBMS_TABLE_NAME);
        RdbmsTable rdbmsTable1 = newRdbmsTable(RDBMS_TABLE_NAME1);

        final RdbmsIdentifierField id = RdbmsBuilders.newRdbmsIdentifierFieldBuilder()
                .withName("_id")
                .withUuid("Tables." + RDBMS_JUNCT_TABLE_NAME + "#_id")
                .build();

        RdbmsJunctionTable rdbmsJunctionTable = RdbmsJunctionTableBuilder.create()
                .withName(RDBMS_JUNCT_TABLE_NAME)
                .withPrimaryKey(id)
                .withUuid("Tables." + RDBMS_JUNCT_TABLE_NAME)
                .withField1(RdbmsBuilders.newRdbmsForeignKeyBuilder()
                        .withName(RDBMS_TABLE_NAME)
                        .withUuid(rdbmsTable.getUuid() + "#" + RDBMS_TABLE_NAME)
                        .withReferenceKey(rdbmsTable.getPrimaryKey())
                        .build()
                )
                .withField2(RdbmsBuilders.newRdbmsForeignKeyBuilder()
                        .withName(RDBMS_TABLE_NAME1)
                        .withUuid(rdbmsTable1.getUuid() + "#" + RDBMS_TABLE_NAME1)
                        .withReferenceKey(rdbmsTable1.getPrimaryKey())
                        .build()
                )
                .build();

        rdbmsModel.addContent(rdbmsTable);
        rdbmsModel.addContent(rdbmsTable1);
        rdbmsModel.addContent(rdbmsJunctionTable);

        saveModel(rdbmsModel);

    }

}
