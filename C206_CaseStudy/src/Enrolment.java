public class Enrolment {
	private String enrolDate;
	private boolean isEnrolled;

	public Enrolment(String enrolDate) {
		this.enrolDate = enrolDate;
		this.isEnrolled = true;
	}

	public boolean isEnrolled() {
		return isEnrolled;
	}

	public void setEnrolled(boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}

	public String getEnrolDate() {
		return enrolDate;
	}

}
