package common_subscriber;

import commonpublisher.CommonPublish;
import commonpublisher.CommonPublishImpl;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import subscriber.CustomerActivator;

public class Activator implements BundleActivator {
	
	ServiceReference CommonServiceReference;
	
	ServiceReference CustomerServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Common Subscriber Service");
        //CustomerServiceReference = context.getServiceReference(SaloonPublish.class.getName());
		
		CommonServiceReference = context.getServiceReference(CommonPublish.class.getName());
		
		//SaloonPublish customerPublish = (SaloonPublish) context.getService(CustomerServiceReference);
		 
		CommonPublish commonPublish = (CommonPublish) context.getService(CommonServiceReference);
		
		try {
			
			int shopid;
			
			
			//SaloonPublish cusPublish = new SaloonPublishImpl();
			
			CommonPublish cmpublish = new CommonPublishImpl();
			
			cmpublish.defaultShopList();
			
			while(true) {
				
				
				 
				cmpublish.printShopList();
				
				System.out.println("");
				//System.out.print("\t\t\t\t\t\t");
				System.out.print("<< Please enter the shop ID  >>");
				Scanner scan = new Scanner(System.in);
				shopid = scan.nextInt();
				
				
				
				if (shopid == 2) {
					
					//SaloonServiceActivator saloonserviceActivator = new SaloonServiceActivator();
					//saloonserviceActivator.start(context);
				}else if(shopid == 4) {
					CustomerActivator cusActivator = new CustomerActivator();
					cusActivator.start(context);
				}
				
				
			}
		
	} catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!!");
	}

}
