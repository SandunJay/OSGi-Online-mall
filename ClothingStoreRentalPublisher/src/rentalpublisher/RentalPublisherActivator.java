package rentalpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class RentalPublisherActivator implements BundleActivator {
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Rental Service Publisher start!!");
		final RentalPublisher publishService = new RentalPublisherImpl();
		this.serviceRegistration = context.registerService(RentalPublisher.class.getName(), (Object)publishService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Rental Service Publisher Stop!!");
		this.serviceRegistration.unregister();
	}

}
