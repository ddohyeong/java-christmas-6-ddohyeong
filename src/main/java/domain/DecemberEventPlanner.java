package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class DecemberEventPlanner {
	private final Boolean christmasDiscountDay;
	private final Boolean weekendDiscount;
	private final Boolean weekDayDiscount;
	private final Boolean specialDiscount;

	public DecemberEventPlanner(ReservationDate reservationDate) {
		this.christmasDiscountDay = isChristmasDiscountDay(reservationDate);
		this.weekDayDiscount = isWeekdayDiscount(reservationDate);
		this.weekendDiscount = isWeekendDiscount(reservationDate);
		this.specialDiscount = isSpecialDiscount(reservationDate);
	}

	public Boolean getChristmasDiscountDay() {
		return christmasDiscountDay;
	}

	public Boolean getWeekendDiscount() {
		return weekendDiscount;
	}

	public Boolean getWeekDayDiscount() {
		return weekDayDiscount;
	}

	public Boolean getSpecialDiscount() {
		return specialDiscount;
	}

	private Boolean isChristmasDiscountDay(ReservationDate reservationDate) {
		LocalDate christmasDiscountDayStart = LocalDate.of(2023, 12, 1);
		LocalDate christmasDiscountDayEnd = LocalDate.of(2023, 12, 25);
		LocalDate date = reservationDate.getReservationDate();

		return !date.isBefore(christmasDiscountDayStart) && !date.isAfter(christmasDiscountDayEnd);
	}

	private Boolean isWeekendDiscount(ReservationDate reservationDate) {
		LocalDate date = reservationDate.getReservationDate();
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
	}

	private Boolean isWeekdayDiscount(ReservationDate reservationDate) {
		return !isWeekendDiscount(reservationDate);
	}

	private Boolean isSpecialDiscount(ReservationDate reservationDate) {
		List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);
		LocalDate date = reservationDate.getReservationDate();

		for (Integer day : specialDay) {
			LocalDate dateToCheck = LocalDate.of(2023, 12, day);

			if (date.isEqual(dateToCheck)) {
				return true;
			}
		}
		return false;
	}
}
