package finecollectorpublish;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FineCollectorPublishActivator implements BundleActivator {
	
	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Fine collector started, can collect fines now");
		FineCollectorService fineCollectorService = new FineCollectorImpl();
		publishServiceRegistration = context.registerService(FineCollectorService.class.getName(), fineCollectorService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Fine collector stopped, can not collect fines now");
		publishServiceRegistration.unregister();
	}

	
}
