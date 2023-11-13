package domain;

public class OrderMenu {
	private String menuName;
	private int amount;

	public OrderMenu(String input) {
		validateOrderMenuFormat(input);
	}

	public String getMenuName() {
		return menuName;
	}

	public int getAmount() {
		return amount;
	}

	private void validateOrderMenuFormat(String input) {
		if (!input.matches("^[가-힣]+-\\d+$")) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

}
