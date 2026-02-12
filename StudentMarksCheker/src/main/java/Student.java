
public class Student {
     private int id;
     private int marks1;
     private int marks2;
     private int marks3;
     public Student(int id,int marks1,int marks2,int marks3) {
    	   this.id=id;
    	   this.marks1=marks1;
    	   this.marks2=marks2;
    	   this.marks3=marks3;
     }
	 /**
 	 * @return the id
 	 */
	 public final int getId() {
		 return id;
	 }
	 /**
 	 * @param id the id to set
 	 */
	 public final void setId(int id) {
		 this.id = id;
	 }
	 /**
 	 * @return the marks1
 	 */
	 public final int getMarks1() {
		 return marks1;
	 }
	 /**
 	 * @param marks1 the marks1 to set
 	 */
	 public final void setMarks1(int marks1) {
		 this.marks1 = marks1;
	 }
	 /**
 	 * @return the marks2
 	 */
	 public final int getMarks2() {
		 return marks2;
	 }
	 /**
 	 * @param marks2 the marks2 to set
 	 */
	 public final void setMarks2(int marks2) {
		 this.marks2 = marks2;
	 }
	 /**
 	 * @return the marks3
 	 */
	 public final int getMarks3() {
		 return marks3;
	 }
	 /**
 	 * @param marks3 the marks3 to set
 	 */
	 public final void setMarks3(int marks3) {
		 this.marks3 = marks3;
	 }
     
}
