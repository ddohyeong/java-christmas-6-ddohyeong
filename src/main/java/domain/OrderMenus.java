package domain;

import static message.RegexMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.ErrorMessage;

public class OrderMenus {

	private static final int MAX_MENU_AMOUNT = 20;

	private final List<OrderMenu> orderMenus = new ArrayList<>();
	private int totalAmount = 0;

	public OrderMenus(MenuManager menuManager, String input) {
		validateOrderMenusFormat(input);
		List<String> orderMenusByComma = splitByComma(input);

		for (String s : orderMenusByComma) {
			OrderMenu orderMenu = new OrderMenu(menuManager, s);

			this.totalAmount += orderMenu.getAmount();
			validateTotalAmountRange(totalAmount);

			validateOrderMenusDuplicate(orderMenu.getMenuName());
			this.orderMenus.add(orderMenu);
		}
	}

	public List<OrderMenu> getOrderMenus() {
		return orderMenus;
	}

	public List<String> splitByComma(String input) {
		return Arrays.asList(input.split(COMMA.getRegex()));
	}

	private void validateOrderMenusFormat(String input) {
		if (!input.matches(ORDER_MENUS_REGEX.getRegex())) {
			ErrorMessage.INVALID_DATE.throwException();
		}
	}

	private void validateTotalAmountRange(int totalAmount) {
		if (totalAmount > MAX_MENU_AMOUNT) {
			ErrorMessage.MAX_MENU_EXCEEDED.throwException();
		}
	}

	private void validateOrderMenusDuplicate(String menuName) {
		for (OrderMenu orderMenu : orderMenus) {
			if (orderMenu.getMenuName().equals(menuName)) {
				ErrorMessage.INVALID_ORDER.throwException();
			}
		}
	}
}
