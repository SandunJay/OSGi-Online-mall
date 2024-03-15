package saloonpublisher;

public interface SaloonPublish {
	
	public void defaultList();
	public void printServicesList();
	public String LoginVerification(String username,String password);
	public void addService(String serviceName, float serviceCharges);
	public void removeService(int serviceId);
	public double calculateBill(int serviceId, int count);
	public int getServicesListSize();
	//public double calcBalance(double subTotal);
	

}
