
public class User {
	private String nric;
	private String username;
	private String password;
	private int contactNo;
	private String emailAddress;
	private String userType;

	public User(String nric, String username, String password, int contactNo, String emailAddress, String userType) {
		this.nric = nric;
		this.username = username;
		this.password = password;
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
		this.userType = userType;
	}

	public String getNric() {
		return nric;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getContactNo() {
		return contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getUserType() {
		return userType;
	}
}
