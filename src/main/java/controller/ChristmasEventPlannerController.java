package controller;

import domain.MenuManager;
import domain.ReservationDate;
import service.ChristmasEventPlannerService;
import view.OutputView;

public class ChristmasEventPlannerController {
	private final OutputView outputView = new OutputView();
	private final ChristmasEventPlannerService christmasEventPlannerService = new ChristmasEventPlannerService();
	private ReservationDate reservationDate;
	private MenuManager menuManager;

	public void run() {
		outputView.printStartInfo();
		getExceptedReservationDate();
		getExceptedOrderMenus();
	}

	private void getExceptedReservationDate() {
		reservationDate = christmasEventPlannerService.setReservationDate();
	}

	private void getExceptedOrderMenus() {
		menuManager = christmasEventPlannerService.setOrderMenuManager();
	}
}
