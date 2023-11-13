package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenusTest {
	private final Menus menus = new Menus();

	@DisplayName("메뉴 형식(음식-주문수,음식-주문수..) 검증")
	@ParameterizedTest
	@ValueSource(strings = {"양송이버섯-4, 초코케이크", "초코케이크-4,티본스테이크"})
	public void test3(String input) {
		// when & then
		assertThatThrownBy(() -> new OrderMenus(menus, input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("메뉴 입력을 쉼표로 분리")
	@Test
	public void testSplitByComma() {
		// given
		String input = "양송이수프-1,제로콜라-1";
		List<String> excepted = List.of("양송이수프-1", "제로콜라-1");

		// when
		OrderMenus orderMenus = new OrderMenus(menus, input);
		orderMenus.splitByComma(input);

		// then
		Assertions.assertThat(orderMenus.splitByComma(input)).isEqualTo(excepted);
	}

	@DisplayName("주문 개수가 총 20개가 넘으면 예외 발생")
	@Test
	public void testValidateTotalAmountRange() {
		// given
		String input = "양송이수프-20,제로콜라-1";

		// when & then
		assertThatThrownBy(() -> new OrderMenus(menus, input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
