public class Enrolment {
	private int studentID;
	private String studentName;
	private String StartDate;
	private String EndDate;
	private String CourseName;
	private boolean isEnrolled;

	public Enrolment(int studentID, String studentName, String StartDate, String EndDate, String CourseName,
			boolean isEnrolled) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.CourseName = CourseName;
		this.isEnrolled = true;
	}

	public boolean isEnrolled() {
		return isEnrolled;
	}

	public void setEnrolled(boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
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
