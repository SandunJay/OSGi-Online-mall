package deliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceDeliveryImp implements ServiceDelivery{

	@Override
	public void deliverService() {
		// TODO Auto-generated method stub
		int ans = 0;
        do {
            final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Give a number to view delivery details of the current area :");
            System.out.println("1 :  Colombo\n");
            System.out.println("2 :  Wattala\n");
            System.out.println("3 :  Negombo\n");
            System.out.println("-1 : Exit\n");
            System.out.println("Enter Number:");
            try {
            	ans = Integer.parseInt(in.readLine());
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
            switch (ans) {
                case 1: {
                    System.out.println("Contact No:  077 111 1111\n We will deliver around Colombo 10 such as Kollupitiya, Bambalapitiya, Fort etc\n Note: Orders within 5km from the select outlet will be delivered.\n\n\n ");
                    
                    continue;
                }
                case 2: {
                    System.out.println("Contact No:  077 222 2222\n We will deliver around Wattala such as Paliyagoda, Hunupitiya, Elakanda etc\n Note: Orders within 5km from the select outlet will be delivered.\n\n\n ");
                    continue;
                }
                case 3: {
                    System.out.println("Contact No:  077 333 3333\n We will deliver around Negombo such as Katunayaka, Pamunugama, Seeduwa etc\n Note: Orders within 5km from the select outlet will be delivered.\n\n\n ");
                    continue;
                }
                case 99: {
                    continue;
                }
                default: {
                    System.out.println("The number you entered is invalid!!!");
                    continue;
                }
            }
        } while (ans != -1);
		
	}

}
