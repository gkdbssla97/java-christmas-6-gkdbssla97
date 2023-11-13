package christmas.controller;

import christmas.model.domain.EventManager;
import christmas.model.domain.menu.Menu;
import christmas.model.service.EventManagerService;
import christmas.model.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class ChristmasController {

    private final EventManager eventManager = new EventManager();

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();
    private final EventManagerService eventManagerService = new EventManagerService();

    private void startEvent() {

        List<Menu> menuList = menuService.initMenuList();

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int date = inputView.readDate();
        String menus = inputView.readMenu();
        menuService.orderMenuList(eventManager, menus, menuList);

        outputView.printMenuList(eventManager);
        outputView.printTotalOrderPriceBeforeDiscount(eventManager);


    }
}
