package restaurantadminpublisher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import restaurantpublisher.Food;

public class RestaurantAdminServicesImpl implements RestaurantAdminServices {

	private static final String FILE_NAME = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/food_details.txt";

    //private static final String FILE_NAME = "food_details.txt";
    private List<Food> foodItems;

    public RestaurantAdminServicesImpl() {
        // Initialize the list of food items
        this.foodItems = new ArrayList<>();
        // Load existing food details from file
        loadFoodDetails();
    }

    @Override
    public void displayFoodDetails() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(FILE_NAME));

            // Display header
            System.out.printf("%-5s %-20s %-10s\n", "ID", "Item", "Price (LKR)");
            System.out.println("------------------------------------------");

            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);
                    System.out.printf("%-5d %-20s %-10.2f\n", id, name, price);
                }
            }
            System.out.println();
            System.out.println("------------------------------------------\n");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }


    
    private int getNextId() {
        // If foodItems list is empty, return 1 as the first ID
        if (foodItems.isEmpty()) {
            return 1;
        } else {
            // Find the maximum ID in the list and increment it by 1 to get the next ID
            int maxId = foodItems.stream().mapToInt(Food::getId).max().orElse(0);
            return maxId + 1;
        }
    }

    
//    private int getNextId() {
//        // If foodItems list is empty, return 1 as the first ID
//        if (foodItems.isEmpty()) {
//            return 1;
//        } else {
//            // Find the maximum ID in the list and increment it by 1 to get the next ID
//            int maxId = foodItems.stream().mapToInt(Food::getId).max().orElse(0);
//            return maxId + 1;
//        }
//    }
    
//    private int getNextId() {
//        int maxId = 0;
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                int currentId = Integer.parseInt(parts[0]);
//                if (currentId > maxId) {
//                    maxId = currentId;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return maxId + 1; // Increment the max ID to get the next available ID
//    }
    
//    private int getNextId() {
//        // If foodItems list is empty, return 1 as the first ID
//        if (foodItems.isEmpty()) {
//            return 1;
//        } else {
//            // Find the maximum ID in the list and increment it by 1 to get the next ID
//            int maxId = foodItems.stream().mapToInt(Food::getId).max().orElse(0);
//            return maxId + 1;
//        }
//    }
    
//    private int getNextId() {
//        // Calculate the length of the foodItems list
//        int count = foodItems.size();
//        
//        // Increment the count by 1 to get the next ID
//        return count + 1;
//    }


    
    
    
    
    
    @Override
    public void addFood() {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter the name of the food (or enter -99 to stop adding):");
            String name = scanner.nextLine();

            // Check if the user wants to stop adding food items
            if (name.equals("-99")) {
                break;
            }

            System.out.println("\nEnter the price of the food:");
            float price = scanner.nextFloat();
            scanner.nextLine(); // Consume the newline character

            // Increment the internal counter to get the next ID
            int nextId = getNextId();
            //System.out.println(nextId);

            // Create a new Food object with the provided details and the next available ID
            Food newFood = new Food(nextId, name, price);

            //System.out.println(newFood);
            // Add the new food item to the list
            foodItems.add(newFood);

            // Save the updated list to file
            saveFoodDetails();
        }

        System.out.println("\nNew food items added successfully.\n");
    }


    



//    @Override
//    public void addFood() {
//        // Create a Scanner object to read user input
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Enter the name of the food (or enter -99 to stop adding):");
//            String name = scanner.nextLine();
//
//            // Check if the user wants to stop adding food items
//            if (name.equals("-99")) {
//                break;
//            }
//
//            System.out.println("Enter the price of the food:");
//            float price = scanner.nextFloat();
//            scanner.nextLine(); // Consume the newline character
//
//            // Determine the ID for the new food item
//            int nextId = foodItems.isEmpty() ? 1 : foodItems.get(foodItems.size() - 1).getId() + 1;
//
//            // Create a new Food object with the provided details
//            Food newFood = new Food(nextId, name, price);
//
//            // Add the new food item to the list
//            foodItems.add(newFood);
//        }
//
//        // Save the updated list to file
//        saveFoodDetails();
//
//        System.out.println("New food items added successfully.");
//    }

    private void saveFoodDetails() {
        // Save food details to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Food food : foodItems) {
                writer.write(food.getId() + "," + food.getName() + "," + food.getPrice() + "\n");
                //System.out.println(food.getId() + "," + food.getName() + "," + food.getPrice() + "\n");
            }
        } catch (IOException e) {
            // Handle IO exception
            e.printStackTrace();
        }
    }


    @Override
    public void searchFood(String keyword) {
        System.out.println("Searching for food items with keyword: " + keyword);
        
        boolean found = false;
        
        for (Food food : foodItems) {
            if (food.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(food);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No food items found matching the keyword: " + keyword);
        }
    }


    @Override
    public void removeFood(int id) {
        System.out.println("Removing food item with ID: " + id);
        
        // Remove the food item with the given ID from the list
        foodItems.removeIf(food -> food.getId() == id);
        
        // Save the updated list to file
        saveFoodDetails();
        
        System.out.println("Food item removed successfully.");
        
    }
    

   


    @Override
    public void updateFood(int id) {
        if (!foodItems.isEmpty()) {
            // Find the food item with the specified ID
            Food foodToUpdate = null;
            for (Food food : foodItems) {
                if (food.getId() == id) {
                    foodToUpdate = food;
                    break;
                }
            }
            
            // If the item is found, prompt the user for updated details
            if (foodToUpdate != null) {
                Scanner scanner = new Scanner(System.in);
                
                System.out.println("Enter the new name for the food item:");
                String newName = scanner.nextLine();
                
                System.out.println("Enter the new price for the food item:");
                float newPrice = scanner.nextFloat();
                
                // Update the details of the food item
                foodToUpdate.setName(newName);
                foodToUpdate.setPrice(newPrice);
                
                // Save the updated list to file
                saveFoodDetails();
                System.out.println("Food details updated successfully.");
            } else {
                System.out.println("Food item with ID " + id + " not found.");
            }
        } else {
            System.out.println("No food items to update.");
        }
    }



    private void loadFoodDetails() {
        // Read food details from the file and populate the list
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                Food food = new Food(id, name, price);
                foodItems.add(food);
            }
        } catch (IOException e) {
            // Handle IO exception
            e.printStackTrace();
        }
    }

//    private void saveFoodDetails() {
//        // Save food details to the file
//        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
//            for (Food food : foodItems) {
//                writer.println(food.getId() + "," + food.getName() + "," + food.getPrice());
//            }
//        } catch (IOException e) {
//            // Handle IO exception
//            e.printStackTrace();
//        }
//    }
    
//    private void saveFoodDetails() {
//        // Save food details to the file
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
//            for (Food food : foodItems) {
//                writer.write(food.getId() + "," + food.getName() + "," + food.getPrice() + "\n");
//            }
//            // Clear the foodItems list after writing to the file
//            foodItems.clear();
//        } catch (IOException e) {
//            // Handle IO exception
//            e.printStackTrace();
//        }
//    }


}
