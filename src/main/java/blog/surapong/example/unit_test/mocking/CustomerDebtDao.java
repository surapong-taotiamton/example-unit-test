package blog.surapong.example.unit_test.mocking;

import java.io.IOException;
import java.util.List;

public interface CustomerDebtDao {
	
	public List<CustomerDebt> findAll() throws IOException;
	public CustomerDebt findByRef(String ref) throws IOException;
	

}
