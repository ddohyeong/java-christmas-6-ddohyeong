package domain.menu;

import java.util.HashMap;
import java.util.Map;

import domain.menu.menuenum.MainCourse;

public class MainCourseMenu implements Menu<MainCourse> {
	private final Map<MainCourse, Integer> mainMenu;

	public MainCourseMenu() {
		this.mainMenu = new HashMap<>() {{
				put(MainCourse.T_BONE_STEAK, 0);
				put(MainCourse.BBQ_RIBS, 0);
				put(MainCourse.SEAFOOD_PASTA, 0);
				put(MainCourse.CHRISTMAS_PASTA, 0);
			}};
	}

	@Override
	public Map<MainCourse, Integer> getMenuItems() {
		return mainMenu;
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
	public void putMenu(Enum<? extends Enum<?>> category, int amount) {
		mainMenu.put((MainCourse)category, mainMenu.get(category) + amount);
	}
}
