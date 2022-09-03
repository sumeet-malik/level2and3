package CodeForTemplateMethod;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxCalculator tc = new SeniorCitizenTaxCalculator();
		System.out.println(tc.calculateTax(1000000));
	}

}
