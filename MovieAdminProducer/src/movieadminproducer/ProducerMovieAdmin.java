package movieadminproducer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ProducerMovieAdmin implements MovieAdminProducer{

	Scanner input = new Scanner(System.in);	
	@Override
	public String welcomeMsg() {
		
		return "_________________________________ Movie Admin DashBoard _________________________________\\n";
	}


}
