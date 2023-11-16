package domain;

import static message.RegexMessage.*;

import java.util.Arrays;
import java.util.List;

import exception.ErrorMessage;

public class OrderMenu {
	private final String menuName;
	private final int amount;

	public OrderMenu(MenuManager menuManager, String input) {
		validateOrderMenuFormat(input);
		List<String> orderMenu = splitByHyphen(input);

		String orderMenuName = orderMenu.get(0);
		validateMenuExists(menuManager, orderMenuName);
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
		if (!input.matches(ORDER_MENU_REGEX.getRegex())) {
			ErrorMessage.INVALID_ORDER.throwException();
		}
	}

	private List<String> splitByHyphen(String input) {
		return Arrays.asList(input.split(HYPHEN.getRegex()));
	}

	private void validateMenuExists(MenuManager menuManager, String input) {
		if (isMenuExists(menuManager, input)) {
			ErrorMessage.INVALID_ORDER.throwException();
		}
	}

	private static boolean isMenuExists(MenuManager menuManager, String input) {
		return menuManager.findEnumValueInMenuName(input) == null;
	}

	private void validateAmountZero(int amount) {
		if (amount == 0) {
			ErrorMessage.INVALID_ORDER.throwException();
		}
	}
}
