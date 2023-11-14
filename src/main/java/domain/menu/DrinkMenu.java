package domain.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MenuMessage;
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
		return totalAmount;
	}

	@Override
	public Map<Drink, Integer> getMenu() {
		return this.drinkMenu;
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

	public Map<Drink, Integer> getDrinkMenu() {
		return drinkMenu;
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
		this.totalAmount += amount;
	}

	@Override
	public List<MenuMessage> createMenusMessage() {
		List<MenuMessage> messages = new ArrayList<>();
		for (Map.Entry<Drink, Integer> drink : drinkMenu.entrySet()) {
			String menuName = drink.getKey().getMenuName();
			int amount = drink.getValue();
			if (amount > 0) {
				messages.add(new MenuMessage(menuName, amount));
			}
		}
		return messages;
	}
}
