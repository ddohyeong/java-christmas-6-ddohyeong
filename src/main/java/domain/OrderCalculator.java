package domain;

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
		return getMainCourseMenu()
				.getMenu()
				.entrySet()
				.stream()
				.mapToInt(entry -> {
					MainCourse menu = (MainCourse)entry.getKey();
					int amount = entry.getValue();
					return menu.getPrice() * amount;
				})
				.sum();
	}

	public int getAppetizerBills() {
		return getAppetizerMenu()
				.getMenu()
				.entrySet()
				.stream()
				.mapToInt(entry -> {
					Appetizer menu = (Appetizer)entry.getKey();
					int amount = entry.getValue();
					return menu.getPrice() * amount;
				})
				.sum();
	}

	public int getDessertBills() {
		return getDessertMenu()
				.getMenu()
				.entrySet()
				.stream()
				.mapToInt(entry -> {
					Dessert menu = (Dessert)entry.getKey();
					int amount = entry.getValue();
					return menu.getPrice() * amount;
				})
				.sum();
	}

	public int getDrinkBills() {
		return getDrinkMenu()
				.getMenu()
				.entrySet()
				.stream()
				.mapToInt(entry -> {
					Drink menu = (Drink)entry.getKey();
					int amount = entry.getValue();
					return menu.getPrice() * amount;
				})
				.sum();
	}

	public int getMainCourseTotalAmount() {
		return getMainCourseMenu().getTotalAmount();
	}

	public int getDessertTotalAmount() {
		return getDessertMenu().getTotalAmount();
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
