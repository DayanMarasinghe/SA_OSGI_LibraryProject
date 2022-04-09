package librarianconsumer;

import booklendingpublish.*;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class LibrarianConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("----Librarian is live now----");
		System.out.println();
		
		serviceReference = context.getServiceReference(BookLendingService.class.getName());
		
		BookLendingService bookLendingService = (BookLendingService) context.getService(serviceReference);
		bookLendingOptions(bookLendingService);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("----Librarian is not live now----");
		System.out.println();
		context.ungetService(serviceReference);
	}
	
	public void bookLendingOptions(BookLendingService bookLendingService) {
		Scanner sc = new Scanner(System.in);
		String bookName;
		int option;
		
		System.out.println("------------------------------------------------------");
		System.out.println("------------------Available options-------------------");
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("1. Book check in");
		System.out.println("2. Book check out");
		
		System.out.println();
		
		System.out.print("Enter option number : ");
		option = Integer.parseInt(sc.nextLine().trim());
		
		if(option == 1) {
			System.out.print("Enter book name : ");
			bookName = sc.nextLine().trim();
			bookLendingService.checkIn(bookName);
			bookLendingOptions(bookLendingService);
		}else if(option == 2) {
			System.out.print("Enter book name : ");
			bookName = sc.nextLine().trim();
			bookLendingService.checkOut(bookName);
			bookLendingOptions(bookLendingService);
		}else {
			System.out.println("Not a valid option");
			bookLendingOptions(bookLendingService);
		}
		
	}

	

}











