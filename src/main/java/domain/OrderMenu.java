package domain;

import java.util.Arrays;
import java.util.List;

public class OrderMenu {
	private final String menuName;
	private final int amount;

	public OrderMenu(String input) {
		validateOrderMenuFormat(input);
		List<String> orderMenu = splitByHyphen(input);
		this.menuName = orderMenu.get(0);
		this.amount = Integer.parseInt(orderMenu.get(1));
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

	private List<String> splitByHyphen(String input) {
		return Arrays.asList(input.split("-"));
	}
}
