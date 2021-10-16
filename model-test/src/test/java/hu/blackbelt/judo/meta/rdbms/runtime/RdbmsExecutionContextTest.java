package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;

import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

class RdbmsExecutionContextTest {

    @Test
    @DisplayName("Create Rdbms model with builder pattern")
    void testRdbmsReflectiveCreated() throws Exception {
        String createdSourceModelName = "urn:rdbms.judo-meta-rdbms";

        RdbmsModelResourceSupport rdbmsModelSupport = rdbmsModelResourceSupportBuilder()
                .uri(URI.createFileURI(createdSourceModelName))
                .build();

        // Build model here
        rdbmsModelSupport.addContent(RdbmsBuilders
                .newRdbmsTableBuilder()
                .withFullName("TEST").build());

        System.out.println(rdbmsModelSupport.asString());
    }
}