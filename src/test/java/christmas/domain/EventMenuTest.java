package christmas.domain;

import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EventMenuTest {

    private final List<Menu> menus = new ArrayList<>();
    private final EventMenu eventMenu = new EventMenu();
    private Menu menu1, menu2, menu3;

    @BeforeEach
    void initializeMenus() {

        menu1 = new Main(Price.해산물파스타.name(), 10000, Category.MAIN);
        menu2 = new Dessert(Price.초코케이크.name(), 20000, Category.DESSERT);
        menu3 = new Appetizer(Price.양송이수프.name(), 50000, Category.APPETIZER);

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
    }

    @Test
    @DisplayName("메뉴들을 메뉴판에 초기화한다.")
    void initializeMenuList() {

        eventMenu.initializeMenuList(menus);
        List<Menu> eventMenus = eventMenu.getEventMenus();
        Assertions.assertThat(eventMenus).contains(menu1, menu2, menu3);
    }

    @ParameterizedTest
    @MethodSource("provideMenuNames")
    @DisplayName("메뉴 이름을 통해 카테고리를 검색한다.")
    void initializeMenuList(String input, Category expectCategory) {
        eventMenu.initializeMenuList(menus);
        Category findCategory = eventMenu.findMenuCategory(input);
        Assertions.assertThat(findCategory).isEqualTo(expectCategory);
    }

    private static Stream<Arguments> provideMenuNames() {
        return Stream.of(
                Arguments.of("해산물파스타", Category.MAIN),
                Arguments.of("초코케이크", Category.DESSERT),
                Arguments.of("양송이수프", Category.APPETIZER)
        );
    }
}
