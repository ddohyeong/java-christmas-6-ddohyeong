package domain;

import java.util.Arrays;
import java.util.List;

public class OrderMenu {
	private final String menuName;
	private final int amount;

	public OrderMenu(Menus menus, String input) {
		validateOrderMenuFormat(input);
		List<String> orderMenu = splitByHyphen(input);

		String orderMenuName = orderMenu.get(0);
		validateMenuExists(menus, orderMenuName);
		this.menuName = orderMenuName;

		int orderAmount = getParseInt(orderMenu.get(1));
		validateAmountZero(orderAmount);

		this.amount = orderAmount;
	}

	private static int getParseInt(String amount) {
		return Integer.parseInt(amount);
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

	private void validateMenuExists(Menus menus, String input) {
		if (isMenuExists(menus, input)) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private static boolean isMenuExists(Menus menus, String input) {
		return menus.findEnumValueInMenus(input) == null;
	}

	private void validateAmountZero(int amount) {
		if (amount == 0) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

}
