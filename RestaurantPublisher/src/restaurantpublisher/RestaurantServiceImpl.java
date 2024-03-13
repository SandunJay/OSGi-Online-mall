package restaurantpublisher;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class RestaurantServiceImpl implements RestaurantServicePublish {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<Food> foodItems = new ArrayList<>();
    private ArrayList<Integer> qty = new ArrayList<>();
    public int quantity;
    public String anythingElse;
    public float total;
    private static final String FILE_NAME = "C:/Projects/RestaurantAdminPublisher/src/restaurantadminpublisher/food_details.txt";

    Food newFood;

    public RestaurantServiceImpl() {
        readMenuFromFile();
    }

    @Override
    public void order() {
        displayMenu();
        processOrder();
    }

    public void displayMenu() {
    	System.out.println("##################################################");
        System.out.println("\n\nWelcome to the Restaurant Menu!\n");

        // Display food items
//        for (int i = 0; i < foodItems.size(); i++) {
//            Food food = foodItems.get(i);
//            System.out.println((i + 1) + ". " + food.getName() + " - LKR " + food.getPrice());
//        }
//        System.out.println();
        
        System.out.println("Displaying food items...");
        System.out.println("+----+------------------------------------+------------+");
        System.out.println("| ID |        Item                        |  Price(LKR)");
        System.out.println("+----+------------------------------------+------------+");
        for (int i = 0; i < foodItems.size(); i++) {
            Food food = foodItems.get(i);
            System.out.printf("| %2d | %-34s |  LKR %.2f  |\n", (i + 1), food.getName(), food.getPrice());
        }
        System.out.println("+----+------------------------------------+------------+\n\n");
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
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);
                foodItems.add(new Food(id, name, price));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


//    public void displayFoodItems() {
//        System.out.println("Displaying food items...");
//        for (int i = 0; i < foodItems.size(); i++) {
//            Food food = foodItems.get(i);
//           // System.out.println((i + 1) + ". " + food.getName() + " - LKR " + food.getPrice());
//            System.out.printf("%2d. %-20s - LKR %.2f\n", (i + 1), food.getName(), food.getPrice());
//        }
//    }
    
    


    public void processOrder() {
        System.out.println("Please enter the food item number:");
        int foodItemNumber = scanner.nextInt();
        if (foodItemNumber < 1 || foodItemNumber > foodItems.size()) {
            System.out.println("\nInvalid food item number.");
            processOrder();
            return;
        }

        System.out.println("\nPlease enter the quantity:");
        quantity = scanner.nextInt();
        qty.add(quantity);

        Food selectedFood = foodItems.get(foodItemNumber - 1);
        total += selectedFood.getPrice() * quantity;

        System.out.println("\nAnything else (Y/N)?");
        anythingElse = scanner.next();

        if (anythingElse.equalsIgnoreCase("Y")) {
            processOrder();
        } else if (anythingElse.equalsIgnoreCase("N")) {
            System.out.println("\n\n============================\n");
            System.out.println("Total bill : LKR " + total);
            System.out.println("\n\tTHANK YOU");
            System.out.println("\n============================\n\n");
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
            processOrder();
        }
    }
}
