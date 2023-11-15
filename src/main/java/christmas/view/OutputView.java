package christmas.view;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.constant.ViewConstant.*;

public class OutputView {

    public void printMenuList(EventManager eventManager) {
        System.out.println(PREVIEW_EVENT_BENEFIT);
        System.out.println(ORDER_MENU);
        for (Menu orderMenu : eventManager.getOrderMenus()) {
            System.out.printf(MENU_INFO_FORMAT, orderMenu.getName(), orderMenu.getCount());
        }
    }

    public void printTotalOrderPriceBeforeDiscount(EventManager eventManager) {
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT);
        System.out.printf(TOTAL_PRICE_BEFORE_DISCOUNT_FORMAT, eventManager.getTotalPriceBeforeDiscount());
    }

    public void printPresentMenu(EventManager eventManager) {
        System.out.println(PRESENT_MENU);
        if (eventManager.isEligibleForPresentMenu()) {
            System.out.println(CHAMPAGNE_ONE);
            return;
        }
        System.out.println(NONE);
    }

    public void printBenefitList(EventManager eventManager) {
        System.out.println(BENEFIT_DETAILS);
        if (eventManager.isEligibleForBenefitDetails()) {
            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
                if (benefitDetail.getValue() != 0) {
                    System.out.printf(BENEFIT_DETAILS_FORMAT, benefitDetail.getKey().getDiscountPolicy(), benefitDetail.getValue());
                }
            }
            return;
        }
        System.out.println(NONE);
    }

    public void printTotalBenefitPriceAfterDiscount(EventManager eventManager) {
        System.out.println(TOTAL_BENEFIT_PRICE);
        System.out.printf(TOTAL_BENEFIT_PRICE_FORMAT, eventManager.calculateTotalBenefitAfterDiscount());
    }

    public void printTotalOrderPriceAfterDiscount(EventManager eventManager) {
        System.out.println(TOTAL_PRICE_AFTER_DISCOUNT);
        System.out.printf(TOTAL_PRICE_AFTER_DISCOUNT_FORMAT, eventManager.calculateTotalPriceAfterDiscount());
    }

    public void printEventBadge(EventManager eventManager) {
        System.out.println(EVENT_BADGE);
        System.out.println(eventManager.getEventBadge());
    }
}
