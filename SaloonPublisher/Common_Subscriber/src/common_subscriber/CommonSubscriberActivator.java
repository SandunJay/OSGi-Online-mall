package common_subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import common_publisher.CommonPublish;
import common_publisher.CommonPublishImpl;
import movieadminconsumer.MovieAdminConsumerActivator;
import movieadminproducer.MovieAdminProducer;
import moviecustomerconsumer.MovieCustomerConsumerActivator;
import moviecustomerproducer.MovieCustomerProducer;
import restaurantadminsubscriber.RestaurantAdminActivator;
import restaurantsubscriber.RestaurantSubscriberActivator;
import saloonpublisher.SaloonPublish;
import saloonpublisher.SaloonPublishImpl;
import saloonsubscriber.SaloonServiceActivator;
import subscriber.CustomerActivator;

public class CommonSubscriberActivator implements BundleActivator {
	
	ServiceReference CommonServiceReference;
	
	ServiceReference CustomerServiceReference;
	
	
	

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Common Subscriber Service");
        //CustomerServiceReference = context.getServiceReference(SaloonPublish.class.getName());
		
		CommonServiceReference = context.getServiceReference(CommonPublish.class.getName());
		
		//SaloonPublish customerPublish = (SaloonPublish) context.getService(CustomerServiceReference);
		 
		CommonPublish commonPublish = (CommonPublish) context.getService(CommonServiceReference);
		
//		
//        ServiceReference adminServiceReference = context.getServiceReference(MovieAdminProducer.class.getName());
//        ServiceReference customerServiceReference = context.getServiceReference(MovieCustomerProducer.class.getName());
//        MovieAdminProducer movieAdminProducer = (MovieAdminProducer) context.getService(adminServiceReference);
//        MovieCustomerProducer movieCustomerProducer = (MovieCustomerProducer) context.getService(customerServiceReference);
		
		
		try {
			
			int shopid;
			
			CommonPublish cmpublish = new CommonPublishImpl();
			
			cmpublish.defaultShopList();
			
			while(true) {
				cmpublish.printShopList();
				
				System.out.println("");
				//System.out.print("\t\t\t\t\t\t");
				System.out.print("<< Please enter the shop ID  >>");
				Scanner scan = new Scanner(System.in);
				shopid = scan.nextInt();
				
                if (shopid == 1) {
                	while (true) {
                        System.out.println("\n<< Enter 'end' for username to exit >>\n");
                        System.out.println("============================== Login ===================================");
                        System.out.print("Enter User Type (admin/customer): ");
                        String userType = scan.next();
                        System.out.println("========================================================================\n");

                        if (userType.equals("end")) {
                            System.out.println("Ending the Self Checkout For Cinema");
                            CommonSubscriberActivator cSA = new CommonSubscriberActivator();
                            cSA.start(context);
                        }

                        if (userType.equals("admin")) {
                        	MovieAdminConsumerActivator adminConsumerActivator = new MovieAdminConsumerActivator();
                            adminConsumerActivator.start(context);
                        } else if (userType.equals("customer")) {
                             MovieCustomerConsumerActivator customerConsumerActivator = new MovieCustomerConsumerActivator();
                            customerConsumerActivator.start(context);
                        } else {
                            System.out.println("Incorrect user type.");
                        }
                    }
                }
				
                else if (shopid == 2) {
					SaloonServiceActivator saloonserviceActivator = new SaloonServiceActivator();
					saloonserviceActivator.start(context);
					
                }else if(shopid == 3) {
                	while (true) {
                        System.out.println("\n<< Enter 'end' for username to exit >>\n");
                        System.out.println("============================== Login ===================================");
                        System.out.print("Enter User Type (admin/customer): ");
                        String userType = scan.next();
                        System.out.println("========================================================================\n");

                        if (userType.equals("end")) {
                            System.out.println("Ending the Self Checkout For Restaurant");
                            CommonSubscriberActivator cSA = new CommonSubscriberActivator();
                            cSA.start(context);
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
					
				}else if(shopid == 4) {
					CustomerActivator cusActivator = new CustomerActivator();
					cusActivator.start(context);
				}
			}
		
	} catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
		context.ungetService(CommonServiceReference);
	}

}
