package maven_Project;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;




public class CalculatorTest {
	private Calculator calculator;
	@BeforeEach
	void setup() {
	 calculator=new Calculator();
	}
  
   @Test 
   public void testTwoAndTwoGivesFour() {
	   assertEquals(4, calculator.add(2, 2));
   }
   @Test 
   public void testFiveAndFourGivesNine() {
	   assertEquals(9, calculator.add(5,4));
   }
   @Test 
   public void testSixAndSevenGivesThirteen() {
	   assertEquals(13, calculator.add(6,7));
   }
   
   @Test
   @DisplayName("Test sum of two positive Number")
   void testSumOfPositiveNumbers() {
	   assertEquals(9,calculator.add(5,4),"sum of 5 and 4 ");
   }
   @RepeatedTest(3)
   @DisplayName("Test sum with repeated execution")
   void testSumRepeated() {
	   assertEquals(10, calculator.add(6, 4),"Sum of 5 and 5 is");
   }
   
   @Nested
   @DisplayName("Substraction Tests")
   class SubstractionTest {
	   @Test
	   @DisplayName("Test substraction of two number")
	   void testSubstraction() {
		   assertEquals(1,calculator.substract(5,4),"5-4 should be 1");
	   }
   }
   
   @ParameterizedTest
   @ValueSource(ints= {1,2,3,4,5})
   @DisplayName("Test multiplication of two number")
   void testMultiplyByTwo(int number) {
	   assertEquals(number*2,calculator.multiply(number,2),"Mulitplication of two number");
   }
   
   
   @ParameterizedTest

   @CsvSource({"2,2,4","2,3,6","4,4,16"})
   void testMultiply(int x,int y,int expected) {
	   assertEquals(expected,calculator.multiply(x, y));
   }
   
}
