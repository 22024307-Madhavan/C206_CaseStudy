import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// prepare test data
	private Student student1; // nur syafiqah
	private Student student2; // nur syafiqah

	private Course course1;
	private Course course2;
	
	private Enrolment enrolment1;//Madhavan
	private Enrolment enrolment2;//Madhavan

	private ArrayList<Student> studentList;// adib adam
	private ArrayList<Course> courseList;// adib adam
	private ArrayList<Enrolment> enrolmentList;//Madhavan
	
	@Before
	public void setUp() throws Exception {
		student1 = new Student(22013320, "Mika", "98776531", "mika@mail.com"); // nur syafiqah
		student2 = new Student(22096321, "Azim", "87789632", "azimmy@mail.com"); // nur syafiqah

		course1 = new Course("C234", "History", "Ms Jenny", "Saturday");// adib adam
		course2 = new Course("C230", "Art", "Mr Heng", "Sunday");// adib adam

		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();// adib adam
	}

	@Test
	public void testAddStudent() {
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
	
	public void testAddEnrolments() { //madhavan
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
		Enrolment missingEndDate = new Enrolment(25,22089202, "Grace","18/4/2022","","DISM");
		C206_CaseStudy.addEnrolment(enrolmentList, missingEndDate);
		assertEquals("Test that the Enrolment arraylist size is unchanged.", 1, enrolmentList.size());

	}

	@Test
	public void testRetrieveAllStudents() {
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
	
	public void testRetrieveAllEnrolments() { //madhavan
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
		testing = String.format("%-15d %-20d %-20s %-20s %-23s %-10s\n", 18, 22045216, "Ryan","18/4/2022","3/3/2025","DBIS");
		testing += String.format("%-15d %-20d %-20s %-20s %-23s %-10s\n", 16, 22013029, "Riyad","18/4/2022","3/3/2025","DFT");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allEnrolment);

	}

	@Test
	public void testDoRemoveStudent() {
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid Student ArrayList to remove", studentList);

		C206_CaseStudy.addStudent(studentList, student1); // add student (test to remove)
		// Remove existing Student (normal0
		Boolean confirm = C206_CaseStudy.doRemoveStudent(studentList, 22013320);
		assertTrue("Test if an existing student confirms to delete?", confirm);

		// Remove existing student AGAIN (error)
		confirm = C206_CaseStudy.doRemoveStudent(studentList, 22013320);
		assertFalse("Test if an existing student is NOT confirm to delete again?", confirm);

		// Remove non-existing student (error)
		confirm = C206_CaseStudy.doRemoveStudent(studentList, 21032633);
		assertFalse("Test that non-existing student is NOT confirm to delete?", confirm);
	}

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
	
	public void testDoRemoveEnrolment() { //madhavan
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid enrolment ArrayList to remove", enrolmentList);

		C206_CaseStudy.addEnrolment(enrolmentList, enrolment1); // add course (test to remove)
		// Remove existing Course (normal0
		Boolean confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList,12);
		assertTrue("Test if an existing student confirms to delete?", confirm);

		// Remove existing Course AGAIN (error)
		confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList, 15);
		assertFalse("Test if an existing enrolment is NOT confirmed to delete again?", confirm);

		// Remove non-existing course (error)
		confirm = C206_CaseStudy.doRemoveEnrolment(enrolmentList, 20);
		assertFalse("Test that non-existing enrolment is NOT confirmed to delete?", confirm);
	}

	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
		studentList = null;
		course1 = null;// adib adam
		course2 = null;// adib adam
		courseList = null;// adib adam
		enrolment1 = null; //madhavan
		enrolment2 = null; //madhavan
		enrolmentList = null;//madhavan
	}

	/*
	 * @Test public void c206_test() { // fail("Not yet implemented");
	 * assertTrue("C206_CaseStudy_SampleTest ", true); }
	 */

}
