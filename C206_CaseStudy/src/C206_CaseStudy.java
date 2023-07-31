import java.util.ArrayList;

public class C206_CaseStudy {
	private static final String CONTACTNUM_PATTERN = "[89][0-9]{7}";

	public static void main(String[] args) {

		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student(22011021, "Nur Alisha", "87221032", "alice@mail.com", "17/04/2023"));
		studentList.add(new Student(22011022, "Bob Tan", "98653211", "bobby@mail.com", "24/04/2023"));
		studentList.add(new Student(22011023, "Charlie", "85529633", "charlie@mail.com", "17/04/2023"));

		int option = 0;
		int view = 0;
		int add = 0;
		int del = 0;

		while (option != 3) {
			loginMenu();
			option = Helper.readInt("Enter option to login > ");

			Helper.line(140, "-");

			if (option == 1) { // Administrator
				System.out.println("You logged in as Administrator\n");
				menu(); // view, add, delete

				int admin = Helper.readInt("Enter option > ");
				// Helper.line(140, "-");

				if (admin == 1) {
					viewAdminMenu(); // view menu
					view = Helper.readInt("Enter option to view > ");

					if (view == 1) { // ---- VIEW ----
						// insert "view all enrolments" code here
					} else if (view == 2) {
						// insert "view all students" code here
						viewAllStudents(studentList);

					} else if (view == 3) {
						// insert "view all fees" code here
					} else if (view == 4) {
						// insert "view all user accounts" code here

					} else if (view == 5) {
						// insert "view all courses" code here
					} else {
						System.out.println("Invalid option to view.\n");
					}
				} else if (admin == 2) { // ---- ADD ----
					addAdminMenu(); // add menu
					add = Helper.readInt("Enter option to add > ");

					if (add == 1) {
						// insert "add new enrolment" code here
					} else if (add == 2) {
						// insert "add new students" code here
						Student stud = inputStudentDetails();
						addStudent(studentList, stud);

						System.out.println("\nStudent added successfully!\n");
					} else if (add == 3) {
						// insert "add new fees" code here
					} else if (add == 4) {
						// insert "add new user accounts" code here

					} else if (add == 5) {
						// insert "add new courses" code here
					} else {
						System.out.println("Invalid option to add.\n");
					}
				} else if (admin == 3) { // ---- DELETE ----
					deleteAdminMenu(); // delete
					del = Helper.readInt("Enter option to delete > ");

					if (del == 1) {
						// insert "delete an existing enrolment" code here
					} else if (del == 2) {
						// insert "delete an existing students" code here
						removeStudent(studentList);

					} else if (del == 3) {
						// insert "delete an existing fees" code here
					} else if (del == 4) {
						// insert "delete an existing user accounts" code here
					} else if (del == 5) {
						// insert "delete an existing courses" code here
					} else {
						System.out.println("Invalid option to delete.\n");
					}
				}
			} else if (option == 2) { // Student
				System.out.println("You logged in as Student\n");
				studentMenu();

				int studentOption = Helper.readInt("Enter option to add > ");

				if (studentOption == 1) {
					// insert add codes here
				}

			} else if (option == 3) {
				System.out.println("Thank you for using Tuition Management System!");
			} else {
				System.out.println("Invalid option. Try Again.");
			}

		}

	}

	public static void loginMenu() { // login as Administrator, student
		C206_CaseStudy.setHeader("Welcome to Tuition Management System!");
		System.out.println("1. Login as Administrator");
		System.out.println("2. Login as Student");
		System.out.println("3. Exit");
		Helper.line(140, "-");
	}

	public static void menu() { // view, add, delete
		System.out.println("1. View");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		Helper.line(140, "-");
	}

	public static void studentMenu() { // student menu - add (for now)
		System.out.println("1. Add");
		Helper.line(140, "-");
	}

	public static void viewAdminMenu() { // view (for administrators)
		C206_CaseStudy.setHeader("VIEW");

		System.out.println("1. Enrolments");
		System.out.println("2. Students");
		System.out.println("3. Fees");
		System.out.println("4. User Accounts");
		System.out.println("5. Courses");
		Helper.line(140, "-");
	}

	public static void addAdminMenu() { // add (for administrators)
		C206_CaseStudy.setHeader("ADD");
		System.out.println("1. Enrolment");
		System.out.println("2. Student");
		System.out.println("3. Fees");
		System.out.println("4. User Accounts");
		System.out.println("5. Courses");
		Helper.line(140, "-");
	}

	public static void deleteAdminMenu() { // delete (for administrators)
		C206_CaseStudy.setHeader("DELETE");
		System.out.println("1. Existing Enrolment");
		System.out.println("2. Existing Student");
		System.out.println("3. Existing Fees");
		System.out.println("4. Existing User Accounts");
		System.out.println("5. Existing Courses");
		Helper.line(140, "-");
	}

	/*
	 * public static void viewTeacherMenu() { // view (for teachers)
	 * System.out.println("1. View All Attendance Records");
	 * System.out.println("2. View Courses Assigned"); Helper.line(80, "-"); }
	 */

	public static void setHeader(String header) {
		Helper.line(140, "-");
		System.out.println(header);
		Helper.line(140, "-");
	}

	private static String obscure(String inStr) {
		String rtnVal = "";
		if (inStr.length() <= 5) {
			rtnVal = inStr;
		} else {
			rtnVal = inStr.substring(0, 1) + String.format("%" + (inStr.length() - 5) + "s", " ").replaceAll(" ", "X")
					+ inStr.substring(inStr.length() - 4);
		}
		return rtnVal;
	}

	public static String enrolmentStatus(boolean isEnrolled) {
		String status;

		if (isEnrolled == true) {
			status = "Enrolled";
		} else {
			status = "Not Enrol"; // not enrol
		}
		return status;
	}

	// ====================== Option 1 View ======================
	// View all Students
	public static void viewAllStudents(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader(" VIEW ALL STUDENTS ");
		String output = "";

		System.out.println(String.format("%-15s %-20s %-20s %-23s %-20s %-15s", "==========", "============",
				"==============", "=============", "==============", "================"));
		System.out.println(String.format("%-15s %-20s %-20s %-23s %-20s %-15s", "Student ID", "Student Name",
				"Contact Number", "Email Address", "Enrolment Date", "Enrolment Status"));
		System.out.println(String.format("%-15s %-20s %-20s %-23s %-20s %-15s", "==========", "============",
				"==============", "=============", "==============", "================"));

		output += retrieveAllStudents(studentList);
		System.out.println(output);

		Helper.line(140, "-");
	}

	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).isEnrolled()) { // Check if the student is enrolled
				output += String.format("%-15d %-20s %-20s %-23s %-20s %-15s\n", studentList.get(i).getStudentID(),
						studentList.get(i).getStudentName(), studentList.get(i).getContactNo(),
						studentList.get(i).getEmailAddress(), studentList.get(i).getEnrolDate(),
						C206_CaseStudy.enrolmentStatus(studentList.get(i).isEnrolled()));
			}
		}
		return output;
	}

	// ====================== Option 2 Add ======================

	// Add Students
	public static Student inputStudentDetails() {
		int id = Helper.readInt("Enter Student ID > ");
		String name = Helper.readString("Enter Student Name > ");
		String mobile = Helper.readStringRegEx("Enter Contact Number > ", CONTACTNUM_PATTERN);
		String email = Helper.readString("Enter Email Address > ");
		String enrol = Helper.readString("Enter Enrolment Date > ");

		// Create a new Student object with the entered information.
		Student stud = new Student(id, name, mobile, email, enrol);
		return stud;
	}

	public static void addStudent(ArrayList<Student> studentList, Student stud) {
		Student studentAdded;

		// Check to see if the student already exists in the list.
		for (int i = 0; i < studentList.size(); i++) {
			studentAdded = studentList.get(i);
			if (studentAdded.getStudentID() == stud.getStudentID()) {
				// The student ID already exists, don't add it again to student list.
				return;
			}
		}
		// Check to make sure that the student's name and email address are not empty.
		if ((stud.getEmailAddress().isEmpty()) || (stud.getStudentName().isEmpty())) {
			// The student email address and student name is empty, don't add them in
			// student ArrayList.
			return;
		}
		// Add the new student to the list when everything is correctly filled in.
		studentList.add(stud);
	}

	// ====================== Option 3 Delete/Remove ======================
	public static boolean doRemoveStudent(ArrayList<Student> studentList, int id) {
		boolean isWithdraw = false;

		if (id < 1) {
			return false;
		}

		for (int i = 0; i < studentList.size(); i++) {

			// existing student ID & still enrol
			if (id == studentList.get(i).getStudentID() && studentList.get(i).isEnrolled() == true) {
				studentList.remove(studentList.get(i));
				isWithdraw = true;
				break;
			}
		}
		return isWithdraw;
	}

	public static void removeStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.viewAllStudents(studentList); // View students before deletion

		// Prompt the user to enter the student ID of the student they want to remove.
		int studentid = Helper.readInt("Enter Student ID > ");

		// Check if the user has confirmed that they want to remove the student.
		char confirmation = Helper.readChar("Are you sure to delete Student ID " + studentid + "? (Y/N) > ");

		if (confirmation == 'Y' || confirmation == 'y') {

			// If user confirm to delete, call the doRemoveStudent() method to remove the
			// student from the list.
			Boolean withdraw = doRemoveStudent(studentList, studentid);

			// If the student was successfully removed, print a message to confirm.
			if (withdraw) { // withdraw == true
				System.out.println("\nStudent ID " + studentid + " successfully delete!\n");
			}
			// Otherwise, print a message to indicate that the student ID is invalid.
			else {
				System.out.println("\nInvalid student ID.\n");
			}
		}
	}
}
