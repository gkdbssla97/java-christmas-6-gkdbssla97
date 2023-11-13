package christmas.model.domain;

import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;
    private HashMap<String, Integer> benefitDetails;

    public EventManager() {
        initializeBenefitDetails();
    }

    public void orderMenuList(List<Menu> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    public void calculateTotalOrderPrice() {
        for (Menu menu : this.orderMenuList) {
            this.totalPrice += menu.getPrice();
        }
    }

    public void initializeBenefitDetails() {
        benefitDetails.put("크리스마스 디데이 할인", 0);
        benefitDetails.put("평일 할인", 0);
        benefitDetails.put("주말 할인", 0);
        benefitDetails.put("특별 할인", 0);
        benefitDetails.put("증정 이벤트", 0);
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

    public HashMap<String, Integer> getBenefitDetails() {
        return benefitDetails;
    }
}
