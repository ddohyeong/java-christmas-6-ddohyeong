package domain;

import java.time.LocalDate;

public class DecemberEventPlanner {
	public Boolean isChristmasDiscountDay(ReservationDate reservationDate) {
		LocalDate christmasDiscountDayStart = LocalDate.of(2023, 12, 1);
		LocalDate christmasDiscountDayEnd = LocalDate.of(2023, 12, 25);
		LocalDate date = reservationDate.getReservationDate();

		return !date.isBefore(christmasDiscountDayStart) && !date.isAfter(christmasDiscountDayEnd);
	}

}
