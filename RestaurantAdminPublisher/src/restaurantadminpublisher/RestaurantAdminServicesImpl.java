package restaurantadminpublisher;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import restaurantpublisher.Food;

public class RestaurantAdminServicesImpl implements RestaurantAdminServices {

    private static final String BASE_DIR = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/";
    private static final String[] FILE_NAMES = {"appetizers.txt", "main_courses.txt", "desserts.txt", "beverages.txt"};
    private static final String[] PREFIXES = {"A-", "M-", "D-", "B-"};
    private List<Food>[] foodItems; // Array of ArrayLists for each category

    
    Scanner scanner = new Scanner(System.in);
    
    
    public RestaurantAdminServicesImpl() {
        // Initialize the lists of food items for each category
        this.foodItems = new ArrayList[4]; // Initialize array for 4 categories
        for (int i = 0; i < 4; i++) {
            this.foodItems[i] = new ArrayList<>();
            // Load existing food details from file for each category
            loadFoodDetails(i);
        }
    }

    @Override
    public void displayFoodDetails() {
    	
    	System.out.printf("\t\t\t\t\t\t%-8s %-20s %-12s %-5s\n", "ID", "Item", "Price (LKR)", "Quantity");
    	System.out.println("\t\t\t\t\t\t--------------------------------------------------");
        for (int i = 0; i < 4; i++) {
        	if((i + 1) == 1) {
        		System.out.println("\n\t\t\t\t\t\t1 - Appetizers");
        	}else if((i + 1) == 2) {
        		System.out.println("\n\t\t\t\t\t\t2 - Main Courses");
        	}else if((i + 1) == 3) {
        		System.out.println("\n\t\t\t\t\t\t3 - Desserts");
        	}else if((i + 1) == 4) {
        		System.out.println("\n\t\t\t\t\t\t4 - Beverages");
        	}else {
        		System.out.println("Wrong category number");
        	}
            
            
            for (Food food : foodItems[i]) {
                System.out.printf("\t\t\t\t\t\t%-8s %-20s %-12.2f %-5d\n", food.getId(), food.getName(), food.getPrice(), food.getQty());
            }
            System.out.println("\t\t\t\t\t\t--------------------------------------------------\n");
        }
    }
    
    public void displayCategories() {
    	System.out.println("1 - Appetizers");
        System.out.println("2 - Main Courses");
        System.out.println("3 - Desserts");
        System.out.println("4 - Beverages");
    }

    @Override
    public void addNewFood() {
        

        System.out.println("\nEnter the category of the food (1-4):");
        displayCategories();
        int category = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (true) {
            System.out.println("\nEnter the name of the food (or enter -99 to stop adding):");
            String name = scanner.nextLine();

            if (name.equals("-99")) {
                break;
            }

            System.out.println("\nEnter the price of the food:");
            float price = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline character

            System.out.println("\nEnter the quantity of the food:");
            int qty = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            String nextId = getNextId(category);

            Food newFood = new Food(nextId, name, price, qty);
            foodItems[category - 1].add(newFood);

            saveFoodDetails(category - 1); // Save details for the relevant category
        }

        System.out.println("\nNew food items added successfully.\n");
    }
    
    

    @Override
    public void updateFood() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the category number:");
        int categoryNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate category number
        if (categoryNumber < 1 || categoryNumber > 4) {
            System.out.println("Invalid category number.");
            return;
        }

