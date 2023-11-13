package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderMenus {
	private List<OrderMenu> orderMenus = new ArrayList<>();
	private int totalAmount = 0;

	public OrderMenus(Menus menus, String input) {
		validateOrderMenusFormat(input);
	}

	public List<String> splitByComma(String input) {
		return Arrays.asList(input.split(","));
	}

	private void validateOrderMenusFormat(String input) {
		if (!input.matches("^[^,-]+-[^,-]+(,[^,-]+-[^,-]+)*$")) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}
}
