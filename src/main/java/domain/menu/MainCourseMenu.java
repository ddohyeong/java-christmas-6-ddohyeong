package domain.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MenuMessage;
import domain.menu.menuenum.MainCourse;

public class MainCourseMenu implements Menu<MainCourse> {
	private final Map<MainCourse, Integer> mainMenu;
	private int totalAmount = 0;

	public MainCourseMenu() {
		this.mainMenu = new HashMap<>() {{
				put(MainCourse.T_BONE_STEAK, 0);
				put(MainCourse.BBQ_RIBS, 0);
				put(MainCourse.SEAFOOD_PASTA, 0);
				put(MainCourse.CHRISTMAS_PASTA, 0);
			}};
	}

	@Override
	public int getTotalAmount() {
		return totalAmount;
	}

	@Override
	public Map<MainCourse, Integer> getMenu() {
		return this.mainMenu;
	}

	@Override
	public MainCourse fromString(String input) {
		for (MainCourse value : MainCourse.values()) {
			if (value.getMenuName().equals(input)) {
				return value;
			}
		}
		return null;
	}

	@Override
	public void calculateTotalAmount() {
		for (Integer amount : mainMenu.values()) {
			this.totalAmount += amount;
		}
	}

	@Override
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		mainMenu.put((MainCourse)category, mainMenu.get(category) + amount);
		this.totalAmount += amount;
	}

	@Override
	public List<MenuMessage> createMenusMessage() {
		return new ArrayList<>(mainMenu.entrySet().stream()
				.filter(entry -> entry.getValue() > 0)
				.map(entry -> new MenuMessage(entry.getKey().getMenuName(), entry.getValue()))
				.toList());
	}
}
