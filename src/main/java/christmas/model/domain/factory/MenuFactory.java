package christmas.model.domain.factory;

import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {

    public static Menu registerMenu(Category category, String[] menu) {
        String name = menu[0];
        int count = Integer.parseInt(menu[1]);

        if (category.getCategory().equals(Category.APPETIZER.getCategory())) {
            return new Appetizer(name, count);
        } else if (category.getCategory().equals(Category.MAIN.getCategory())) {
            return new Main(name, count);
        } else if (category.getCategory().equals(Category.DRINK.getCategory())) {
            return new Drink(name, count);
        }
        return new Dessert(name, count);
    }

    public static void registerDrink(List<Menu> menuList) {
        menuList.add(new Drink("제로콜라", 3000));
        menuList.add(new Drink("레드와인", 60000));
        menuList.add(new Drink("샴페인", 25000));
    }

    public static void registerDessert(List<Menu> menuList) {
        menuList.add(new Dessert("초코케이크", 15000));
        menuList.add(new Dessert("아이스크림", 5000));
    }

    public static void registerMain(List<Menu> menuList) {
        menuList.add(new Main("티본스테이크", 55000));
        menuList.add(new Main("바비큐립", 54000));
        menuList.add(new Main("해산물파스타", 35000));
        menuList.add(new Main("크리스마스파스타", 25000));
    }

    public static void registerAppetizer(List<Menu> menuList) {
        menuList.add(new Appetizer("양송이수프", 6000));
        menuList.add(new Appetizer("타파스", 5500));
        menuList.add(new Appetizer("시저샐러드", 8000));
    }
}
