package christmas.discount;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.discount.condition.*;
import christmas.model.domain.discount.policy.*;
import christmas.model.domain.event.EventCalendar;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.menu.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class DiscountTest {

    private final List<Menu> menus = new ArrayList<>();
    private final EventManager eventManager = new EventManager();
    private final EventCalendar eventCalendar = new EventCalendar();

    @BeforeEach
    void initialize() {
        Menu menu1 = new Main(Price.바비큐립.name(), 2); // 54000 * 2
        Menu menu2 = new Main(Price.티본스테이크.name(), 1); // 55000
        Menu menu3 = new Dessert(Price.아이스크림.name(), 2); // 5000 * 2
        Menu menu4 = new Drink(Price.레드와인.name(), 5); // 60000 * 5
        Menu menu5 = new Appetizer(Price.시저샐러드.name(), 5); // 8000 * 5

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);

        eventManager.orderMenuList(menus);
        eventManager.initializeBenefitDetails();
        eventManager.calculateTotalOrderPrice();
    }

    @Nested
    @DisplayName("D-Day 할인 이벤트 정책 및 조건")
    class DDay {
        private final DiscountCondition discountCondition = new DDayCondition();
        private final DiscountPolicy discountPolicy = new DDayPolicy();

        @ParameterizedTest
        @MethodSource("provideInputDate")
        void dDayDiscount(int input, int expectedValue) {
            discountCondition.isSatisfied(eventCalendar, input);
            discountPolicy.discount(eventManager, input);

            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            Integer discountPrice = benefitDetails.get(DiscountPolicyName.CHRISTMAS_D_DAY);
            Assertions.assertThat(discountPrice).isEqualTo(expectedValue);
        }

        private static Stream<Arguments> provideInputDate() {
            return Stream.of(
                    Arguments.of(1, -1000 - (1 - 1) * 100),
                    Arguments.of(2, -1000 - (2 - 1) * 100),
                    Arguments.of(3, -1000 - (3 - 1) * 100),
                    Arguments.of(5, -1000 - (5 - 1) * 100),
                    Arguments.of(10, -1000 - (10 - 1) * 100),
                    Arguments.of(25, -1000 - (25 - 1) * 100)
            );
        }
    }

    @Nested
    @DisplayName("평일 할인 이벤트 정책 및 조건")
    class Weekday {
        private final DiscountCondition discountCondition = new WeekdayCondition();
        private final DiscountPolicy discountPolicy = new WeekdayPolicy();

        @ParameterizedTest
        @MethodSource("provideInputDate")
        void dDayDiscount(int input, int expectedValue) {
            discountCondition.isSatisfied(eventCalendar, input);
            discountPolicy.discount(eventManager, input);

            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            Integer discountPrice = benefitDetails.get(DiscountPolicyName.WEEKDAY);
            Assertions.assertThat(discountPrice).isEqualTo(expectedValue);
        }

        private static Stream<Arguments> provideInputDate() {
            return Stream.of(
                    Arguments.of(4, -2023),
                    Arguments.of(12, -2023),
                    Arguments.of(13, -2023),
                    Arguments.of(20, -2023)
            );
        }
    }

    @Nested
    @DisplayName("주말 할인 이벤트 정책 및 조건")
    class Weekend {
        private final DiscountCondition discountCondition = new WeekendCondition();
        private final DiscountPolicy discountPolicy = new WeekendPolicy();

        @ParameterizedTest
        @ValueSource(ints = {8, 16, 23, 29, 30})
        void dDayDiscount(int input) {
            discountCondition.isSatisfied(eventCalendar, input);
            discountPolicy.discount(eventManager, input);

            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            Integer discountPrice = benefitDetails.get(DiscountPolicyName.WEEKEND);
            Assertions.assertThat(discountPrice).isEqualTo(-2023 * 2);
        }
    }

    @Nested
    @DisplayName("특별 할인 이벤트 정책 및 조건")
    class SpecialDay {
        private final DiscountCondition discountCondition = new SpecialCondition();
        private final DiscountPolicy discountPolicy = new SpecialPolicy();

        @ParameterizedTest
        @ValueSource(ints = {3, 10, 17, 24, 25})
        void dDayDiscount(int input) {
            discountCondition.isSatisfied(eventCalendar, input);
            discountPolicy.discount(eventManager, input);

            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            Integer discountPrice = benefitDetails.get(DiscountPolicyName.SPECIAL);
            Assertions.assertThat(discountPrice).isEqualTo(-1000);
        }
    }
}
