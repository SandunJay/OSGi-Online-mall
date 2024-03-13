package restaurantadminpublisher;

import restaurantpublisher.Food;

public interface RestaurantAdminServices {
	
	public void displayFoodDetails();
	public void addFood();
	public void searchFood(String keyword);
	public void removeFood(int id);
	//public void updateFood();
	void updateFood(int id);

}
