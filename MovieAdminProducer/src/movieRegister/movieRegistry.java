package movieRegister;

public class movieRegistry {

	private String mName;
	private int duration;
	private String producer;
	private String rating;

	public movieRegistry() {
	}
	public movieRegistry(String dName, int duration, String producer, String rating) {
		super();
		this.mName = dName;
		this.duration = duration;
		this.producer = producer;
		this.rating = rating;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "movieRegistry [mName=" + mName + ", duration=" + duration + ", producer=" + producer + ", rating="
				+ rating + "]";
	}

	
}
