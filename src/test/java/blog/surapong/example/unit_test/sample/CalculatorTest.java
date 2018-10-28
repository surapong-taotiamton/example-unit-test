package blog.surapong.example.unit_test.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	@Test
	public void plus_Normal_ReturnSuccessValue() throws Exception {
		
		
		/////////////
		// ARRANGE 
		////////////
		int a = 3;
		int b = 5;
		int expectedReturn = 8;
		
		////////////
		// ACT
		///////////
		
		int actualReturn = Calculator.plus(a, b);
		

		////////////
		// ASSERT
		////////////

		assertEquals(expectedReturn, actualReturn);		
	}
}
