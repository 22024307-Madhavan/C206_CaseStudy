
import java.util.ArrayList;
import java.util.regex.Pattern;

public class C206_CaseStudy {
	// Extract Constant
	private static final int OPTION_DEL = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_DEL6 = 6;
	private static final int OPTION_DEL5 = 5;
	private static final int OPTION_DEL4 = 4;
	private static final int OPTION_DEL3 = 3;
	private static final int OPTION_DEL2 = 2;
	private static final int OPTION_DEL1 = 1;
	private static final int OPTION_ADD6 = 6;
	private static final int OPTION_ADD5 = 5;
	private static final int OPTION_ADD4 = 4;
	private static final int OPTION_ADD3 = 3;
	private static final int OPTION_ADD2 = 2;
	private static final int OPTION_ADD1 = 1;
	private static final int OPTION_VIEW6 = 6;
	private static final int OPTION_VIEW5 = 5;
	private static final int OPTION_VIEW4 = 4;
	private static final int OPTION_VIEW3 = 3;
	private static final int OPTION_VIEW2 = 2;
	private static final int OPTION_VIEW1 = 1;
	private static final int OPTION_QUIT = 4;
	
	// Regex Constants
	private static final String userRolePattern = "(Teacher|Admin)";
	private static final String nricPattern = "^[ST]\\d{7}[A-Z]$";
	private static final String passwordPattern = "^(.{8,})$";
	private static final String contactNoPattern = "^[89]\\d{7}$";
	private static final String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$";
	
