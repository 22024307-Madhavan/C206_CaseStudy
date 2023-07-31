
public class User {
	private String nric;
	private String name;
	private String username;
	private String password;
	private String userType;
	
	public User(String nric, String name, String username, String password, String userType) {
		this.nric = nric;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public User(String nric, String name, String username, String password) {
		this.nric = nric;
		this.name = name;
		this.username = username;
		this.password = password;
		this.userType = "";
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getNric() {
		return nric;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}



	
}
