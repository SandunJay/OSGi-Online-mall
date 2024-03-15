package rentalpublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class RentalPublisherImpl implements RentalPublisher{
	
	Scanner sc = new Scanner(System.in);
	
	private ArrayList<Integer> coats = new ArrayList<>();
	private ArrayList<Integer> sarees = new ArrayList<>();
	private ArrayList<Integer> jackets = new ArrayList<>();
	private HashMap<Integer, String> bookingName = new HashMap<>();
	private HashMap<String, Double> bookprice = new HashMap<>();


	@Override
	public void rental() {
		// TODO Auto-generated method stub
		defItems();
		
		System.out.println("\n\n===================================================");
		System.out.println("|This is an seperate shop: You should Log in again|");
		System.out.println("===================================================");
		
		String userName,pwd;
		
		System.out.print("User Name : ");
		userName = sc.next();
		System.out.print("\nPassword: ");
		pwd = sc.next();
		
		if(userName.equalsIgnoreCase("Admin") && pwd.equalsIgnoreCase("Admin")) {
			admin();
		}
		else if(userName.equals("guest") && pwd.equalsIgnoreCase("guest")) {
			guest();
		}
		else {
			System.out.println("Pleace check you username and password and try angin 😞");
			rental();
		}
		
	}
	
	


	private void defItems() {
		// TODO Auto-generated method stub
		coats.add(1);
		coats.add(2);
		coats.add(3);
		coats.add(5);
		coats.add(7);
		
		sarees.add(22);
		sarees.add(24);
		sarees.add(25);
		sarees.add(26);
		
		jackets.add(102);
		jackets.add(106);
		jackets.add(105);
		
	}

	private void guest() {
		// TODO Auto-generated method stub
		int choose=0;
		System.out.println("=================Guest==================");
		System.out.println("1 - View Available items ");
		System.out.println("2 - Book Items");
		System.out.println("any - LogOut");
		System.out.println("=========================================");
		
		while(choose!=99) {
			System.out.println("Enter option Number : ");
			choose = sc.nextInt();
			
			if(choose==1) {
				availability();
				guest();
			}
			
			else if(choose==2) {
				bookItem();
				guest();
			}
			else {
				System.out.println("Pleace Enter Valid Number");
			}
		}
		rental();
		
	}


	private void admin() {
		// TODO Auto-generated method stub
		int choose=0;
		System.out.println("=============Admin==============");
		System.out.println("1 - View Availability ");
		System.out.println("2 - Add Items ");
		System.out.println("3 - Book Items");
		System.out.println("4 - View Bookings");
		System.out.println("any - LogOut");
		System.out.println("=========================================");
		while(choose!=99) {
			System.out.println("Enter option Number : ");
			choose = sc.nextInt();
			if(choose==1) {
				availability();
				admin();
			}
			else if(choose==2) {
				addRentalChoices();
			}
			else if(choose==3) {
				bookItem();
				admin();
			}
			else if(choose==4) {
				viewBookedItems();
				admin();
			}
			else {
				System.out.println("Pleace Enter Valid Number");
			}
			
		}
		rental();
		
	}


	private void addRentalChoices() {
		// TODO Auto-generated method stub
		int selection=0;
		System.out.println("============================================");
		System.out.println("1 - Coats");
		System.out.println("2 - Sarees");
		System.out.println("3 - Jackets");
		System.out.println("-1 - Quit");
		System.out.println("============================================");
		
		while(selection!=-1) {
			int item;
			
			System.out.println("Choose Rental Product : ");
			selection = sc.nextInt();
			
			if(selection==1) {
				System.out.println("Enter Coat Number : ");
				item = sc.nextInt();
				if(coatsCheck(item)) {
					System.out.println("This Coat alrady Available...");
				}
				else {
					coats.add(item);
					System.out.println("Coat No:"+item+" added success full..");
					
				}
				
			}
			else if(selection==2) {
				System.out.println("Enter Saree Number : ");
				item = sc.nextInt();
				if(sareesCheck(item)) {
					System.out.println("This Saree alrady Available...");
				}
				else {
					sarees.add(item);
					System.out.println("Saree No:"+item+" added success full..");
					
				}
				
			}
			
			
			else if(selection==3) {
				System.out.println("Enter Jacket Number : ");
				item = sc.nextInt();
				if(jacketCheck(item)) {
					System.out.println("This Jacket Available...");
				}
				else {
					jackets.add(item);
					System.out.println("Jacket No:"+item+" added success full..");
					
				}
				
			}
			else {
				System.out.println("Pleace enter valid Number!..........");
			}
		
		}
		availability();
		
	}


	private void availability() {
		// TODO Auto-generated method stub
		System.out.println("============Availability====================");
		System.out.println(coats.size()+" Available Coats: "+coats);
		System.out.println("============================================");
		System.out.println(sarees.size()+" Available Sarees: "+sarees);
		System.out.println("============================================");
		System.out.println(jackets.size()+" Available Jackets: "+jackets);
		System.out.println("============================================");
		
		bookItem();
		
	}


	private void bookItem() {
		// TODO Auto-generated method stub
		int selection=0;
		String name;
		double price =0;
		
		System.out.println("============================================");
		System.out.println("1 - Coats");
		System.out.println("2 - Sarees");
		System.out.println("3 - Jackets");
		System.out.println("any - Quit");
		System.out.println("============================================");
		
		System.out.println("Enter Recervation Name: ");
		name = sc.next();
		while(selection!=99) {
			int item;
			
			System.out.println("Choose Item : ");
			selection = sc.nextInt();
			
			if(selection==1) {
				System.out.println("Enter Coat Number : ");
				item = sc.nextInt();
				if(coatsCheck(item)) {
					System.out.println(name+"booked No:"+item+" Coat.");
					coats.remove(Integer.valueOf(item));
					bookingName.put(item, name);
					price = price + 1000;
					
					
					
				}
				else {
					System.out.println("Coat No:"+item+" Alrady Booked");
					
				}
				
			}
			
			else if(selection==2) {
				System.out.println("Enter Saree Number : ");
				item = sc.nextInt();
				if(sareesCheck(item)) {
					System.out.println(name+"booked No:"+item+" Saree.");
					sarees.remove(Integer.valueOf(item));
					bookingName.put(item, name);
					price = price + 1500;
				}
				else {
					System.out.println("Saree No:"+item+" Alrady Booked");
					
				}
				
			}
			
			
			else if(selection==3) {
				System.out.println("Enter Jacket Number : ");
				item = sc.nextInt();
				if(jacketCheck(item)) {
					System.out.println(name+"Jacket No:"+item+" Jacket.");
					jackets.remove(Integer.valueOf(item));
					bookingName.put(item, name);
					price = price + 2000;
				}
				else {
					System.out.println("Jacket No:"+item+" Alrady Booked");
					
				}	
			}
			else {
				System.out.println("Not valid Number!");
			}
		}
		//save price 
		if(price!=0) {
			System.out.println("You have to Pay : "+price);
			bookprice.put(name, price);
		}
		viewBookedItems();
		
	}


	private void viewBookedItems() {
		// TODO Auto-generated method stub
		Set<Map.Entry<String, Double>> set = bookprice.entrySet();
		for(Map.Entry<String, Double> i:set) {
			System.out.println("\n========================================================");
			System.out.println("Item Name: "+i.getKey()+"\nPayment : "+i.getValue());
			for(Map.Entry<Integer, String> bookingEntry: bookingName.entrySet()) {
				if(i.getKey().equals(bookingEntry.getValue())) {
					System.out.println("Item number: " + bookingEntry.getKey());
				}
			}
			System.out.println("==========================================================\n");
			
		}
		
	}


	private boolean sareesCheck(int item) {
		// TODO Auto-generated method stub
		for(int i=0; i<sarees.size(); i++) {
			if(sarees.get(i)==item) {
				return true;
			}
			
		}
		return false;
	}


	private boolean coatsCheck(int item) {
		// TODO Auto-generated method stub
		for(int i=0; i<coats.size(); i++) {
			if(coats.get(i)==item) {
				return true;
			}
			
		}
		return false;
	}


	private boolean jacketCheck(int item) {
		// TODO Auto-generated method stub
			for(int i=0; i<jackets.size(); i++) {
				if(jackets.get(i)==item) {
					return true;
				}
			}	
			
			return false;
	}

}
