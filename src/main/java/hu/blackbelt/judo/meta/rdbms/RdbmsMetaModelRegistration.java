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

@Component(immediate = true)
public class RdbmsMetaModelRegistration {

    ServiceRegistration<Resource.Factory> rdbmsFactoryRegistration;

    @Activate
    public void activate(ComponentContext componentContext) {
        Dictionary<String, Object> params = new Hashtable<>();
        params.put("meta", "rdbms");
        params.put("version", componentContext.getBundleContext().getBundle().getVersion());

        rdbmsFactoryRegistration = componentContext.getBundleContext()
                .registerService(Resource.Factory.class, new RdbmsResourceFactoryImpl(), params);
    }

    @Deactivate
    public void deactivate() {
        rdbmsFactoryRegistration.unregister();
    }
}
