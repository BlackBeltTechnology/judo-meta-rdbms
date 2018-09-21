package hu.blackbelt.judo.meta.rdbms;

import hu.blackbelt.judo.meta.rdbms.util.RdbmsResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.util.Dictionary;
import java.util.Hashtable;

@Component(immediate = true, service = RdbmsMetaModel.class)
public class RdbmsMetaModelRegistration implements RdbmsMetaModel {

    ServiceRegistration<Resource.Factory> rdbmsFactoryRegistration;
    Resource.Factory factory;

    @Activate
    public void activate(ComponentContext componentContext) {
        Dictionary<String, Object> params = new Hashtable<>();
        params.put("meta", "rdbms");
        params.put("version", componentContext.getBundleContext().getBundle().getVersion());
        params.put("bundle", componentContext.getBundleContext().getBundle());

        factory = new RdbmsResourceFactoryImpl();
        rdbmsFactoryRegistration = componentContext.getBundleContext()
                .registerService(Resource.Factory.class, factory, params);
    }

    @Deactivate
    public void deactivate() {
        rdbmsFactoryRegistration.unregister();
    }

    @Override
    public Resource.Factory getFactory() {
        return factory;
    }
}
