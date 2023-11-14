package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTotalCalculatorTest {

	@DisplayName("메인코스 주문 금액 계산")
	@Test
	public void testGetMainCourseBills() {
		// given
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, "티본스테이크-1,바비큐립-1,초코케이크-2,레드와인-1,양송이수프-4");
		menuManager.order(orderMenus);
		int excepted = 109_000;

		// when
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		int mainCourseBills = orderTotalCalculator.getMainCourseBills();

		// then
		Assertions.assertThat(mainCourseBills).isEqualTo(excepted);
	}

	@DisplayName("애피타이저 주문 금액 계산")
	@Test
	public void testGetAppetizerBills() {
		// given
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, "티본스테이크-1,바비큐립-1,초코케이크-2,레드와인-1,양송이수프-4");
		menuManager.order(orderMenus);
		int excepted = 24_000;

		// when
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		int appetizerBills = orderTotalCalculator.getAppetizerBills();

		// then
		Assertions.assertThat(appetizerBills).isEqualTo(excepted);
	}

	@DisplayName("디저트 주문 금액 계산")
	@Test
	public void testGetDessertBills() {
		// given
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, "티본스테이크-1,바비큐립-1,초코케이크-2,레드와인-1,양송이수프-4");
		menuManager.order(orderMenus);
		int excepted = 30_000;

		// when
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		int dessertBills = orderTotalCalculator.getDessertBills();

		// then
		Assertions.assertThat(dessertBills).isEqualTo(excepted);
	}

	@DisplayName("음료 주문 금액 계산")
	@Test
	public void testGetDrinkBills() {
		// given
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, "티본스테이크-1,바비큐립-1,초코케이크-2,레드와인-1,양송이수프-4");
		menuManager.order(orderMenus);
		int excepted = 60_000;

		// when
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		int drinkBills = orderTotalCalculator.getDrinkBills();

		// then
		Assertions.assertThat(drinkBills).isEqualTo(excepted);
	}

	@DisplayName("총 주문 금액 계산")
	@Test
	public void testGetTotalBills() {
		// given
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, "티본스테이크-1,바비큐립-1,초코케이크-2,레드와인-1,양송이수프-4");
		menuManager.order(orderMenus);
		int excepted = 223_000;

		// when
		OrderTotalCalculator orderTotalCalculator = new OrderTotalCalculator(menuManager);
		int totalBills = orderTotalCalculator.getTotalBills();

		// then
		Assertions.assertThat(totalBills).isEqualTo(excepted);
	}
}
