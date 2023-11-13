package christmas.model.domain;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;
    private final HashMap<DiscountPolicyName, Integer> benefitDetails = new LinkedHashMap<>();
    private EventBadge eventBadge;
    private int benefitPrice;

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
        return orderMenuList;
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getEventBadge() {
        return eventBadge.getCategory();
    }

    public int getBenefitPrice() {
        return benefitPrice;
    }

    public int getTotalBenefitAfterDiscount() {
        int totalBenefitByDiscount = this.totalPrice;
        for(Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            totalBenefitByDiscount -= benefitDetail.getValue();
        }
        this.benefitPrice = totalBenefitByDiscount;

        return totalBenefitByDiscount;
    }

    public int getTotalPriceAfterDiscount() {
        return this.totalPrice - this.benefitPrice;
    }

    public void grantEventBadge() {
        this.eventBadge = EventBadge.grantEventBadge(benefitPrice);
    }

    public HashMap<DiscountPolicyName, Integer> getBenefitDetails() {
        return benefitDetails;
    }
}
