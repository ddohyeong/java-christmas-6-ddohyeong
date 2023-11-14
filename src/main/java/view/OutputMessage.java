package view;

public enum OutputMessage {
	WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
	EVENT_PREVIEW_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
	TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
	EXPECTED_PAYMENT("<할인 후 예상 결제 금액>"),
	GIFT_MENU("<증정 메뉴>"),
	EVENT_BADGE("<12월 이벤트 배지>"),
	ORDER_MENU_HEADER("<주문 메뉴>"),
	BENEFIT_DETAILS_HEADER("<혜택 내역>"),
	CHRISTMAS_DISCOUNT("크리스마스 디데이 할인"),
	WEEKEND_DISCOUNT("주말 할인"),
	WEEKDAY_DISCOUNT("평일 할인"),
	SPECIAL_DAY_DISCOUNT("특별 할인"),
	FREE_GIFT_EVENT("증정 이벤트"),
	TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
	NO_GIFT_MENU("없음"),
	GIFT_MENU_ITEM("%s 1개\n"),
	ORDER_MENU_ITEM("%s %d개\n"),
	FORMATTED_PRICE("%,d원\n"),
	FORMATTED_BENEFIT_PRICE("-%,d원\n"),
	FORMATTED_DISCOUNT_AMOUNT("%s: -%,d원\n");

	private final String message;

	OutputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
