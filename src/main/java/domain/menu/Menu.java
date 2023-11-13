package domain.menu;

import java.util.Map;

public interface Menu<T extends Enum<T>> {
	Map<T, Integer> getMenuItems();

	public T fromString(String input);

	public void putMenu(Enum<? extends Enum<?>> category, int amount);
}
