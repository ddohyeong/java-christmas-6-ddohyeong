package domain;

import static message.DateMessage.*;
import static message.PriceMessage.*;

import domain.menu.menuenum.Drink;

public class BenefitCalculator {
	private int christmasDiscount = 0;
	private int weekDayDiscount = 0;
	private int weekendDayDiscount = 0;
	private int specialDayDiscount = 0;
	private int expectedPayment = 0;
	private Drink freeGiftMenuDiscount;
	private Boolean eventApplicability = false;

	public BenefitCalculator(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		isEventApplicability(orderCalculator);
		applyChristmasDiscount(decemberEventPlanner);
		applyWeekDayDiscount(decemberEventPlanner, orderCalculator);
		applyWeekendDayDiscount(decemberEventPlanner, orderCalculator);
		applySpecialDayDiscount(decemberEventPlanner);
		applyFreeGiftMenu(orderCalculator);
		calculateExpectedPayment(orderCalculator);
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

	public int getTotalBenefitPrice() {
		if (eventApplicability) {
			int benefitPrice = christmasDiscount + weekDayDiscount + weekendDayDiscount + specialDayDiscount;

			if (isFreeGiftMenuNotNull()) {
				benefitPrice += freeGiftMenuDiscount.getPrice();
			}

			return benefitPrice;
		}
		return 0;
	}

	public boolean isFreeGiftMenuNotNull() {
		return getFreeGiftMenu() != null;
	}

	public int getExpectedPayment() {
		return expectedPayment;
	}

	public void calculateExpectedPayment(OrderCalculator orderCalculator) {
		this.expectedPayment = orderCalculator.getTotalBills() - getTotalBenefitPrice();
		if (freeGiftMenuDiscount != null) {
			this.expectedPayment += Drink.CHAMPAGNE.getPrice();
		}
	}

	private void isEventApplicability(OrderCalculator orderCalculator) {
		this.eventApplicability = orderCalculator.getTotalBills() >= EVENT_APPLICABILITY_THRESHOLD.getPrice();
	}

	private void applyFreeGiftMenu(OrderCalculator orderCalculator) {
		if (orderCalculator.getTotalBills() >= FREE_GIFT_MENU_THRESHOLD.getPrice()) {
			this.freeGiftMenuDiscount = Drink.CHAMPAGNE;
		}
	}

	private void applyChristmasDiscount(DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getChristmasDiscountDay()) {
			this.christmasDiscount =
					CHRISTMAS_BASE_DISCOUNT.getPrice() + calculateChristmasDiscount(decemberEventPlanner);
		}
	}

	private int calculateChristmasDiscount(DecemberEventPlanner decemberEventPlanner) {
		return CHRISTMAS_DISCOUNT_INCREMENT.getPrice() * (decemberEventPlanner.getReservationDate() - 1);
	}

	private void applyWeekDayDiscount(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		if (decemberEventPlanner.getWeekDayDiscount()) {
			int dessertTotalAmount = orderCalculator.getDessertTotalAmount();
			this.weekDayDiscount = dessertTotalAmount * EVENT_YEAR.getDate();
		}
	}

	private void applyWeekendDayDiscount(DecemberEventPlanner decemberEventPlanner, OrderCalculator orderCalculator) {
		if (decemberEventPlanner.getWeekendDiscount()) {
			int mainCourseTotalAmount = orderCalculator.getMainCourseTotalAmount();
			this.weekendDayDiscount = mainCourseTotalAmount * EVENT_YEAR.getDate();
		}
	}

	private void applySpecialDayDiscount(DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getSpecialDiscount()) {
			this.specialDayDiscount = SPECIAL_DAY_DISCOUNT.getPrice();
		}
	}
}
