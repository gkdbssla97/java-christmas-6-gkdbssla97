package christmas.model.domain;

import christmas.model.domain.menu.Menu;

import java.util.List;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;


    public void orderMenuList(List<Menu> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    public List<Menu> getOrderMenuList() {
        return orderMenuList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
