package counterconsumer;

import finecollectorpublish.*;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CounterActivator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-Collector started-");
		
		serviceReference = context.getServiceReference(FineCollectorService.class.getName());
		
		FineCollectorService fineCollectorService = (FineCollectorService) context.getService(serviceReference);
		fineCollectorMethods(fineCollectorService);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-Collector stopped-");
		context.ungetService(serviceReference);
	}
	
	public void fineCollectorMethods(FineCollectorService fineCollectorService) {
		Scanner sc = new Scanner(System.in);
		String returnDate;
		int memberID;
		
		System.out.print("Enter member ID : ");
		memberID = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("Enter return date(MM/DD/YYYY) : ");
		returnDate = sc.nextLine();
		
		fineCollectorService.calculateFine(memberID, returnDate);
	}

}
