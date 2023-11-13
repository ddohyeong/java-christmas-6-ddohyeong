package domain.menu;

import java.util.HashMap;
import java.util.Map;

import domain.menu.menuenum.Dessert;

public class DessertMenu implements Menu<Dessert> {
	private final Map<Dessert, Integer> dessertMenu;

	public DessertMenu() {
		this.dessertMenu = new HashMap<>() {{
				put(Dessert.ICE_CREAM, 0);
				put(Dessert.CHOCO_CAKE, 0);
			}};
	}

	@Override
	public Map<Dessert, Integer> getMenuItems() {
		return dessertMenu;
	}

	@Override
	public Dessert fromString(String input) {
		for (Dessert value : Dessert.values()) {
			if (value.getMenuName().equals(input)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		dessertMenu.put((Dessert)category, dessertMenu.get(category) + amount);
	}
}
