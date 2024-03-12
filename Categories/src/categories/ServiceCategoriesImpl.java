package categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import promo.ServicePromo;
import promo.ServicePromoImpl;

public class ServiceCategoriesImpl implements ServiceCategories{
	
	private List<Products> selectedProducts;
	final Scanner sc = new Scanner(System.in);
	
	public ServiceCategoriesImpl(){
		this.selectedProducts = new ArrayList();
	}

	@Override
	public void displayCategories() {
		// TODO Auto-generated method stub
		Integer answer = 0;
        
        do {
            System.out.println("=============Categories==============\n");
            System.out.println(" 1 -  Shirts");
            System.out.println(" 2 -  T-Shirts");
            System.out.println(" 3 -  Trousers");
            System.out.println(" 4 -  Shorts");
            System.out.println("Enter -1 to exit.");
            System.out.println("\nEnter category number to view price details: ");
            System.out.println("=====================================\n");
            answer = sc.nextInt();
            if (answer == -1) {
                break;
            }
            this.getPriceFromIndex(answer);
        } while (answer != -1);
		
        displayBill();
	}
	
	private Products products;
	
	private void getPriceFromIndex(Integer answer) {
		// TODO Auto-generated method stub
		this.products = new Products();
		String size;
		
		System.out.println("\n\n\nPlease Select your size:(M/L/XL)");
		size = sc.next().toUpperCase();
		
		switch(answer) {
			case 1:{
				if(size == "M") {
			        this.products.setProductName("Shirt 1");
			        this.products.setProductprice(500.00);
			        this.products.setProductSize("M");
			        this.printDetails();
			        break;
				}else if(size == "L") {
			        this.products.setProductName("Shirt 2");
			        this.products.setProductprice(600.00);
			        this.products.setProductSize("L");
			        this.printDetails();
			        break;
				}else {
			        this.products.setProductName("Shirt 3");
			        this.products.setProductprice(700.00);
			        this.products.setProductSize("XL");
			        this.printDetails();
			        break;
				}
			}
            case 2: {
				if(size == "M") {
			        this.products.setProductName("T-Shirt 1");
			        this.products.setProductprice(1000.00);
			        this.products.setProductSize("M");
			        this.printDetails();
			        break;
				}else if(size == "L") {
			        this.products.setProductName("T-Shirt 2");
			        this.products.setProductprice(1100.00);
			        this.products.setProductSize("L");
			        this.printDetails();
			        break;
				}else {
			        System.out.println("Not Available!!");
			        break;
				}
			}
            case 3: {
            	this.products.setProductName("Trouser 1");
            	this.products.setProductprice(3000.00);
            	this.products.setProductSize("M");
            	this.printDetails();
            	break;
            }
            case 4: {
            	this.products.setProductName("Short 1");
            	this.products.setProductprice(500.00);
            	this.products.setProductSize("M");
            	this.printDetails();
            	break;
            }
            default: {
                System.out.println("Invalid number. Please enter number from the category.\n");
                break;
            }
		}
        
		System.out.println("Add " + products.getProductName() + " to your cart? (yes/no): ");
        String confirmation = sc.next().toLowerCase();
        if (confirmation.equals("yes")) {
            selectedProducts.add(products);
            System.out.println("Product added to the cart");
        } else {
            System.out.println("Product not added to the cart");
        }
	}

	private void printDetails() {
		// TODO Auto-generated method stub
        System.out.println("\n===================================\n");
        System.out.println(products.getProductName());
        System.out.println("Price : Rs." + products.getProductprice() + "/=");
        System.out.println("Size: Rs." + products.getProductSize() + "/=");
        System.out.println("=====================================\n");
    
		            
	}
	private void displayBill() {
        if (selectedProducts.isEmpty()) {
            System.out.println("\n\n\n========================");
            System.out.println("No items in the cart. Exiting...");
            System.out.println("========================\n\n\n");
            return;
        }
        System.out.println("\n\n\n\n\n====== Promotions =========");        
        ServicePromoImpl sv = new ServicePromoImpl();
     
        System.out.println(sv.Offers());
        System.out.println(sv.discount());
        System.out.println(sv.packages());
        System.out.println("===============================\n\n\n\n\n");  
        
        System.out.println("\n\n\n\n\n====== Your Bill =========");

        double totalBill = 0.0;
        for (Products product : selectedProducts) {
            System.out.println(product.getProductName() + " - Rs." + product.getProductprice());
            totalBill += product.getProductprice();
        }
        
        if(totalBill>=10000) {
        	totalBill *= 0.20;
        	System.out.println("You had 20% discount");
        }
        

        System.out.println("========================");
        System.out.println("Total Bill: Rs." + totalBill);
        System.out.println("========================\n");
    }

}