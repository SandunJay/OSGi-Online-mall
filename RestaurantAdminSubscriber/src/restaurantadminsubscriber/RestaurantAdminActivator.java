package restaurantadminsubscriber;

import org.osgi.framework.BundleActivator;
import java.util.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import restaurantadminpublisher.RestaurantAdminServices;

public class RestaurantAdminActivator implements BundleActivator {

	ServiceReference restaurantAdminServiceReference;

	public void start(BundleContext context) throws Exception {
//		System.out.println("Start Reataurant subscriber service");
//		restaurantAdminServiceReference = context.getServiceReference(RestaurantAdminServices.class.getName());
//		RestaurantAdminServices restaurantAdminServices	 = (RestaurantAdminServices)context.getService(restaurantAdminServiceReference);
//		restaurantAdminServices.addFood();
//		restaurantAdminServices.displayFoodDetails();
		
		System.out.println("Start Restaurant subscriber service");
		restaurantAdminServiceReference = context.getServiceReference(RestaurantAdminServices.class.getName());
		RestaurantAdminServices restaurantAdminServices = (RestaurantAdminServices) context.getService(restaurantAdminServiceReference);

		Scanner scanner = new Scanner(System.in);
		String userInput;
		boolean exit = false;
		do {
		    System.out.println("\nChoose an option:");
		    System.out.println("1. Add Food");
		    System.out.println("2. Display Food Details");
		    System.out.println("3. Search Food");
		    System.out.println("4. Remove Food");
		    System.out.println("5. Update Food");
		    System.out.println("Type 'exit' to quit.");
		    userInput = scanner.nextLine();

		    switch (userInput) {
		        case "1":
		            restaurantAdminServices.addNewFood();
		            break;
		        case "2":
		            restaurantAdminServices.displayFoodDetails();
		            break;
		        case "3":
		            //System.out.println("\nEnter keyword to search:");
		            //String keyword = scanner.nextLine();
		            restaurantAdminServices.searchFood();
		            break;
		        case "4":
		            //System.out.println("\nEnter ID of the food to remove:");
		            //String idToRemove = scanner.nextLine();
		            restaurantAdminServices.removeFood();
		            break;
		        case "5":
		        	//System.out.println("\nEnter ID of the food to update:");
		        	//String idToUpdate = scanner.nextLine();
		            restaurantAdminServices.updateFood();
		            break;
		        case "exit":
		            exit = true;
		            System.out.println("\nExiting...");
		            break;
		        default:
		            System.out.println("\nInvalid option. Please try again.");
		            break;
		    }
		} while (!exit);


	
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Restaurant admin subscriber");
		context.ungetService(restaurantAdminServiceReference);
	}

}
