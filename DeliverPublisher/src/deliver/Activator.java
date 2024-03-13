package deliver;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration serviceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("delivery service start");
        final ServiceDelivery serviceDelivery = new ServiceDeliveryImp();
        this.serviceRegistration = context.registerService(ServiceDelivery.class.getName(), (Object)serviceDelivery, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		 System.out.println("delivery service stop");
	        this.serviceRegistration.unregister();
	}

}
