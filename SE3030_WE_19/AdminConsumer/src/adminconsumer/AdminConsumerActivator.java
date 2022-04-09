package adminconsumer;

import bookregisterpublish.BookRegisterService;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class AdminConsumerActivator implements BundleActivator {
	
	ServiceReference serviceReference;


	public void start(BundleContext context) throws Exception {

		serviceReference = context.getServiceReference(BookRegisterService.class.getName());
			
		BookRegisterService bookregisterservice = (BookRegisterService) context.getService(serviceReference);
		Main(bookregisterservice);
	}

	public void stop(BundleContext context) throws Exception {

		context.ungetService(serviceReference);
	}
	
	public void Main(BookRegisterService bookregisterservice) {
		int input;
		
		System.out.println("\nWelcome to book management!");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n1) Register Book ");
		System.out.println("2) Update Book ");
		System.out.println("3) Update Book Condition ");
		System.out.println("4) Delete Book ");
		
		System.out.print("\nEnter desired option : ");
		input = Integer.parseInt(sc.nextLine().trim());
		System.out.println("");
		
		if(input == 1) {
			bookregisterservice.insertBooks();
			Main(bookregisterservice);
		}else if(input == 2) {
			bookregisterservice.updateBooks();
			Main(bookregisterservice);
		}else if(input == 3) {
			bookregisterservice.updateBookCondition();
			Main(bookregisterservice);
		}else if(input == 4) {
			bookregisterservice.deleteBooks();
			Main(bookregisterservice);
		}else {
			System.out.println("Invalid Input...");
			Main(bookregisterservice);
		}
	}

}
