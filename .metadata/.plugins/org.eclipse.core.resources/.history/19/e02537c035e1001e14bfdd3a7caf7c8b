package employeeconsumer;

import employeeproducer.FoodShopEmployeeService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference empServiceRef;
	static FoodShopEmployeeService foodEmpService;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Employee Consumer Start!!");
		
		empServiceRef = context.getServiceReference(FoodShopEmployeeService.class.getName());
		foodEmpService = (FoodShopEmployeeService)context.getService(empServiceRef);
		foodEmpService.EmployeeService();
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Employee Consumer Stop!!");
		context.ungetService(empServiceRef);
	}

}
