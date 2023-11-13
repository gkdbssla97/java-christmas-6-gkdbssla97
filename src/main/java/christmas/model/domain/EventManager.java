package christmas.model.domain;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;
    private HashMap<DiscountPolicyName, Integer> benefitDetails;

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
        benefitDetails.put(DiscountPolicyName.CHRISTMAS_D_DAY, 0);
        benefitDetails.put(DiscountPolicyName.WEEKDAY, 0);
        benefitDetails.put(DiscountPolicyName.WEEKEND, 0);
        benefitDetails.put(DiscountPolicyName.SPECIAL, 0);
        benefitDetails.put(DiscountPolicyName.PRESENT_EVENT, 0);
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

    public HashMap<DiscountPolicyName, Integer> getBenefitDetails() {
        return benefitDetails;
    }
}
