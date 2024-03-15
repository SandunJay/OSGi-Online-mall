package movieitemsproducer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import itemsAdder.Movie;

public class ProducerMovieItem implements MovieItemProducer{

	boolean itemSaveSuccMsg , isEmptyCategory, invalidID;
//	String BillName = "demo";
    private String currentBillName;

	public int myBillGrandTot;
	String Fpath = System.getProperty("user.home");
	
	
	public int getMyBillGrandTot() {
		return myBillGrandTot;
	}

	public void setMyBillGrandTot(int myBillGrandTot) {
		this.myBillGrandTot = myBillGrandTot;
	}

	public String getBillName() {
		return currentBillName;
	}

	public void setBillName(String billName) {
		currentBillName = billName;
	}

	public boolean isInvalidID() {
		return invalidID;
	}

	public void setInvalidID(boolean invalidID) {
		this.invalidID = invalidID;
	}

	public boolean isEmptyCategory() {
		return isEmptyCategory;
	}

	public void setEmptyCategory(boolean isEmptyCategory) {
		this.isEmptyCategory = isEmptyCategory;
	}

	Scanner input = new Scanner(System.in);
	Movie movie = new Movie();
	
	
	

	public boolean isItemSaveSuccMsg() {
		return itemSaveSuccMsg;
	}

	public void setItemSaveSuccMsg(boolean itemSaveSuccMsg) {
		this.itemSaveSuccMsg = itemSaveSuccMsg;
	}

	@Override
	public void moviecustomerwellcome() {
		System.out.println("_________________________________  Movies _________________________________\n\n"
				+"\n_________________________________  Categories _________________________________"
				+ "1) Thriller\n"
				+ "2) Action\n"
				+ "3) Science fiction\n"
				+ "4) Comedy\n"
				+ "5) Western\n");
		
	}

	@Override
	public void addMovies(String movieID,String movieName, String movieCategory, String moviePrice, String avbSeats) {
		movie.setMovieID(movieID);
		movie.setMovieName(movieName);
		movie.setMovieCategory(movieCategory);
		movie.setMoviePrice(moviePrice);
		movie.setAvbSeats(avbSeats);
		
		this.saveItems();
		
	}
	
	public void saveItems() {
		 boolean found = false;
			
			try {  
			      File myObj2 = new File(Fpath+"\\MovieList.txt");  
			      if (myObj2.createNewFile()) {  
			      } else {
			      }
			    	  try { 
			    		  String nameNumberString;
			    		  int index;
			    		  String iID;
			              String iName;
			              String iCategory;
			              String iPrice;
			              String iQty;
			              String newiID = movie.getMovieID();
			              String newiName = movie.getMovieName();
			              String newiCategory = movie.getMovieCategory();
			              String newiPrice = movie.getMoviePrice();
			              String newiQty =  movie.getAvbSeats();

			    		   RandomAccessFile raf
			                = new RandomAccessFile(myObj2, "rw");

			            while (raf.getFilePointer() < raf.length()) {

			                nameNumberString = raf.readLine();

			                String[] lineSplit
			                    = nameNumberString.split("!");
			 
			               iID = lineSplit[0];
				           iName = lineSplit[1];
				           iCategory = lineSplit[2];
				           iPrice = lineSplit[3];
				           iQty = lineSplit[4];

			                if (iID.equals(newiID)
			                    || iName.equals(newiName)) {
			                    found = true;
			                    System.out.println(" Movie already Inserted!!! ");
			                    this.setItemSaveSuccMsg(false);
			                    break;
			                }
			            }
			 
			            if (found == false) {

			                nameNumberString
			                    = newiID + "!"
			                      + newiName+"!"+newiCategory+"!"+newiPrice+"!"+newiQty;
			 
			               
			                raf.writeBytes(nameNumberString);
			 
			                raf.writeBytes(System.lineSeparator());
			 
			                System.out.println("Movie Successfully Inserted !!! ");
			                
			                this.setItemSaveSuccMsg(true);
			                raf.close();
			            }
 
			    	    } catch (IOException e) {
			    	      System.out.println("An error occurred.");
			    	      e.printStackTrace();
			    	    }  
			      
 
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();  
			    }  

	}
	
