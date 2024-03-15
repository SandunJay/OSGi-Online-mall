package restaurantsubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import restaurantpublisher.RestaurantServiceImpl;
import restaurantpublisher.RestaurantServicePublish;


public class RestaurantSubscriberActivator implements BundleActivator {

	ServiceReference restaurantServiceReference;

	public void start(BundleContext context) throws Exception {
		//RestaurantSubscriberActivator.context = bundleContext;
		System.out.println("Start Reataurant subscriber service");
		restaurantServiceReference = context.getServiceReference(RestaurantServicePublish.class.getName());
		RestaurantServicePublish restaurantServicePublish = (RestaurantServicePublish)context.getService(restaurantServiceReference);
		
		restaurantServicePublish.order();
	
	}

	public void stop(BundleContext context) throws Exception {
		//RestaurantSubscriberActivator.context = null;
		System.out.println("Good Bye !!!");
		context.ungetService(restaurantServiceReference);
	}

}
