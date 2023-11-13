package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenuTest {
	private final Menus menus = new Menus();

	@DisplayName("형식(음식-주문 개수) 검증")
	@ParameterizedTest
	@ValueSource(strings = {"4-초코케이크", "양송이수프-양송이수프", "!@-4", "양송이수프=4"})
	public void testValidateOrderMenuFormat(String input) {
		// when & then
		assertThatThrownBy(() -> new OrderMenu(menus, input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("주문한 메뉴를 하이픈(-) 으로 분리")
	@Test
	public void testSplitByHyphen() {
		// given
		String input = "양송이수프-1";
		String exceptedMenuName = "양송이수프";
		int exceptedAmount = 1;

		// when
		OrderMenu orderMenu = new OrderMenu(menus, input);

		// then
		Assertions.assertThat(orderMenu.getMenuName()).isEqualTo(exceptedMenuName);
		Assertions.assertThat(orderMenu.getAmount()).isEqualTo(exceptedAmount);
	}

	@DisplayName("메뉴판에 없는 메뉴 입력시 예외 발생")
	@Test
	public void testValidateMenuExists() {
		//given
		String input = "탕수육-1";
		// when & then
		assertThatThrownBy(() -> new OrderMenu(menus, input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("주문 개수가 0일때 예외 발생")
	@Test
	public void testValidateAmountZero() {
		// given
		String input = "양송이수프-0";

		// when & then
		assertThatThrownBy(() -> new OrderMenu(menus, input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
