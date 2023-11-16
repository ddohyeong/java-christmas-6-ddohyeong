package message;

public enum DateMessage {
	EVENT_YEAR(2023),
	EVENT_MONTH(12),
	EVENT_START_DAY(1),
	EVENT_END_DAY(25),
	MAX_DAY(31);

	private final int date;

	DateMessage(int date) {
		this.date = date;
	}

	public int getDate() {
		return date;
	}
}
