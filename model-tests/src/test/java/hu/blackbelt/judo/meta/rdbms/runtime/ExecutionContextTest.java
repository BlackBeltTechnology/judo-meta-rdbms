package hu.blackbelt.judo.meta.rdbms.runtime;

import com.google.common.collect.ImmutableList;
import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;
import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

class ExecutionContextTest {

    @Test
    @DisplayName("Create model with builder pattern")
    void testReflectiveCreated() throws Exception {


        String createdSourceModelName = "urn:rdbms.judo-meta-rdbms";

        RdbmsModelResourceSupport rdbmsModelSupport = rdbmsModelResourceSupportBuilder().build();
        Resource rdbmsResource = rdbmsModelSupport.getResourceSet().createResource(
                URI.createFileURI(createdSourceModelName));

        RdbmsIdentifierField test1primarykey = newRdbmsIdentifierFieldBuilder()
                .withName("Id")
                .withSqlName("ID")
                .withMandatory(true)
                .withRdbmsTypeName("INT")
                .build();

        RdbmsModel model = newRdbmsModelBuilder()
                .withRdbmsTables(newRdbmsTableBuilder()
                        .withFields(ImmutableList.of(test1primarykey,
                                newRdbmsValueFieldBuilder()
                                        .withName("d1")
                                        .withSqlName("D1")
                                        .withRdbmsTypeName("STRING")
                                        .build()))
                        .withName("Test1")
                        .withSqlName("T_TEST1")
                        .withPrimaryKey(test1primarykey)
                        .build()
                ).withConfiguration(newRdbmsConfigurationBuilder().withDialect("HSQLDB").build()).build();

        rdbmsResource.getContents().add(model);

    }
}