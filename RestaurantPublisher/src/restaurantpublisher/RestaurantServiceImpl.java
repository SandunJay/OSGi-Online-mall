package restaurantpublisher;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class RestaurantServiceImpl implements RestaurantServicePublish {
    Scanner scanner = new Scanner(System.in);

    
    private static final String BASE_DIR = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/";
    private static final String[] FILE_NAMES = {"appetizers.txt", "main_courses.txt", "desserts.txt", "beverages.txt"};
    private static final String[] PREFIXES = {"A-", "M-", "D-", "B-"};
    private ArrayList<Food> foodItems = new ArrayList<>();
    private ArrayList<Integer> qty = new ArrayList<>();
    public int quantity;
    public String anythingElse;
    public float total;
    //private static final String FILE_NAME = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/food_details.txt";

    Food newFood;

    public RestaurantServiceImpl() {
        readMenuFromFile();
    }

    @Override
    public void order() {
        displayMenu();
        processOrder();
    }

//    public void displayMenu() {
//    	System.out.println("##################################################");
//        System.out.println("\n\nWelcome to the Restaurant Menu!\n");
//
//        // Display food items
////        for (int i = 0; i < foodItems.size(); i++) {
////            Food food = foodItems.get(i);
////            System.out.println((i + 1) + ". " + food.getName() + " - LKR " + food.getPrice());
////        }
////        System.out.println();
//        
//        System.out.println("Displaying food items...");
//        System.out.println("+----+------------------------------------+------------+");
//        System.out.println("| ID |        Item                        |  Price(LKR)");
//        System.out.println("+----+------------------------------------+------------+");
//        for (int i = 0; i < foodItems.size(); i++) {
//            Food food = foodItems.get(i);
//            System.out.printf("| %2d | %-34s |  LKR %.2f  |\n", (i + 1), food.getName(), food.getPrice());
//        }
//        System.out.println("+----+------------------------------------+------------+\n\n");
//    }

    public void displayCategories() {
    	System.out.println("\t\t\t\t\t\t\t 1 - Appetizers");
        System.out.println("\t\t\t\t\t\t\t 2 - Main Courses");
        System.out.println("\t\t\t\t\t\t\t 3 - Desserts");
        System.out.println("\t\t\t\t\t\t\t 4 - Beverages");
    }
    
    public void displayMenu() {
        System.out.println("\n\n\t\t\t\t\t\tMENU\n");

        System.out.println("\t\t\t\t\t\t------------------------------");
        System.out.println("\t\t\t\t\t\t\t  Category");
        System.out.println("\t\t\t\t\t\t------------------------------");
        displayCategories();
        System.out.println("\t\t\t\t\t\t------------------------------\n");

        System.out.println("Please select a category to view its items (enter category number 1-4):");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (categoryChoice < 1 || categoryChoice > 4) {
            System.out.println("Invalid category choice. Please select a number between 1 and 4.");
            return;
        }

        System.out.println("\t\t\t\t\t\tDisplaying food items for Category " + categoryChoice + ":");
        System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t|  Category  |   ID    |             Item                            |  Price(LKR)     ");
        System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(BASE_DIR + FILE_NAMES[categoryChoice - 1]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                // Skip items with quantity 0
                if (quantity == 0) {
                    continue;
                }

                System.out.printf("\t\t\t\t\t\t|  %-9s | %-7s | %-40s |  LKR %-8.2f \n", PREFIXES[categoryChoice - 1], id, name, price);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------------------\n");
    }





    
//    private void readMenuFromFile() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
//                String name = parts[1];
//                float price = Float.parseFloat(parts[2]);
//                foodItems.add(new Food(id, name, price));
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//    }
    
    private void readMenuFromFile() {
        try {
            for (int i = 0; i < 4; i++) {
                String fileName = BASE_DIR + FILE_NAMES[i];
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String id = parts[0];
                    String name = parts[1];
                    float price = Float.parseFloat(parts[2]);
                    int qty = Integer.parseInt(parts[3]);
                    foodItems.add(new Food(id, name, price, qty));
                }
                reader.close();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    
//    private void readMenuFromFile() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                String id = parts[0];
//                String name = parts[1];
//                float price = Float.parseFloat(parts[2]);
//                int qty = Integer.parseInt(parts[3]);
//                foodItems.add(new Food(id, name, price,qty));
//            }
//        } catch (IOException | NumberFormatException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//    }


//    public void displayFoodItems() {
//        System.out.println("Displaying food items...");
//        for (int i = 0; i < foodItems.size(); i++) {
//            Food food = foodItems.get(i);
//           // System.out.println((i + 1) + ". " + food.getName() + " - LKR " + food.getPrice());
//            System.out.printf("%2d. %-20s - LKR %.2f\n", (i + 1), food.getName(), food.getPrice());
//        }
//    }
    
    

    public void processOrder() {
        System.out.println("Please enter the food item ID:");
        String foodItemId = scanner.nextLine().trim(); // Read the food item ID as a string

        boolean found = false;
        for (int categoryNumber = 1; categoryNumber <= 4; categoryNumber++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(BASE_DIR + FILE_NAMES[categoryNumber - 1]))) {
                String line;
                StringBuilder updatedContent = new StringBuilder(); // To store the updated content for the file
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String id = parts[0].trim();
                    if (id.equals(foodItemId)) {
                        found = true;
                        String name = parts[1].trim();
                        float price = Float.parseFloat(parts[2].trim());
                        int quantity = Integer.parseInt(parts[3].trim());

                        System.out.println("Please enter the quantity:");
                        int orderQuantity = scanner.nextInt();

                        // Update total based on the selected food item and quantity
                        total += price * orderQuantity;

                        // Reduce the quantity of the selected food item
                        quantity -= orderQuantity;
                        if (quantity < 0) {
                            System.out.println("Error: Order quantity exceeds available stock.");
                            return;
                        }

                        // Append the updated line to the StringBuilder
                        updatedContent.append(String.format("%s,%s,%.2f,%d\n", id, name, price, quantity));
                    } else {
                        // Append unchanged line to the StringBuilder
                        updatedContent.append(line).append("\n");
                    }
                }

                // Write the updated content back to the file
                try (FileWriter writer = new FileWriter(BASE_DIR + FILE_NAMES[categoryNumber - 1])) {
                    writer.write(updatedContent.toString());
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("Food item with ID " + foodItemId + " not found.");
        }

        System.out.println("\nAnything else (Y/N)?");
        String anythingElse = scanner.next();

        if (anythingElse.equalsIgnoreCase("Y")) {
            displayMenu();
            processOrder();
        } else if (anythingElse.equalsIgnoreCase("N")) {
            System.out.println("\n\n\t\t\t\t\t\t============================\n");
            System.out.println("\t\t\t\t\t\tTotal bill : LKR " + total);
            System.out.println("\n\t\t\t\t\t\t\tTHANK YOU");
            System.out.println("\n\t\t\t\t\t\t============================\n\n");
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
            processOrder();
        }
    }







//    public void processOrder() {
//        System.out.println("Please enter the food item number:");
//        int foodItemNumber = scanner.nextInt();
//        if (foodItemNumber < 1 || foodItemNumber > foodItems.size()) {
//            System.out.println("\nInvalid food item number.");
//            processOrder();
//            return;
//        }
//
//        System.out.println("\nPlease enter the quantity:");
//        quantity = scanner.nextInt();
//        qty.add(quantity);
//
//        Food selectedFood = foodItems.get(foodItemNumber - 1);
//        total += selectedFood.getPrice() * quantity;
//
//        System.out.println("\nAnything else (Y/N)?");
//        anythingElse = scanner.next();
//
//        if (anythingElse.equalsIgnoreCase("Y")) {
//            processOrder();
//        } else if (anythingElse.equalsIgnoreCase("N")) {
//            System.out.println("\n\n============================\n");
//            System.out.println("Total bill : LKR " + total);
//            System.out.println("\n\tTHANK YOU");
//            System.out.println("\n============================\n\n");
//        } else {
//            System.out.println("Invalid input. Please enter Y or N.");
//            processOrder();
//        }
//    }
}
