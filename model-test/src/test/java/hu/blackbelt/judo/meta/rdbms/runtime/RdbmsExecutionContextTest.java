package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

class ExecutionContextTest {

    @Test
    @DisplayName("Create Rdbms model with builder pattern")
    void testRdbmsReflectiveCreated() throws Exception {


        String createdSourceModelName = "urn:rdbms.judo-meta-rdbms";

        RdbmsModelResourceSupport rdbmsModelSupport = rdbmsModelResourceSupportBuilder().build();
        Resource rdbmsResource = rdbmsModelSupport.getResourceSet().createResource(
                URI.createFileURI(createdSourceModelName));

        // Build model here
        rdbmsResource.getContents().add(RdbmsBuilders.newRdbmsTableBuilder().withFullName("TEST").build());
    }
}