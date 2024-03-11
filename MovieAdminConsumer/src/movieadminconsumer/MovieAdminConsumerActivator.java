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
		                + "Enter -1 to exit movie insertion");
		        option = sc.next();
		        if (!option.equals("1")) {
		            System.out.println("Invalid option. Please try again.");
		            continue;
		        }

		        System.out.println("_________________________________ Movie Add Items _________________________________\n");
		        System.out.println("Enter Movie ID ?");
		        String movieID = sc.next();
		        System.out.println("Enter Movie Name ?");
		        String movieName = sc.next();
		        System.out.println("Item Categories: Thriller, Action, Science fiction, Comedy, Western\nItem Category ?");
		        String movieCategory = sc.next();
		        System.out.println("Enter movie Price ?");
		        String moviePrice = sc.next();
		        System.out.println("Enter ticket Qty ?");
		        String movieQty = sc.next();

		        movieitemsproducer.addMovies(movieID, movieName, movieCategory, moviePrice, movieQty);
		    } while (!option.equals("-1"));
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
