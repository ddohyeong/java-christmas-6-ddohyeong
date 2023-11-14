package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeTest {

	@DisplayName("총 혜택 금액이 5000원 이상 : 별")
	@Test
	public void testisStarBadge() {
		// given
		int benefitPrice = 6000;
		EventBadge eventBadge = new EventBadge(benefitPrice);

		// when & then
		Assertions.assertThat(eventBadge.getBadge()).isEqualTo("별");
	}

	@DisplayName("총 혜택 금액이 10000원 이상 : 트리")
	@Test
	public void testIsTreeBadge() {
		// given
		int benefitPrice = 10000;
		EventBadge eventBadge = new EventBadge(benefitPrice);

		// when & then
		Assertions.assertThat(eventBadge.getBadge()).isEqualTo("트리");
	}

	@DisplayName("총 혜택 금액이 5000원 이상 : 산타")
	@Test
	public void testIsSantaBadge() {
		// given
		int benefitPrice = 20000;
		EventBadge eventBadge = new EventBadge(benefitPrice);

		// when & then
		Assertions.assertThat(eventBadge.getBadge()).isEqualTo("산타");
	}

	@DisplayName("총 혜택 금액이 5000원 미만 : 없음")
	@Test
	public void testIsNonBadge() {
		// given
		int benefitPrice = 3000;
		EventBadge eventBadge = new EventBadge(benefitPrice);

		// when & then
		Assertions.assertThat(eventBadge.getBadge()).isEqualTo("없음");
	}
}
