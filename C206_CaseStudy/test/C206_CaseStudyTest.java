import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	// prepare test data
	private Student student1;
	private Student student2;

	private ArrayList<Student> studentList;

	@Before
	public void setUp() throws Exception {
		student1 = new Student(22013320, "Mika", "98776531", "mika@mail.com", "20/04/2023");
		student2 = new Student(22096321, "Azim", "87789632", "azimmy@mail.com", "17/04/2023");

		studentList = new ArrayList<Student>();
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
		testing = String.format("%-15d %-20s %-20s %-23s %-20s %-15s\n", 22013320, "Mika", "98776531", "mika@mail.com", "20/04/2023", "Enrolled");
		testing += String.format("%-15d %-20s %-20s %-23s %-20s %-15s\n", 22096321, "Azim", "87789632", "azimmy@mail.com", "17/04/2023", "Enrolled");
		// Test that the details display accurately
		assertEquals("Test that the display is correct.", testing, allStudent);

	}
	
	
	@Test
	public void testDoRemoveStudent() {
		// Test if Item list is not null and empty (boundary)
		assertNotNull("Test if there is valid Student ArrayList to remove", studentList);
		
		C206_CaseStudy.addStudent(studentList, student1);	// add student (test to remove)
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

	@After
	public void tearDown() throws Exception {
		student1 = null;
		student2 = null;
		studentList = null;
	}

	/*
	 * @Test public void c206_test() { // fail("Not yet implemented");
	 * assertTrue("C206_CaseStudy_SampleTest ", true); }
	 */

}
