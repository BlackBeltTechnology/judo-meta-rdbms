package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsTableBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RdbmsUtilsTest {

    @Test
    public void testGetRdbmsTables() {
        RdbmsModel rdbmsModel = RdbmsModel.buildRdbmsModel()
                .name("TestModel")
                .build();

        rdbmsModel.addContent(
                RdbmsTableBuilder.create()
                        .withName("TestTable")
                        .build()
        );

        RdbmsUtils rdbmsUtils = new RdbmsUtils(rdbmsModel.getResourceSet());


        Assertions.assertTrue(rdbmsUtils.getRdbmsTables()
                .orElseThrow(() -> new RuntimeException("No tables were found"))
                .stream().allMatch(e -> "TestTable".equals(e.getName())));

        assertTrue(rdbmsUtils.getRdbmsTable("TestTable").isPresent());
    }

}
