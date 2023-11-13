package domain.menu.menuenum;

public enum Appetizer {
	MUSHROOM_SOUP("양송이수프", 6000),
	TAPAS("타파스", 5500),
	CAESAR_SALAD("시저샐러드", 8000);

	private final String menuName;
	private final int price;

	Appetizer(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuName() {
		return menuName;
	}

}
