package christmas.model.domain;

import christmas.model.domain.menu.Menu;

import java.util.List;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;

    public void orderMenuList(List<Menu> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    public void calculateTotalOrderPrice() {
        for (Menu menu : this.orderMenuList) {
            this.totalPrice += menu.getPrice();
        }
    }

    public boolean isEligibleForDiscount() {
        return totalPrice >= 10000;
    }

    public boolean isEligibleForPresentMenu() {
        return totalPrice >= 120000;
    }

    public List<Menu> getOrderMenuList() {
        return this.orderMenuList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
