package saloonpublisher;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

 

import saloonpublisher.SaloonPublish;
import saloonpublisher.SaloonPublishImpl;

public class SaloonServiceActivator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		
		
		System.out.println("Publisher Start");
		SaloonPublish publisherService = new SaloonPublishImpl();
		publishServiceRegistration = context.registerService(SaloonPublish.class.getName(), publisherService, null);
		
	
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
