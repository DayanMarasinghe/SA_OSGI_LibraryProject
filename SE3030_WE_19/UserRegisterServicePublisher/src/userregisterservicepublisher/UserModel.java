package userregisterservicepublisher;

public class UserModel {

	private String name;
	private String gender;
	private int age;
	private String Nic;
	
	public UserModel(){}
	
	public UserModel(String name, String gender, int age, String Nic ) {
		
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.Nic = Nic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNic() {
		return Nic;
	}

	public void setNic(String nic) {
		Nic = nic;
	}
	
	
}
