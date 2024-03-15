package subscriber;

import categories.ServiceCategories;

import deliver.ServiceDelivery;
import java.util.Scanner;

import javax.naming.Context;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import promo.ServicePromo;
import promo.ServicePromoImpl;
import rentalpublisher.RentalPublisher;


public class CustomerActivator implements BundleActivator {
	
	ServiceReference serviceReference;


	private boolean authenticateUser() {
		System.out.println("===============================================================");
		System.out.println("|                   Welcome Tesla's login page                |");
		System.out.println("===============================================================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
		System.out.println("\n=================================\n");
        
        if (username.equals("user") && password.equals("123")) {
            return true;
        } else if(username.equals("admin") && password.equals("321")){
        	return true;
        }else {
            return false;
        }
    }
	

	@Override
	public void start(BundleContext context) throws Exception {
		
        if (!authenticateUser()) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }
        
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
        try {
            do {
                System.out.println("************************************************");
                System.out.println("Welcome to Tesla Textiles.\n");
                
                System.out.println("\n========= Promotions ============");        
                ServicePromoImpl sv = new ServicePromoImpl();
             
                System.out.println(sv.Offers());
                System.out.println(sv.discount());
                System.out.println(sv.packages());
                System.out.println("===============================\n\n"); 
                
                System.out.println("============Explore Tesla============\n"); 
                System.out.println("Choose service number to Navigate with Our Services: ");
                System.out.println(" 1 -  Categories");
                System.out.println(" 2 -  Promotions");
                System.out.println(" 3 -  Delivery Service");
                System.out.println(" 4 -  Rental Service");
                System.out.println("Enter -1 to exit.");
                System.out.println("===============================\n\n");

                
                ans = sc.nextInt();
                switch (ans) {
                    case 1: {
                        this.serviceReference = context.getServiceReference(ServiceCategories.class.getName());
                        final ServiceCategories serviceCategories = (ServiceCategories)context.getService(this.serviceReference);
                        if (serviceCategories != null) {
                        	serviceCategories.displayCategories();
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        this.serviceReference = context.getServiceReference(ServicePromo.class.getName());
                        final ServicePromo servicePromotions = (ServicePromo)context.getService(this.serviceReference);
                        if (servicePromotions != null) {
                        	servicePromotions.promo();
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        this.serviceReference = context.getServiceReference(ServiceDelivery.class.getName());
                        final ServiceDelivery serviceDelivery = (ServiceDelivery)context.getService(this.serviceReference);
                        if (serviceDelivery != null) {
                            serviceDelivery.deliverService();
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        this.serviceReference = context.getServiceReference(RentalPublisher.class.getName());
                        final RentalPublisher serviceRental = (RentalPublisher)context.getService(this.serviceReference);
                        if (serviceRental != null) {
                        	serviceRental.rental();
                            continue;
                        }
                        continue;                        
                    }
                    default: {
                        System.out.println("Invalid number.");
                        continue;
                    }
                }
            } while (ans != -1);
	}catch (Exception ex) {
        System.out.println("Exception occured. ");
    }
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
