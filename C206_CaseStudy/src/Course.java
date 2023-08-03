
public class Course {
	
	private String courseCode;
	private String courseTitle;
	private String instructor;
	private String schedule;	
	
	public Course(String courseCode, String courseTitle, String instructor, String schedule) {
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.instructor = instructor;
		this.schedule = schedule;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getSchedule() {
		return schedule;
	}

}
