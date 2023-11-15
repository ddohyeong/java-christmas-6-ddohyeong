package domain;

public class EventBadge {
	private static final String SANTA = "산타";
	private static final String TREE = "트리";
	private static final String STAR = "별";
	private static final String NON = "없음";
	private static final int SANTA_PRICE = 20_000;
	private static final int TREE_PRICE = 10_000;
	private static final int STAR_PRICE = 5_000;

	private final String badge;

	public EventBadge(int benefitPrice) {
		this.badge = createEventBadgeName(benefitPrice);
	}

	public String getBadge() {
		return badge;
	}

	private String createEventBadgeName(int benefitPrice) {
		if (isSantaBadge(benefitPrice)) {
			return SANTA;
		}
		if (isTreeBadge(benefitPrice)) {
			return TREE;
		}
		if (isStarBadge(benefitPrice)) {
			return STAR;
		}

		return NON;
	}

	private boolean isSantaBadge(int benefitPrice) {
		return benefitPrice >= SANTA_PRICE;
	}

	private boolean isTreeBadge(int benefitPrice) {
		return benefitPrice >= TREE_PRICE;
	}

	private boolean isStarBadge(int benefitPrice) {
		return benefitPrice >= STAR_PRICE;
	}
}
