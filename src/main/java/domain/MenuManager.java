package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.menu.AppetizerMenu;
import domain.menu.DessertMenu;
import domain.menu.DrinkMenu;
import domain.menu.MainCourseMenu;
import domain.menu.Menu;
import exception.ErrorMessage;

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
		return menus.stream()
				.map(menuCategory -> menuCategory.fromString(input))
				.filter(Objects::nonNull)
				.findFirst()
				.orElse(null);

	}

	public Menu<? extends Enum<?>> findMenuCategory(String input) {
		return menus.stream()
				.filter(menuType -> menuType.fromString(input) != null)
				.findFirst()
				.orElse(null);
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
			ErrorMessage.DRINKS_ONLY_ORDER.throwException();
		}
	}

	private int getTotalAmountNonDrink() {
		return menus.stream()
				.filter(menu -> !(menu instanceof DrinkMenu))
				.mapToInt(Menu::getTotalAmount)
				.sum();
	}
}
