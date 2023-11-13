package christmas.model.service;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    public void orderMenuList(EventManager eventManager, String menus, List<Menu> menuList) {
        List<Menu> orderMenuList = new ArrayList<>();
        String[] menusInfos = menus.split(",");
        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            String name = menu[0];
            Category menuCategory = findMenuCategory(menuList, name);
            Menu registerMenu = registerMenu(menuCategory, menu);
            orderMenuList.add(registerMenu);
        }
        eventManager.orderMenuList(orderMenuList);
        eventManager.calculateTotalOrderPrice();
    }

    public Menu registerMenu(Category category, String[] menu) {
        String name = menu[0];
        int count = Integer.parseInt(menu[1]);

        if (category.getCategory().equals(Category.APPETIZER.getCategory())) {
            return new Appetizer(name, count);
        } else if (category.getCategory().equals(Category.MAIN.getCategory())) {
            return new Main(name, count);
        } else if (category.getCategory().equals(Category.DRINK.getCategory())) {
            return new Drink(name, count);
        } else if (category.getCategory().equals(Category.DESSERT.getCategory())) {
            return new Dessert(name, count);
        }
        throw new IllegalArgumentException("메뉴 X");
    }

    public Category findMenuCategory(List<Menu> menuList, String name) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return menu.getCategory();
            }
        }
        throw new IllegalArgumentException();
    }

    public List<Menu> initializeMenuList() {
        List<Menu> menuList = new ArrayList<>();

        registerAppetizer(menuList);
        registerMain(menuList);
        registerDessert(menuList);
        registerDrink(menuList);

        return menuList;
    }

    private void registerDrink(List<Menu> menuList) {
        menuList.add(new Drink("제로콜라", 3000));
        menuList.add(new Drink("레드와인", 60000));
        menuList.add(new Drink("샴페인", 25000));
    }

    private void registerDessert(List<Menu> menuList) {
        menuList.add(new Dessert("초코케이크", 15000));
        menuList.add(new Dessert("아이스크림", 5000));
    }

    private void registerMain(List<Menu> menuList) {
        menuList.add(new Main("티본스테이크", 55000));
        menuList.add(new Main("바비큐립", 54000));
        menuList.add(new Main("해산물파스타", 35000));
        menuList.add(new Main("크리스마스파스타", 25000));
    }

    private void registerAppetizer(List<Menu> menuList) {
        menuList.add(new Appetizer("양송이수프", 6000));
        menuList.add(new Appetizer("타파스", 5500));
        menuList.add(new Appetizer("시저샐러드", 8000));
    }
}
