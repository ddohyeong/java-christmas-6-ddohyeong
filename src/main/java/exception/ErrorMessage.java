package exception;

public enum ErrorMessage {
	INVALID_DATE("유효하지 않은 날짜입니다."),
	INVALID_ORDER("유효하지 않은 주문입니다."),
	MAX_MENU_EXCEEDED("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
	DRINKS_ONLY_ORDER("음료만 주문 시, 주문할 수 없습니다.");

	private static final String ERROR_TAG = "[ERROR] ";
	private static final String RETRY_MESSAGE = " 다시 입력해 주세요.";
	private final String message;

	ErrorMessage(String message) {
		this.message = ERROR_TAG + message + RETRY_MESSAGE;
	}

	public void throwException() {
		throw new IllegalArgumentException(message);
	}

}