	public void getAllMovies() {
	    try {
	        File movieListFile = new File(Fpath + "\\MovieList.txt");
	        if (movieListFile.createNewFile()) {
	            System.out.println("File created: " + movieListFile.getName());
	            System.out.println("File Opened: " + movieListFile.getAbsolutePath());
	        } else {
	            System.out.println("File Opened: " + movieListFile.getAbsolutePath());
	        }
	        try (Scanner scanner = new Scanner(movieListFile)) {
	            System.out.println("|-----------------------------------------|");
	            System.out.println("|             All Movies                  |");
	            System.out.println("|-----------------------------------------|");
	            System.out.println("| ID\t| Name\t| Category\t| Price\t| Qty |");
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] movieData = line.split("!");
	                String id = movieData[0];
	                String name = movieData[1];
	                String category = movieData[2];
	                String price = movieData[3];
	                String qty = movieData[4];
	                System.out.printf("| %s\t| %s\t| %s\t\t| %s\t| %s\n", id, name, category, price, qty);
	            }
	            System.out.println("|-----------------------------------------|");
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}
	

	@Override
	public boolean itemSaveSucc() {
		
		return this.isItemSaveSuccMsg();
	}

	@Override
	public void searchMovieByCategory(String category) {
		boolean found = false;
				
				try {
					
					File myObj2 = new File(Fpath+"\\MovieList.txt");  
					if (myObj2.createNewFile()) {  
				        System.out.println("File created: " + myObj2.getName());  
				        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      } else {
				    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
				      }  
				    	  try { 
				    		  String nameNumberString;
				    		  int index;
				    		  String iID;
				              String iName;
				              String iCategory;
				              String iPrice;
				              String iQty;
				             
				              RandomAccessFile raf
				                = new RandomAccessFile(myObj2, "rw");
		        
				              System.out.println("|---------------------------------|");
				              System.out.println("|-------- "+category+" -----------|");
				              System.out.println("|---------------------------------|");
				              System.out.println("| \tID\t|\tName\t|\tPrice\t|\tQty |");
				              
				              while (raf.getFilePointer() < raf.length()) {
				 
				                
				                nameNumberString = raf.readLine();
				 
				                
				                String[] lineSplit
				                    = nameNumberString.split("!");
				 
				              
				                	iID = lineSplit[0];
				                	iName = lineSplit[1];
				                	iCategory = lineSplit[2];
				                	iPrice = lineSplit[3];
				                	iQty = lineSplit[4];

				                
				                
				                if (iCategory.equals(category)) {
				                    found = true;
				                    System.out.println("|---------------------------------|");
				            		System.out.println("| "+iID+"\t|\t"+iName+"\t|\t"+iPrice+"\t|\t"+iQty+" |");
				            		this.setEmptyCategory(false);
				                    continue;
				                }
				            }
				 
				            if (found == false) {
				 
				              
				            	System.out.println("|---------------------------------|");
			            		System.out.println("| There is no Items in Under the "+category+" category !!"+" |");
				            	
			            		this.setEmptyCategory(true);
				                raf.close();
				            }
				    		  
				    		  
				    	    } catch (IOException e) {
				    	      System.out.println("An error occurred.");
				    	      e.printStackTrace();
				    	    }  
				       
				      
				     
				      
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();  
				    }
		
	}
	
	

