package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecemberEventPlannerTest {
	private final DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner();

	@DisplayName("크리스마스 디데이 할인 기간인지 검증")
	@Test
	public void testIsChristmasDiscountDay() {
		// given
		ReservationDate reservationDate = new ReservationDate("12");

		// when
		Boolean christmasDiscountDay = decemberEventPlanner.isChristmasDiscountDay(reservationDate);

		// then
		Assertions.assertThat(christmasDiscountDay).isTrue();
	}

}
