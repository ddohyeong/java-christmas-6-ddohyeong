package domain;

import java.util.ArrayList;
import java.util.List;

import domain.menu.AppetizerMenu;
import domain.menu.DessertMenu;
import domain.menu.DrinkMenu;
import domain.menu.MainCourseMenu;
import domain.menu.Menu;

public class Menus {
	private final List<Menu<? extends Enum<?>>> menus;

	public Menus() {
		menus = new ArrayList<>();
		menus.add(new MainCourseMenu());
		menus.add(new AppetizerMenu());
		menus.add(new DessertMenu());
		menus.add(new DrinkMenu());
	}

	public List<Menu<? extends Enum<?>>> getMenus() {
		return menus;
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
}
