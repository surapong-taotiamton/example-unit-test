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

	public List<String> findCompanyToAlertDept(Integer dept) throws IOException {
		
		
		HashMap<String, Integer> companyDeptHash = new HashMap<>();
		List<CustomerDebt> customerDebts = this.customerDebtDao.findAll();
		
		for (CustomerDebt customerDebt : customerDebts) {
			 Integer currentDept = companyDeptHash.get(customerDebt.getCompanyName());
			 
			 if (currentDept == null) {
				 companyDeptHash.put(customerDebt.getCompanyName(), customerDebt.getDebt());
			 } else {
				 companyDeptHash.put(customerDebt.getCompanyName(), currentDept + customerDebt.getDebt());
			 }
		}
		
		List<String> listAnswer = companyDeptHash.entrySet().stream()
		.filter( obj -> {
			return obj.getValue() >= dept;
		}).map( obj -> obj.getKey() )
		.collect(Collectors.toList());
		
		Collections.sort(listAnswer);
		return listAnswer;
	}
	
}
