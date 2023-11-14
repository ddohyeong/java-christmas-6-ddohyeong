package domain;

public class EventBadge {
	private final String badge;

	public EventBadge(int benefitPrice) {
		this.badge = createEventBadgeName(benefitPrice);
	}

	public String getBadge() {
		return badge;
	}

	private String createEventBadgeName(int benefitPrice) {
		if (isSantaBadge(benefitPrice)) {
			return "산타";
		}
		if (isTreeBadge(benefitPrice)) {
			return "트리";
		}
		if (isStarBadge(benefitPrice)) {
			return "별";
		}

		return "없음";
	}

	private boolean isSantaBadge(int benefitPrice) {
		return benefitPrice >= 20000;
	}

	private boolean isTreeBadge(int benefitPrice) {
		return benefitPrice >= 10000;
	}

	private boolean isStarBadge(int benefitPrice) {
		return benefitPrice >= 5000;
	}

}
