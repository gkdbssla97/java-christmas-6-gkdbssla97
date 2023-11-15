package christmas.validate;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.util.validate.input.MenuError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputMenuTest extends NsTest {

    @Nested
    @DisplayName("주문 메뉴 숫자 관련 케이스")
    class MenuNumberCase {

        @DisplayName("메뉴의 개수는 1 이상의 숫자만 입력받는다.")
        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-0", "레드와인-!", "아이스크림-10,타파쓰-a"})
        void validateMenuQuantityByInputMenus(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_ORDER.getErrorMessage());
            });
        }

        @DisplayName("메뉴는 한 번에 최대 20개까지만 주문할 수 있다.")
        @ParameterizedTest
        @ValueSource(strings = {"제로콜라-10,레드와인-9,아이스크림-2", "타파스-21"})
        void validateMenuMaxQuantity(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_MAX_MENU_QUANTITY.getErrorMessage());
            });
        }
    }

    @Nested
    @DisplayName("주문 메뉴 입력 형식 관련 케이스")
    class MenuFormatCase {
        @DisplayName("고객이 메뉴판에 없는 메뉴를 입력하는 경우 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"f-1", "티본스테이크1-2", "아이스크림-20,타파쓰-1"})
        void validateMatchMenuNameInEventMenus(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_ORDER.getErrorMessage());
            });
        }

        @DisplayName("메뉴 형식이 예시와 다른 경우 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크--0", "크리스마스파스타0,", "샴페인0", "-레드와인-1,바베큐립-3", "아이스크림-10,,타파스-1", "초코케이크-10,.타파스"})
        void validateMenuFormatByuInputMenus(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_MENU_FORMAT.getErrorMessage());
            });
        }

        @DisplayName("중복 메뉴를 입력한 경우 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"초코케이크-10,초코케이크-1", "아이스크림-1,바비큐립-3,타파스-4,아이스크림-1"})
        void validateDuplicateMenuNamesByuInputMenus(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_DUPLICATE_MENU_NAME.getErrorMessage());
            });
        }

        @DisplayName("음료만 주문 시, 주문할 수 없으므로 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"제로콜라-1", "제로콜라-10,레드와인-9", "제로콜라-1,샴페인-2,레드와인-3"})
        void validateOnlyDrinkCategoryByuInputMenus(String input) {
            assertSimpleTest(() -> {
                runException("1", input);
                assertThat(output()).contains(MenuError.INVALID_ORDERING_ONLY_DRINK.getErrorMessage());
            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
