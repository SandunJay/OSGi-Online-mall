package commonpublisher;

import java.util.ArrayList;

public class CommonPublishImpl implements CommonPublish{
	
	ArrayList<String> shops = new ArrayList<String>();

	@Override
	public void defaultShopList() {
		// TODO Auto-generated method stub
		   shops.add("Cinema");
			 
			
		   shops.add("Saloon");
			 
			
		   shops.add("Restaurant");
			 
			
		   shops.add("Clothing Store");
		
	}

	@Override
	public void printShopList() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------Our Shop  List-----------------------------------------");
		System.out.println("");
		for (int i = 0; i < shops.size(); i++)
		  {
			System.out.print("ID :  ");
	        System.out.println(i+1 + "  " +shops.get(i)  );
	        System.out.println("");
	      }
		
	}

}
