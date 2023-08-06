public class Fee {
	private static int counter = 1;
	private int feeID;
	private double amount;
	private String dueDate;
	private boolean paymentStatus;
	private String type;
	private int studentID;

	public Fee(double amount, String dueDate, String type, int studentID) {
		this.feeID = counter++;
		this.amount = amount;
		this.dueDate = dueDate;
		this.paymentStatus = false;
		this.type = type;
		this.studentID = studentID;
	}

	public int getFeeID() {
		return feeID;
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

	// For future implementation
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getType() {
		return type;
	}

	public int getStudentID() {
		return studentID;
	}

//	public boolean equals(Fee fee) {
//		return this.amount == fee.amount && this.dueDate.equals(fee.dueDate) && this.paymentStatus == fee.paymentStatus
//				&& this.type.equals(fee.type) && this.studentID == fee.studentID;
//	}

}