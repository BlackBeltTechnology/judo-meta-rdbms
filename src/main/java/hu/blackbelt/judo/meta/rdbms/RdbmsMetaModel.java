package hu.blackbelt.judo.meta.rdbms;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface RdbmsMetaModel {

    Resource.Factory getFactory();

    void registerRdbmsMetamodel(ResourceSet resourceSet);
}
