package moviecustomerproducer;

public interface MovieCustomerProducer {

	public String wellcome();
	public void insertProducerMovieCustomer(String name , String address , String email, String password);
	public String display();
	public void customerLogin(String name, String phone);
	public boolean loggingSucc();
	public String getMyName();
}
