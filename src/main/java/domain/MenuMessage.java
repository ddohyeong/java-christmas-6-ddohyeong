package domain;

public class MenuMessage {
	private final String menuName;
	private final int amount;

	public MenuMessage(String menuName, int amount) {
		this.menuName = menuName;
		this.amount = amount;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getAmount() {
		return amount;
	}
}
