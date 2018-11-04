package blog.surapong.example.unit_test.mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DebtManagementTest {
	
	@Test
	public void findCompanyToAlertDept_NormalCase_ReturnCorrect() throws Exception {
		
		/////////////
		// ARRANGE
		////////////
		
		CustomerDebt customerDebt1 = new CustomerDebt("1", "A", 1000);
		CustomerDebt customerDebt2 = new CustomerDebt("2", "B", 500);
		CustomerDebt customerDebt3 = new CustomerDebt("3", "C", 1200);
		
		List<CustomerDebt> returnData = Arrays.asList(customerDebt1, customerDebt2, customerDebt3);
		
		CustomerDebtDao customerDebtDao = mock(CustomerDebtDao.class);
		
		when(customerDebtDao.findAll()).thenReturn(returnData);
		
		List<String> expected = Arrays.asList("A", "C");
		DebtManagement debtManagement = new DebtManagement(customerDebtDao);
		
		////////////
		// ACT
		///////////
		
		List<String> actual = debtManagement.findCompanyToAlertDept(1000);

		////////////
		// ASSERT
		////////////
		
		System.out.println(expected.get(0)); 
		
		assertEquals(expected.get(0), actual.get(0));
		assertEquals(expected.get(1), actual.get(1));
	}
	
	@Test
	public void findCompanyToAlertDept_MultipleDeptInCompany_ReturnCorrect() throws Exception {
		
		/////////////
		// ARRANGE
		////////////
		
		CustomerDebt customerDebt1 = new CustomerDebt("1", "A", 1000);
		CustomerDebt customerDebt2 = new CustomerDebt("2", "B", 500);
		CustomerDebt customerDebt3 = new CustomerDebt("3", "C", 1200);
		CustomerDebt customerDebt4 = new CustomerDebt("4", "B", 500);
		CustomerDebt customerDebt5 = new CustomerDebt("5", "D", 600);
		
		
		List<CustomerDebt> returnData = Arrays.asList(customerDebt1, customerDebt2, customerDebt3, customerDebt4, customerDebt5);
		
		CustomerDebtDao customerDebtDao = mock(CustomerDebtDao.class);
		
		when(customerDebtDao.findAll()).thenReturn(returnData);
		
		List<String> expected = Arrays.asList("A", "B", "C");
		DebtManagement debtManagement = new DebtManagement(customerDebtDao);
		
		////////////
		// ACT
		///////////
		
		List<String> actual = debtManagement.findCompanyToAlertDept(1000);

		////////////
		// ASSERT
		////////////
		
		assertEquals(expected.get(0), actual.get(0));
		assertEquals(expected.get(1), actual.get(1));
		assertEquals(expected.get(2), actual.get(2));
	}
	
	@Test
	public void findCompanyToAlertDept_ErrorFromDao_ThrowIOException() throws Exception {
		
		/////////////
		// ARRANGE
		////////////

		CustomerDebtDao customerDebtDao = mock(CustomerDebtDao.class);
		when(customerDebtDao.findAll()).thenThrow(IOException.class);	
		DebtManagement debtManagement = new DebtManagement(customerDebtDao);
		
		////////////
		// ACT
		///////////

		////////////
		// ASSERT
		////////////
		
		assertThrows(IOException.class, () -> {
			debtManagement.findCompanyToAlertDept(1000);
		});

	}
}
