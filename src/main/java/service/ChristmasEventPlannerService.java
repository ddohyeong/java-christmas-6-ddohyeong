package service;

import domain.MenuManager;
import domain.OrderMenus;
import domain.ReservationDate;
import view.InputView;

public class ChristmasEventPlannerService {
	private final InputView inputView = new InputView();
	private final MenuManager initManager = new MenuManager();

	public ReservationDate setReservationDate() {
		while (true) {
			try {
				return new ReservationDate(inputView.enterReservationDate());
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public MenuManager setOrderMenuManager() {
		while (true) {
			try {
				MenuManager orderManager = new MenuManager();
				orderManager.order(new OrderMenus(initManager, inputView.enterOrderMenus()));
				return orderManager;
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
