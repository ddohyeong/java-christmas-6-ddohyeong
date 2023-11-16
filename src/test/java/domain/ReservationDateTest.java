package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReservationDateTest {
	@DisplayName("날짜 입력이 숫자가 아니라면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {" ", "", "asd"})
	public void nonNumeric(String input) {
		// when & then
		assertThatThrownBy(() -> new ReservationDate(input))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("날짜가 1~31 사이의 숫자가 아니면 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"0", "32"})
	public void testDateRangeValidation(String input) {
		// when & then
		assertThatThrownBy(() -> new ReservationDate(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
