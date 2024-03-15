package saloonpublisher;
import java.util.ArrayList;

public class SaloonPublishImpl implements SaloonPublish {
	
	ArrayList<String> services = new ArrayList<String>();
	 
	ArrayList<Float> serviceCharges = new ArrayList<Float>();
	
	
	@Override
	
	public void defaultList() {
		
		services.add("Haircutting and Styling");
		serviceCharges.add((float) 3000.00);
		
		services.add("Hair Care Treatments");
		serviceCharges.add((float) 5000.00);
		
		services.add("Manicures");
		serviceCharges.add((float) 9000.00);
		
		services.add("Pedicures");
		serviceCharges.add((float) 7000.00);
		
		services.add("Facial Treatments");
		serviceCharges.add((float) 9000.00);
		
		services.add("Waxing");
		serviceCharges.add((float) 3000.00);
		
		services.add("Makeup Application");
		serviceCharges.add((float) 6000.00);
		
		services.add("Eyebrow and Eyelash Services");
		serviceCharges.add((float) 2000.00);
		
		
	}
	
	@Override
	
	public void printServicesList() {
		
		System.out.println("---------------------------------------Services List-----------------------------------------");
		System.out.println("");
		for (int i = 0; i < serviceCharges.size(); i++)
		  {
			System.out.print("ID :  ");
	        System.out.println(i+1 + "  " +services.get(i) +" --- "+" --- "+" Service Charges : Rs:"+serviceCharges.get(i));
	        System.out.println("");
	      }
		System.out.println("-------------------------------------------------------------------------------------------");
	}
	
	@Override
	
	public String LoginVerification(String username,String password){
		if((username.equals("admin")) && (password.equals("123"))){
			return "admin";
		}
		else if((username.equals("customer")) && (password.equals("456"))) {
			return "customer";
		}else {
			return "invalid";
		}
	}
	
	@Override
	
	public void addService(String serviceName, float Charges){
		
		services.add(serviceName);
		 
		serviceCharges.add(Charges);
		
	}
	
	@Override
	
	public void removeService(int serviceId){
		services.remove(serviceId-1);
		serviceCharges.remove(serviceId-1);
		
	}
	
	@Override
	
	public double calculateBill(int serviceId, int count){
		
		double scharge = serviceCharges.get(serviceId-1);
		
		//System.out.print("\t\t\t\t\t\t");
		System.out.println((count+1) +") Service : "+ services.get(serviceId-1) +" --- "+ "Service Charges : " + scharge);
		
		
		return scharge;
		
	}
	
	@Override
	
	public int getServicesListSize(){
		
		return services.size();
	}
//	public double calcBalance(double subTotal){}
//	 
//
}
