package domain;

import java.util.ArrayList;
import java.util.List;

import domain.menu.AppetizerMenu;
import domain.menu.DessertMenu;
import domain.menu.DrinkMenu;
import domain.menu.MainCourseMenu;
import domain.menu.Menu;

public class MenuManager {
	private final List<Menu<? extends Enum<?>>> menus;

	public MenuManager() {
		menus = new ArrayList<>();
		menus.add(new MainCourseMenu());
		menus.add(new AppetizerMenu());
		menus.add(new DessertMenu());
		menus.add(new DrinkMenu());
	}

	public List<Menu<? extends Enum<?>>> getMenus() {
		return menus;
	}

	public void order(OrderMenus orderMenus) {
		for (OrderMenu orderMenu : orderMenus.getOrderMenus()) {
			putOrderMenu(orderMenu);
		}
		validateHasOnlyDrink();
	}

	public Enum<? extends Enum<?>> findEnumValueInMenuName(String input) {
		for (Menu<? extends Enum<?>> menuCategory : menus) {
			Enum<? extends Enum<?>> menuTypeConverter = menuCategory.fromString(input);

			if (menuTypeConverter != null) {
				return menuTypeConverter;
			}
		}
		return null;
	}

	public Menu<? extends Enum<?>> findMenuCategory(String input) {
		for (Menu<? extends Enum<?>> menuType : this.menus) {
			if (menuType.fromString(input) != null) {
				return menuType;
			}
		}
		return null;
	}

	private void putOrderMenu(OrderMenu orderMenu) {
		for (Menu<? extends Enum<?>> menuType : this.menus) {
			if (menuType.equals(findMenuCategory(orderMenu.getMenuName()))) {
				menuType.putMenu(findEnumValueInMenuName(orderMenu.getMenuName()), orderMenu.getAmount());
			}
		}
	}

	public void validateHasOnlyDrink() {
		if (getTotalAmountNonDrink() == 0) {
			throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
		}
	}

	private int getTotalAmountNonDrink() {
		int totalAmountNonDrink = 0;

		for (Menu<? extends Enum<?>> menu : menus) {
			if (!(menu instanceof DrinkMenu)) {
				totalAmountNonDrink += menu.getTotalAmount();
			}
		}

		return totalAmountNonDrink;
	}

}
