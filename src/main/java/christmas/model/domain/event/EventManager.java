package christmas.model.domain.event;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static christmas.model.domain.menu.Price.샴페인;
import static christmas.util.constant.NumberConstant.ELIGIBLE_FOR_DISCOUNT;
import static christmas.util.constant.NumberConstant.ELIGIBLE_PRESENT_PRICE;

public class EventManager {

    private final HashMap<DiscountPolicyName, Integer> benefitDetails = new LinkedHashMap<>();
    private List<Menu> orderMenus;
    private int totalPrice;
    private EventBadge eventBadge;

    public EventManager() {
        initializeBenefitDetails();
    }

    public void orderMenuList(List<Menu> orderMenus) {
        this.orderMenus = orderMenus;
    }

    public void calculateTotalOrderPrice() {
        for (Menu menu : this.orderMenus) {
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

    public boolean isEligibleForBenefitDetails() {
        int sum = 0;
        for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            sum += benefitDetail.getValue();
        }
        return sum != 0;
    }

    public List<Menu> getOrderMenus() {
        return orderMenus;
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPrice;
    }

    public String getEventBadge() {
        return eventBadge.getCategory();
    }

    public int calculateTotalBenefitAfterDiscount() {
        int totalBenefitByDiscount = 0;
        for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            totalBenefitByDiscount += benefitDetail.getValue();
        }

        return totalBenefitByDiscount;
    }

    public int calculateTotalPriceAfterDiscount() {
        if(isEligibleForPresentMenu()) {
            return this.totalPrice + calculateTotalBenefitAfterDiscount() + 샴페인.getPrice();
        }
        return this.totalPrice + calculateTotalBenefitAfterDiscount();
    }

    public void grantEventBadge() {
        this.eventBadge = EventBadge.grantEventBadge(Math.abs(calculateTotalBenefitAfterDiscount()));
    }

    public HashMap<DiscountPolicyName, Integer> getBenefitDetails() {
        return benefitDetails;
    }
}
