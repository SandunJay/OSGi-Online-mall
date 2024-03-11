package movieadminproducer;

public interface MovieAdminProducer {

	public String welcomeMsg();
	public void insertMovies(String name, int duration, String producer, String rating);
	public String DisplayMovies();
	public void ViewAllMovies();
	
}
