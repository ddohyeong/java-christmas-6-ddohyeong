package domain.menu.menuenum;

public enum MainCourse {
	T_BONE_STEAK("티본스테이크", 55000),
	BBQ_RIBS("바비큐립", 54000),
	SEAFOOD_PASTA("해산물파스타", 35000),
	CHRISTMAS_PASTA("크리스마스파스타", 25000);

	private final String menuName;
	private final int price;

	MainCourse(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public int getPrice() {
		return price;
	}
}