        //System.out.println("Displaying food items for Category " + categoryNumber + ":");
        if(categoryNumber == 1) {
    		System.out.println("\n\t\t\t\t\t\t1 - Appetizers");
    	}else if(categoryNumber== 2) {
    		System.out.println("\n\t\t\t\t\t\t2 - Main Courses");
    	}else if(categoryNumber == 3) {
    		System.out.println("\n\t\t\t\t\t\t3 - Desserts");
    	}else if(categoryNumber == 4) {
    		System.out.println("\n\t\t\t\t\t\t4 - Beverages");
    	}else {
    		System.out.println("Wrong category number");
    	}
        
        
        System.out.println("Search results:");
	    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t| ID |              Item                    |  Price(LKR)|  Quantity  ");
        System.out.println("Search results:");
	    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");
        for (Food food : foodItems[categoryNumber - 1]) {
            System.out.printf("\t\t\t\t\t\t| %-2s | %-34s |  LKR %-8.2f | %-10d |\n", food.getId(), food.getName(), food.getPrice(), food.getQty());
        }
        System.out.println("Search results:");
	    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");

        // Find the food item to update
        System.out.println("Please enter the food item ID:");
        String id = scanner.nextLine();

        for (Food food : foodItems[categoryNumber - 1]) {
            if (food.getId().equals(id)) {
                System.out.println("Food found in Category " + categoryNumber);
                System.out.println("Do you want to update the name? (yes/no)");
                String updateName = scanner.nextLine().toLowerCase();
                if (updateName.equals("yes")) {
                    System.out.println("Enter the new name for the food item:");
                    String newName = scanner.nextLine();
                    food.setName(newName);
                }

                System.out.println("Do you want to update the price? (yes/no)");
                String updatePrice = scanner.nextLine().toLowerCase();
                if (updatePrice.equals("yes")) {
                    System.out.println("Enter the new price for the food item:");
                    float newPrice = scanner.nextFloat();
                    scanner.nextLine();
                    food.setPrice(newPrice);
                }

                System.out.println("Do you want to update the quantity? (yes/no)");
                String updateQuantity = scanner.nextLine().toLowerCase();
                if (updateQuantity.equals("yes")) {
                    System.out.println("Enter the new quantity for the food item:");
                    int newQuantity = scanner.nextInt();
                    food.setQty(newQuantity);
                }

                saveFoodDetails(categoryNumber - 1); // Save details for the relevant category
                System.out.println("Food details updated successfully.");
                return;
            }
        }

