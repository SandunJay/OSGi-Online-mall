package employeeproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration serviceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Employee Producer Start!!");
		FoodShopEmployeeService fillstaempserv = (FoodShopEmployeeService) new FoodShopEmployeeServiceImpl();
		serviceRegistration = context.registerService(FoodShopEmployeeService.class.getName(), fillstaempserv,null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Employee Producer Stop!!");
		serviceRegistration.unregister();
	}

}
