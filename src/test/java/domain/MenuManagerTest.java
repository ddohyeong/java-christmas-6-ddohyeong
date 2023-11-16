package domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.AppetizerMenu;
import domain.menu.menuenum.Appetizer;
import domain.menu.menuenum.Dessert;
import domain.menu.menuenum.Drink;
import domain.menu.menuenum.MainCourse;

class MenuManagerTest {
	private MenuManager initTestMenus() {
		MenuManager menuManager = new MenuManager();
		menuManager.getMenus().get(0).putMenu(MainCourse.T_BONE_STEAK, 3);
		menuManager.getMenus().get(1).putMenu(Appetizer.MUSHROOM_SOUP, 4);
		menuManager.getMenus().get(2).putMenu(Dessert.CHOCO_CAKE, 3);
		menuManager.getMenus().get(3).putMenu(Drink.ZERO_COKE, 4);

		return menuManager;
	}

	@DisplayName("주문한 메뉴 이름에 따라 메뉴 찾기")
	@Test
	public void testFindEnumValueInMenuName() {
		// given
		MenuManager menuManager = new MenuManager();

		// when & then
		Assertions.assertThat(menuManager.findEnumValueInMenuName("양송이수프"))
				.isEqualTo(Appetizer.MUSHROOM_SOUP);
	}

	@DisplayName("주문한 메뉴 이름에 따라 메뉴 카테고리 찾기")
	@Test
	public void testFindMenuCategory() {
		// given
		MenuManager menuManager = new MenuManager();

		// when & then
		Assertions.assertThat(menuManager.findMenuCategory("양송이수프").getClass())
				.isEqualTo(AppetizerMenu.class);
	}

	@DisplayName("주문을 원하는 메뉴 정보로 주문")
	@Test
	public void testOrder() {
		// given
		String input = "티본스테이크-3,양송이수프-4,초코케이크-3,제로콜라-4";
		MenuManager menuManager = new MenuManager();
		OrderMenus orderMenus = new OrderMenus(menuManager, input);

		// when
		menuManager.order(orderMenus);

		// then
		Assertions.assertThat(menuManager.getMenus())
				.usingRecursiveFieldByFieldElementComparator()
				.containsExactlyElementsOf(initTestMenus().getMenus());
	}

	@DisplayName("음료만 주문 시 예외 발생")
	@Test
	public void testValidateHasOnlyDrink() {
		// given
		String input = "샴페인-3,레드와인-4,제로콜라-4";
		MenuManager menuManager = new MenuManager();

		OrderMenus orderMenus = new OrderMenus(menuManager, input);

		// when & then
		assertThatThrownBy(() -> menuManager.order(orderMenus))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
