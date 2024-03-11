package movieitemsproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Movie  Producer Start");
		MovieItemProducer movieitemproducer = (MovieItemProducer) new ProducerMovieItem();
		publishServiceRegistration = context.registerService(MovieItemProducer.class.getName(), movieitemproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Movie Producer Stop");
		publishServiceRegistration.unregister();
	}

}
