package moviecustomerconsumer;

import java.util.Scanner;
import moviecustomerproducer.MovieCustomerProducer;
import movieitemsproducer.MovieItemProducer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class MovieCustomerConsumerActivator implements BundleActivator {

	boolean check = false;
	ServiceReference serviceReference,serviceReference2,serviceReferencecustomerItems;

	public void start(BundleContext context) throws Exception {
		String decision = "y";
		Scanner sc = new Scanner(System.in);
		boolean logingSuccMsg = false;
		
		System.out.println("Start Consumer Service");
		serviceReference = context.getServiceReference(MovieCustomerProducer.class.getName());
		MovieCustomerProducer movieCustomerProducer = (MovieCustomerProducer) context.getService(serviceReference);
		
		serviceReferencecustomerItems = context.getServiceReference(MovieItemProducer.class.getName());
		MovieItemProducer movieItemsProducer = (MovieItemProducer) context.getService(serviceReferencecustomerItems);
		
		
		
		System.out.println(movieCustomerProducer.wellcome());
		
		while(logingSuccMsg==false) {
			logingSuccMsg = movieCustomerProducer.loggingSucc();
			if(logingSuccMsg==true) {
				break;
			}
			do{
				System.out.println("You Have a Account ?(Y/N)");
				decision = sc.next();
				if(decision.equals("Y")||decision.equals("y")) {
					System.out.println("_________________________________ Cinema Customer Login _________________________________\n");
					System.out.println("Enter Your Name ?");
					String bcName = sc.next();
					System.out.println("Enter Your Phone Number ?");
					String bcPhone = sc.next();
					movieCustomerProducer.customerLogin(bcName, bcPhone);	
					
					break;
				}else if(decision.equals("N")||decision.equals("n")) {
					System.out.println("_________________________________ Cinema Customer Registration _________________________________\n");
					System.out.println("Enter Your Name ?");
					String bcName = sc.next();
					System.out.println("Enter Your Phone Number ?");
					String bcPhone = sc.next();
					System.out.println("Enter Your Email ?");
					String bcEmail = sc.next();
					System.out.println("Enter Your Address ?");
					String bcAddress = sc.next();
					movieCustomerProducer.insertProducerMovieCustomer(bcName, bcAddress , bcEmail, bcPhone);
					
					break;
				}else {
				
					System.out.println("Wrong Input!!");
				}
				
				
			}while(!decision.equals("Y")||!decision.equals("y")|| !decision.equals("N")||!decision.equals("n"));
		}
			String buyItemsDecision = "y";
			while(buyItemsDecision.equals("y")||buyItemsDecision.equals("Y")) {
				System.out.println("Do you Want To Buy Tickets ?(Y/N)");
				buyItemsDecision = sc.next();
				if(buyItemsDecision.equals("n")||buyItemsDecision.equals("N")) {
					
					if(check == true) {
						movieItemsProducer.showMyBill();
					}
					
					break;
				}
				movieItemsProducer.moviecustomerwellcome();
				System.out.println("Select a movie from the list:");
				movieItemsProducer.getAllMovies();
				System.out.println("Choose a Category ?");
				String iCategory = sc.next();
				movieItemsProducer.searchMovieByCategory(iCategory);
				boolean isCategoryEmpty=movieItemsProducer.isEmptyCategoryMsg();
				if(isCategoryEmpty==false) {
					String buyAnItemsDecision = "y";
					while(buyAnItemsDecision.equals("y")||buyAnItemsDecision.equals("Y")) {
						System.out.println("Do you Want To Buy movie tickets under this catogery ?(Y/N)");
						buyAnItemsDecision = sc.next();
						if(buyAnItemsDecision.equals("n")||buyAnItemsDecision.equals("N")) {
							break;
						}
						System.out.println("Enter Item ID ?");
						String iID = sc.next();
						movieItemsProducer.searchMovieByID(iID);
						String buyAnItemDecision = "y";
						while(buyAnItemDecision.equals("y")||buyAnItemDecision.equals("Y")) {
							System.out.println("Do you Want To Buy Item ?(Y/N)");
							buyAnItemDecision = sc.next();
							if(buyAnItemDecision.equals("n")||buyAnItemDecision.equals("N")) {
								break;
							}
							boolean qtyCheck = false;
							while(qtyCheck == false) {
								System.out.println("How many Qty you Need ?");
								String icQty = sc.next();
								qtyCheck=movieItemsProducer.checkQty(iID,icQty);
								if(qtyCheck == true) {
									//AddtoBill
									String myName=movieCustomerProducer.getMyName();
									movieItemsProducer.addToBill(myName, iID, icQty);
									check = true;
									break;
								}
								if(qtyCheck == false) {
									System.out.println("No Qty Available for this Request! and try less Qty");
									continue;
								}
								
							}
							
							
						}
					}
					
				}
			}
			
			
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Customer Consumer Stop !!!");
		if(serviceReference != null) {
			context.ungetService(serviceReference);
		}
		if(serviceReference2 != null) {
			context.ungetService(serviceReference2);
		}
		if(serviceReferencecustomerItems != null) {
			context.ungetService(serviceReferencecustomerItems);
		}
		
	}

}
