package blog.surapong.example.unit_test.mocking;

import java.io.IOException;
import java.util.List;

public class DebtTask implements Runnable {

	
	private DebtManagement debtManagement;
	private int deptValue;
	private AlertChanel alertChanel;
	
	public DebtTask(DebtManagement debtManagement, int deptValue,AlertChanel alertChanel) {
		super();
		this.deptValue = deptValue;
		this.debtManagement = debtManagement;
		this.alertChanel = alertChanel;
	}


	@Override
	public void run() {
		
		try {
			List<String> companies = debtManagement.findCompanyToAlertDept(deptValue);
			
			for(String company : companies) {
				String alertMessage = String.format("Company %s, please pay the dept", company);
				alertChanel.alert(alertMessage);
			}
			
		} catch (IOException  ex) {
			
		}
	}

}
