package booklendingpublish;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BookLendingPublishActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("----Book lending publisher started, you can return or lend books now :)---");
		System.out.println();
		BookLendingService bookService = new BookLendingImpl();
		publishServiceRegistration = context.registerService(BookLendingService.class.getName(), bookService, null);
			
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("----Book lending publisher stopped, you can't return or lend books now :(----");
		System.out.println();
		publishServiceRegistration.unregister();
		
	}
	
	

}
