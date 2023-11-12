package domain;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationDate {
	private final LocalDate reservationDate;

	public ReservationDate(String inputDate) {
		validateIsDigit(inputDate);
		int date = Integer.parseInt(inputDate);
		validateInDateRange(date);
		this.reservationDate = LocalDate.of(2023, 12, date);
	}

	public void validateIsDigit(String date) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(date);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("[ERROR] 날짜는 숫자만 입력 하세요");
		}
	}

	public void validateInDateRange(int date) {
		if (!(1 <= date && date <= 31)) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		}
	}
}
