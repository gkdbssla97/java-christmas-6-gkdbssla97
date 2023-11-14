package christmas.controller;

import christmas.model.domain.event.EventCalendar;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.Menu;
import christmas.model.service.EventManagerService;
import christmas.model.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasController {

    private final EventManager eventManager = new EventManager();
    private final EventCalendar eventCalendar = new EventCalendar();
    private final EventMenu eventMenu = new EventMenu();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();
    private final EventManagerService eventManagerService = new EventManagerService();

    public void startEvent() {

        menuService.initializeMenuList(eventMenu);

        int date = inputView.readDate();
        String menus = inputView.readMenu(eventMenu);

        menuService.orderMenuList(eventManager, menus, eventMenu);

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
