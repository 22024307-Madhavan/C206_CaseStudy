// Nur Syafiqah

public class Student extends User {
	private int studentID;
	private String studentName;
	
	public Student(String nric, String username, String password, int contactNo, String emailAddress, String userType,
			int studentID, String studentName) {
		super(nric, username, password, contactNo, emailAddress, userType);
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}	
}
