package christmas.model.domain.event;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;
import christmas.model.domain.menu.Price;
import christmas.util.constant.NumberConstant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static christmas.model.domain.menu.Price.*;
import static christmas.util.constant.NumberConstant.*;

public class EventManager {
    private List<Menu> orderMenuList;
    private int totalPrice;
    private int benefitPrice;
    private final HashMap<DiscountPolicyName, Integer> benefitDetails = new LinkedHashMap<>();
    private EventBadge eventBadge;

    public EventManager() {
        initializeBenefitDetails();
    }

    public void orderMenuList(List<Menu> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    public void calculateTotalOrderPrice() {
        for (Menu menu : this.orderMenuList) {
            this.totalPrice += (menu.getPrice() * menu.getCount());
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
        return totalPrice >= ELIGIBLE_FOR_DISCOUNT;
    }

    public boolean isEligibleForPresentMenu() {
        return totalPrice >= ELIGIBLE_PRESENT_PRICE;
    }

    public boolean isEligibleForBenefitList() {
        int sum = 0;
        for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            sum += benefitDetail.getValue();
        }
        return sum != 0;
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

    public int calculateTotalBenefitAfterDiscount() {
        int totalBenefitByDiscount = 0;
        for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            totalBenefitByDiscount += benefitDetail.getValue();
        }

        this.benefitPrice = totalBenefitByDiscount;
        return totalBenefitByDiscount;
    }

    public int getTotalPriceAfterDiscount() {
        if(isEligibleForPresentMenu()) {
            return this.totalPrice + this.benefitPrice + 샴페인.getPrice();
        }
        return this.totalPrice + this.benefitPrice;
    }

    public void grantEventBadge() {
        this.eventBadge = EventBadge.grantEventBadge(Math.abs(benefitPrice));
    }

    public HashMap<DiscountPolicyName, Integer> getBenefitDetails() {
        return benefitDetails;
    }
}
