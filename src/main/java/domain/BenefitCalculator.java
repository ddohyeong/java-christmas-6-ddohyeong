package domain;

import domain.menu.menuenum.Drink;

public class BenefitCalculator {
	private int christmasDiscount = 0;
	private int weekDayDiscount = 0;
	private int weekendDayDiscount = 0;
	private int specialDayDiscount = 0;
	private Drink freeGiftMenuDiscount;
	private Boolean eventApplicability = false;

	public BenefitCalculator(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		isEventApplicability(orderCalculator);
		applyChristmasDiscount(decemberEventPlanner);
		applyWeekDayDiscount(decemberEventPlanner, orderCalculator);
		applyWeekendDayDiscount(decemberEventPlanner, orderCalculator);
		applySpecialDayDiscount(decemberEventPlanner);
		applyFreeGiftMenu(orderCalculator);
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

	public int getSpecialDayDiscount() {
		return specialDayDiscount;
	}

	public Boolean getEventApplicability() {
		return eventApplicability;
	}

	public Drink getFreeGiftMenu() {
		return freeGiftMenuDiscount;
	}

	private void isEventApplicability(OrderCalculator orderCalculator) {
		this.eventApplicability = orderCalculator.getTotalBills() >= 10_000;
	}

	private void applyFreeGiftMenu(OrderCalculator orderCalculator) {
		if (orderCalculator.getTotalBills() >= 120_000) {
			this.freeGiftMenuDiscount = Drink.CHAMPAGNE;
		}
	}

	private void applyChristmasDiscount(DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getChristmasDiscountDay()) {
			this.christmasDiscount = 1000 + (100 * (decemberEventPlanner.getReservationDate() - 1));
		}
	}

	private void applyWeekDayDiscount(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		if (decemberEventPlanner.getWeekDayDiscount()) {
			int dessertTotalAmount = orderCalculator.getDessertTotalAmount();
			this.weekDayDiscount = dessertTotalAmount * 2023;
		}
	}

	private void applyWeekendDayDiscount(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		if (decemberEventPlanner.getWeekendDiscount()) {
			int mainCourseTotalAmount = orderCalculator.getMainCourseTotalAmount();
			this.weekendDayDiscount = mainCourseTotalAmount * 2023;
		}
	}

	private void applySpecialDayDiscount(DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getSpecialDiscount()) {
			this.specialDayDiscount = 1000;
		}
	}
}
