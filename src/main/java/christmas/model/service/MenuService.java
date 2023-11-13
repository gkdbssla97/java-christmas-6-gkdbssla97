package christmas.model.service;

import christmas.model.domain.Category;
import christmas.model.domain.menu.*;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    /**
     * <애피타이저>
     * 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
     *
     * <메인>
     * 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
     *
     * <디저트>
     * 초코케이크(15,000), 아이스크림(5,000)
     *
     * <음료>
     * 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
     */
    public void initMenuList() {
        List<Menu> menuList = new ArrayList<>();

        registerAppetizer(menuList);
        registerMain(menuList);
        registerDessert(menuList);
        registerDrink(menuList);

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