	public static void main(String[] args) {
		ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>(); //Madhavan
		ArrayList<Student> studentList = new ArrayList<Student>();//Syafiqah
		ArrayList<Course> courseList = new ArrayList<Course>(); //Adib
		ArrayList<Fee> feeList = new ArrayList<Fee>(); //Faiz
		ArrayList<User> userList = new ArrayList<User>(); //Justin

		studentList.add(new Student("Nur Alisha", "87221032", "alice@mail.com"));//Syafiqah
		studentList.add(new Student("Bob Tan", "98653211", "bobby@mail.com"));//Syafiqah
		studentList.add(new Student("Charlie", "85529633", "charlie@mail.com"));//Syafiqah

		courseList.add(new Course("C110", "Mathematics", "Ms Mary", "Monday"));//Adib
		courseList.add(new Course("C235", "Science", "Mr James", "Tuesday"));//Adib
		courseList.add(new Course("C105", "English", "Ms Tan", "Wednesday"));//Adib
		courseList.add(new Course("C208", "Literature", "Mr John", "Thursday"));//Adib
		courseList.add(new Course("C338", "Geography", "Dr Alvin", "Friday"));//Adib

		enrolmentList.add(new Enrolment(01,22027639 , "Mateen" , "17/04/2022" , "13/03/2025" , "DIT"));//Madhavan
		enrolmentList.add(new Enrolment(02,22031035 , "Jeremiah" , "12/04/2022" , "10/03/2025" , "DDD"));//Madhavan
		enrolmentList.add(new Enrolment(03,22016115 , "Fitri" , "14/04/2022" , "12/03/2025" , "DISA"));//Madhavan
		
		feeList.add(new Fee(200.99, "21/12/2023", "tuition", 22011021));//Faiz
		feeList.add(new Fee(300, "19/09/2023", "exam", 22011022));//Faiz
		feeList.add(new Fee(100.35, "23/10/2023", "tuition", 22011023));//Faiz

		userList.add(new User("Teacher", "S9823456R", "Mr Tan", "1234567890", "86783699", "tannnn09@gmail.com"));//Justin
		userList.add(new User("Admin", "S6922256Y", "Mr Wang", "1234567890", "86821699", "wangwang@gmail.com"));//Justin
		userList.add(new User("Teacher", "S7921656M", "Mr Stilton", "1234567890", "86583639", "geronimo@gmail.com"));//Justin
		userList.add(new User("Admin", "S1237456Y", "Mr Johnny Wang", "1234567890", "86821689", "johnnywang@gmail.com"));//Justin
		userList.add(new User("Teacher", "S9723456M", "Mr Pang", "1234567890", "86453639", "pangpang@gmail.com"));//Justin

		int option = 0;
		int view = 0;
		int add = 0;
		int del = 0;

		setHeader("Welcome to Tuition Management System!");

		while (option != OPTION_QUIT) {
			menu();		// Extract Method
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				viewMenu();		// Extract Method
				view = Helper.readInt("Enter option to view > ");
				Helper.line(140, "-");

				if (view == OPTION_VIEW1) { // ---- VIEW ----
					// insert "view all enrolments" code here
					viewAllEnrolments(enrolmentList); // madhavan

				} else if (view == OPTION_VIEW2) {
					// insert "view all students" code here
					viewAllStudents(studentList); // nur syafiqah

				} else if (view == OPTION_VIEW3) {
					// insert "view all fees" code here
					viewAllFees(feeList); // faiz
				} else if (view == OPTION_VIEW4) {
					// insert "view all user accounts" code here

					viewAllAdmins(userList);
					viewAllTeachers(userList);
					System.out.println();
					accountStatistics(userList); // Justin

				} else if (view == OPTION_VIEW5) {
					// insert "view all courses" code here
					viewAllCourse(courseList); // adib adam

				} else if (view == OPTION_VIEW6) {
					// menu();
				} else {
					System.out.println("Invalid option to view.\n");

					Helper.line(140, "-");
				}

			} else if (option == OPTION_ADD) {
				addMenu();		// Extract Method
				add = Helper.readInt("Enter option to add > ");
				Helper.line(140, "-");

				if (add == OPTION_ADD1) {
					// insert "add new enrolment" code here
					Enrolment enrol = inputEnrolment();
					addEnrolment(enrolmentList, enrol);
					
				} else if (add == OPTION_ADD2) {
					// insert "add new students" code here
					Student stud = inputStudentDetails();
					addStudent(studentList, stud);

					
				} else if (add == OPTION_ADD3) {
					// insert "add new fees" code here
					Fee fee = inputFeeDetails();
					addFee(studentList, feeList, fee); // faiz
				} else if (add == OPTION_ADD4) {
					// insert "add new user accounts" code here
					User newUser = newUserInput();
					addNewUser(userList, newUser);
					Helper.line(140, "-"); // Justin
				} else if (add == OPTION_ADD5) {
					// insert "add new courses" code here
					Course cors = inputCourseDetails(); // adib adam
					addCourse(courseList, cors); // adib adam
				} else if (add == OPTION_ADD6) {
					// menu();
				} else {
					System.out.println("Invalid option to add.\n");
					Helper.line(140, "-");

				}

			} else if (option == OPTION_DEL) {
				deleteMenu();		// Extract Method
				del = Helper.readInt("Enter option to delete > ");
				Helper.line(140, "-");

				if (del == OPTION_DEL1) {
					// insert "delete an existing enrolment" code here
					removeEnrolment(enrolmentList); // madhavan

				} else if (del == OPTION_DEL2) {
					// insert "delete an existing students" code here
					removeStudent(studentList); // nur syafiqah

				} else if (del == OPTION_DEL3) {
					// insert "delete an existing fees" code here
					removeFee(feeList); // faiz
				} else if (del == OPTION_DEL4) {
					// insert "delete an existing user accounts" code here

					deleteExistingUser(userList);

				} else if (del == OPTION_DEL5) {
					// insert "delete an existing courses" code here
					removeCourse(courseList); // adib adam

				} else if (del == OPTION_DEL6) {
					// menu();
				} else {
					System.out.println("Invalid option to delete.\n");
					Helper.line(140, "-");

				}
			} else if (option == OPTION_QUIT) {
				System.out.println("Thank you for using Tuition Management System!");
			} else {
				System.out.println("Invalid option. Try Again.");
				Helper.line(140, "-");
			}
		}
	}
	// Extract Method
	public static void menu() { // view, add, delete
		System.out.println("1. View");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		System.out.println("4. Exit");
		Helper.line(140, "-");
	}

	// Extract Method
	public static void viewMenu() {
		setHeader("VIEW");
		System.out.println("1. Enrolments");
		System.out.println("2. Students");
		System.out.println("3. Fees");
		System.out.println("4. User Accounts");
		System.out.println("5. Courses");
		System.out.println("6. Return to previous menu");
		Helper.line(140, "-");
	}

	// Extract Method
	public static void addMenu() {
		setHeader("ADD");
		System.out.println("1. Enrolment");
		System.out.println("2. Student");
		System.out.println("3. Fees");
		System.out.println("4. User Account");
		System.out.println("5. Course");
		System.out.println("6. Return to previous menu");
		Helper.line(140, "-");
	}

	// Extract Method
	public static void deleteMenu() {
		setHeader("DELETE");
		System.out.println("1. Existing Enrolment");
		System.out.println("2. Existing Student");
		System.out.println("3. Existing Fees");
		System.out.println("4. Existing User Accounts");
		System.out.println("5. Existing Courses");
		System.out.println("6. Return to previous menu");

		Helper.line(140, "-");
	}

	public static void setHeader(String header) {
		Helper.line(140, "-");
		System.out.println(header);
		Helper.line(140, "-");
	}



	// ====================== Option 1 View ======================
	// View all Students (Nur Syafiqah)
	public static void viewAllStudents(ArrayList<Student> studentList) {
		setHeader(" VIEW ALL STUDENTS ");
		String output = "";
		String format = "%-15s %-20s %-20s %-23s";		// Extract Variables

		System.out.println(String.format(format, "==========", "============", "==============",
				"============="));
		System.out.println(String.format(format, "Student ID", "Student Name", "Contact Number",
				"Email Address"));
		System.out.println(String.format(format, "==========", "============", "==============",
				"============="));

		output += retrieveAllStudents(studentList);
		System.out.println(output);

		Helper.line(140, "-");
	}

	public static String retrieveAllStudents(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {
			Student stud = studentList.get(i);			// Extract Variables
			output += String.format("%-15d %-20s %-20s %-23s\n", stud.getStudentID(),
					stud.getStudentName(), stud.getContactNo(),
					stud.getEmailAddress());
		}
		return output;
	}


	// View all Courses (Adib adam)
	public static void viewAllCourse(ArrayList<Course> courseList) {
		setHeader(" VIEW ALL COURSE ");
		String output = "";
		String format = "%-15s %-20s %-20s %-15s\n";

		output += (String.format(format, "===========", "===========", "===========", "=========="));
		output += (String.format(format, "CourseCode", "CourseTitle", "Instructor", "Schedule"));
		output += (String.format(format, "===========", "===========", "===========", "=========="));

		output += retrieveAllCourse(courseList);
		System.out.println(output);

	}

	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {
			output += String.format("%-15s %-20s %-20s %-15s\n", courseList.get(i).getCourseCode(),
					courseList.get(i).getCourseTitle(), courseList.get(i).getInstructor(),
					courseList.get(i).getSchedule());
		}
		return output;

	}

	// View all Enrolments (Madhavan)
	public static void viewAllEnrolments(ArrayList<Enrolment> enrolmentList) {
		setHeader(" VIEW ALL ENROLMENTS ");
		String format = "%-15s %-13s %-14s %-15s %-15s %-13s\n";
		
		
		String output = String.format(format, "============", "==========",
				"============", "==========", "========", "===========");
		output += String.format(format, "Enrolment ID", "Student ID",
				"Student Name", "Start Date", "End Date", "Course Name");
		output += String.format(format, "============", "==========",
				"============", "==========", "========", "===========");
		
		output += retrieveAllEnrolments(enrolmentList);
		System.out.println(output);
	}

	public static String retrieveAllEnrolments(ArrayList<Enrolment> enrolmentList) {// madhavan
		String output = "";

		for (int i = 0; i < enrolmentList.size(); i++) {
			output += String.format("%-15d %-13d %-14s %-15s %-15s %-13s\n", enrolmentList.get(i).getEnrolmentID(),
					enrolmentList.get(i).getStudentID(), enrolmentList.get(i).getStudentName(),
					enrolmentList.get(i).getStartDate(), enrolmentList.get(i).getEndDate(),
					enrolmentList.get(i).getCourseName());
		}
		return output;
	}

	// View all Fees (Faiz)
	public static void viewAllFees(ArrayList<Fee> feeList) {
		setHeader("VIEW ALL FEES");
		String output = "";
		String format = "%-9s%-15s%-15s%-17s%-15s%s\n";

		output = String.format(format, "======", "======", "========", "==============",
				"========", "==========");
		output += String.format(format, "Fee ID", "Amount", "Due Date", "Payment Status",
				"Fee Type", "Student ID");
		output += String.format(format, "======", "======", "========", "==============",
				"========", "==========");

		output += retrieveAllFees(feeList);

		System.out.println(output);
	}

	public static String retrieveAllFees(ArrayList<Fee> feeList) {
		String output = "";
		String bool = "";

		for (int i = 0; i < feeList.size(); i++) {
			// change output for boolean
			Fee fee = feeList.get(i);
			if (fee.isPaymentStatus()) {
				bool = "Yes";
			} else {
				bool = "No";
			}
			output += String.format("%-9d%-15.2f%-15s%-17s%-15s%d\n", fee.getFeeID(), fee.getAmount(), fee.getDueDate(),
					bool, fee.getType(), fee.getStudentID());
		}

		return output;

	}

	// J u s t i n ' s P a r t //

	public static void viewAllAdmins(ArrayList<User> userList) {

		String viewAdmin = "";

		System.out.println();
		Helper.line(50, "~");
		System.out.println("<< ADMIN ACCOUNTS >>");
		Helper.line(50, "~");
		
		Helper.line(100, "-");
		System.out.println(String.format("%-12s %-15s %-15s %-15s %-15s %-15s", "User Role", "NRIC", "Username",
				"Password", "Contact", "Email"));
		Helper.line(100, "-");
		

		viewAdmin += retrieveAllAdmins(userList);
		System.out.println(viewAdmin);

		Helper.line(140, "-");

	}

	public static String retrieveAllAdmins(ArrayList<User> userList) {

		String viewAdmin = "";

		// Display all Admin - Justin -

		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getUserRole().equals("Admin")) {

				viewAdmin += String.format("%-12s %-15s %-15s %-15s %-15s %-15s\n\n", userList.get(i).getUserRole(),
						userList.get(i).getNric(), userList.get(i).getUsername(), userList.get(i).getPassword(),
						userList.get(i).getContactNo(), userList.get(i).getEmailAddress());
			}

		}

		return viewAdmin;
	}

	public static void viewAllTeachers(ArrayList<User> userList) {

		String viewTeachers = "";

		System.out.println("");
		Helper.line(50, "~");
		System.out.println("<< TEACHER ACCOUNTS >>");
		Helper.line(50, "~");

		Helper.line(100, "-");
		System.out.println(String.format("%-12s %-15s %-15s %-15s %-15s %-15s", "User Role", "NRIC", "Username",
				"Password", "Contact", "Email"));
		Helper.line(100, "-");

		viewTeachers += retrieveAllTeachers(userList);
		System.out.println(viewTeachers);

		Helper.line(140, "-");

	}

	public static String retrieveAllTeachers(ArrayList<User> userList) {

		String viewTeachers = "";

		for (int i = 0; i < userList.size(); i++) {

			if (userList.get(i).getUserRole().equals("Teacher")) {

				viewTeachers += String.format("%-12s %-15s %-15s %-15s %-15s %-15s\n\n", userList.get(i).getUserRole(),
						userList.get(i).getNric(), userList.get(i).getUsername(), userList.get(i).getPassword(),
						userList.get(i).getContactNo(), userList.get(i).getEmailAddress());
			}

		}

		return viewTeachers;

	}

	public static void accountStatistics(ArrayList<User> userList) {

		int adminCount = 0;
		int teacherCount = 0;

		for (int e = 0; e < userList.size(); e++) {

			if (userList.get(e).getUserRole().equals("Admin")) {

				adminCount++;
			}

			if (userList.get(e).getUserRole().equals("Teacher")) {

				teacherCount++;
			}

		}

		// Display account statistics - Justin -

		Helper.line(50, "~");
		System.out.println("<< ACCOUNTS OVERVIEW >>");
		Helper.line(50, "~");

		Helper.line(30, "-");
		System.out.println("\nTotal Admins -----> " + adminCount + "\n");
		System.out.println("Total Teachers ----> " + teacherCount + "\n");
		Helper.line(30, "-");
		System.out.println("\nTotal Accounts ----> " + (adminCount + teacherCount) + "\n");
		Helper.line(30, "-");
		System.out.println();
		Helper.line(140, "-");

	}

	// ====================== Option 2 Add ======================

	// Add Student (Nur Syafiqah)
	public static Student inputStudentDetails() {
		String name = Helper.readString("Enter Student Name > ");
		String mobile = Helper.readStringRegEx("Enter Contact Number > ", contactNoPattern);
		String email = Helper.readString("Enter Email Address > ");

		// Create a new Student object with the entered information.
		Student stud = new Student(name, mobile, email);
		return stud;
	}

	public static void addStudent(ArrayList<Student> studentList, Student stud) {
		// Check to see if the student already exists in the list.
		for (int i = 0; i < studentList.size(); i++) {
			Student studentAdded = studentList.get(i);		// Extract Variables
			if (studentAdded.getContactNo().equals(stud.getContactNo())) {
				// If mobile number already exists, don't add it to student list.
				System.out.println("\nContact Number Exists. Try Again.\n");
				Helper.line(140, "-");
				return;
			}
		}
		// Check to make sure that the student's name and email address are not empty.
		if (stud.getStudentName().isEmpty()) {
			// The student name is empty, don't add them in student ArrayList.
			System.out.println("\nFill in Student Name. \n");
			Helper.line(140, "-");
			return;
		} else if (stud.getEmailAddress().isEmpty()) {
			// The student email address is empty, don't add them in student ArrayList.
			System.out.println("\nFill in Email Address. \n");
			Helper.line(140, "-");
			return;
		} else {
			// Add the new student to the list when everything is correctly filled in.
			studentList.add(stud);
			System.out.println("\nStudent added successfully!\n");
			Helper.line(140, "-");
		}
	}

	// Add course (Adib Adam)
	public static Course inputCourseDetails() {

		String code = Helper.readString("Enter course code > ");
		String title = Helper.readString("Enter course title  > ");
		String teacher = Helper.readString("Enter intructor's name > ");
		String sched = Helper.readString("Enter course schedule > ");

		// Create a new course object with the entered information.
		Course cors = new Course(code, title, teacher, sched);
		System.out.println("Course added");
		return cors;
	}

	public static void addCourse(ArrayList<Course> courseList, Course cors) {
		Course courseAdded;
		
		// Check to see if the course already exists in the list.
		for (int i = 0; i < courseList.size(); i++) {
			courseAdded = courseList.get(i);
			if (courseAdded.getCourseCode().equalsIgnoreCase(cors.getCourseCode())) {
				// The course code already exists, don't add it again to course list.
				System.out.println("course code  existed !!");
				return;
			}
		}
		// Check to make sure that the student's name and email address are not empty.
		if (cors.getCourseCode().isEmpty() || (cors.getCourseTitle().isEmpty()) || (cors.getSchedule().isEmpty())) {
			// The course code and course title is empty, don't add them in
			// course ArrayList.
			System.out.println(" Course code and course name cant be empty!");
			return;
		}

		// Add the new course to the list when everything is correctly filled in.
		courseList.add(cors);

	}

	// Add Enrolment (Madhavan)
	public static Enrolment inputEnrolment() {
		int enrolmentID = Helper.readInt("Enter Enrolment ID > ");
		int studentID = Helper.readInt("Enter Student ID > ");
		String name = Helper.readString("Enter Student Name > ");
		String StartDate = Helper.readString("Enter the Start Date of the Enrolment > ");
		String EndDate = Helper.readString("Enter the End Date of the Enrolment > ");
		String CourseName = Helper.readString("Enter the Course Name > ");

		Enrolment enrol = new Enrolment(enrolmentID, studentID, name, StartDate, EndDate, CourseName);
		return enrol;
	}

	public static void addEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment enrol) {// madhavan
		Enrolment record;
		for (int i = 0; i < enrolmentList.size(); i++) {
			record = enrolmentList.get(i);
			if (record.getStudentID() == enrol.getStudentID() || (record.getEnrolmentID() == enrol.getEnrolmentID())) {
				// The student ID and enrolment ID already exist, don't add it again to student
				// list.
				return;
			}

		}

		if (enrol.getCourseName().isEmpty() || (enrol.getStudentName().isEmpty())) {
			return;

		}
		enrolmentList.add(enrol);
	}

	// Add new fee (Faiz)
	public static boolean isStudentExist(ArrayList<Student> studentList, int id) {
		boolean exist = false;

		for (Student student : studentList) {
			if (id == student.getStudentID()) {
				exist = true;
			}
		}

		return exist;

	}

	public static boolean isFeeExist(ArrayList<Fee> feeList, Fee fee) {
		boolean exist = false;

		for (Fee fee2 : feeList) {
			if (fee.getFeeID() == fee2.getFeeID()) {
				exist = true;
			}
		}

		return exist;

	}

	public static Fee inputFeeDetails() {
		double amount = Helper.readDouble("Enter Amount > "); // can negative e.g., refund
		String dueDate = Helper.readString("Enter Due Date > ");
		String type = Helper.readString("Enter Fee Type > ");
		int studentID = Helper.readInt("Enter Student ID > ");

		Fee fee = new Fee(amount, dueDate, type, studentID);
		return fee;

	}

	public static void addFee(ArrayList<Student> studentList, ArrayList<Fee> feeList, Fee fee) {
		if (!isStudentExist(studentList, fee.getStudentID())) { // check if studentID exist
			System.out.println("Student does not exist.");
		} else if (isFeeExist(feeList, fee)) { // check if an exact same fee already exist
			System.out.println("This fee already exists.");
		} else if (fee.getAmount() != 0) { // amount can't be zero
			feeList.add(fee);
			System.out.println("Fee added.");

		}

		else {
			System.out.println("Fee not added.\n Check amount is not zero.");
		}
	}

	// [ Inputs for new user acc! - Justin - ]

	public static User newUserInput() { // Inputs for adding a new user! - Justin

		// Regex Patterns! - Justin -
		
		// on top now //
		
		// String userRolePattern = "(Teacher|Admin)"; //
		// String nricPattern = "^[ST]\\d{7}[A-Z]$"; //
		// String passwordPattern = "^(.{8,})$"; //
		// String contactNoPattern = "^[89]\\d{7}$"; //
		// String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$"; //


		// Inputs for adding users + Regex validation - Justin -

		// Validate UserRole - Justin -

		System.out.println();
		String userRoleInput = Helper.readString("What is the new user's role? (Teacher/Admin) >>> ");
		System.out.println();

		while (!Pattern.matches(userRolePattern, userRoleInput)) {

			System.out.println("Only 'Teacher' OR 'Admin' allowed!");
			System.out.println();
			userRoleInput = Helper.readString("What is the new user's role? (Teacher/Admin) >>> ");
			System.out.println();
		}

		// Validate NRIC - Justin -

		System.out.println();
		String nricInput = Helper.readString("Please enter a valid Singapore NRIC >>> ");
		System.out.println();

		while (!Pattern.matches(nricPattern, nricInput)) {

			System.out.println("Please enter a valid NRIC! [ S/T 1234567 A-Z]");
			System.out.println();
			nricInput = Helper.readString("Please enter a valid Singapore NRIC >>> ");
			System.out.println();
		}

		// Validate Username - Justin -

		System.out.println();
		String usernameInput = Helper.readString("Now choose a username... >>> ");
		System.out.println();

		while (usernameInput.isEmpty()) {

			System.out.println("Username is required >:(");
			System.out.println();
			usernameInput = Helper.readString("Now choose a username... >>> ");
			System.out.println();

		}

		// Validate Password - Justin -

		System.out.println();
		String passwordInput = Helper.readString("Create a strong and memorable password >>> ");
		System.out.println();

		while (!Pattern.matches(passwordPattern, passwordInput)) {

			System.out.println("Password should be 8-15 characters long");
			System.out.println();
			passwordInput = Helper.readString("Create a strong and memorable password >>> ");
			System.out.println();
		}

		// Validate Contact Number - Justin -

		System.out.println();
		String contactNoInput = Helper.readString("What is your number? >>> +65 ");
		System.out.println();

		while (!Pattern.matches(contactNoPattern, contactNoInput)) {

			System.out.println("Singapore numbers only. 8 digits please :)\nRemember to start with 8 or 9!");
			System.out.println();
			contactNoInput = Helper.readString("What is your number? >>> +65 ");
			System.out.println();
		}

		// Validate Email - Justin -

		System.out.println("");
		String emailInput = Helper.readString("What is your email? >>> ");

		while (!Pattern.matches(emailPattern, emailInput)) {

			System.out.println("Please include '@' and '.com' in your email!");
			System.out.println();
			emailInput = Helper.readString("What is your email? >>> ");
			System.out.println();
		}

		User newUser = new User(userRoleInput, nricInput, usernameInput, passwordInput, contactNoInput, emailInput);
		return newUser;

	}

	// Method for test case "Add New User" - Justin -

	public static void addNewUser(ArrayList<User> userList, User newUser) { // Adding new users! - Justin
		User user;
		for (int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getNric().equalsIgnoreCase(newUser.getNric()))
				return;
		}
		if ((newUser.getNric().isEmpty()) || (newUser.getUserRole().isEmpty())) {
			return;
		}

		userList.add(newUser);
		System.out.println();
		System.out.println("== User Added Successfully! :) ==");
		System.out.println();
	}

	// ====================== Option 3 Delete/Remove ======================
	// Delete Student (Nur Syafiqah)
	public static boolean doRemoveStudent(ArrayList<Student> studentList, int id) {
		boolean removed = false;

		if (id < 1) {
			return false;
		}

		for (int i = 0; i < studentList.size(); i++) {

			// existing student ID
			if (id == studentList.get(i).getStudentID()) {
				Student student = studentList.get(i);
				studentList.remove(student);		// Extract Variables
				removed = true;
				break;
			}
		}
		return removed;
	}

	public static void removeStudent(ArrayList<Student> studentList) {
		viewAllStudents(studentList); // View students before deletion

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
				Helper.line(140, "-");
			}
			// Otherwise, print a message to indicate that the student ID is invalid.
			else {
				System.out.println("\nInvalid student ID.\n");
				Helper.line(140, "-");

			}
		}
	}

	// Delete course (Adib Adam)
	public static boolean doRemoveCourse(ArrayList<Course> courseList, String courseCode) {
		boolean isWithdraw = false;

		if (courseCode.isEmpty()) {
			return false;
		}

		for (int i = 0; i < courseList.size(); i++) {
			if (courseCode.equalsIgnoreCase(courseList.get(i).getCourseCode())) {
				courseList.remove(courseList.get(i));
				isWithdraw = true;
				break;
			}
		}

		return isWithdraw;

	}

	public static void removeCourse(ArrayList<Course> courseList) {

		viewAllCourse(courseList);

		String ccode = Helper.readString("Enter course code > ");
		char confirm = Helper.readChar("Are you sure to delete Course " + ccode + "? (Y/N) > ");
		if (confirm == 'Y' || confirm == 'y') {

			// If user confirm to delete, call the doRemoveCourse() method to remove the
			// course from the list.
			Boolean withdraw = doRemoveCourse(courseList, ccode);

			// If the course was successfully removed, print a message to confirm.
			if (withdraw) { // withdraw == true
				System.out.println("\nCourse code " + ccode + " successfully delete!\n");
			}
			// Otherwise, print a message to indicate that the course code is invalid.
			else {
				System.out.println("\nInvalid Course code.\n");
			}
		}

	}

	// Delete Enrolment (Madhavan)
	public static boolean doRemoveEnrolment(ArrayList<Enrolment> enrolmentList, int enrolmentID) {
		boolean isWithdraw = false;

		if (enrolmentID == 0) {
			return false;
		}

		for (int i = 0; i < enrolmentList.size(); i++) {
			if (enrolmentID == enrolmentList.get(i).getEnrolmentID()) {
				enrolmentList.remove(enrolmentList.get(i));
				isWithdraw = true;
				break;
			}
		}

		return isWithdraw;

	}

	public static void removeEnrolment(ArrayList<Enrolment> enrolmentList) { // madhavan

		viewAllEnrolments(enrolmentList);

		int enrolID = Helper.readInt("Enter Enrolment ID  > ");
		char confirm = Helper.readChar("Are you sure to delete enrolment " + enrolID + "? (Y/N) > ");
		if (confirm == 'Y' || confirm == 'y') {

			// If user confirm to delete, call the doRemoveEnrolment() method to remove the
			// enrolment from the list.
			Boolean withdraw = doRemoveEnrolment(enrolmentList, enrolID);

			// If the enrolment was successfully removed, print a message to confirm.
			if (withdraw) { // withdraw == true
				System.out.println("\n Student enrolment " + enrolID + " successfully delete!\n");
			}
			// Otherwise, print a message to indicate that the enrolment id is invalid.
			else {
				System.out.println("\nInvalid Student enrolment .\n");
			}
		}

	}

	// Delete Fee (Faiz)
	public static boolean doRemoveFee(ArrayList<Fee> feeList, int id) {
		boolean found = false;

		for (int i = 0; i < feeList.size(); i++) {
			if (feeList.get(i).getFeeID() == id) {
				feeList.remove(i);
				found = true;
			}
		}
		return found;
	}

	public static void removeFee(ArrayList<Fee> feeList) {
		viewAllFees(feeList);

		int feeID = Helper.readInt("Enter Fee ID > ");
		char confirmation = Helper.readChar("Are you sure to delete Fee ID " + feeID + "? (Y/N)");

		if (confirmation == 'Y' || confirmation == 'y') {
			boolean removed = doRemoveFee(feeList, feeID);

			if (removed) {
				System.out.println("Fee removed!");
			} else {
				System.out.println("Invalid Fee ID.");
			}
		} else {
			System.out.println("Fee unaffected.");
			return;
		}
	}

	// [ Deleting Existing User Accounts - Justin - ]

	public static boolean doDeleteExistingUser(ArrayList<User> userList, String nric) {

		boolean isValid = false;

		for (int e = 0; e < userList.size(); e++) {

			if (userList.get(e).getNric().equals(nric)) {

				userList.remove(e);

				return true; // Return true to indicate successful deletion
			}

		}

		return isValid; // Return false if user with given NRIC is not found

	}

	public static void deleteExistingUser(ArrayList<User> userList) {

		viewAllAdmins(userList);
		viewAllTeachers(userList);

		System.out.println();
		String nricInput = Helper.readString("Enter a NRIC to delete >>> ");
		System.out.println();

		// If NRIC input is wrong, it'll keep prompting the user until correct :)

		boolean validNric = false;

		while (!validNric) {

			for (int e = 0; e < userList.size(); e++) {

				if (userList.get(e).getNric().equals(nricInput)) {

					validNric = true;
					break;
				}
			}

			if (!validNric) {

				System.out.println();
				System.out.println("Invalid NRIC :(");
				System.out.println();
				nricInput = Helper.readString("Enter an NRIC to delete >>> ");
			}
		}

		System.out.println();
		String confirm = Helper.readString("Are you sure??? (Yes/No) >>> ");
		String confirmPattern = "(Yes|No)";

		// If user confirm to delete, call the doDeleteExistingUser() method to remove
		// the
		// user from the list.

		while (!Pattern.matches(confirmPattern, confirm)) {

			System.out.println();
			System.out.println("Only 'Yes' or 'No' allowed!");
			System.out.println();
			confirm = Helper.readString("Are you sure??? (Yes/No) >>> ");
		}

		if (confirm.equals("Yes")) {

			Boolean delete = doDeleteExistingUser(userList, nricInput);

			// If the student was successfully removed, print a message to confirm.
			if (delete) { // delete == true
				System.out.println();
				System.out.println(nricInput + " deleted successfully :)");
				System.out.println();
				Helper.line(140, "-");
			}

		} // End of "if yes" option

		if (confirm.equals("No")) {

			System.out.println();
			System.out.println("Deletion Cancelled!");
			System.out.println();
			Helper.line(140, "-");

		}

	}

} // END OF ENTIRE CODE
