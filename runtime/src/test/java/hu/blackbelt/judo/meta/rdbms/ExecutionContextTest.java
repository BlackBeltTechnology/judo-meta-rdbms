package hu.blackbelt.judo.meta.rdbms;

import com.google.common.collect.ImmutableList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.jupiter.api.Test;

import java.io.File;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModelLoader.createRdbmsResourceSet;
import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

class ExecutionContextTest {

    @Test
    void testReflectiveCreated() throws Exception {


        String createdSourceModelName = "urn:rdbms.judo-meta-rdbms";

        ResourceSet executionResourceSet = createRdbmsResourceSet();
        Resource rdbmsResource = executionResourceSet.createResource(
                URI.createURI(createdSourceModelName));

        RdbmsIdentifierField test1primarykey = newRdbmsIdentifierFieldBuilder()
                .withName("Id")
                .withSqlName("ID")
                .withMandatory(true)
                .withRdbmsTypeName("INT")
                .build();

        hu.blackbelt.judo.meta.rdbms.RdbmsModel model = newRdbmsModelBuilder()
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

    public File scriptDir(){
        String relPath = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        File targetDir = new File(relPath+"../../src/main");
        if(!targetDir.exists()) {
            targetDir.mkdir();
        }
        return targetDir;
    }

}