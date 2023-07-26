import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		
		int option = 0;
		int view = 0;

		while (option != 4) {
			loginMenu();

			option = Helper.readInt("Enter option to login > ");
			Helper.line(80, "-");

			if (option == 1) { // Administrator
				System.out.println("You logged in as Administrator\n");
				menu(); // view, add, delete

				option = Helper.readInt("Enter option > ");
				Helper.line(80, "-");

				if (option == 1) {
					viewAdminMenu(); // view menu
					option = Helper.readInt("Enter option to view > ");

					if (option == 1) {
						// insert "view all enrolments" code here
					} else if (view == 2) {
						// insert "view all students" code here
					} else if (view == 3) {
						// insert "view all fees" code here
					} else if (view == 4) {
						// insert "view all user accounts" code here
					} else if (view == 5) {
						// insert "view all courses" code here
					}
				}
				else if (option == 2)	{
					addAdminMenu();		// add 
					option = Helper.readInt("Enter option to view > ");
					
					if (option == 1) {
						// insert "add new enrolment" code here
					} else if (view == 2) {
						// insert "add new students" code here
					} else if (view == 3) {
						// insert "add new fees" code here
					} else if (view == 4) {
						// insert "add new user accounts" code here
					} else if (view == 5) {
						// insert "add new courses" code here
					}
				}
				else if (option == 3)	{
					deleteAdminMenu();		// delete 
					option = Helper.readInt("Enter option to view > ");
					
					if (option == 1) {
						// insert "delete an existing enrolment" code here
					} else if (view == 2) {
						// insert "delete an existing students" code here
					} else if (view == 3) {
						// insert "delete an existing fees" code here
					} else if (view == 4) {
						// insert "delete an existing user accounts" code here
					} else if (view == 5) {
						// insert "delete an existing courses" code here
					}
				}

			} else if (option == 2) { // Teacher
				menu();
				option = Helper.readInt("Enter option > ");
			} else if (option == 3) { // Student
				menu();
				option = Helper.readInt("Enter option > ");
			} else if (option == 4) {
				System.out.println("Thank you for using Tuition Management System!");
			} else {
				System.out.println("Invalid option. Try Again.");
			}
		}

	}

	public static void loginMenu() { // login as Administrator, teacher, student
		C206_CaseStudy.setHeader("Welcome to Tuition Management System!");
		System.out.println("1. Login as Administrator");
		System.out.println("2. Login as Teacher");
		System.out.println("3. Login as Student");
		System.out.println("4. Exit");
		Helper.line(80, "-");
	}

	public static void menu() { // view, add, delete
		System.out.println("1. View");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		Helper.line(80, "-");
	}

	public static void viewAdminMenu() { // view (for administrators)
		System.out.println("1. View All Enrolments");
		System.out.println("2. View All Students");
		System.out.println("3. View All Fees");
		System.out.println("4. View All User Accounts");
		System.out.println("5. View All Courses");
		Helper.line(80, "-");
	}
	

	public static void addAdminMenu() { // add (for administrators)
		System.out.println("1. Add new Enrolment");
		System.out.println("2. Add new Student");
		System.out.println("3. Add new Fees");
		System.out.println("4. Add new User Accounts");
		System.out.println("5. Add new Courses");
		Helper.line(80, "-");
	}
	
	
	public static void deleteAdminMenu() { // delete (for administrators)
		System.out.println("1. Delete an Existing Enrolment");
		System.out.println("2. Delete an Existing Student");
		System.out.println("3. Delete an Existing Fees");
		System.out.println("4. Delete an Existing User Accounts");
		System.out.println("5. Delete an Existing Courses");
		Helper.line(80, "-");
	}
	
	/*
	 * public static void viewTeacherMenu() { // view (for teachers)
	 * System.out.println("1. View All Attendance Records");
	 * System.out.println("2. View Courses Assigned"); Helper.line(80, "-"); }
	 */

	

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}
