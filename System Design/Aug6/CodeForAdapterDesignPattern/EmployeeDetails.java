package CodeForAdapterDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {
	public List<String> GetEmployees(){
		List<String> emps = new ArrayList<>();
		
		emps.add("1-ABC-SDE1-9999786543");
		emps.add("2-DEF-SDE2-9876523456");
		emps.add("3-GHI-TL-9321499876");
		emps.add("4-JKL-Architect-9985432121");
		emps.add("5-MNO-HR-9211345667");
		
		return emps;
	}
}
