package domain.menu.menuenum;

public enum Dessert {
	CHOCO_CAKE("초코케이크", 15000),
	ICE_CREAM("아이스크림", 5000);

	private final String menuName;
	private final int price;

	Dessert(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuName() {
		return menuName;
	}
}
