package CodeForTemplateMethod;

public class YoungFemaleTaxCalculator extends TaxCalculator {

	@Override
	int applyStandardDeduction(int income) {
		return income - 50000;
	}

	@Override
	int applyTaxRate(int income) {
		return (int)(income * 0.2);
	}

	@Override
	int applySurcharge(int tax) {
		return (int)(tax * 1.01);
	}
	
}
