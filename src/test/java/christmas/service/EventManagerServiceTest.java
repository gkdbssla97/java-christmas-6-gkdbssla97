package christmas.service;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.event.EventCalendar;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.*;
import christmas.model.service.EventManagerService;
import christmas.model.service.MenuService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManagerServiceTest {

    private final EventManagerService eventManagerService = new EventManagerService();
    private final MenuService menuService = new MenuService();
    private final EventManager eventManager = new EventManager();
    private final EventMenu eventMenu = new EventMenu();
    private final EventCalendar eventCalendar = new EventCalendar();
    private final List<Menu> menus = new ArrayList<>();

    private void eventProcess() {
        eventManager.orderMenuList(menus);
        eventManager.initializeBenefitDetails();

        menuService.initializeMenuList(eventMenu);
        eventManager.calculateTotalOrderPrice();
    }

    @DisplayName("이벤트 할인 정책이 정상적으로 혜택 금액에 적용된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 11, 16, 25, 31})
    void applyDiscountPolicyByAllEvent(int input) {

        Menu menu1 = new Main(Price.해산물파스타.name(), 2);
        Menu menu2 = new Main(Price.바비큐립.name(), 2);
        Menu menu3 = new Dessert(Price.초코케이크.name(), 1);
        Menu menu4 = new Appetizer(Price.양송이수프.name(), 5);

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);

        eventProcess();

        eventManagerService.processBenefitDetails(input, eventManager, eventCalendar);
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();

        Assertions.assertThat(benefitDetails.values()).anyMatch(benefitPrice -> benefitPrice != 0);
    }

    @DisplayName("이벤트 할인 정책이 10,000원 미만일 경우 적용되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 11, 16, 25, 31})
    void noApplyDiscountPolicyByAllEvent(int input) {

        Menu menu = new Appetizer(Price.양송이수프.name(), 1);
        menus.add(menu);

        eventProcess();

        eventManagerService.processBenefitDetails(input, eventManager, eventCalendar);
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();

        Assertions.assertThat(benefitDetails.values()).allMatch(benefitPrice -> benefitPrice == 0);
    }
}
