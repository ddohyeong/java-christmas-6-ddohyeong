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
		menus.add(new DrinkMenu());
		menus.add(new DessertMenu());
		menus.add(new AppetizerMenu());
	}

	public List<Menu<? extends Enum<?>>> getMenus() {
		return menus;
	}

	public Enum<? extends Enum<?>> findEnumValueInMenus(String input) {
		for (Menu<? extends Enum<?>> menuType : menus) {
			Enum<? extends Enum<?>> menuTypeConverter = menuType.fromString(input);

			if (menuTypeConverter != null) {
				return menuTypeConverter;
			}
		}
		return null;
	}

}
