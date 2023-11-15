package christmas.domain;

import christmas.model.domain.discount.policy.DDayPolicy;
import christmas.model.domain.discount.policy.DiscountPolicy;
import christmas.model.domain.event.EventBadge;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.menu.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventManagerTest {

    private final List<Menu> menus = new ArrayList<>();
    private final EventManager eventManager = new EventManager();

    @BeforeEach
    void initialize() {
        Menu menu1 = new Main(Price.해산물파스타.name(), 2); // 35000 * 2
        Menu menu2 = new Dessert(Price.초코케이크.name(), 1); // 15000
        Menu menu3 = new Appetizer(Price.양송이수프.name(), 5); // 6000 * 5

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);

        eventManager.orderMenuList(menus);
        eventManager.initializeBenefitDetails();
        DiscountPolicy dDayPolicy = new DDayPolicy();
        dDayPolicy.discount(eventManager, 25);
    }

    @Test
    @DisplayName("주문한 메뉴리스트의 총 주문 금액을 계산한다.")
    void calculateTotalPriceByOrderingMenuList() {

        eventManager.calculateTotalOrderPrice();
        int totalPriceBeforeDiscount = eventManager.getTotalPriceBeforeDiscount();
        assertThat(totalPriceBeforeDiscount).isEqualTo(115000);
    }

    @Test
    @DisplayName("25일 방문 시 주문한 메뉴의 총 혜택금액을 계산한다.")
    void calculateTotalBenefit() {

        int totalBenefitAfterDiscount = eventManager.calculateTotalBenefitAfterDiscount();
        assertThat(totalBenefitAfterDiscount).isEqualTo(-3400);
    }

    @Test
    @DisplayName("할인 후 예상 결제금액을 계산한다.")
    void calculateTotalPriceAfterDiscount() {
        eventManager.calculateTotalOrderPrice();
        eventManager.calculateTotalBenefitAfterDiscount();
        int totalPriceAfterDiscount = eventManager.calculateTotalPriceAfterDiscount();
        assertThat(totalPriceAfterDiscount).isEqualTo(111600);
    }

    @Test
    @DisplayName("혜택금액에 따른 이벤트 뱃지를 지급한다.")
    void grantEventBadgeByBenefitDetails() {
        eventManager.calculateTotalOrderPrice();
        eventManager.calculateTotalBenefitAfterDiscount();

        eventManager.grantEventBadge();
        assertThat(eventManager.getEventBadge()).isEqualTo(EventBadge.NONE.getCategory());
    }
}
