package promo;

import java.util.Scanner;

public class ServicePromoImpl implements ServicePromo{

	@Override
	public void promo() {
		// TODO Auto-generated method stub
		final Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println("Promotions: \n1.Offers\n2.Discounts\n3.Packages\n99.Exit\nInput number:");
            select = sc.nextInt();
            switch (select) {
                case 1: {
                    System.out.println(this.Offers());
                    continue;
                }
                case 2: {
                    System.out.println(this.discount());
                    continue;
                }
                case 3: {
                    System.out.println(this.packages());
                    continue;
                }
                case 99: {
                    continue;
                }
                default: {
                    System.out.println("Invalid input\n");
                    continue;
                }
            }
        } while (select != -1);
		
	}

	@Override
	public String discount() {
		// TODO Auto-generated method stub
		return "2.50% off for Kids Clothings";
	}

	@Override
	public String packages() {
		// TODO Auto-generated method stub
		return "3.Buy More than 10 clothes for New Year - Get ready!! Starting from April first";
	}

	@Override
	public String Offers() {
		// TODO Auto-generated method stub
		return "1.20% off for over 10 000 bils";
	}

}
