package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitCalculatorTest {

	private static OrderTotalCalculator getOrderTotalCalculator(String menus) {
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, menus);

		menuManager.order(orderMenus);
		return new OrderTotalCalculator(menuManager);
	}

	@DisplayName("총 가격 주문이 10000원 이상일때 이벤트 적용")
	@Test
	public void testIsEventApplicabilityTrue() {
		// given
		OrderTotalCalculator orderTotalCalculator = getOrderTotalCalculator("티본스테이크-1,바비큐립-1,초코케이크-2");

		// when
		BenefitCalculator benefitCalculator = new BenefitCalculator();
		boolean eventApplicability = benefitCalculator.isEventApplicability(orderTotalCalculator);

		// then
		Assertions.assertThat(eventApplicability).isTrue();
	}

	@DisplayName("총 가격 주문이 10000원 이상이 아니라면 이벤트 적용 실패")
	@Test
	public void testIsEventApplicabilityFail() {
		// given
		OrderTotalCalculator orderTotalCalculator = getOrderTotalCalculator("양송이수프-1");
		// when
		BenefitCalculator benefitCalculator = new BenefitCalculator();
		boolean eventApplicability = benefitCalculator.isEventApplicability(orderTotalCalculator);

		// then
		Assertions.assertThat(eventApplicability).isFalse();
	}

}
