package client_common_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

//	private static BundleContext context;
//
//	static BundleContext getContext() {
//		return context;
//	}
	
	ServiceRegistration clientServiceRegistration;

	public void start(BundleContext context) throws Exception {
		//Activator.context = bundleContext;
		System.out.println("Client Publisher started");
		ClientServices publishClientService = new ClientServicesImpl();
		clientServiceRegistration = context.registerService(ClientServices.class.getName(), publishClientService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping client publisher");
		clientServiceRegistration.unregister();
	}

}
