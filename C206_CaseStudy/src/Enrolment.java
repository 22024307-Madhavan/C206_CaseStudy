public class Enrolment { //madhavan
	private int enrolmentID;
	private int studentID;
	private String studentName;
	private String StartDate;
	private String EndDate;
	private String CourseName;
	
	
	
	
	public Enrolment(int enrolmentID,int studentID,String studentName,String StartDate,String EndDate,String CourseName) {
		this.enrolmentID = enrolmentID;
		this.studentID = studentID;
		this.studentName = studentName;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.CourseName = CourseName;
		
	}



	public int getEnrolmentID() {
		return enrolmentID;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getCourseName() {
		return CourseName;
	}



	
	

	
}
