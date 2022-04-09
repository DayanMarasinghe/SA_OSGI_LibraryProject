package userregisterservicepublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class UserRegisterPublisherImp implements UserRegisterPublisher {

	private ArrayList<UserModel> userarr = new ArrayList<UserModel>();
	
	public UserRegisterPublisherImp() {
		super();
		
		userarr.add(new UserModel("Dayan Eranjan","M",23,"981231234V"));
		userarr.add(new UserModel("Ruvini Viranga","F",25,"967891234V"));
		userarr.add(new UserModel("Ishini Kiridena","F",24,"9789012678V"));
		userarr.add(new UserModel("Gihan Liyanage","M",30,"926678678V"));
		userarr.add(new UserModel("Dilshan Bandara","M",20,"217899874V"));
	}
	
	@Override
	public void listOfUser() {
		System.out.println("\n**********User List************");
		System.out.println("\nID\tName\t\t\tNIC\t\tGender\tAge\n");
		for(int i=0;i<userarr.size();i++) {
			System.out.println((i+1) +"\t"+ userarr.get(i).getName() + "\t\t"+userarr.get(i).getNic() + "\t"+userarr.get(i).getGender() + "\t"+userarr.get(i).getAge());
		}
	}

	@Override
	public void insertUser() {
		String name,nic,gender;
		int age = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter Full name : ");
		name = sc.nextLine();
		
		System.out.print("Enter NIC : ");
		nic = sc.nextLine();
		
		System.out.print("Enter Gender (M/F) : ");
		gender = sc.nextLine();
		
		try 
		{ 
			System.out.print("Enter age : ");
			age = Integer.parseInt(sc.nextLine().trim());
			
			if(name != null && nic != null && gender != null && age != 0) {
				userarr.add(new UserModel(name, gender, age, nic));
				
				System.out.println("\n'"+name+"'"+" user is successfully added");
			}else {
				System.out.println("\nInvalid ! Please enter again");
				insertUser();
			}
		}  
		catch (NumberFormatException e)  
		{ 
			System.out.println("Age is not a valid type. please try again.");
			insertUser();
		} 
		
		
	}

	@Override
	public void updateUser() {
		String name,nic,gender;
		int age = 0;;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nID\tName\t\t\tNIC\t\tGender\tAge\n");
		for(int i=0;i<userarr.size();i++) {
			System.out.println((i+1) +"\t"+ userarr.get(i).getName() + "\t\t"+userarr.get(i).getNic() + "\t"+userarr.get(i).getGender() + "\t"+userarr.get(i).getAge());
		}
		
		

		System.out.print("\nEnter User ID to update :");
		
		int value = Integer.parseInt(sc.nextLine().trim());
		
		if(value > userarr.size()) {
			System.out.print("\nInvalid user ID! please enter again.\n");
			updateUser();
		}
		
		System.out.println("\nUpdate all details\t(1)");
		System.out.println("Update name\t(2)");
		System.out.println("Update NIC\t(3)");
		System.out.println("Update Age\t(4)");
		System.out.println("Update Gender\t(5)");
		
		System.out.print("\nEnter type :");
		
		int type = Integer.parseInt(sc.nextLine().trim());
		
		
		if(type == 1) {
			
			System.out.print("\nPlease enter new Name: ");
			name = sc.nextLine();
			
			System.out.println("Enter new NIC : ");
			nic = sc.nextLine();
			
			System.out.println("Enter new Gender (M/F) : ");
			gender = sc.nextLine();
		
			
			try 
			{ 
				System.out.println("Enter new age : ");
				age = Integer.parseInt(sc.nextLine().trim());
				
				userarr.get(value-1).setName(name);
				userarr.get(value-1).setGender(gender);
				userarr.get(value-1).setAge(age);
				userarr.get(value-1).setNic(nic);
				
				System.out.println("'"+name+"'"+"Successfully Updated!\n");
			}  
			catch (NumberFormatException e)  
			{ 
				System.out.println("Age is not a valid type. please try again.");
				updateUser();
			} 
			
			
			
		}else if(type == 2) {
			
			System.out.print("\nPlease enter new Name: ");
			name = sc.nextLine();
			
			userarr.get(value-1).setName(name);
			System.out.println("\n'"+name+"'"+"Successfully Updated!\n");
		
		}else if(type == 3) {
			
			System.out.println("\nEnter new NIC : ");
			nic = sc.nextLine();;
			
			userarr.get(value-1).setNic(nic);
			System.out.println("\n'"+userarr.get(value-1).getName()+"'" +"NIC is " + "Successfully Updated!\n");
		
		}else if(type == 4) {
			
			try 
			{ 
				System.out.println("\nEnter new age : ");
				age = Integer.parseInt(sc.nextLine().trim());
				
				userarr.get(value-1).setAge(age);
				
				System.out.println("\n'"+userarr.get(value-1).getName()+"'" +"age is " + "Successfully Updated!\n");
			}  
			catch (NumberFormatException e)  
			{ 
				System.out.println("Age is not a valid type. please try again.");
				updateUser();
			} 
		
		}else if(type == 5) {
			
			System.out.println("\nEnter new Gender (M/F) : ");
			gender = sc.nextLine();
			
			userarr.get(value-1).setGender(gender);
			
			System.out.println("\n'"+userarr.get(value-1).getName()+"'" +"gender is " + "Successfully Updated!\n");
		}else {
			System.out.println("\nInvalid type! Please enter again :");
			updateUser();
		}
			
	}

	@Override
	public void deleteUser() {
		int Id;
		UserModel removed = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n**********User List************");
		System.out.println("\nID\tName\t\t\tNIC\t\tGender\tAge\n");
		for(int i=0;i<userarr.size();i++) {
			System.out.println((i+1) +"\t"+ userarr.get(i).getName() + "\t\t"+userarr.get(i).getNic() + "\t"+userarr.get(i).getGender() + "\t"+userarr.get(i).getAge());
		}
		
		System.out.print("\nEnter the ID that wants to remove : ");
		Id = Integer.parseInt(sc.nextLine().trim());
		
		if(Id > userarr.size()) {
			System.out.print("\nInvalid user ID! please enter again.\n");
			deleteUser();
		}
		
		String username = userarr.get(Id-1).getName();
		removed = userarr.remove(Id-1);
		
		if(removed != null) {
			System.out.println("\n'"+ username +"'"+ " User Removed Successfully");
		}
		
	}

}
