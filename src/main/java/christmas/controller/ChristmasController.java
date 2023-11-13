package christmas.controller;

import christmas.model.domain.EventCalendar;
import christmas.model.domain.EventManager;
import christmas.model.domain.menu.Menu;
import christmas.model.service.EventManagerService;
import christmas.model.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasController {

    private final EventManager eventManager = new EventManager();
    private final EventCalendar eventCalendar = new EventCalendar();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();
    private final EventManagerService eventManagerService = new EventManagerService();

    public void startEvent() {

        List<Menu> menuList = menuService.initializeMenuList();

        int date = inputView.readDate();
        String menus = inputView.readMenu();

        menuService.orderMenuList(eventManager, menus, menuList);

        outputView.printMenuList(eventManager);

        outputView.printTotalOrderPriceBeforeDiscount(eventManager);

        outputView.printPresentMenu(eventManager);

        eventManagerService.processBenefitDetails(date, eventManager, eventCalendar);

        outputView.printBenefitList(eventManager);

        outputView.printTotalBenefitPriceAfterDiscount(eventManager);

        outputView.printTotalOrderPriceAfterDiscount(eventManager);

        eventManager.grantEventBadge();

        outputView.printEventBadge(eventManager);
    }
}
