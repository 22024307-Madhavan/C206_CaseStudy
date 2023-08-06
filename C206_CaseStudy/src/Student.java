// Nur Syafiqah

public class Student {
	private static int counter = 22000001;
	private int studentID;
	private String studentName;
	private String contactNo;
	private String emailAddress;

	public Student(String studentName, String contactNo, String emailAddress) {
		this.studentID = counter++;
		this.studentName = studentName;
		this.contactNo = contactNo;
		this.emailAddress = emailAddress;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

}
