package CodeForTemplateMethod;

public class SeniorCitizenTaxCalculator extends TaxCalculator {

	@Override
	int applyStandardDeduction(int income) {
		return income - 100000;
	}

	@Override
	int applyTaxRate(int income) {
		return (int)(income * 0.1);
	}

	@Override
	int applySurcharge(int tax) {
		return (int)(tax * 1.00);
	}
	
}
