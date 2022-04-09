package bookregisterpublish;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BookRegisterPublishActivator implements BundleActivator {

	ServiceRegistration pServiceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		BookRegisterService adminservicepublisher = new BookRegServiceImpl();
		
		pServiceRegistration = bundleContext.registerService(BookRegisterService.class.getName(), adminservicepublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {

		pServiceRegistration.unregister();
	}

}
