package restaurantpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class RestaurantPublisherActivator implements BundleActivator {


	ServiceRegistration publishServiceRegistration;
	

	public void start(BundleContext context) throws Exception {
		System.out.println();
		System.out.println("Welcome to the Restaurant :)");
		System.out.println();
		
		RestaurantServicePublish publisherService = new RestaurantServiceImpl();
		publishServiceRegistration = context.registerService(RestaurantServicePublish.class.getName(), publisherService, null);
		
	
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!! Come Again !!!");
		publishServiceRegistration.unregister();
	}

}