        System.out.println("Food item with ID " + id + " not found in Category " + categoryNumber + ".");
    }



    private String getNextId(int category) {
        if (foodItems[category - 1].isEmpty()) {
            return "1";
        } else {
            int maxId = foodItems[category - 1].stream().mapToInt(f -> Integer.parseInt(f.getId())).max().orElse(0);
            return String.valueOf(maxId + 1);
        }
    }


    private void saveFoodDetails(int category) {
        String fileName = BASE_DIR + FILE_NAMES[category];

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Food food : foodItems[category]) {
                writer.write(food.getId() + "," + food.getName() + "," + food.getPrice() + "," + food.getQty() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFoodDetails(int category) {
        String fileName = BASE_DIR + FILE_NAMES[category];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                int qty = Integer.parseInt(parts[3]);
                Food food = new Food(id, name, price, qty);
                foodItems[category].add(food);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void searchFood() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Please enter a keyword to search for in food items:");
	    String keyword = scanner.nextLine().toLowerCase();

	    boolean found = false;

	    System.out.println("Search results:");
	    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");
	    System.out.println("\t\t\t\t\t\t| Category | ID |              Item                    |  Price(LKR)|  Quantity  ");
	    System.out.println("Search results:");
	    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");

	    // Iterate through each category
	    for (int i = 0; i < 4; i++) {
	        // Iterate through each food item in the category
	        for (Food food : foodItems[i]) {
	            // Check if the food item's name contains the keyword
	            if (food.getName().toLowerCase().contains(keyword)) {
	                // Display the food item details
	                System.out.printf("\t\t\t\t\t\t| %-9s | %-2s | %-34s |  LKR %-8.2f | %-10d |\n", PREFIXES[i], food.getId(), food.getName(), food.getPrice(), food.getQty());
	                found = true;
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("\t\t\t\t\t\tNo matching food items found.");
	    } else {
	    	System.out.println("Search results:");
		    System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");
	    }
	}



	@Override
	public void removeFood() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Please enter the category number:");
	    displayCategories();
	    
	    int categoryNumber = scanner.nextInt();
	    scanner.nextLine(); // Consume newline

	    // Validate category number
	    if (categoryNumber < 1 || categoryNumber > 4) {
	        System.out.println("Invalid category number.");
	        return;
	    }

	    //System.out.println("Displaying food items for Category " + categoryNumber + ":");
	    if(categoryNumber == 1) {
    		System.out.println("\n\t\t\t\t\t\t1 - Appetizers");
    	}else if(categoryNumber== 2) {
    		System.out.println("\n\t\t\t\t\t\t2 - Main Courses");
    	}else if(categoryNumber == 3) {
    		System.out.println("\n\t\t\t\t\t\t3 - Desserts");
    	}else if(categoryNumber == 4) {
    		System.out.println("\n\t\t\t\t\t\t4 - Beverages");
    	}else {
    		System.out.println("Wrong category number");
    	}
	    System.out.println("\t\t\t\t\t\t--------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t| ID |              Item                    |  Price(LKR)|  Quantity  ");
        System.out.println("\t\t\t\t\t\t---------------------------------------------------------------------");
        for (Food food : foodItems[categoryNumber - 1]) {
            System.out.printf("\t\t\t\t\t\t| %-2s | %-34s |  LKR %-8.2f | %-10d |\n", food.getId(), food.getName(), food.getPrice(), food.getQty());
        }
        System.out.println("\t\t\t\t\t\t---------------------------------------------------------------------");

	    // Find the food item to remove
	    System.out.println("Please enter the food item ID to remove:");
	    String id = scanner.nextLine();

	    System.out.println("Are you sure you want to delete this food item? (yes/no)");
	    String confirmDelete = scanner.nextLine().toLowerCase();

	    if (confirmDelete.equals("yes")) {
	        // Remove the food item
	        Iterator<Food> iterator = foodItems[categoryNumber - 1].iterator();
	        while (iterator.hasNext()) {
	            Food food = iterator.next();
	            if (food.getId().equals(id)) {
	                iterator.remove();
	                System.out.println("Food item with ID " + id + " removed successfully from Category " + categoryNumber);
	                saveFoodDetails(categoryNumber - 1); // Save details for the relevant category after removal
	                return;
	            }
	        }
	        System.out.println("Food item with ID " + id + " not found in Category " + categoryNumber);
	    } else if (confirmDelete.equals("no")) {
	        System.out.println("Deletion canceled.");
	    } else {
	        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
	    }
	}

}





//package restaurantadminpublisher;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import restaurantpublisher.Food;
//
//public class RestaurantAdminServicesImpl implements RestaurantAdminServices {
//
//    private static final String BASE_DIR = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/";
//    private static final String[] FILE_NAMES = {"food_details_category1.txt", "food_details_category2.txt", "food_details_category3.txt", "food_details_category4.txt"};
//    private static final String[] PREFIXES = {"CAT1", "CAT2", "CAT3", "CAT4"};
//    private List<Food>[] foodItems; // Array of ArrayLists for each category
//
//    public RestaurantAdminServicesImpl() {
//        // Initialize the lists of food items for each category
//        this.foodItems = new ArrayList[4]; // Initialize array for 4 categories
//        for (int i = 0; i < 4; i++) {
//            this.foodItems[i] = new ArrayList<>();
//            // Load existing food details from file for each category
//            loadFoodDetails(i);
//        }
//    }
//
//    @Override
//    public void displayFoodDetails() {
//    	
//    	System.out.printf("%-8s %-20s %-12s %-5s\n", "ID", "Item", "Price (LKR)", "Quantity");
//    	System.out.println("--------------------------------------------------");
//        for (int i = 0; i < 4; i++) {
//            System.out.println("\nCategory " + (i + 1) );
//            
//            for (Food food : foodItems[i]) {
//                System.out.printf("%-8s %-20s %-12.2f %-5d\n", PREFIXES[i] + food.getId(), food.getName(), food.getPrice(), food.getQty());
//            }
//            //System.out.println("--------------------------------------------------");
//        }
//    }
//
//    @Override
//    public void addNewFood() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("\nEnter the category of the food (1-4):");
//        int category = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//
//        while (true) {
//            System.out.println("\nEnter the name of the food (or enter -99 to stop adding):");
//            String name = scanner.nextLine();
//
//            if (name.equals("-99")) {
//                break;
//            }
//
//            System.out.println("\nEnter the price of the food:");
//            float price = scanner.nextFloat();
//            scanner.nextLine(); // Consume the newline character
//
//            System.out.println("\nEnter the quantity of the food:");
//            int qty = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline character
//            
//            int nextId = getNextId(category);
//
//            Food newFood = new Food(nextId, name, price, qty);
//            foodItems[category - 1].add(newFood);
//
//            saveFoodDetails(category - 1); // Save details for the relevant category
//        }
//
//        System.out.println("\nNew food items added successfully.\n");
//    }
//
//    @Override
//    public void updateFood(int id) {
//        Scanner scanner = new Scanner(System.in);
//
//        for (int i = 0; i < 4; i++) {
//            for (Food food : foodItems[i]) {
//                if (food.getId() == id) {
//                    System.out.println("Food found in Category " + (i + 1));
//                    System.out.println("Do you want to update the name? (yes/no)");
//                    String updateName = scanner.nextLine().toLowerCase();
//                    if (updateName.equals("yes")) {
//                        System.out.println("Enter the new name for the food item:");
//                        String newName = scanner.nextLine();
//                        food.setName(newName);
//                    }
//
//                    System.out.println("Do you want to update the price? (yes/no)");
//                    String updatePrice = scanner.nextLine().toLowerCase();
//                    if (updatePrice.equals("yes")) {
//                        System.out.println("Enter the new price for the food item:");
//                        float newPrice = scanner.nextFloat();
//                        food.setPrice(newPrice);
//                    }
//
//                    System.out.println("Do you want to update the quantity? (yes/no)");
//                    String updateQuantity = scanner.nextLine().toLowerCase();
//                    if (updateQuantity.equals("yes")) {
//                        System.out.println("Enter the new quantity for the food item:");
//                        int newQuantity = scanner.nextInt();
//                        food.setQty(newQuantity);
//                    }
//
//                    saveFoodDetails(i); // Save details for the relevant category
//                    System.out.println("Food details updated successfully.");
//                    return;
//                }
//            }
//        }
//
//        System.out.println("Food item with ID " + id + " not found.");
//    }
//
////    private int getNextId(int category) {
////        if (foodItems[category - 1].isEmpty()) {
////            return 1;
////        } else {
////            int maxId = foodItems[category - 1].stream().mapToInt(Food::getId).max().orElse(0);
////            return maxId + 1;
////        }
////    }
//    
//    private int getNextId(int category) {
//        if (foodItems[category - 1].isEmpty()) {
//            return 1;
//        } else {
//            int maxId = foodItems[category - 1].stream().mapToInt(Food::getId).max().orElse(0);
//            return maxId + 1;
//        }
//    }
//
//
//    private void saveFoodDetails(int category) {
//        String fileName = BASE_DIR + FILE_NAMES[category];
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (Food food : foodItems[category]) {
//                writer.write(food.getId() + "," + food.getName() + "," + food.getPrice() + "," + food.getQty() + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void loadFoodDetails(int category) {
//        String fileName = BASE_DIR + FILE_NAMES[category];
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
//                String name = parts[1];
//                float price = Float.parseFloat(parts[2]);
//                int qty = Integer.parseInt(parts[3]);
//                Food food = new Food(id, name, price, qty);
//                foodItems[category].add(food);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//	@Override
//	public void searchFood(String keyword) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeFood(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//}
