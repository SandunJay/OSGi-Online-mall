package employeemanagementinterface;

import employeeproducer.FoodShopEmployeeService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
    static FoodShopEmployeeService foodEmpService;
    static ServiceTracker<FoodShopEmployeeService, FoodShopEmployeeService> EmpTrack;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Gui Service Start!!");
        EmpTrack = new ServiceTracker<>(context, FoodShopEmployeeService.class, null);
        EmpTrack.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Gui Service Is Stop!!");
        EmpTrack.close();
    }

    public static boolean EmpServChecker() {
        foodEmpService = EmpTrack.getService();
        return foodEmpService != null;
    }
}