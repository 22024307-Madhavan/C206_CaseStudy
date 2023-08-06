import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// prepare test data
	private Student student1; // nur syafiqah
	private Student student2; // nur syafiqah
	private Course course1; // adib adam
	private Course course2; // adib adam
	private Enrolment enrolment1;// Madhavan
	private Enrolment enrolment2;// Madhavan
	private Fee fee1;// Faiz
	private Fee fee2;// Faiz
	private Fee fee3;// Faiz

	private ArrayList<Student> studentList;// nur syafiqah
	private ArrayList<Course> courseList;// adib adam
	private ArrayList<Enrolment> enrolmentList;// Madhavan
	private ArrayList<Fee> feeList; // Faiz

	@Before
	public void setUp() throws Exception {
		student1 = new Student(22013320, "Mika", "98776531", "mika@mail.com"); // nur syafiqah
		student2 = new Student(22096321, "Azim", "87789632", "azimmy@mail.com"); // nur syafiqah

		course1 = new Course("C234", "History", "Ms Jenny", "Saturday");// adib adam
		course2 = new Course("C230", "Art", "Mr Heng", "Sunday");// adib adam
		
		fee1 = new Fee(500, "30/08/2023", "tuition", student1.getStudentID());// Faiz
		fee2 = new Fee(100.10, "31/08/2023", "tuition", 22046375); // Faiz - studentID is not found in feeList
		fee3 = new Fee(300.10, "30/08/2023", "exam", student1.getStudentID());// Faiz

		studentList = new ArrayList<Student>(); // nur syafiqah
		courseList = new ArrayList<Course>(); // adib adam
		feeList = new ArrayList<Fee>(); // Faiz
		
		
	}

	@Test
	public void testAddStudent() { // nur syafiqah
		// Valid Student ArrayList is not null and it is empty. (boundary)
		// Size of the ArrayList is 0.
		assertNotNull("Test if there is valid Student ArrayList to add to", studentList);
		assertEquals("Test that the Student ArrayList is empty.", 0, studentList.size());

		// Add an item in Student arraylist (normal)
		// Size of the ArrayList would be 1.
		C206_CaseStudy.addStudent(studentList, student1);
		assertEquals("Test that the Student arraylist size is now 1.", 1, studentList.size());
		assertSame("Test that new Student is added successfully to the list.", student1, studentList.get(0));

		// Add an item that already exists in the list (error)
		// Size of the ArrayList would remain as 1.
		C206_CaseStudy.addStudent(studentList, student1);
		assertEquals("Test that the Student arraylist size is unchange.", 1, studentList.size());

		// Add an item that has missing detail (error)
		// "" - Student Name has empty fields
		// Size of the ArrayList would remain as 1.
		Student missingName = new Student(22015933, "", "89887523", "elsa@mail.com");
		C206_CaseStudy.addStudent(studentList, missingName);
		assertEquals("Test that the Student arraylist size is unchange.", 1, studentList.size());

	}

	@Test
	public void testAddCourse() { // adib adam
		// Valid Course ArrayList is not null and it is empty. (boundary)
		// Size of the ArrayList is 0.
		assertNotNull("Test if there is valid Course ArrayList to add to", courseList);
		assertEquals("Test that the Course ArrayList is empty.", 0, courseList.size());

		// Add an item in Course arraylist (normal)
		// Size of the ArrayList would be 1.
		C206_CaseStudy.addCourse(courseList, course1);
		assertEquals("Test that the Course arraylist size is now 1.", 1, courseList.size());
		assertSame("Test that new Course is added successfully to the list.", course1, courseList.get(0));

		// Add an item that already exists in the list (error)
		// Size of the ArrayList would remain as 1.
		C206_CaseStudy.addCourse(courseList, course1);
		assertEquals("Test that the Course arraylist size is unchange.", 1, courseList.size());

		// Add an item that has missing detail (error)
		// "" - Course code has empty fields
		// Size of the ArrayList would remain as 1.
		Course missingCode = new Course("C239", "Malay", "Ms Juan", "Sunday");
		C206_CaseStudy.addCourse(courseList, missingCode);
		assertEquals("Test that the Course arraylist size is unchange.", 1, courseList.size());
	}// adib adam

	@Test
	public void testAddEnrolments() { // madhavan
		// Valid enrolment ArrayList is not null and it is empty. (boundary)
		// Size of the ArrayList is 0.
		assertNotNull("Test if there is valid Enrolment ArrayList to add to", enrolmentList);
		assertEquals("Test that the enrolment ArrayList is empty.", 0, enrolmentList.size());

		// Add an item in Enrolment arraylist (normal)
		// Size of the ArrayList would be 1.
		C206_CaseStudy.addEnrolment(enrolmentList, enrolment1);
		assertEquals("Test that the enrolment arraylist size is now 1.", 1, enrolmentList.size());
		assertSame("Test that new Enrolmentt is added successfully to the list.", enrolment1, enrolmentList.get(0));

		// Add an item that already exists in the list (error)
		// Size of the ArrayList would remain as 1.
		C206_CaseStudy.addEnrolment(enrolmentList, enrolment1);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 1, enrolmentList.size());

		// Add an item that has missing detail (error)
		// "" - Student Name has empty fields
		// Size of the ArrayList would remain as 1.
		Enrolment missingEndDate = new Enrolment(25, 22089202, "Grace", "18/4/2022", "", "DISM");
		C206_CaseStudy.addEnrolment(enrolmentList, missingEndDate);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 1, enrolmentList.size());

	}
	
	@Test
	public void testAddFee() { // Faiz
		// Valid Fee ArrayList is not null and it is empty. (boundary)
		// Size of the ArrayList is 0.
		assertNotNull("Test if there is valid Fee ArrayList to add to", feeList);
		assertEquals("Test that the Fee ArrayList is empty.", 0, feeList.size());

		// Add a fee in Fee Arraylist where student exist (normal)
		// Size of the Fee ArrayList would be 1.
		// Check that the fee can be added, where the studentID is found in studentList
		assertEquals("Test that the Student ArrayList is empty.", 0, studentList.size());
		C206_CaseStudy.addStudent(studentList, student1); // already test in testAddStudent

		C206_CaseStudy.addFee(studentList, feeList, fee1);
		assertEquals("Test that the Fee arraylist size is now 1.", 1, feeList.size());
		assertSame("Test that the new Fee is added successfully to the list.", fee1, feeList.get(0));

		// Add a fee in Fee ArrayList where student does not exist (Error)
		// Size of the Fee ArrayList would be 1.
		// Check that the fee cannot be added, as the studentID is not found in
		// studentList
		assertEquals("Test that the Fee arraylist size is 1.", 1, feeList.size());
		C206_CaseStudy.addFee(studentList, feeList, fee2);
		assertEquals("Test that the Fee arraylist size is still 1.", 1, feeList.size());

		// Add a fee that already exist in Fee ArrayList (Error)
		assertEquals("Test that the Fee arraylist size is 1.", 1, feeList.size());
		C206_CaseStudy.addFee(studentList, feeList, fee1);
		assertEquals("Test that the Fee arraylist size is still 1.", 1, feeList.size());

	}

	@Test
	public void testRetrieveAllStudents() { // nur syafiqah
		// Test Case 1
		// Test if Item list is not null and empty (Boundary)
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		assertEquals("Test that the Student arraylist is empty.", 0, studentList.size());

		// Test Case 2
		// Retrieve the studentList (Boundary)
		String allStudent = C206_CaseStudy.retrieveAllStudents(studentList);
		String testing = "";
		// Test if the output is empty (Boundary)
		assertEquals("Test that nothing is displayed", testing, allStudent);

		// Test Case 3
		// Add 2 students in studentList (Normal)
		C206_CaseStudy.addStudent(studentList, student1);
		C206_CaseStudy.addStudent(studentList, student2);
		// Test that the list is NOT empty. Arraylist size = 2.
		assertEquals("Test that Student arraylist size is 2.", 2, studentList.size());
		// Retrieve the studentList
		allStudent = C206_CaseStudy.retrieveAllStudents(studentList);
		testing = String.format("%-15d %-20s %-20s %-23s\n", 22013320, "Mika", "98776531", "mika@mail.com");
		testing += String.format("%-15d %-20s %-20s %-23s\n", 22096321, "Azim", "87789632", "azimmy@mail.com");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allStudent);

	}

	@Test
	public void testRetrieveAllCourse() { // adib adam
		// Test Case 1
		// Test if Item list is not null and empty (Boundary)
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		assertEquals("Test that the course arraylist is empty.", 0, courseList.size());

		// Test Case 2
		// Retrieve the courseList (Boundary)
		String allCourse = C206_CaseStudy.retrieveAllCourse(courseList);
		String testing = "";
		// Test if the output is empty (Boundary)
		assertEquals("Test that nothing is displayed", testing, allCourse);

		// Test Case 3
		// Add 2 course in courseList (Normal)
		C206_CaseStudy.addCourse(courseList, course1);
		C206_CaseStudy.addCourse(courseList, course2);
		// Test that the list is NOT empty. Arraylist size = 2.
		assertEquals("Test that Course arraylist size is 2.", 2, courseList.size());
		// Retrieve the courseList
		allCourse = C206_CaseStudy.retrieveAllCourse(courseList);
		testing = String.format("%-15d %-20s %-20s %-15s\n", "C234", "History", "Ms Jenny", "Saturday");
		testing += String.format("%-15d %-20s %-20s %-15s\n", "C230", "Art", "Mr Heng", "Sunday");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allCourse);

	}// adib adam

	@Test
	public void testRetrieveAllEnrolments() { // madhavan
		// Test Case 1
		// Test if Item list is not null and empty (Boundary)
		assertNotNull("Test if there is a valid enrolment arraylist to add to", enrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, enrolmentList.size());

		// Test Case 2
		// Retrieve the studentList (Boundary)
		String allEnrolment = C206_CaseStudy.retrieveAllEnrolments(enrolmentList);
		String testing = "";
		// Test if the output is empty (Boundary)
		assertEquals("Test that nothing is displayed", testing, allEnrolment);

		// Test Case 3
		// Add 2 students in studentList (Normal)
		C206_CaseStudy.addEnrolment(enrolmentList, enrolment1);
		C206_CaseStudy.addEnrolment(enrolmentList, enrolment2);
		// Test that the list is NOT empty. Arraylist size = 2.
		assertEquals("Test that Enrolment arraylist size is 2.", 2, enrolmentList.size());
		// Retrieve the studentList
		allEnrolment = C206_CaseStudy.retrieveAllEnrolments(enrolmentList);
		testing = String.format("%-15d %-20d %-20s %-20s %-23s %-10s\n", 18, 22045216, "Ryan", "18/4/2022", "3/3/2025",
				"DBIS");
		testing += String.format("%-15d %-20d %-20s %-20s %-23s %-10s\n", 16, 22013029, "Riyad", "18/4/2022",
				"3/3/2025", "DFT");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allEnrolment);

	}
	
	@Test
	public void testRetrieveAllFees() { // Faiz
		// Test if feeList exist and empty (boundary)
		assertNotNull("Test if there is valid Fee arraylist to add to", feeList);
		assertEquals("Test that the Fee arraylist is empty.", 0, feeList.size());
		String testOutput = "";
		String actualOutput = C206_CaseStudy.retrieveAllFees(feeList);
		assertEquals("Test that nothing is being displayed", testOutput, actualOutput);

		// Test that the fees added are displayed with the correct details. (normal)
		// Add 2 fees into the list and view the list
		assertEquals("Test that the Fee arraylist is empty.", 0, feeList.size());
		C206_CaseStudy.addStudent(studentList, student1); // fee1 & fee3 uses the studentID of student1
		C206_CaseStudy.addFee(studentList, feeList, fee1);
		C206_CaseStudy.addFee(studentList, feeList, fee3);
		assertEquals("Test that the 2 fees are added.", 2, feeList.size());
		

		testOutput += String.format("%-9d%-15.2f%-15s%-17s%-15s%d\n", fee1.getFeeID(), fee1.getAmount(), fee1.getDueDate(), "No",
				fee1.getType(), fee1.getStudentID());
		testOutput += String.format("%-9d%-15.2f%-15s%-17s%-15s%d\n", fee3.getFeeID(), fee3.getAmount(), fee3.getDueDate(), "No",
				fee3.getType(), fee3.getStudentID());
		actualOutput = C206_CaseStudy.retrieveAllFees(feeList);
		assertEquals("Test that the 2 fees are being displayed with the correct details.", testOutput, actualOutput);
		
		// Test that fee payment status when true is displayed as "Yes" (normal)
		// Change a fee's payment status attribute to true.
		testOutput = ""; // reset to empty String
		testOutput += String.format("%-9d%-15.2f%-15s%-17s%-15s%d\n", fee1.getFeeID(), fee1.getAmount(), fee1.getDueDate(), "No",
				fee1.getType(), fee1.getStudentID());
		testOutput += String.format("%-9d%-15.2f%-15s%-17s%-15s%d\n", fee3.getFeeID(), fee3.getAmount(), fee3.getDueDate(), "Yes",
				fee3.getType(), fee3.getStudentID());
		feeList.get(1).setPaymentStatus(true); // Change payment status of the 2nd fee in feeList
		actualOutput = C206_CaseStudy.retrieveAllFees(feeList);
		assertEquals("Test that the 2 fees are being displayed with the correct details.", testOutput, actualOutput);
		
	}
	@Test
	public void testDoRemoveStudent() { // nur syafiqah
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid Student ArrayList to remove", studentList);

		C206_CaseStudy.addStudent(studentList, student1); // add student (test to remove)
		// Remove existing Student (normal)
		Boolean confirm = C206_CaseStudy.doRemoveStudent(studentList, 22013320);
		assertTrue("Test if an existing student confirms to delete?", confirm);

		// Remove existing student AGAIN (error)
		confirm = C206_CaseStudy.doRemoveStudent(studentList, 22013320);
		assertFalse("Test if an existing student is NOT confirm to delete again?", confirm);

		// Remove non-existing student (error)
		confirm = C206_CaseStudy.doRemoveStudent(studentList, 21032633);
		assertFalse("Test that non-existing student is NOT confirm to delete?", confirm);
	}

	@Test
	public void testDoRemoveCourse() { // adib adam
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid course ArrayList to remove", courseList);

		C206_CaseStudy.addCourse(courseList, course1); // add course (test to remove)
		// Remove existing Course (normal0
		Boolean confirm = C206_CaseStudy.doRemoveCourse(courseList, "C230");
		assertTrue("Test if an existing student confirms to delete?", confirm);

		// Remove existing Course AGAIN (error)
		confirm = C206_CaseStudy.doRemoveCourse(courseList, "C235");
		assertFalse("Test if an existing Course is NOT confirm to delete again?", confirm);

		// Remove non-existing course (error)
		confirm = C206_CaseStudy.doRemoveCourse(courseList, "C110");
		assertFalse("Test that non-existing Course is NOT confirm to delete?", confirm);
	} // adib adam

	@Test
	public void testDoRemoveEnrolment() { // madhavan
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid enrolment ArrayList to remove", enrolmentList);

		C206_CaseStudy.addEnrolment(enrolmentList, enrolment1); // add course (test to remove)
		// Remove existing Course (normal0
		Boolean confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList, 12);
		assertTrue("Test if an existing student confirms to delete?", confirm);

		// Remove existing Course AGAIN (error)
		confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList, 15);
		assertFalse("Test if an existing enrolment is NOT confirmed to delete again?", confirm);

		// Remove non-existing course (error)
		confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList, 20);
		assertFalse("Test that non-existing enrolment is NOT confirmed to delete?", confirm);
	}
	
	@Test
	public void testDoRemoveFee() { // Faiz
		// Test if the correct fee is removed. (normal)
		C206_CaseStudy.addStudent(studentList, student1);
		C206_CaseStudy.addFee(studentList, feeList, fee1);
		C206_CaseStudy.addFee(studentList, feeList, fee3);
		assertEquals("Test that the 2 fees have been added",feeList.size(),2);
		boolean deleted = C206_CaseStudy.doRemoveFee(feeList, fee1.getFeeID()); //remove fee1 from feeList by feeID
		assertTrue(deleted); // check if returns True (meaning deleted)
		assertEquals("Test that there is 1 fee left in feeList",feeList.size(),1);
		assertEquals(fee3,feeList.get(0)); // Check that the last remaining fee is fee3
		
		// Test that nothing will happened when removing a fee that has already been removed (error)
		assertEquals("Test that feeList size is 1.",feeList.size(),1);
		deleted = C206_CaseStudy.doRemoveFee(feeList, fee1.getFeeID()); //remove fee1 again
		assertFalse(deleted); // check if returns false (not deleted)
		assertEquals("Test that the feeList size remains as 1.",feeList.size(),1);
		
		// Test that nothing will happened when removing a fee that has already been removed (error)
		assertEquals("Test that feeList size is 1.",feeList.size(),1);
		deleted = C206_CaseStudy.doRemoveFee(feeList, 82); //remove non-existing fee by feeID
		assertFalse(deleted); // check if returns false (not deleted)
		assertEquals("Test that the feeList size remains as 1.",feeList.size(),1);
		
	}

	@After
	public void tearDown() throws Exception {
		student1 = null; // nur syafiqah
		student2 = null; // nur syafiqah
		studentList = null; // nur syafiqah
		course1 = null;// adib adam
		course2 = null;// adib adam
		courseList = null;// adib adam
		enrolment1 = null; // madhavan
		enrolment2 = null; // madhavan
		enrolmentList = null;// madhavan
		fee1 = null; // Faiz
		fee2 = null; // Faiz
		fee3 = null; // Faiz
		feeList = null; // Faiz
	}

	/*
	 * @Test public void c206_test() { // fail("Not yet implemented");
	 * assertTrue("C206_CaseStudy_SampleTest ", true); }
	 */

}
