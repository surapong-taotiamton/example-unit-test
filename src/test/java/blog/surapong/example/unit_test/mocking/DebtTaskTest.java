package blog.surapong.example.unit_test.mocking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;


public class DebtTaskTest {
	
	private AlertChanel alertChanel;
	private DebtManagement debtManagement;
	
	@BeforeEach
	public void prepare() {
		alertChanel = mock(AlertChanel.class);
		debtManagement = mock(DebtManagement.class);
	}
	
	@Test
	public void run_NormalCase_AlertCorrectMessage() throws Exception {	
		/////////////
		// ARRANGE
		////////////
		final int DEPT_VALUE = 100;
		final String COMPANY_NAME = "A";
		final String EXPECTED_MESSAGE = String.format("Company %s, please pay the dept", COMPANY_NAME);
						
		when(debtManagement.findCompanyToAlertDept(eq(DEPT_VALUE)) ).thenReturn(Arrays.asList(COMPANY_NAME));
		
		DebtTask debtTask = new DebtTask(debtManagement, DEPT_VALUE, alertChanel);
		
		////////////
		// ACT
		///////////
		
		
		debtTask.run();
		
		////////////
		// ASSERT
		////////////
		
		verify(debtManagement, times(1)).findCompanyToAlertDept(DEPT_VALUE);
		verify(alertChanel, times(1)).alert(EXPECTED_MESSAGE);
		
	}
	
	@Test
	public void run_NormalCase_CorrectNumberCallMessage() throws Exception {
		
		
		/////////////
		// ARRANGE
		////////////
		
		final int DEPT_VALUE = 100;
		
		when(debtManagement.findCompanyToAlertDept( eq(DEPT_VALUE) )).thenReturn(Arrays.asList("A", "B", "C", "D", "E"));
		
		DebtTask debtTask = new DebtTask(debtManagement, DEPT_VALUE, alertChanel);

		////////////
		// ACT
		///////////

		debtTask.run();
		
		////////////
		// ASSERT
		////////////
		
		verify(debtManagement, times(1)).findCompanyToAlertDept(DEPT_VALUE);
		verify(alertChanel, times(5)).alert(anyString());

	}
}
	

