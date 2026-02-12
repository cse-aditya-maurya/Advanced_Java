
public class StudentService {
    public int calculateTotal(Student student) {
    	return student.getMarks1()+student.getMarks2()+student.getMarks3();
    }
    public double calculateAverage(Student student) {
    	   int total=calculateTotal(student);
    	   return total/3.0;
    }
    public boolean isPassed(Student student) {
    	return calculateAverage(student)>=40;
    }
}


