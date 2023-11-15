package controller;

import domain.BenefitCalculator;
import domain.DecemberEventPlanner;
import domain.EventBadge;
import domain.MenuManager;
import domain.OrderCalculator;
import domain.ReservationDate;
import service.ChristmasEventPlannerService;
import view.OutputView;

public class ChristmasEventPlannerController {
	private final OutputView outputView = new OutputView();
	private final ChristmasEventPlannerService christmasEventPlannerService = new ChristmasEventPlannerService();
	private ReservationDate reservationDate;
	private MenuManager menuManager;
	private OrderCalculator orderCalculator;
	private DecemberEventPlanner decemberEventPlanner;
	private BenefitCalculator benefitCalculator;
	private EventBadge eventBadge;

	public void run() {
		outputView.printStartInfo();
		getExceptedReservationDate();
		getExceptedOrderMenus();
		exceptedOrder();
		getExceptedBenefitInfo();
	}

	private void getExceptedReservationDate() {
		reservationDate = christmasEventPlannerService.setReservationDate();
	}

	private void getExceptedOrderMenus() {
		outputView.printEventNotice();
		menuManager = christmasEventPlannerService.setOrderMenuManager();
	}

	private void exceptedOrder() {
		orderCalculator = new OrderCalculator(menuManager);
		decemberEventPlanner = new DecemberEventPlanner(reservationDate);
		benefitCalculator = new BenefitCalculator(decemberEventPlanner, orderCalculator);
		eventBadge = new EventBadge(benefitCalculator.getTotalBenefitPrice());
	}

	private void getExceptedBenefitInfo() {
		outputView.printEventBenefitsPreviewMessage(decemberEventPlanner);
		outputView.printOrderMenus(menuManager);
		outputView.printBenefitBeforeTotalPrice(orderCalculator);
		outputView.printFreeGiftMenu(benefitCalculator);
		outputView.printBenefitDetails(benefitCalculator, decemberEventPlanner);
		outputView.printTotalBenefits(benefitCalculator);
		outputView.printExceptedPayment(benefitCalculator);
		outputView.printEventBadge(eventBadge);
	}
}
