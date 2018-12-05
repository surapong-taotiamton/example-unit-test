package blog.surapong.example.unit_test.mocking;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DebtManagement {
	
	private CustomerDebtDao customerDebtDao;
	
	public DebtManagement(CustomerDebtDao customerDebtDao) {
		super();
		this.customerDebtDao = customerDebtDao;
	}

	public List<String> findCompanyToAlertDebt(Integer debt) throws IOException {
		
		
		HashMap<String, Integer> companyDebtHash = new HashMap<>();
		List<CustomerDebt> customerDebts = this.customerDebtDao.findAll();
		
		for (CustomerDebt customerDebt : customerDebts) {
			 Integer currentDebt = companyDebtHash.get(customerDebt.getCompanyName());
			 
			 if (currentDebt == null) {
				 companyDebtHash.put(customerDebt.getCompanyName(), customerDebt.getDebt());
			 } else {
				 companyDebtHash.put(customerDebt.getCompanyName(), currentDebt + customerDebt.getDebt());
			 }
		}
		
		List<String> listAnswer = companyDebtHash.entrySet().stream()
		.filter( obj -> {
			return obj.getValue() >= debt;
		}).map( obj -> obj.getKey() )
		.collect(Collectors.toList());
		
		Collections.sort(listAnswer);
		return listAnswer;
	}
	
}
