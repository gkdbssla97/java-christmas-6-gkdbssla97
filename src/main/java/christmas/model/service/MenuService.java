package christmas.model.service;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.*;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.domain.factory.MenuFactory.*;

public class MenuService {

    public void orderMenuList(EventManager eventManager, String menus, EventMenu eventMenu) {
        List<Menu> eventMenuList = eventMenu.getEventMenuList();
        List<Menu> orderMenuList = new ArrayList<>();
        String[] menusInfos = menus.split(",");
        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            String name = menu[0];
            Category menuCategory = findMenuCategory(eventMenuList, name);
            Menu registerMenu = registerMenu(menuCategory, menu);
            orderMenuList.add(registerMenu);
        }
        eventManager.orderMenuList(orderMenuList);
        eventManager.calculateTotalOrderPrice();
    }

    public Category findMenuCategory(List<Menu> menuList, String name) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return menu.getCategory();
            }
        }
        throw new IllegalArgumentException();
    }

    public void initializeMenuList(EventMenu eventMenu) {
        List<Menu> menuList = new ArrayList<>();

        registerAppetizer(menuList);
        registerMain(menuList);
        registerDessert(menuList);
        registerDrink(menuList);

        eventMenu.initializeMenuList(menuList);
    }
}
