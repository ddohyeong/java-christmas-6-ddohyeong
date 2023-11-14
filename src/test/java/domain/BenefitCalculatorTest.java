package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitCalculatorTest {
	private static DecemberEventPlanner getDecemberEventPlanner(String inputDate) {
		ReservationDate reservationDate = new ReservationDate(inputDate);
		return new DecemberEventPlanner(reservationDate);
	}

	private static BenefitCalculator getBenefitCalculator(MenuManager menuManager,
			DecemberEventPlanner decemberEventPlanner, String input) {

		OrderMenus orderMenus = new OrderMenus(menuManager, input);
		menuManager.order(orderMenus);
		OrderCalculator orderCalculator = new OrderCalculator(menuManager);
		return new BenefitCalculator(decemberEventPlanner, orderCalculator);
	}

	@DisplayName("총 가격 주문이 10000원 이상일때 이벤트 적용")
	@Test
	public void testIsEventApplicabilityTrue() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("12");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner,
				"티본스테이크-1,바비큐립-1,초코케이크-2"
		);

		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		// when
		boolean eventApplicability = benefitCalculator.isEventApplicability(orderTotalCalculator);

		// then
		Assertions.assertThat(eventApplicability).isTrue();
	}

	@DisplayName("총 가격 주문이 10000원 이상이 아니라면 이벤트 적용 실패")
	@Test
	public void testIsEventApplicabilityFail() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("12");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner, "양송이수프-1");
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);

		// when
		boolean eventApplicability = benefitCalculator.isEventApplicability(orderTotalCalculator);

		// then
		Assertions.assertThat(eventApplicability).isFalse();
	}

	@DisplayName("크리스마스 디데이 할인 25일때 - 할인 가격 3400원")
	@Test
	public void testGetChristmasDiscount() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("25");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner, "초코케이크-3");

		int excepted = 3400;

		// when & then
		Assertions.assertThat(benefitCalculator.getChristmasDiscount()).isEqualTo(excepted);
	}

	@DisplayName("평일 할인 - 디저트 3개 6069원 할인")
	@Test
	public void testApplyWeekDayDiscount() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("25");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner, "초코케이크-3");

		int excepted = 6069;

		// when & then
		Assertions.assertThat(benefitCalculator.getWeekDayDiscount()).isEqualTo(excepted);
	}

	@DisplayName("주말 할인 - 메인 3개 6069원 할인")
	@Test
	public void testApplyWeekendDayDiscount() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("23");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner,
				"티본스테이크-3");

		int excepted = 6069;

		// when & then
		Assertions.assertThat(benefitCalculator.getWeekendDayDiscount()).isEqualTo(excepted);
	}

	@DisplayName("특별 할인 - 1000원 할인")
	@Test
	public void testApplySpecialDayDiscount() {
		// given
		MenuManager menuManager = new MenuManager();
		DecemberEventPlanner decemberEventPlanner = getDecemberEventPlanner("24");
		BenefitCalculator benefitCalculator = getBenefitCalculator(menuManager, decemberEventPlanner,
				"티본스테이크-3");

		int excepted = 1000;

		// when & then
		Assertions.assertThat(benefitCalculator.getSpecialDayDiscount()).isEqualTo(excepted);
	}
}
