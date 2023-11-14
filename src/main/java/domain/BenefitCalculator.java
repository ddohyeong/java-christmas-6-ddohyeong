package domain;

public class BenefitCalculator {
	private int christmasDiscount = 0;
	private int weekDayDiscount = 0;
	private int weekendDayDiscount = 0;

	public BenefitCalculator(DecemberEventPlanner decemberEventPlanner, MenuManager menuManager) {
		applyChristmasDiscount(decemberEventPlanner);
		applyWeekDayDiscount(decemberEventPlanner, menuManager);
		applyWeekendDayDiscount(decemberEventPlanner, menuManager);
	}

	public int getChristmasDiscount() {
		return christmasDiscount;
	}

	public int getWeekDayDiscount() {
		return weekDayDiscount;
	}

	public int getWeekendDayDiscount() {
		return weekendDayDiscount;
	}

	public boolean isEventApplicability(OrderTotalCalculator orderTotalCalculator) {
		return orderTotalCalculator.getTotalBills() >= 10_000;
	}

	private void applyChristmasDiscount(DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getChristmasDiscountDay()) {
			this.christmasDiscount = 1000 + (100 * (decemberEventPlanner.getReservationDate() - 1));
		}
	}

	private void applyWeekDayDiscount(DecemberEventPlanner decemberEventPlanner, MenuManager menuManager) {
		if (decemberEventPlanner.getWeekDayDiscount()) {
			int dessertTotalAmount = menuManager.getMenus().get(2).getTotalAmount();
			this.weekDayDiscount = dessertTotalAmount * 2023;
		}
	}

	private void applyWeekendDayDiscount(DecemberEventPlanner decemberEventPlanner, MenuManager menuManager) {
		if (decemberEventPlanner.getWeekendDiscount()) {
			int mainCourseTotalAmount = menuManager.getMenus().get(0).getTotalAmount();
			this.weekendDayDiscount = mainCourseTotalAmount * 2023;
		}
	}
}