	@Override
	public void searchMovieByID(String id) {
		boolean found = false;
		
		try {
			
			File myObj2 = new File(Fpath+"\\MovieList.txt");  
			if (myObj2.createNewFile()) {  
//		        System.out.println("File created: " + myObj2.getName());  
//		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
//		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iID;
		              String iName;
		              String iCategory;
		              String iPrice;
		              String iQty;
		             
		              RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");
        
		              		              
		              while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                	iID = lineSplit[0];
		                	iName = lineSplit[1];
		                	iCategory = lineSplit[2];
		                	iPrice = lineSplit[3];
		                	iQty = lineSplit[4];

		                
		                
		                if (iID.equals(id)) {
		                    found = true;
		                    System.out.println("|---------------------------------|");
		            		System.out.println("| ID: "+iID+"\nName: "+iName+"\nPrice: "+iPrice+"\nQty: "+iQty+" |\n");
		            		this.setInvalidID(false);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		 
		              
		            	System.out.println("|---------------------------------|");
	            		System.out.println("| There is no movies in Under the "+id+" ID !!"+" |");
		            	
	            		this.setInvalidID(true);
		                raf.close();
		            }
		    		  
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		       
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
		
	}

	@Override
	public boolean isEmptyCategoryMsg() {
		
		return this.isEmptyCategory();
	}

	@Override
	public boolean invalidIDMsg() {
	
		return this.isInvalidID();
	}

	@Override
	public boolean checkQty(String icID, String icQty) {
		boolean check=false;
		
		boolean found = false;
				
				try {
					
					File myObj2 = new File(Fpath+"\\MovieList.txt");  
					if (myObj2.createNewFile()) {  
				      } else {
				      } 
				    	  try { 
				    		  String nameNumberString;
				    		  int index;
				    		  String iID;
				              String iName;
				              String iCategory;
				              String iPrice;
				              String iQty;
				             
				              RandomAccessFile raf
				                = new RandomAccessFile(myObj2, "rw");
		        
				              		              
				              while (raf.getFilePointer() < raf.length()) {
				 
				                
				                nameNumberString = raf.readLine();
				 
				                
				                String[] lineSplit
				                    = nameNumberString.split("!");
				 
				              
				                	iID = lineSplit[0];
				                	iName = lineSplit[1];
				                	iCategory = lineSplit[2];
				                	iPrice = lineSplit[3];
				                	iQty = lineSplit[4];
		
				                
				                
				                if (iID.equals(icID)) {
				                    found = true;
				                    int pQty=Integer.parseInt(icQty);
				                    int rQty=Integer.parseInt(iQty);
				                    if(rQty>=pQty) {
				                    	check=true;
				                    }
				                    break;
				                }
				            }
				 
				            if (found == false) {
				 
				              
				            	System.out.println("|---------------------------------|");
			            		System.out.println("| There is no Items in Under the "+icID+" ID !!"+" |");
				            	
				                raf.close();
				            }
				    		  
				    		  
				    	    } catch (IOException e) {
				    	      System.out.println("An error occurred.");
				    	      e.printStackTrace();
				    	    }  
				       
		      
		     
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
		
		
		
		return check;
	}
	
	@Override
	public String getItemQty(String icID) {
	    String iQty = null; // Initialize to null
	    
	    try {
	        File myObj2 = new File(Fpath + "\\MovieList.txt");

	        if (myObj2.createNewFile()) {
	            // File created
	        } else {
	            // File already exists
	        }

	        try (RandomAccessFile raf = new RandomAccessFile(myObj2, "rw")) {
	            String nameNumberString;
	            boolean found = false;

	            while ((nameNumberString = raf.readLine()) != null) {
	                String[] lineSplit = nameNumberString.split("!");

	                String iID = lineSplit[0];
	                iQty = lineSplit[4]; // Retrieve quantity

	                if (iID.equals(icID)) {
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                // Item not found
	                iQty = "-1"; // Set a flag value to indicate item not found
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }

	    return iQty;
	}
	
//	@Override
//	public void addToBill(String CName, String iID, String iQty, String iTPrice) {
//	    String gNo = Integer.toString(genarateANumber());
//	    String billName = CName + gNo;
//	    String billFolderPath = Fpath + "\\" + billName;
//	    
//	    // Create the directory if it doesn't exist
//	    File billFolder = new File(billFolderPath);
//	    if (!billFolder.exists()) {
//	        if (billFolder.mkdirs()) {
//	            System.out.println("Bill folder created: " + billFolderPath);
//	        } else {
//	            System.out.println("Failed to create bill folder: " + billFolderPath);
//	            return;
//	        }
//	    }
//
//	    try {
//	        File billFile = new File(billFolderPath + "\\" + billName + ".txt");
//	        if (billFile.createNewFile()) {
//	            System.out.println("Bill file created: " + billFile.getName());
//	        } else {
//	            System.out.println("Bill file already exists: " + billFile.getName());
//	        }
//
//	        try (RandomAccessFile raf = new RandomAccessFile(billFile, "rw")) {
//	            boolean found = false;
//	            String nameNumberString;
//
//	            while ((nameNumberString = raf.readLine()) != null) {
//	                String[] lineSplit = nameNumberString.split("!");
//
//	                String iiID = lineSplit[0];
//
//	                if (iiID.equals(iID)) {
//	                    found = true;
//	                    System.out.println("Item already inserted!");
//	                    break;
//	                }
//	            }
//
//	            if (!found) {
//	                String newItem = iID + "!" + iQty + "!" + iTPrice;
//	                raf.writeBytes(newItem);
//	                raf.writeBytes(System.lineSeparator());
//	                System.out.println("Successfully inserted!");
//	            }
//	        }
//	    } catch (IOException e) {
//	        System.out.println("An error occurred.");
//	        e.printStackTrace();
//	    }
//	}
	
	@Override
	public void addToBill(String CName, String iID, String iQty, String iTPrice) {
        String gNo = Integer.toString(genarateANumber());
        this.currentBillName = CName + gNo;
        String billFolderPath = Fpath + "\\" + this.currentBillName;

	    // Create the directory if it doesn't exist
	    File billFolder = new File(billFolderPath);
	    if (!billFolder.exists()) {
	        if (billFolder.mkdirs()) {
	            System.out.println("Bill folder created: " + billFolderPath);
	        } else {
	            System.out.println("Failed to create bill folder: " + billFolderPath);
	            return;
	        }
	    }

	    try {
	        File billFile = new File(billFolderPath + "\\" + currentBillName + ".txt");
	        if (billFile.createNewFile()) {
	            System.out.println("Bill file created: " + billFile.getName());
	        } else {
	            System.out.println("Bill file already exists: " + billFile.getName());
	        }

	        try (RandomAccessFile raf = new RandomAccessFile(billFile, "rw")) {
	            boolean found = false;
	            String nameNumberString;

	            while ((nameNumberString = raf.readLine()) != null) {
	                String[] lineSplit = nameNumberString.split("!");

	                String iiID = lineSplit[0];

	                if (iiID.equals(iID)) {
	                    found = true;
	                    System.out.println("Item already inserted!");
	                    break;
	                }
	            }

	            if (!found) {
	                String newItem = iID + "!" + iQty + "!" + iTPrice;
	                raf.writeBytes(newItem);
	                raf.writeBytes(System.lineSeparator());
	                System.out.println("Successfully inserted!");
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred while adding item to bill.");
	        e.printStackTrace();
	    }
	}

	
	public int genarateANumber() {
		
		int min = 1;
	    int max = 1000000;
	        
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		return random_int;
		
	}
	
	public int getItemPrice(String icID) {
		int p=0;
		boolean found = false;
		
		try {
			
			File myObj2 = new File(Fpath+"\\MovieList.txt");  
			if (myObj2.createNewFile()) {  
//		        System.out.println("File created: " + myObj2.getName());  
//		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
//		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iID;
		              String iName;
		              String iCategory;
		              String iPrice;
		              String iQty;
		             
		              RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");
        
		              		              
		              while (raf.getFilePointer() < raf.length()) {
		 
		                
		                nameNumberString = raf.readLine();
		 
		                
		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		              
		                	iID = lineSplit[0];
		                	iName = lineSplit[1];
		                	iCategory = lineSplit[2];
		                	iPrice = lineSplit[3];
		                	iQty = lineSplit[4];

		                
		                
		                if (iID.equals(icID)) {
		                    found = true;
		                    p=Integer.parseInt(iPrice);
		                    break;
		                }
		            }
		 
		            if (found == false) {
		     	System.out.println("|---------------------------------|");
	            		System.out.println("| There is no movies in Under the "+icID+" ID !!"+" |");
		            	
		                raf.close();
		            }
		            
		    		  
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();  
    }

		return p;
		
	}

	@Override
	public void showMyBill() {
		boolean found = false;
		
		
		try {  
			
            File myObj2 = new File(Fpath + "\\" + this.currentBillName + ".txt");
		      if (myObj2.createNewFile()) {  
		        System.out.println("File created: " + myObj2.getName()); 
//		        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      } else {
//		    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
		      }
		    	  try { 
		    		  String nameNumberString;
		    		  int index;
		    		  String iiID;
		              String iiQty;
		              String iTPrice;
		              

		    		   RandomAccessFile raf
		                = new RandomAccessFile(myObj2, "rw");

		    		   System.out.println("----------------------------------------------------\n");
		    		   System.out.println("------------------"+this.getBillName()+"-----------------\n");
		    		   System.out.println("------------------Bill-----------------\n");
		    		   System.out.println("\tItem ID\t"
		            		   +"\tQty\t"
		            		   +"\tTotal\t");
		    		   
		    		   while (raf.getFilePointer() < raf.length()) {

		                nameNumberString = raf.readLine();

		                String[] lineSplit
		                    = nameNumberString.split("!");
		 
		               iiID = lineSplit[0];
		               iiQty = lineSplit[1];
		               iTPrice = lineSplit[2];
			          
		               System.out.println("\t"+iiID+"\t"
		            		   +"\t"+iiQty+"\t"
		            		   +"\t"+iTPrice+"\t");
		               
		               
		            }
		            	this.calculateGrandTot();
		            	System.out.println("------------------------------------------------------\n");
		            	System.out.println("Grand Total: Rs."+Integer.toString(this.myBillGrandTot)+".00");
		            	System.out.println("------------------------------------------------------\n");

		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }  
		      

		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }  

		
	}

	@Override
	public void AddtoBillRegister(String deliverStatus) {
		 boolean found = false;
			
			try {  
			      File myObj2 = new File(Fpath+"\\BillRegister.txt");  
			      if (myObj2.createNewFile()) {  
//			        System.out.println("File created: " + myObj2.getName()); 
//			        System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
			      } else {
//			    	  System.out.println("File Opened: " + myObj2.getAbsolutePath()); 
			      }
			    	  try { 
			    		  String nameNumberString;
			    		  int index;
			    		  String BillID;
			              String GPrice;
			              String DStatus;
			              String newBillID = this.getBillName();
			              String newGPrice = Integer.toString(this.myBillGrandTot);
			              String newDStatus =  deliverStatus;

			    		   RandomAccessFile raf
			                = new RandomAccessFile(myObj2, "rw");

			            while (raf.getFilePointer() < raf.length()) {

			                nameNumberString = raf.readLine();

			                String[] lineSplit
			                    = nameNumberString.split("!");
			 
			                BillID = lineSplit[0];
			                GPrice = lineSplit[1];
			                DStatus = lineSplit[2];

			            }
			 
			            

			                nameNumberString
			                    = newBillID + "!"
			                      + newGPrice+"!"+newDStatus;
			 
			               
			                raf.writeBytes(nameNumberString);
			 
			                raf.writeBytes(System.lineSeparator());
			 
			                System.out.println("Successfully Inserted to Bill Register !!! ");
			                
			               
			                raf.close();
			            

			    	    } catch (IOException e) {
			    	      System.out.println("An error occurred.");
			    	      e.printStackTrace();
			    	    }  
			      

			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();  
			    }
		
	}
	
	public String getMoviePriceByID(String movieID) {
	    String price = ""; // Default price, in case movie is not found
	    
	    try {
	        File movieListFile = new File(Fpath + "\\MovieList.txt");
	        if (movieListFile.createNewFile()) {
	            // File created
	        }

	        try (Scanner scanner = new Scanner(movieListFile)) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] movieData = line.split("!");
	                String id = movieData[0];
	                String moviePrice = movieData[3];

	                if (id.equals(movieID)) {
	                    price = moviePrice;
	                    break;
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading movie data.");
	            e.printStackTrace();
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred while accessing movie list file.");
	        e.printStackTrace();
	    }

	    return price;
	}

	
	@Override
    public void calculateGrandTot() {
        this.myBillGrandTot = 0; // Reset total before calculation
        try {
            File billFile = new File(Fpath + "\\" + this.currentBillName + ".txt"); // Use current bill name
            if (billFile.exists()) { // Check if bill file exists
                try (Scanner scanner = new Scanner(billFile)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] itemData = line.split("!");
                        int itemPrice = Integer.parseInt(itemData[2]); // Item price
                        int itemQty = Integer.parseInt(itemData[1]); // Item quantity
                        this.myBillGrandTot += itemPrice * itemQty; // Add to total
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while reading the bill file.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Bill file does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

	
}
