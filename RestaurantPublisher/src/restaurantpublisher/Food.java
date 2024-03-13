package restaurantpublisher;

public class Food {

	private int id;
	private String name;
	private float price;
	
	
	public Food(int id,String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

//	public void addFood(int id,String name, float price) {
//		this.name = name;
//		this.price = price;
//	}
	
	public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}
