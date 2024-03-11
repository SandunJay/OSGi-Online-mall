package movieadminconsumer;

import java.util.Scanner;
import movieadminproducer.MovieAdminProducer;
import movieitemsproducer.MovieItemProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

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
		
		System.out.println("Choose a Option ?\n"
				+ "1. Add Movies\n" );
		String option = sc.next();	
			  System.out.println("_________________________________ Movie  Add Items _________________________________\n");
				System.out.println("Enter Movie ID ?");
				String bcID = sc.next();
				System.out.println("Enter Movie Name ?");
				String bcName = sc.next();
				System.out.println("Item Categorys :Bars\tBreads\tBreakfast Products\tCookies\tDessertsEnter\n Item Category ?");
				String bcCategory = sc.next();
				System.out.println("Enter movie Price ?");
				String bcPrice = sc.next();
				System.out.println("Enter ticket Qty ?");
				String bcQty = sc.next();
				
				movieitemsproducer.addMovies(bcID, bcName , bcCategory, bcPrice, bcQty);
		
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println(" Adamin Consumer Good Bye !!!");
	}

}
