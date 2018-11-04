package blog.surapong.example.unit_test.mocking;

public class CustomerDebt {
	
	private String transactionRef;
	private String companyName;
	private Integer debt;
	
	public CustomerDebt(String transactionRef, String companyName, Integer debt) {
		super();
		this.transactionRef = transactionRef;
		this.companyName = companyName;
		this.debt = debt;
	}
	
	public String getTransactionRef() {
		return transactionRef;
	}
	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getDebt() {
		return debt;
	}
	public void setDebt(Integer debt) {
		this.debt = debt;
	}
	
}
