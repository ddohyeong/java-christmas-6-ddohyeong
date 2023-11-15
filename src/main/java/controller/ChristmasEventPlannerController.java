package controller;

import domain.ReservationDate;
import service.ChristmasEventPlannerService;
import view.OutputView;

public class ChristmasEventPlannerController {
	private final OutputView outputView = new OutputView();
	private final ChristmasEventPlannerService christmasEventPlannerService = new ChristmasEventPlannerService();
	private ReservationDate reservationDate;

	public void run() {
		outputView.printStartInfo();
		getExceptedReservationDate();
	}

	private void getExceptedReservationDate() {
		reservationDate = christmasEventPlannerService.setReservationDate();
	}
}
