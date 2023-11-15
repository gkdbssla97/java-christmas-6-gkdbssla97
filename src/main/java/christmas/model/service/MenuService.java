package christmas.model.service;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.domain.factory.MenuFactory.*;

public class MenuService {

    public void orderMenuList(EventManager eventManager, String menus, EventMenu eventMenu) {
        List<Menu> eventMenus = eventMenu.getEventMenus();
        List<Menu> orderMenus = new ArrayList<>();
        String[] menusInfos = menus.split(",");
        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            String name = menu[0];
            Category menuCategory = eventMenu.findMenuCategory(eventMenus, name);
            Menu registerMenu = registerMenu(menuCategory, menu);
            orderMenus.add(registerMenu);
        }
        eventManager.orderMenuList(orderMenus);
        eventManager.calculateTotalOrderPrice();
    }

    public void initializeMenuList(EventMenu eventMenu) {
        List<Menu> menus = new ArrayList<>();

        registerAppetizer(menus);
        registerMain(menus);
        registerDessert(menus);
        registerDrink(menus);

        eventMenu.initializeMenuList(menus);
    }
}
