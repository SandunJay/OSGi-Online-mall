package client_common_subscriber;

//import common_publisher.CommonPublish;
//import common_publisher.CommonPublishImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import restaurantadminpublisher.RestaurantAdminServices;
import restaurantadminsubscriber.RestaurantAdminActivator;
import restaurantpublisher.RestaurantServicePublish;
import restaurantsubscriber.RestaurantSubscriberActivator;
import restaurantpublisher.*;
import client_common_publisher.ClientServices;
import client_common_publisher.ClientServicesImpl;

import java.util.*;


public class Activator implements BundleActivator {

//	private static BundleContext context;
//
//	static BundleContext getContext() {
//		return context;
//	}
	
	//ServiceReference restaurant;
	Scanner scanner = new Scanner(System.in);
	
	ServiceReference resAdminServiceReference;
	ServiceReference resServiceReference;
	ServiceReference commonServiceReference;

	public void start(BundleContext context) throws Exception {
		//Activator.context = bundleContext;
//		System.out.println("Start Client");
//		restaurant = context.getServiceReference(RestaurantServicePublish.class.getName());
//		RestaurantServicePublish res = (RestaurantServicePublish) context.getService(restaurant);
//	}
		
		
		resAdminServiceReference = context.getServiceReference(RestaurantAdminServices.class.getName());
        resServiceReference = context.getServiceReference(RestaurantServicePublish.class.getName());
        commonServiceReference = context.getServiceReference(ClientServices.class.getName());

//        RestaurantAdminServices resAdminProducer = (RestaurantAdminServices) context.getService(resAdminServiceReference);
//        RestaurantServicePublish resCustomerProducer = (RestaurantServicePublish) context.getService(resServiceReference);
//        ClientServices commonPublish = (ClientServices) context.getService(commonServiceReference);
//

        try {
            int shopId;
            
            ClientServices cmpublish = new ClientServicesImpl();
            
            cmpublish.defaultShopList();

            while (true) {
                cmpublish.printShopList();
                System.out.println("\n<< Please enter the shop ID  >>");
                shopId = scanner.nextInt();

                if (shopId == 3) {
                    while (true) {
                        System.out.println("\n<< Enter 'end' for username to exit >>\n");
                        System.out.println("============================== Login ===================================");
                        System.out.print("Enter User Type (admin/customer): ");
                        String userType = scanner.next();
                        System.out.println("========================================================================\n");

                        if (userType.equals("end")) {
                            System.out.println("Ending the Self Checkout For Restaurant");
                            break;
                        }

                        else if (userType.equals("admin")) {
                        	//resAdminProducer.display();
                        	RestaurantAdminActivator adminConsumerActivator = new RestaurantAdminActivator();
                            adminConsumerActivator.start(context);
                            break;
                        } else if (userType.equals("customer")) {
                            RestaurantSubscriberActivator customerConsumerActivator = new RestaurantSubscriberActivator();
                            customerConsumerActivator.start(context);
                            break;

                            
                        } else {
                            System.out.println("Incorrect user type.");
                        }
                        
                    }
                    //break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


	public void stop(BundleContext context) throws Exception {
		//Activator.context = null;
		System.out.println("Stopping Client Subscriber");
		context.ungetService(resServiceReference);
		context.ungetService(resAdminServiceReference);
	}

}
