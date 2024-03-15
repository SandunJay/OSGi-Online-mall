package commonmoviesubscriber;

import common_publisher.CommonPublish;
import common_publisher.CommonPublishImpl;
import common_subscriber.CommonSubscriberActivator;
import movieadminproducer.MovieAdminProducer;
import movieadminproducer.ProducerMovieAdmin;
import moviecustomerconsumer.MovieCustomerConsumerActivator;
import moviecustomerproducer.MovieCustomerProducer;
import moviecustomerproducer.ProducerMovieCustomer;

import java.util.Scanner;
import movieadminconsumer.MovieAdminConsumerActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CommonMovieActivator implements BundleActivator {
	ServiceReference customerServiceReference;
    ServiceReference commonServiceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Start Customer Subscriber Service");

        ServiceReference adminServiceReference = context.getServiceReference(MovieAdminProducer.class.getName());
        ServiceReference customerServiceReference = context.getServiceReference(MovieCustomerProducer.class.getName());
//        ServiceReference commonServiceReference = context.getServiceReference(CommonPublish.class.getName());


        MovieAdminProducer movieAdminProducer = (MovieAdminProducer) context.getService(adminServiceReference);
        MovieCustomerProducer movieCustomerProducer = (MovieCustomerProducer) context.getService(customerServiceReference);
//        CommonPublish commonPublish = (CommonPublish) context.getService(commonServiceReference);


        try {
            Scanner scanner = new Scanner(System.in);            
            while (true) {
                    while (true) {
                        System.out.println("\n<< Enter 'end' for username to exit >>\n");
                        System.out.println("============================== Login ===================================");
                        System.out.print("Enter User Type (admin/customer): ");
                        String userType = scanner.next();
                        System.out.println("========================================================================\n");

                        if (userType.equals("end")) {
                            System.out.println("Ending the Self Checkout For Cinema");
                            CommonSubscriberActivator cSA = new CommonSubscriberActivator();
                            cSA.start(context);
                        }

                        if (userType.equals("admin")) {
                        	MovieAdminConsumerActivator adminConsumerActivator = new MovieAdminConsumerActivator();
                            adminConsumerActivator.start(context);
                        } else if (userType.equals("customer")) {
                             MovieCustomerConsumerActivator customerConsumerActivator = new MovieCustomerConsumerActivator();
                            customerConsumerActivator.start(context);
                        } else {
                            System.out.println("Incorrect user type.");
                        }
                    }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Good Bye!!");
        context.ungetService(customerServiceReference);
        context.ungetService(commonServiceReference);
    }
}
