package domain.menu;

import java.util.HashMap;
import java.util.Map;

import domain.menu.menuenum.Drink;

public class DrinkMenu implements Menu<Drink> {
	private final Map<Drink, Integer> drinkMenu;
	private int totalAmount = 0;
	public DrinkMenu() {
		this.drinkMenu = new HashMap<>() {{
				put(Drink.ZERO_COKE, 0);
				put(Drink.RED_WINE, 0);
				put(Drink.CHAMPAGNE, 0);
			}};
	}

	@Override
	public int getTotalAmount() {
		calculateTotalAmount();
		return totalAmount;
	}

	@Override
	public Map<Drink, Integer> getMenuItems() {
		return drinkMenu;
	}

	@Override
	public Drink fromString(String input) {
		for (Drink value : Drink.values()) {
			if (value.getMenuName().equals(input)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public void calculateTotalAmount() {
		for (Integer amount : drinkMenu.values()) {
			this.totalAmount += amount;
		}
	}

	@Override
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		drinkMenu.put((Drink)category, drinkMenu.get(category) + amount);
	}
}
