package promo;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		 final ServicePromo promotions = (ServicePromo) new ServicePromoImpl();
	     this.serviceRegistration = context.registerService(ServicePromo.class.getName(), (Object)promotions, null);
	     System.out.println("Promo service stop!");
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		this.serviceRegistration.unregister();
		System.out.println("Promo service stop!");
	}

}
