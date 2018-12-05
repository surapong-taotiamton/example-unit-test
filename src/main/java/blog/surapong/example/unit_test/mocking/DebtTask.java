package blog.surapong.example.unit_test.mocking;

import java.io.IOException;
import java.util.List;

public class DebtTask implements Runnable {

	
	private DebtManagement debtManagement;
	private int debtValue;
	private AlertChanel alertChanel;
	
	public DebtTask(DebtManagement debtManagement, int debtValue,AlertChanel alertChanel) {
		super();
		this.debtValue = debtValue;
		this.debtManagement = debtManagement;
		this.alertChanel = alertChanel;
	}


	@Override
	public void run() {
		
		try {
			List<String> companies = debtManagement.findCompanyToAlertDebt(debtValue);
			
			for(String company : companies) {
				String alertMessage = String.format("Company %s, please pay the debt", company);
				alertChanel.alert(alertMessage);
			}
			
		} catch (IOException  ex) {
			
		}
	}

}
