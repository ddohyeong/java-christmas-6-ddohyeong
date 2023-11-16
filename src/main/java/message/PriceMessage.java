package message;

public enum PriceMessage {
	SANTA_PRICE(20_000),
	TREE_PRICE(10_000),
	STAR_PRICE(5_000),
	SPECIAL_DAY_DISCOUNT(1_000),
	CHRISTMAS_BASE_DISCOUNT(1_000),
	FREE_GIFT_MENU_THRESHOLD(120_000),
	CHRISTMAS_DISCOUNT_INCREMENT(100),
	EVENT_APPLICABILITY_THRESHOLD(10_000);

	private final int price;

	PriceMessage(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
