package receptionsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import userregisterservicepublisher.UserRegisterPublisher;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println(".......................................................................");
		System.out.println("Start Reception Consumer Service");
	
		serviceReference = bundleContext.getServiceReference(UserRegisterPublisher.class.getName());
		
		UserRegisterPublisher userRegisterPublisher = (UserRegisterPublisher) bundleContext.getService(serviceReference);
		
		userMainFunc(userRegisterPublisher);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(".......................................................................");
		System.out.println("Stop Reception Consumer Service");
		bundleContext.ungetService(serviceReference);
	}
	
	public void userMainFunc (UserRegisterPublisher userRegisterPublisher) {
		
		int index;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n------- User Register -------\n");
		
		System.out.println("See User Info\t\t(1) : ");
		System.out.println("Register new user\t(2) : ");
		System.out.println("Update user\t\t(3) : ");
		System.out.println("Delete user\t\t(4) : ");
		
		System.out.println("\n");
		
		System.out.print("Enter the number : ");
		index = Integer.parseInt(sc.nextLine().trim());
		
		if(index == 1) {
			userRegisterPublisher.listOfUser();
			userMainFunc(userRegisterPublisher);
		}else if(index == 2) {
			userRegisterPublisher.insertUser();
			userMainFunc(userRegisterPublisher);
		}else if(index == 3) {
			userRegisterPublisher.updateUser();
			userMainFunc(userRegisterPublisher);
		}else if(index == 4) {
			userRegisterPublisher.deleteUser();
			userMainFunc(userRegisterPublisher);
		}else {
			System.out.println("Invalid Input.Please enter again\t");
			userMainFunc(userRegisterPublisher);
		}
		
				
	}

}
