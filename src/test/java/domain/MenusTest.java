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

class MenusTest {
	private Menus initTestMenus() {
		Menus menus = new Menus();
		menus.getMenus().get(0).putMenu(MainCourse.T_BONE_STEAK, 3);
		menus.getMenus().get(1).putMenu(Appetizer.MUSHROOM_SOUP, 4);
		menus.getMenus().get(2).putMenu(Dessert.CHOCO_CAKE, 3);
		menus.getMenus().get(3).putMenu(Drink.ZERO_COKE, 4);

		return menus;
	}

	@DisplayName("주문한 메뉴 이름에 따라 메뉴 찾기")
	@Test
	public void testFindEnumValueInMenuName() {
		// given
		Menus menus = new Menus();

		// when & then
		Assertions.assertThat(menus.findEnumValueInMenuName("양송이수프"))
				.isEqualTo(Appetizer.MUSHROOM_SOUP);
	}

	@DisplayName("주문한 메뉴 이름에 따라 메뉴 카테고리 찾기")
	@Test
	public void testFindMenuCategory() {
		// given
		Menus menus = new Menus();

		// when & then
		Assertions.assertThat(menus.findMenuCategory("양송이수프").getClass())
				.isEqualTo(AppetizerMenu.class);
	}

	@DisplayName("주문을 원하는 메뉴 정보로 주문")
	@Test
	public void testOrder() {
		// given
		String input = "티본스테이크-3,양송이수프-4,초코케이크-3,제로콜라-4";
		Menus menus = new Menus();
		OrderMenus orderMenus = new OrderMenus(menus, input);

		// when
		menus.order(orderMenus);

		// then
		Assertions.assertThat(menus.getMenus())
				.usingRecursiveFieldByFieldElementComparator()
				.containsExactlyElementsOf(initTestMenus().getMenus());
	}

	@DisplayName("음료만 주문 시 예외 발생")
	@Test
	public void testValidateHasOnlyDrink() {
		// given
		String input = "샴페인-3,레드와인-4,제로콜라-4";
		Menus menus = new Menus();

		OrderMenus orderMenus = new OrderMenus(menus, input);
		menus.order(orderMenus);

		// when & then
		assertThatThrownBy(() -> menus.validateHasOnlyDrink())
				.isInstanceOf(IllegalArgumentException.class);
	}
}
