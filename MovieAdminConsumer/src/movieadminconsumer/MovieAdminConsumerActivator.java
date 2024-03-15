package movieadminconsumer;

import java.util.Scanner;
import movieadminproducer.MovieAdminProducer;
import movieitemsproducer.MovieItemProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class MovieAdminConsumerActivator implements BundleActivator {

	ServiceReference serviceReference, serviceReferenceItems;
	Scanner sc = new Scanner(System.in);
	String decision = "y";
	boolean itemsSaveSuccMsg = false;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Adamin Consumer Service");
		serviceReference = context.getServiceReference(MovieAdminProducer.class.getName());
		MovieAdminProducer movieadminproducer = (MovieAdminProducer) context.getService(serviceReference);
		
		serviceReferenceItems = context.getServiceReference(MovieItemProducer.class.getName());
		MovieItemProducer movieitemsproducer =(MovieItemProducer) context.getService(serviceReferenceItems);
		
			
		System.out.println(movieadminproducer.welcomeMsg());
		   String option;
		   do {
			    System.out.println("Choose an Option:\n"
			            + "1. Add Movies\n"
			            + "2. Get Available Seats\n"
			            + "3. Retrieve All Movies\n"
			            + "Enter -1 to exit");
			    option = sc.next();
			    
			    switch (option) {
			        case "1":
			            System.out.println("_________________________________ Movie Add Items _________________________________\n");
			            System.out.println("Enter Movie ID ?");
			            String movieID = sc.next();
			            System.out.println("Enter Movie Name ?");
			            String movieName = sc.next();
			            System.out.println("Enter Movie Category: \nThriller, Action, Science fiction, Comedy, Western ");
			            String movieCategory = sc.next();
			            System.out.println("Enter ticket Price ?");
			            String moviePrice = sc.next();
			            System.out.println("Enter available seats ?");
			            String avbSeats = sc.next();

			            movieitemsproducer.addMovies(movieID, movieName, movieCategory, moviePrice, avbSeats);
			            break;
			            
			        case "2":
			        	movieitemsproducer.getAllMovies();
			        	System.out.println("Enter the movie ID");
			        	String x= sc.next();
			        	System.out.println(movieitemsproducer.getItemQty(x)); 
			            break;
			            
			        case "3":
			        	movieitemsproducer.getAllMovies();
			            break;
			            
			        case "-1":
			            break;
			            
			        default:
			            System.out.println("Invalid option. Please try again.");
			            break;
			    }
			} while (!option.equals("-1"));
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
