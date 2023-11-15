package christmas.model.domain.factory;

import christmas.model.domain.menu.*;

import java.util.List;

import static christmas.model.domain.menu.Price.*;

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

    public static void registerDrink(List<Menu> menus) {
        menus.add(new Drink(제로콜라.name(), 제로콜라.getPrice()));
        menus.add(new Drink(레드와인.name(), 레드와인.getPrice()));
        menus.add(new Drink(샴페인.name(), 샴페인.getPrice()));
    }

    public static void registerDessert(List<Menu> menus) {
        menus.add(new Dessert(초코케이크.name(), 초코케이크.getPrice()));
        menus.add(new Dessert(아이스크림.name(), 아이스크림.getPrice()));
    }

    public static void registerMain(List<Menu> menus) {
        menus.add(new Main(티본스테이크.name(), 티본스테이크.getPrice()));
        menus.add(new Main(바비큐립.name(), 바비큐립.getPrice()));
        menus.add(new Main(해산물파스타.name(), 해산물파스타.getPrice()));
        menus.add(new Main(크리스마스파스타.name(), 크리스마스파스타.getPrice()));
    }

    public static void registerAppetizer(List<Menu> menus) {
        menus.add(new Appetizer(양송이수프.name(), 양송이수프.getPrice()));
        menus.add(new Appetizer(타파스.name(), 타파스.getPrice()));
        menus.add(new Appetizer(시저샐러드.name(), 시저샐러드.getPrice()));
    }
}
