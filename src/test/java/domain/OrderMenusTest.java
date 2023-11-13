package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

}
