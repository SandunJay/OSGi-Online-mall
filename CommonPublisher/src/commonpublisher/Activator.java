package commonpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Common Publisher Start");
		CommonPublish publisherService = (CommonPublish) new CommonPublishImpl();
		publishServiceRegistration = context.registerService(CommonPublish.class.getName(), publisherService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Common Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
