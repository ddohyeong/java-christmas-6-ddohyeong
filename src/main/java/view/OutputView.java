package view;

import static view.OutputMessage.*;

import java.util.List;

import domain.BenefitCalculator;
import domain.DecemberEventPlanner;
import domain.EventBadge;
import domain.MenuManager;
import domain.MenuMessage;
import domain.OrderCalculator;
import domain.menu.Menu;

public class OutputView {
	public void printStartInfo() {
		System.out.println(WELCOME.getMessage());
	}

	public void printEventBenefitsPreviewMessage(DecemberEventPlanner decemberEventPlanner) {
		System.out.printf(EVENT_PREVIEW_MESSAGE.getMessage(), decemberEventPlanner.getReservationDate());
		printBlank();
	}

	public void printOrderMenus(MenuManager menuManager) {
		System.out.println(ORDER_MENU_HEADER.getMessage());

		for (Menu<? extends Enum<?>> menu : menuManager.getMenus()) {
			List<MenuMessage> menuMessage = menu.createMenusMessage();
			for (MenuMessage message : menuMessage) {
				System.out.printf(ORDER_MENU_ITEM.getMessage(), message.getMenuName(), message.getAmount());
			}
		}

		printBlank();
	}

	public void printBenefitBeforeTotalPrice(OrderCalculator orderCalculator) {
		System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage());
		System.out.printf(FORMATTED_PRICE.getMessage(), orderCalculator.getTotalBills());
		System.out.println();
	}

	public void printFreeGiftMenu(BenefitCalculator benefitCalculator) {
		System.out.println(GIFT_MENU.getMessage());
		if (!(benefitCalculator.getFreeGiftMenu() == null)) {
			System.out.printf(GIFT_MENU_ITEM.getMessage(), benefitCalculator.getFreeGiftMenu().getMenuName());
			System.out.println();
			return;
		}

		System.out.println(NO_GIFT_MENU.getMessage());
		System.out.println();
	}

	public void printBenefitDetails(BenefitCalculator benefitCalculator, DecemberEventPlanner decemberEventPlanner) {
		System.out.println(BENEFIT_DETAILS_HEADER.getMessage());
		if (benefitCalculator.getEventApplicability()) {
			printDiscount(CHRISTMAS_DISCOUNT.getMessage(), benefitCalculator.getChristmasDiscount());
			printWeekendDiscount(benefitCalculator, decemberEventPlanner);
			printWeekdayDiscount(benefitCalculator, decemberEventPlanner);
			printDiscount(SPECIAL_DAY_DISCOUNT.getMessage(), benefitCalculator.getSpecialDayDiscount());
			printFreeGiftMenuDiscount(benefitCalculator);
			printBlank();
			return;
		}
		System.out.println(NO_GIFT_MENU.getMessage());
		printBlank();
	}

	private void printFreeGiftMenuDiscount(BenefitCalculator benefitCalculator) {
		if (benefitCalculator.isFreeGiftMenuNotNull()) {
			printDiscount(FREE_GIFT_EVENT.getMessage(), benefitCalculator.getFreeGiftMenu().getPrice());
			return;
		}

		System.out.printf(FORMATTED_GIFT_MENU.getMessage(), FREE_GIFT_EVENT.getMessage(), NO_GIFT_MENU.getMessage());
	}

	private void printDiscount(String label, int discountAmount) {
		System.out.printf(FORMATTED_DISCOUNT_AMOUNT.getMessage(), label, discountAmount);
	}

	private void printWeekdayDiscount(BenefitCalculator benefitCalculator, DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getWeekDayDiscount()) {
			printDiscount(WEEKDAY_DISCOUNT.getMessage(), benefitCalculator.getWeekDayDiscount());
		}
	}

	private void printWeekendDiscount(BenefitCalculator benefitCalculator, DecemberEventPlanner decemberEventPlanner) {
		if (decemberEventPlanner.getWeekendDiscount()) {
			printDiscount(WEEKEND_DISCOUNT.getMessage(), benefitCalculator.getWeekendDayDiscount());
		}
	}

	public void printTotalBenefits(BenefitCalculator benefitCalculator) {
		System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage());
		System.out.printf(FORMATTED_BENEFIT_PRICE.getMessage(), benefitCalculator.getTotalBenefitPrice());
		System.out.println();
	}

	public void printExceptedPayment(BenefitCalculator benefitCalculator) {
		System.out.println(EXPECTED_PAYMENT.getMessage());
		System.out.printf(FORMATTED_PRICE.getMessage(), benefitCalculator.getExpectedPayment());
		System.out.println();
	}

	public void printEventBadge(EventBadge eventBadge) {
		System.out.println(EVENT_BADGE.getMessage());
		System.out.println(eventBadge.getBadge());
	}

	public void printBlank() {
		System.out.println();
	}
}
