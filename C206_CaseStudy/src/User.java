// Justin Li - 22046133 -

public class User {
	private String userRole;
	private String nric;
	private String username;
	private String password;
	private String contactNo;
	private String emailAddress;

	public User(String userRole, String nric, String username, String password, String contactNo, String emailAddress) {
		this.userRole = userRole;
		this.nric = nric;
		this.username = username;
		this.password = password;
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
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

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getUserRole() {
		return userRole;
	}
}
