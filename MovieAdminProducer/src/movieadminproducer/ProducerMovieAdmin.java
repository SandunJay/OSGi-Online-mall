package movieadminproducer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import movieRegister.movieRegistry;

public class ProducerMovieAdmin implements MovieAdminProducer{

	Scanner input = new Scanner(System.in);
	movieRegistry movie= new movieRegistry();
	String Fpath = System.getProperty("user.home");
	
	@Override
	public String welcomeMsg() {
		
		return "_________________________________ Movie Admin DashBoard _________________________________\\n";
	}
	@Override
	public void insertMovies(String name, int duration, String producer, String rating) {
		// TODO Auto-generated method stub
		movie.setmName(name);
		movie.setDuration(duration);
		movie.setProducer(producer);
		movie.setRating(rating);

		this.AddRecord();
	}

	private void AddRecord() {
		boolean found = false;
		try {  
		      File myObj = new File(Fpath+"\\movie.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		        System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } else {
		    	  System.out.println("File Opened: " + myObj.getAbsolutePath()); 
		      } 
		    	  try { 
		    		  String nameDurationString;
		    		  int index;
		    		  String name;
		              String duration;
		              String producer;
		              String rating;
		              String newName= movie.getmName();     
		              int newDuration = movie.getDuration();
		              String newProducer = movie.getProducer();
		              String newRating = movie.getRating();

		    		   RandomAccessFile raf = new RandomAccessFile(myObj, "rw");



		            while (raf.getFilePointer() < raf.length()) {


		            	nameDurationString = raf.readLine();


		                String[] lineSplit
		                    = nameDurationString.split("!");


		                name = lineSplit[0];
		                duration = lineSplit[1];
		                producer= lineSplit[2];
		                rating = lineSplit[3];

		                if (name.equals(newName)
		                    || duration.equals(newDuration)) {
		                    found = true;
		                    System.out.println(" Movie already in the registry!!! ");

		                    break;
		                }
		            }

		            if (found == false) {


		                nameDurationString
		                    = newName + "!"
		                      + newDuration+"!"+newProducer+"!"+newRating;


		                raf.writeBytes(nameDurationString);

		                raf.writeBytes(System.lineSeparator());

		                System.out.println("Movie added Successfull !!! ");
		                System.out.println("Hi " + newName +", added to the registry");

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
	public void ViewAllMovies()  {
		try {
		      File myObj = new File(Fpath+"\\driver.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
    }

	@Override
	public String DisplayMovies() {
		return movie.getmName() + " " +movie.getDuration()+" " + movie.getProducer() +" ";
	}


}
