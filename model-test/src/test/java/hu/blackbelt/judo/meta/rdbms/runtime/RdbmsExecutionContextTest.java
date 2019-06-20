package hu.blackbelt.judo.meta.rdbms.runtime;

import com.google.common.collect.ImmutableList;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;
import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

class ExecutionContextTest {

    @Test
    @DisplayName("Create Rdbms model with builder pattern")
    void testRdbmsReflectiveCreated() throws Exception {


        String createdSourceModelName = "urn:rdbms.judo-meta-rdbms";

        RdbmsModelResourceSupport rdbmsModelSupport = rdbmsModelResourceSupportBuilder().build();
        Resource rdbmsResource = rdbmsModelSupport.getResourceSet().createResource(
                URI.createFileURI(createdSourceModelName));

        // Build model here
    }
}