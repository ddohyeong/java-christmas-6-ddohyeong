package domain.menu;

import java.util.List;
import java.util.Map;

import domain.MenuMessage;

public interface Menu<T extends Enum<T>> {
	Map<T, Integer> getMenu();

	T fromString(String input);

	int getTotalAmount();

	void calculateTotalAmount();

	void putMenu(Enum<? extends Enum<?>> category, int amount);

	List<MenuMessage> createMenusMessage();
}
