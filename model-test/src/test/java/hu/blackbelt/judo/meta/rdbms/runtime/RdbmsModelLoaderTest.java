package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.LoadArguments.rdbmsLoadArgumentsBuilder;

public class RdbmsModelLoaderTest {

    static Logger log = LoggerFactory.getLogger(RdbmsModelLoaderTest.class);
	
    @Test
    @DisplayName("Load Rdbms Model")
    void loadRdbmsModel() throws IOException {
        ResourceSet rdbmsResourceSet = RdbmsModelResourceSupport.createRdbmsResourceSet();

        RdbmsModel rdbmsModel = RdbmsModel.loadRdbmsModel(rdbmsLoadArgumentsBuilder()
                .resourceSet(rdbmsResourceSet)
                .uri(URI.createFileURI(new File("src/test/model/test.rdbms").getAbsolutePath()))
                .name("test"));

        for (Iterator<EObject> i = rdbmsModel.getResourceSet().getResource(rdbmsModel.getUri(), false).getAllContents(); i.hasNext(); ) {
            log.info(i.next().toString());
        }
    }
}