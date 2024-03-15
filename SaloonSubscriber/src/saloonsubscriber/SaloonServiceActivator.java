package saloonsubscriber;

import org.osgi.framework.BundleActivator;



import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import saloonpublisher.SaloonPublish;
import saloonpublisher.SaloonPublishImpl;
import java.util.Scanner;
import common_publisher.CommonPublish;
import common_publisher.CommonPublishImpl;
import common_subscriber.CommonSubscriberActivator;



public class SaloonServiceActivator implements BundleActivator {

	ServiceReference CustomerServiceReference;
	
	//ServiceReference CommonServiceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start Customer Subscriber Service");
		CustomerServiceReference = context.getServiceReference(SaloonPublish.class.getName());
		
		//CommonServiceReference = context.getServiceReference(CommonPublish.class.getName());
		
		SaloonPublish customerPublish = (SaloonPublish) context.getService(CustomerServiceReference);
		 
		//CommonPublish commonPublish = (CommonPublish) context.getService(CommonServiceReference);
		
	try {
		String username, password,choice,serviceName,time;
		double cash, balance;
		float serviceCharges;
		int serviceId,shopid;
		
	    
		
		SaloonPublish cusPublish = new SaloonPublishImpl();
		
		//CommonPublish cmpublish = new CommonPublishImpl();
		
		//cmpublish.defaultShopList();
		
		//while(true) {
			
		
		 
		//cmpublish.printShopList();
		
//		System.out.println("");
//		//System.out.print("\t\t\t\t\t\t");
//		System.out.print("<< Please enter the shop ID  >>");
//		Scanner scan = new Scanner(System.in);
//		shopid = scan.nextInt();
//		
//		
//		
//		if (shopid == 2) {
		
			
		cusPublish.defaultList();
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("");
			System.out.println("<< if you wont exit enter 'end' for username >>");
			System.out.println("");
			System.out.println("============================== Login ===================================");
			System.out.println("");
			System.out.print("Enter User Name : ");
			username = scanner.next();
			if( username.equals("end")) {
				System.out.println("Ending the Self Checkout For Beauty Services");
				CommonSubscriberActivator cSA = new CommonSubscriberActivator();
                cSA.start(context);
			}
			
			System.out.print("Enter Password : ");
			password = scanner.next();
			System.out.println("========================================================================\n");
			choice = cusPublish.LoginVerification(username, password);
			if(choice=="admin") {
				//System.out.print("\t\t\t\t\t\t");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Welcome ADMIN ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("");
				cusPublish.printServicesList();
				while(true) {
					System.out.println("");
					System.out.print("You want Add Service or Remove Service or logout (add / remove / logout) :");
					choice = scanner.next();
					
					if(choice.equals("add")) {
						
						System.out.println("Enter Service Name : ");
						serviceName = scanner.next();
	
						 
						System.out.println("Enter Service Charges : ");
						serviceCharges = scanner.nextFloat();

						
						cusPublish.addService(serviceName,serviceCharges);
						
						cusPublish.printServicesList();
					
					}else if(choice.equals("remove")) {
						
						System.out.print("Enter Service Id : ");
						serviceId = scanner.nextInt();
						cusPublish.removeService(serviceId);
						cusPublish.printServicesList();
					}else if(choice.equals("logout")) {
						break;
					}else {
						System.out.println("Error: Invalide input");
					}
				}
			}
			else if (choice == "customer") {
				//System.out.print("\t\t\t\t\t\t");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Welcome DEAR CUSTOMER ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				while(true) {
					double total =0;
					//System.out.print("\t\t\t\t\t\t");
					System.out.print("You want logout? (y / n) : ");
					choice = scanner.next();
					System.out.print("\n");
					if(choice.equals("y")) {
						
						System.out.print("Thanks for shop with Us. Come Again ");
						break;
					}else {
						cusPublish.printServicesList();
						System.out.println("");
						//System.out.print("\t\t\t\t\t\t");
						System.out.println("<< Please enter the service ID of the service/services which you plan to have or Enter 0 to get your total payment >>");
						System.out.println("");
						System.out.println("");
						 
						int count = 0;
						while(true) {
							System.out.println("");
							//System.out.print("\t\t\t\t\t\t");
							System.out.print("Enter the service Id / (end(0)): ");
						
							serviceId = scanner.nextInt();
							if(serviceId == 0) {
								break;
							}else if((serviceId<=cusPublish.getServicesListSize()) && serviceId>0) {
		
								total = total + cusPublish.calculateBill(serviceId, count);
							
								count++;
							}else {
								System.out.println("Error : invalid input");
							}
						}
						//System.out.print("\t\t\t\t\t\t");
						 
						System.out.println("__________________________________________Bill___________________________________________________");
						System.out.println("");
						//System.out.print("\t\t\t\t\t\t");
						System.out.println("Total Service charges = " + total);
						 
						 
//						System.out.println("===========================");
//						System.out.println("");
						System.out.println("");
					   // System.out.print("\t\t\t\t\t\t");
//						System.out.print("Enter Cash : " );
//						cash = scanner.nextFloat();
//						balance = cusPublish.calcBalance(total, cash);
//						System.out.println("");
//						System.out.print("\t\t\t\t\t\t");
//						System.out.println("Balance = " + balance);
//						System.out.println("");
//						System.out.print("\t\t\t\t\t\t");
						System.out.println("No of Servics = " + count);
						System.out.println("");
					    //System.out.print("\t\t\t\t\t\t");
						System.out.println("Scan your card on scanner");
						//System.out.print("\t\t\t\t\t\t");
						System.out.println("________________________________________________________________________________________________");
					}
				}
			}
			else {
				System.out.println("Incorrect login");
			}
		}
		//}
		//}
		
		
		
		
		
		
		
		
	}catch(Exception e) {
		
		System.out.println(e.getMessage());
	}
	
	
	
	
	
	
	}
	
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!!");
		context.ungetService(CustomerServiceReference);
		//context.ungetService(CommonServiceReference);
		
	}


}
