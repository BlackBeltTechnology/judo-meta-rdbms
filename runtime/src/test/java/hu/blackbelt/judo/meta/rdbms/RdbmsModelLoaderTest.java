package hu.blackbelt.judo.meta.rdbms;

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModelLoader;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Slf4j
@Disabled
class RdbmsModelLoaderTest {

    @Test
    void loadRdbmsModel() throws IOException {
        RdbmsModel rdbmsModel = RdbmsModelLoader.loadRdbmsModel(
                URI.createURI(new File(srcDir(), "test/models/northwind-rdbms.model").getAbsolutePath()),
                "test",
                "1.0.0");

        for (Iterator<EObject> i = rdbmsModel.getResourceSet().getResource(rdbmsModel.getUri(), false).getAllContents(); i.hasNext(); ) {
            log.info(i.next().toString());
        }
    }

    public File srcDir(){
        String relPath = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        File targetDir = new File(relPath+"../../src");
        if(!targetDir.exists()) {
            targetDir.mkdir();
        }
        return targetDir;
    }


}