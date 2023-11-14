package domain;

public class BenefitCalculator {
	private int christmasDiscount = 0;

	public BenefitCalculator(ReservationDate reservationDate, DecemberEventPlanner decemberEventPlanner) {
		applyChristmasDiscount(reservationDate, decemberEventPlanner);
	}

	public int getChristmasDiscount() {
		return christmasDiscount;
	}

	public boolean isEventApplicability(OrderTotalCalculator orderTotalCalculator) {
		return orderTotalCalculator.getTotalBills() >= 10_000;
	}

	public void applyChristmasDiscount(ReservationDate reservationDate, DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getChristmasDiscountDay()) {
			this.christmasDiscount = 1000 + (100 * (reservationDate.getReservationDate().getDayOfMonth() - 1));
		}
	}
}
