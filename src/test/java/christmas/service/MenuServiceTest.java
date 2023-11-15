package christmas.service;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;
import christmas.model.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuServiceTest {

    private final MenuService menuService = new MenuService();
    private final EventMenu eventMenu = new EventMenu();
    private final EventManager eventManager = new EventManager();

    @BeforeEach
    void initialize() {
        menuService.initializeMenuList(eventMenu);
    }

    @Test
    @DisplayName("12월 이벤트 메뉴에 포함된 모든 메뉴를 초기화한다.")
    void initializeMenuList() {

        List<Menu> eventMenus = eventMenu.getEventMenus();

        Set<Category> allCategories = EnumSet.allOf(Category.class);
        Set<Category> menuCategories = eventMenus.stream()
                .map(Menu::getCategory)
                .collect(Collectors.toSet());

        assertEquals(allCategories, menuCategories);
        assertThat(eventMenus.size()).isGreaterThan(0);
    }

    @Nested
    @DisplayName("입력한 메뉴를 주문한다.")
    class OrderMenuList {

        @DisplayName("주문이 정상적으로 됐는지 주문목록을 검증한다.")
        @ParameterizedTest
        @MethodSource("provideInputOrderMenuList")
        void orderInputMenuListAndCheckOrderList(String input, String expectedMessage) {
            menuService.orderMenuList(eventManager, input, eventMenu);
            List<Menu> orderMenus = eventManager.getOrderMenus();

            String orderMenusMessage = orderMenus.stream()
                    .map(menu -> menu.getName() + "-" + menu.getCount())
                    .collect(Collectors.joining(","));

            assertEquals(expectedMessage, orderMenusMessage);
        }

        private static Stream<Arguments> provideInputOrderMenuList() {
            return Stream.of(
                    Arguments.of("타파스-1,제로콜라-1", "타파스-1,제로콜라-1"),
                    Arguments.of("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"),
                    Arguments.of("해산물파스타-2,레드와인-1,초코케이크-1", "해산물파스타-2,레드와인-1,초코케이크-1")
            );
        }
    }
}
