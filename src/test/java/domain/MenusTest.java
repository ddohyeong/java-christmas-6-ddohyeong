package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.AppetizerMenu;
import domain.menu.menuenum.Appetizer;

class MenusTest {
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
}
