package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class DecemberEventPlanner {
	public Boolean isChristmasDiscountDay(ReservationDate reservationDate) {
		LocalDate christmasDiscountDayStart = LocalDate.of(2023, 12, 1);
		LocalDate christmasDiscountDayEnd = LocalDate.of(2023, 12, 25);
		LocalDate date = reservationDate.getReservationDate();

		return !date.isBefore(christmasDiscountDayStart) && !date.isAfter(christmasDiscountDayEnd);
	}

	public Boolean isWeekendDiscount(ReservationDate reservationDate) {
		LocalDate date = reservationDate.getReservationDate();
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
	}

	public Boolean isWeekdayDiscount(ReservationDate reservationDate) {
		return !isWeekendDiscount(reservationDate);
	}

	public Boolean isSpecialDiscount(ReservationDate reservationDate) {
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
