package hu.blackbelt.judo.meta.rdbms.runtime;

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsDataTypes.support.RdbmsDataTypesModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsNameMapping.runtime.RdbmsNameMappingModel;
import hu.blackbelt.judo.meta.rdbmsNameMapping.support.RdbmsNameMappingModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsRules.support.RdbmsTableMappingRulesModelResourceSupport;
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
import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.createRdbmsResourceSet;
import static hu.blackbelt.judo.meta.rdbmsDataTypes.support.RdbmsDataTypesModelResourceSupport.registerRdbmsDataTypesMetamodel;
import static hu.blackbelt.judo.meta.rdbmsNameMapping.support.RdbmsNameMappingModelResourceSupport.registerRdbmsNameMappingMetamodel;
import static hu.blackbelt.judo.meta.rdbmsRules.support.RdbmsTableMappingRulesModelResourceSupport.registerRdbmsTableMappingRulesMetamodel;

public class RdbmsModelLoaderTest {

    static Logger log = LoggerFactory.getLogger(RdbmsModelLoaderTest.class);
	
    @Test
    @DisplayName("Load Rdbms Model")
    void loadRdbmsModel() throws IOException, RdbmsModel.RdbmsValidationException {
        ResourceSet rdbmsResourceSet = createRdbmsResourceSet();

        registerRdbmsNameMappingMetamodel(rdbmsResourceSet);
        registerRdbmsDataTypesMetamodel(rdbmsResourceSet);
        registerRdbmsTableMappingRulesMetamodel(rdbmsResourceSet);

        RdbmsModel rdbmsModel = RdbmsModel.loadRdbmsModel(rdbmsLoadArgumentsBuilder()
                .resourceSet(rdbmsResourceSet)
                .uri(URI.createFileURI(new File("target/test-classes/model/northwind-rdbms_hsqldb.model").getAbsolutePath()))
                .name("test"));

        for (Iterator<EObject> i = rdbmsModel.getResourceSet().getResource(rdbmsModel.getUri(), false).getAllContents(); i.hasNext(); ) {
            log.info(i.next().toString());
        }
    }
}