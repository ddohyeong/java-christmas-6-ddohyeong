package domain.menu;

import java.util.Map;

public interface Menu<T extends Enum<T>> {
	Map<T, Integer> getMenuItems();

	T fromString(String input);

	int getTotalAmount();

	void calculateTotalAmount();

	void putMenu(Enum<? extends Enum<?>> category, int amount);
}
