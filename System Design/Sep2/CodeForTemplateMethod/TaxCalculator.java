package CodeForTemplateMethod;

public abstract class TaxCalculator {
	public final int calculateTax(int inc) {
		int incAfterSD = applyStandardDeduction(inc);
		int tax = applyTaxRate(incAfterSD);
		int taxAfterSurcharge = applySurcharge(tax);
		return taxAfterSurcharge;
	}
	
	abstract int applyStandardDeduction(int income);
	abstract int applyTaxRate(int income);
	abstract int applySurcharge(int tax);
}
