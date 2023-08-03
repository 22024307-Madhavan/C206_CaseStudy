import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// prepare test data
	private Student student1;
	private Student student2;

	private Course course1;
	private Course course2;

	private ArrayList<Student> studentList;// adib adam
	private ArrayList<Course> courseList;// adib adam

	@Before
	public void setUp() throws Exception {
		student1 = new Student(22013320, "Mika", "98776531", "mika@mail.com", "20/04/2023");
		student2 = new Student(22096321, "Azim", "87789632", "azimmy@mail.com", "17/04/2023");

		course1 = new Course("C234","History","Ms Jenny","Saturday");// adib adam
		course2 = new Course("C230","Art","Mr Heng","Sunday");// adib adam
				
				
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
		Student missingName = new Student(22015933, "", "89887523", "elsa@mail.com", "05/05/2023");
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
			Course missingCode = new Course("C239", "Malay", "Ms Juan","Sunday");
			C206_CaseStudy.addCourse(courseList, missingCode);
			assertEquals("Test that the Course arraylist size is unchange.", 1, courseList.size());
	}// adib adam

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
		testing = String.format("%-15d %-20s %-20s %-23s %-20s %-15s\n", 22013320, "Mika", "98776531", "mika@mail.com",
				"20/04/2023", "Enrolled");
		testing += String.format("%-15d %-20s %-20s %-23s %-20s %-15s\n", 22096321, "Azim", "87789632",
				"azimmy@mail.com", "17/04/2023", "Enrolled");
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
		testing = String.format("%-15d %-20s %-20s %-15s\n", "C234","History","Ms Jenny","Saturday");
		testing += String.format("%-15d %-20s %-20s %-15s\n","C230","Art","Mr Heng","Sunday");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allCourse);

	}// adib adam

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
		confirm = C206_CaseStudy.doRemoveCourse(courseList,"C235");
		assertFalse("Test if an existing Course is NOT confirm to delete again?", confirm);

		// Remove non-existing course (error)
		confirm = C206_CaseStudy.doRemoveCourse(courseList,"C110" );
		assertFalse("Test that non-existing Course is NOT confirm to delete?", confirm);
	} // adib adam

	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
		studentList = null;
		course1 = null;//adib adam
		course2 = null;//adib adam
		courseList = null;// adib adam
	}

	/*
	 * @Test public void c206_test() { // fail("Not yet implemented");
	 * assertTrue("C206_CaseStudy_SampleTest ", true); }
	 */

}
