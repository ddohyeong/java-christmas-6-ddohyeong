package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecemberEventPlannerTest {

	@DisplayName("크리스마스 디데이 할인 기간인지 검증")
	@Test
	public void testIsChristmasDiscountDay() {
		// given
		ReservationDate reservationDate = new ReservationDate("12");
		DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner(reservationDate);
		// when
		Boolean christmasDiscountDay = decemberEventPlanner.getChristmasDiscountDay();

		// then
		Assertions.assertThat(christmasDiscountDay).isTrue();
	}

	@DisplayName("주말 할인 기간인지 검증")
	@Test
	public void testIsWeekendDiscount() {
		// given
		ReservationDate reservationDate = new ReservationDate("8");
		DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner(reservationDate);

		// when
		Boolean weekendDiscount = decemberEventPlanner.getWeekendDiscount();

		// then
		Assertions.assertThat(weekendDiscount).isTrue();
	}

	@DisplayName("평일 할인 기간인지 검증")
	@Test
	public void testIsWeekdayDiscount() {
		// given
		ReservationDate reservationDate = new ReservationDate("10");
		DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner(reservationDate);

		// when
		Boolean weekDayDiscount = decemberEventPlanner.getWeekDayDiscount();

		// then
		Assertions.assertThat(weekDayDiscount).isTrue();
	}

	@DisplayName("특별 할인 기간인지 검증")
	@Test
	public void testIsSpecialDiscount() {
		// given
		ReservationDate reservationDate = new ReservationDate("25");
		DecemberEventPlanner decemberEventPlanner = new DecemberEventPlanner(reservationDate);


		// when
		Boolean specialDiscount = decemberEventPlanner.getSpecialDiscount();

		// then
		Assertions.assertThat(specialDiscount).isTrue();
	}
}
