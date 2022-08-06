package CodeForAdapterDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeToPLAdapter implements IPhoneListSource{
	private EmployeeDetails empDS;
	
	public EmployeeToPLAdapter(EmployeeDetails ds) {
		this.empDS = ds;
	}
	
	@Override
	public List<String> GetPhoneNumbers() {
		List<String> emps = this.empDS.GetEmployees();
		List<String> phones = new ArrayList<>();
		
		for(String emp: emps) {
			String[] parts = emp.split("-");
			String phone = parts[3];
			phones.add(phone);
		}
		
		return phones;
	}

}
