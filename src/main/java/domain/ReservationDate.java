package domain;

import static message.DateMessage.*;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.ErrorMessage;

public class ReservationDate {
	private final LocalDate reservationDate;

	public ReservationDate(String inputDate) {
		validateIsDigit(inputDate);
		int date = Integer.parseInt(inputDate);
		validateInDateRange(date);
		this.reservationDate = LocalDate.of(EVENT_YEAR.getDate(), EVENT_MONTH.getDate(), date);
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void validateIsDigit(String date) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(date);

		if (!matcher.matches()) {
			ErrorMessage.INVALID_DATE.throwException();
		}
	}

	public void validateInDateRange(int date) {
		if (!(EVENT_START_DAY.getDate() <= date && date <= MAX_DAY.getDate())) {
			ErrorMessage.INVALID_DATE.throwException();
		}
	}
}
