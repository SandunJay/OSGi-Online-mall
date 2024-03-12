package movieitemsproducer;

public interface MovieItemProducer {
	public void moviecustomerwellcome();
	public void getAllMovies();
	public void searchMovieByCategory(String category);
	public void searchMovieByID(String id);
	public boolean isEmptyCategoryMsg();
	public boolean invalidIDMsg();
	public boolean checkQty(String icID,String icQty);
	public void addToBill(String CName, String iID, String iQty);
	public void showMyBill();
	public void AddtoBillRegister(String deliverStatus);
	
	
	//Admin
	public void addMovies(String movieID,String movieName,String movieCategory,String moviePrice,String avbSeats);
	public boolean itemSaveSucc();

}
