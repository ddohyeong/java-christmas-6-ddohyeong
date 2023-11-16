package domain;

import static message.PriceMessage.*;

public class EventBadge {
	private static final String SANTA = "산타";
	private static final String TREE = "트리";
	private static final String STAR = "별";
	private static final String NON = "없음";


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
		return benefitPrice >= SANTA_PRICE.getPrice();
	}

	private boolean isTreeBadge(int benefitPrice) {
		return benefitPrice >= TREE_PRICE.getPrice();
	}

	private boolean isStarBadge(int benefitPrice) {
		return benefitPrice >= STAR_PRICE.getPrice();
	}
}
