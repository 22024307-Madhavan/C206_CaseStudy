public class Fee {
	private double amount;
	private String dueDate;
	private boolean paymentStatus;
	private String type;
	private int studentID;

	public Fee(double amount, String dueDate, String type, int studentID) {
		this.amount = amount;
		this.dueDate = dueDate;
		this.paymentStatus = false;
		this.type = type;
		this.studentID = studentID;
	}

	public double getAmount() {
		return amount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getType() {
		return type;
	}

	public int getStudentID() {
		return studentID;
	}

}
