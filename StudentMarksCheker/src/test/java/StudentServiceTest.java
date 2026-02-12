import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {
	Student student;

	 StudentService studentservice;
	 @BeforeEach
	 void setup() {
		 studentservice=new StudentService();
		 student = new Student(1, 50, 60, 70);
	 }
	 @Test
	 public void testStudentTotalMarks() {
		 assertEquals(180,studentservice.calculateTotal(student));
	 }
	 
	 @Test
	 public void testStudentAvgMarks() {
		 assertEquals(60.0,studentservice.calculateAverage(student));
	 }
	 
	 @Test
	 public void testStudentpassed() {
	        assertTrue(studentservice.isPassed(student));
	        
	 }
}
