package domain.menu.menuenum;

public enum Drink {
	ZERO_COKE("제로콜라", 3_000),
	RED_WINE("레드와인", 60_000),
	CHAMPAGNE("샴페인", 25_000);

	private final String menuName;
	private final int price;

	Drink(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuName() {
		return this.menuName;
	}
}
