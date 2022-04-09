package userregisterservicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		
		UserRegisterPublisher userRegisterPublisher = new UserRegisterPublisherImp();
		
		serviceRegistration = bundleContext.registerService(UserRegisterPublisher.class.getName(), userRegisterPublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistration.unregister();
	}

}
