package domain.menu;

import java.util.HashMap;
import java.util.Map;

import domain.menu.menuenum.Appetizer;

public class AppetizerMenu implements Menu<Appetizer> {
	private final Map<Appetizer, Integer> appetizerMenu;
	private int totalAmount = 0;

	public AppetizerMenu() {
		this.appetizerMenu = new HashMap<>() {{
				put(Appetizer.TAPAS, 0);
				put(Appetizer.MUSHROOM_SOUP, 0);
				put(Appetizer.CAESAR_SALAD, 0);
			}};
	}

	@Override
	public int getTotalAmount() {
		calculateTotalAmount();
		return totalAmount;
	}

	@Override
	public void calculateTotalAmount() {
		for (Integer amount : appetizerMenu.values()) {
			this.totalAmount += amount;
		}
	}

	@Override
	public Map<Appetizer, Integer> getMenuItems() {
		return appetizerMenu;
	}

	@Override
	public Appetizer fromString(String input) {
		for (Appetizer value : Appetizer.values()) {
			if (value.getMenuName().equals(input)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		appetizerMenu.put((Appetizer)category, appetizerMenu.get(category) + amount);
	}
}
