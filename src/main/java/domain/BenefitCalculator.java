package domain;

public class BenefitCalculator {

	public boolean isEventApplicability(OrderTotalCalculator orderTotalCalculator) {
		return orderTotalCalculator.getTotalBills() >= 10_000;
	}
}
