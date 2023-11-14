package domain.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MenuMessage;
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
		return totalAmount;
	}

	@Override
	public void calculateTotalAmount() {
		for (Integer amount : appetizerMenu.values()) {
			this.totalAmount += amount;
		}
	}

	@Override
	public Map<Appetizer, Integer> getMenu() {
		return this.appetizerMenu;
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
		this.totalAmount += amount;
	}

	@Override
	public List<MenuMessage> createMenusMessage() {
		List<MenuMessage> messages = new ArrayList<>();
		for (Map.Entry<Appetizer, Integer> appetizer : appetizerMenu.entrySet()) {
			String menuName = appetizer.getKey().getMenuName();
			int amount = appetizer.getValue();
			if (amount > 0) {
				messages.add(new MenuMessage(menuName, amount));
			}
		}
		return messages;
	}
}
