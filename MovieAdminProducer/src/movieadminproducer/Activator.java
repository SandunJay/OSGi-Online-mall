package movieadminproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Movie Admin Producer Start");
		MovieAdminProducer movieAdminproducer = (MovieAdminProducer) new ProducerMovieAdmin();
		publishServiceRegistration = context.registerService(MovieAdminProducer.class.getName(), movieAdminproducer, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Admin Producer Stop");
		publishServiceRegistration.unregister();
	}

}
