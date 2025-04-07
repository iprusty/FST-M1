package Examples;

import static org.junit.jupiter.api.Assertions.assertAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import activities.Calculator;

public class CalculatorTest {
	
	//create calculator object
	Calculator calc = new Calculator();
	
	//Test method 1
	
	@Test
	public  void multiplyTest() {
		 int actualResult = calc.multiply(10, 30);
		 
		 //verify result
		 assertEquals(300, actualResult);
	}
	
	@ParameterizedTest
	@CsvSource({
		"10, 20, 30",
		"90, 100, 190",
		"150, 300, 450"
	})
	public void addTest(int num1, int num2, int expectedResult) {
		int actualResult = calc.add(num1, num2);
		
		//Assertion
		assertEquals(expectedResult, actualResult);
	}
	

}
