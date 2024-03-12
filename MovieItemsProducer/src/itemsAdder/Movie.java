package itemsAdder;

public class Movie {

	private String movieID;
	private String movieName;
	private String movieCategory;
	private String moviePrice;
	private String avbSeats;
	

	public Movie() {
	}


	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieCategory() {
		return movieCategory;
	}
	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}
	public String getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(String moviePrice) {
		this.moviePrice = moviePrice;
	}
	public String getAvbSeats() {
		return avbSeats;
	}
	public void setAvbSeats(String ticketQty) {
		this.avbSeats = ticketQty;
	}
	
	
}
