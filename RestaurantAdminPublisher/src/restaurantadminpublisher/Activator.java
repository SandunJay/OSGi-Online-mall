package restaurantadminpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println();
		System.out.println("Welcome to the Admin Portal :)");
		System.out.println();
		
		RestaurantAdminServices publishService = new RestaurantAdminServicesImpl();
		publishServiceRegistration = context.registerService(RestaurantAdminServices.class.getName(), publishService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye Admin !!!");
		publishServiceRegistration.unregister();
		
	}

}
