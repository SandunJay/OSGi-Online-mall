package categories;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		final ServiceCategories serviceMenu = (ServiceCategories) new ServiceCategoriesImpl();
        this.serviceRegistration = context.registerService(ServiceCategories.class.getName(), (Object)serviceMenu, null);
		System.out.println("Category Service is start!!");
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Category service is Stop");
	}

}
