package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenuTest {

	@DisplayName("형식(음식-주문 개수) 검증")
	@ParameterizedTest
	@ValueSource(strings = {"4-초코케이크", "양송이버섯-양송이버섯", "!@-4", "양송이버섯=4"})
	public void testValidateOrderMenuFormat(String input) {
		// when & then
		assertThatThrownBy(() -> new OrderMenu(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
