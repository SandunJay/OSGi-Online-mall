//package restaurantpublisher;
//
//public class Food {
//
//	private int id;
//	private String name;
//	private float price;
//	private int qty;
//	
//	
//	public Food(int id,String name, float price, int qty) {
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.qty = qty;
//	}
//
////	public void addFood(int id,String name, float price) {
////		this.name = name;
////		this.price = price;
////	}
//	
//	public int getId() {
//        return id;
//    }
//    
//    public void setId(int id) {
//        this.id = id;
//    }
//
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/**
//	 * @return the price
//	 */
//	public float getPrice() {
//		return price;
//	}
//
//	/**
//	 * @param price the price to set
//	 */
//	public void setPrice(float price) {
//		this.price = price;
//	}
//	
//	@Override
//    public String toString() {
//        return "ID: " + id + ", Name: " + name + ", Price: " + price;
//    }
//
//	public int getQty() {
//		return qty;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
//}


package restaurantpublisher;

public class Food {

    private String id;
    private String name;
    private float price;
    private int availableQty;
    
    public Food(String id, String name, float price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availableQty = qty;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public int getQty() {
        return availableQty;
    }
    
    public void setQty(int qty) {
        this.availableQty = qty;
    }
    
    public void addQuantity(int quantity) {
        this.availableQty += quantity;
    }
    
    public void removeQuantity(int quantity) {
        if (this.availableQty >= quantity) {
            this.availableQty -= quantity;
        } else {
            System.out.println("Error: Insufficient quantity available.");
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + availableQty;
    }
}
