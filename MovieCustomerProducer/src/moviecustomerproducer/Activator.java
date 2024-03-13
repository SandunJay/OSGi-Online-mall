package moviecustomerproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext context) throws Exception {
		System.out.println("Movie Customer Producer Starting");
		MovieCustomerProducer moviecustomerproducer = (MovieCustomerProducer) new ProducerMovieCustomer();
		publishServiceRegistration = context.registerService(MovieCustomerProducer.class.getName(), moviecustomerproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Movie Customer Producer Stop");
		publishServiceRegistration.unregister();
	}

}
