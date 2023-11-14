package domain;

import java.util.Map;

import domain.menu.Menu;
import domain.menu.menuenum.Appetizer;
import domain.menu.menuenum.Dessert;
import domain.menu.menuenum.Drink;
import domain.menu.menuenum.MainCourse;

public class OrderCalculator {
	private final MenuManager menuManager;

	public OrderCalculator(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public int getTotalBills() {
		return getMainCourseBills() + getAppetizerBills() + getDessertBills() + getDrinkBills();
	}

	public int getMainCourseBills() {
		Menu<? extends Enum<?>> mainMenus = getMainCourseMenu();
		int mainCourseTotalPrice = 0;

		for (Map.Entry<? extends Enum<?>, Integer> entry : mainMenus.getMenu().entrySet()) {
			MainCourse menu = (MainCourse)entry.getKey();
			Integer amount = entry.getValue();

			mainCourseTotalPrice += menu.getPrice() * amount;
		}

		return mainCourseTotalPrice;
	}

	public int getAppetizerBills() {
		Menu<? extends Enum<?>> mainMenus = getAppetizerMenu();
		int appetizerTotalPrice = 0;

		for (Map.Entry<? extends Enum<?>, Integer> entry : mainMenus.getMenu().entrySet()) {
			Appetizer menu = (Appetizer)entry.getKey();
			Integer amount = entry.getValue();

			appetizerTotalPrice += menu.getPrice() * amount;
		}

		return appetizerTotalPrice;
	}

	public int getDessertBills() {
		Menu<? extends Enum<?>> mainMenus = getDessertMenu();
		int dessertTotalPrice = 0;

		for (Map.Entry<? extends Enum<?>, Integer> entry : mainMenus.getMenu().entrySet()) {
			Dessert menu = (Dessert)entry.getKey();
			Integer amount = entry.getValue();

			dessertTotalPrice += menu.getPrice() * amount;
		}

		return dessertTotalPrice;
	}

	public int getDrinkBills() {
		Menu<? extends Enum<?>> mainMenus = getDrinkMenu();
		int drinkTotalPrice = 0;

		for (Map.Entry<? extends Enum<?>, Integer> entry : mainMenus.getMenu().entrySet()) {
			Drink menu = (Drink)entry.getKey();
			Integer amount = entry.getValue();

			drinkTotalPrice += menu.getPrice() * amount;
		}

		return drinkTotalPrice;
	}

	public int getMainCourseTotalAmount() {
		return getMainCourseMenu().getTotalAmount();
	}

	public int getAppetizerTotalAmount() {
		return getAppetizerMenu().getTotalAmount();
	}

	public int getDessertTotalAmount() {
		return getDessertMenu().getTotalAmount();
	}

	public int getDrinkTotalAmount() {
		return getDrinkMenu().getTotalAmount();
	}

	private Menu<? extends Enum<?>> getMainCourseMenu() {
		return menuManager.getMenus().get(0);
	}

	private Menu<? extends Enum<?>> getAppetizerMenu() {
		return menuManager.getMenus().get(1);
	}

	private Menu<? extends Enum<?>> getDessertMenu() {
		return menuManager.getMenus().get(2);
	}

	private Menu<? extends Enum<?>> getDrinkMenu() {
		return menuManager.getMenus().get(3);
	}

}
