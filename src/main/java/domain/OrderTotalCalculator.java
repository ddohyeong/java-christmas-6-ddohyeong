package domain;

import java.util.Map;

import domain.menu.Menu;
import domain.menu.menuenum.MainCourse;

public class OrderTotalCalculator {
	private final MenuManager menuManager;

	public OrderTotalCalculator(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public int getMainCourseBills() {
		Menu<? extends Enum<?>> mainMenus = menuManager.getMenus().get(0);
		int mainCourseTotalPrice = 0;

		for (Map.Entry<? extends Enum<?>, Integer> entry : mainMenus.getMenu().entrySet()) {
			MainCourse menu = (MainCourse)entry.getKey();
			Integer amount = entry.getValue();

			mainCourseTotalPrice += menu.getPrice() * amount;
		}

		return mainCourseTotalPrice;
	}
}
