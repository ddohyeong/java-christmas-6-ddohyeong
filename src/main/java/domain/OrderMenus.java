package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMenus {
	private final List<OrderMenu> orderMenus = new ArrayList<>();
	private int totalAmount = 0;

	public OrderMenus(Menus menus, String input) {
		validateOrderMenusFormat(input);
		List<String> orderMenusByComma = splitByComma(input);

		for (String s : orderMenusByComma) {
			OrderMenu orderMenu = new OrderMenu(menus, s);

			this.totalAmount += orderMenu.getAmount();
			validateTotalAmountRange(totalAmount);

			validateOrderMenusDuplicate(orderMenu.getMenuName());
			this.orderMenus.add(orderMenu);
		}
	}

	public List<OrderMenu> getOrderMenus() {
		return orderMenus;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public List<String> splitByComma(String input) {
		return Arrays.asList(input.split(","));
	}

	private void validateOrderMenusFormat(String input) {
		if (!input.matches("^[^,-]+-[^,-]+(,[^,-]+-[^,-]+)*$")) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private void validateTotalAmountRange(int totalAmount) {
		if (totalAmount > 20) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private void validateOrderMenusDuplicate(String menuName) {
		for (OrderMenu orderMenu : orderMenus) {
			if (orderMenu.getMenuName().equals(menuName)) {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}
		}
	}
}
