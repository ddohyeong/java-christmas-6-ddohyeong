package service;

import domain.ReservationDate;
import view.InputView;

public class ChristmasEventPlannerService {
	private final InputView inputView = new InputView();
	public ReservationDate setReservationDate() {
		while (true) {
			try {
				return new ReservationDate(inputView.enterReservationDate());
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
