package domain.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MenuMessage;
import domain.menu.menuenum.Dessert;

public class DessertMenu implements Menu<Dessert> {
	private final Map<Dessert, Integer> dessertMenu;
	private int totalAmount = 0;

	public DessertMenu() {
		this.dessertMenu = new HashMap<>() {{
				put(Dessert.ICE_CREAM, 0);
				put(Dessert.CHOCO_CAKE, 0);
			}};
	}

	@Override
	public int getTotalAmount() {
		return totalAmount;
	}

	@Override
	public Map<Dessert, Integer> getMenu() {
		return this.dessertMenu;
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
	public void calculateTotalAmount() {
		for (Integer amount : dessertMenu.values()) {
			this.totalAmount += amount;
		}
	}

	@Override
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		dessertMenu.put((Dessert)category, dessertMenu.get(category) + amount);
		this.totalAmount += amount;
	}

	@Override
	public List<MenuMessage> createMenusMessage() {
		return new ArrayList<>(dessertMenu.entrySet().stream()
				.filter(entry -> entry.getValue() > 0)
				.map(entry -> new MenuMessage(entry.getKey().getMenuName(), entry.getValue()))
				.toList());
	}
}
