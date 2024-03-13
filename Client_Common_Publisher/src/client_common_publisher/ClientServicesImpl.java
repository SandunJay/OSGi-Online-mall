package client_common_publisher;

import java.util.ArrayList;

public class ClientServicesImpl implements ClientServices{

//	public int storeSelection;
//	
//	@Override
//	public void login() {
//		// TODO Auto-generated method stub
//		System.out.println("Login Clients");
//		
//	}
//
//	@Override
//	public void selectStores() {
//		// TODO Auto-generated method stub
//		System.out.println("Select the store");
//		System.out.println("1 - Restaurant");
//		System.out.println("2 - Bla bla bla");
//		
//		
//		switch(storeSelection) {
//		case 1 :
//			
//		}
//		
//	}
//
//	@Override
//	public void logout() {
//		// TODO Auto-generated method stub
//		System.out.println("Logout clients");
//		
//	}

	
	ArrayList<String> shops = new ArrayList<String>();


	@Override
		
		public void defaultShopList() {
			
		   shops.add("Cinema");
			 
			
		   shops.add("Saloon");
			 
			
		   shops.add("Restaurant");
			 
			
		   shops.add("Clothing Store");
			
			 
	}

	@Override

	public void printShopList() {
		
		System.out.println("\t\t\t\t\t\t---------------------------------------Our Shop  List-----------------------------------------");
		System.out.println("");
		for (int i = 0; i < shops.size(); i++)
		  {
			System.out.print("\t\t\t\t\t\t ID :  ");
	        System.out.println(i+1 + "  " +shops.get(i)  );
	        System.out.println("");
	      }
		System.out.println("\t\t\t\t\t\t-------------------------------------------------------------------------------------------");
	}
}
