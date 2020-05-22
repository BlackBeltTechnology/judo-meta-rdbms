package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.epsilon.runtime.execution.api.Log;
import hu.blackbelt.epsilon.runtime.execution.impl.Slf4jLog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils.newRdbmsTable;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class RdbmsUtilsTest {

    private static final Log log = new Slf4jLog();
    private static final String RDBMS_MODEL_NAME = "TestModel";
    private static final String RDBMS_TABLE_NAME = "TestTable";
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
    public void testGetRdbmsTables() {
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name(RDBMS_MODEL_NAME)
                .build();

        rdbmsModel.addContent(newRdbmsTable(RDBMS_TABLE_NAME));

        saveModel(rdbmsModel);

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());

        Assertions.assertTrue(rdbmsUtils.getRdbmsTables()
                .orElseThrow(() -> new RuntimeException("No tables were found"))
                .stream().allMatch(e -> RDBMS_TABLE_NAME.equals(e.getName())));

        assertTrue(rdbmsUtils.getRdbmsTable(RDBMS_TABLE_NAME).isPresent());
    }

    @Test
    public void testGetRdbmsFields() {
        // TODO
    }

}
