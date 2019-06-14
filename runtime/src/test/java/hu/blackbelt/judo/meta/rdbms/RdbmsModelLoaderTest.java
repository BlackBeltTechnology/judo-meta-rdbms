package hu.blackbelt.judo.meta.rdbms;

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsDataTypes.support.RdbmsDataTypesModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsNameMapping.support.RdbmsNameMappingModelResourceSupport;
import hu.blackbelt.judo.meta.rdbmsRules.support.RdbmsTableMappingRulesModelResourceSupport;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.LoadArguments.loadArgumentsBuilder;

@Slf4j
public class RdbmsModelLoaderTest {

    @Test
    @DisplayName("Load RDBMS Model")
    void loadRdbmsModel() throws IOException {
        ResourceSet rdbmsResourceSet = RdbmsModelResourceSupport.createRdbmsResourceSet();
        RdbmsNameMappingModelResourceSupport.registerRdbmsNameMappingMetamodel(rdbmsResourceSet);
        RdbmsTableMappingRulesModelResourceSupport.registerRdbmsTableMappingRulesMetamodel(rdbmsResourceSet);
        RdbmsDataTypesModelResourceSupport.registerRdbmsDataTypesMetamodel(rdbmsResourceSet);

        RdbmsModel rdbmsModel = hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.loadRdbmsModel(loadArgumentsBuilder()
                .resourceSet(Optional.of(rdbmsResourceSet))
                .uri(URI.createURI(new File("src/test/models/northwind-rdbms.model").getAbsolutePath()))
                .name("test")
                .build());

        for (Iterator<EObject> i = rdbmsModel.getResourceSet().getResource(rdbmsModel.getUri(), false).getAllContents(); i.hasNext(); ) {
            log.info(i.next().toString());
        }
    }
}