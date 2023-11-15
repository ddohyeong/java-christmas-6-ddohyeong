package service;

import java.util.function.Supplier;

import domain.MenuManager;
import domain.OrderMenus;
import domain.ReservationDate;
import view.InputView;

public class ChristmasEventPlannerService {
	private final InputView inputView = new InputView();
	private final MenuManager initManager = new MenuManager();

	public ReservationDate promptForReservationDate() {
		return promptForInput(() -> new ReservationDate(inputView.enterReservationDate()));
	}

	public MenuManager promptForOrderMenuManager() {
		return promptForInput(() -> {
			MenuManager orderManager = new MenuManager();
			orderManager.order(new OrderMenus(initManager, inputView.enterOrderMenus()));
			return orderManager;
		});
	}

	private <T> T promptForInput(Supplier<T> supplier) {
		while (true) {
			try {
				return supplier.get();
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
