package blog.surapong.example.unit_test.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderUtilTest {
	
	
	@Test
	public void indexOfOrder_InputNullArray_ReturnImposibleIndex() throws Exception {
		
		/////////////
		// ARRANGE
		////////////
		int[] arrayInput = null;
		int order = 1;
		int expected = -1;
		
		////////////
		// ACT
		///////////
		
		int actual = OrderUtil.indexOfOrder(arrayInput, order);
		
		////////////
		// ASSERT
		////////////
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void indexOfOrder_OrderMoreThanLengthArray_ReturnImposibleIndex() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		int[] arrayInput = {1, 2};
		int order = 3;
		int expected = -1;
		
		
		////////////
		// ACT
		///////////
		
		int actual = OrderUtil.indexOfOrder(arrayInput, order);

		////////////
		// ASSERT
		////////////
		
		assertEquals(expected, actual);

	}
	
	@Test
	public void indexOfOrder_OrderImposible_ReturnImposibleIndex() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		int[] arrayInput = {1, 2};
		int order = 0;
		int expected = -1;

		////////////
		// ACT
		///////////
		
		int actual = OrderUtil.indexOfOrder(arrayInput, order);

		////////////
		// ASSERT
		////////////
		
		assertEquals(expected, actual);

	}
	
	@Test
	public void indexOfOrder_NormalCase_ReturnCorrectIndex() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		int[] arrayInput = {3, 1, 2};
		int order = 1;
		int expected = 1;

		////////////
		// ACT
		///////////
		
		int actual = OrderUtil.indexOfOrder(arrayInput, order);

		////////////
		// ASSERT
		////////////
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void indexOfOrder_NotUniqueArray_ThrowIllegalArgumentException() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		int[] arrayInput = {3, 3, 1, 2};
		int order = 1;
		
		////////////
		// ACT
		///////////
		
		
		////////////
		// ASSERT
		////////////
		
		assertThrows(IllegalArgumentException.class, () -> {
			OrderUtil.indexOfOrder(arrayInput, order);
		});
		

	}
	
	
}
