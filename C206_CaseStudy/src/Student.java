// Nur Syafiqah

public class Student extends Enrolment {
	private int studentID;
	private String studentName;
	private String contactNo;
	private String emailAddress;

	public Student(int studentID, String studentName, String contactNo, String emailAddress, String enrolDate) {
		super(enrolDate);
		this.studentID = studentID;
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
