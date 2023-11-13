package christmas.view;

import christmas.model.domain.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public void printMenuList(EventManager eventManager) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("<주문 메뉴>");
        for(Menu orderMenu: eventManager.getOrderMenuList()) {
            System.out.printf("%s %d개\n", orderMenu.getName(), orderMenu.getCount());
        }
    }

    public void printTotalOrderPriceBeforeDiscount(EventManager eventManager) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", eventManager.getTotalPriceBeforeDiscount());
    }

    public void printPresentMenu(EventManager eventManager) {
        System.out.println("<증정 메뉴>");
        if(eventManager.isEligibleForPresentMenu()) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void printBenefitList(EventManager eventManager) {
        System.out.println("<혜택 내역>");
        if(eventManager.isEligibleForBenefitList()) {
            HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
            for (Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
                System.out.printf("%s: %,d원\n", benefitDetail.getKey().getDiscountPolicy(), benefitDetail.getValue());
            }
            return;
        }
        System.out.println("없음");
    }

    public void printTotalBenefitPriceAfterDiscount(EventManager eventManager) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", eventManager.getTotalBenefitAfterDiscount());
    }

    public void printTotalOrderPriceAfterDiscount(EventManager eventManager) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", eventManager.getTotalPriceAfterDiscount());
    }

    public void printEventBadge(EventManager eventManager) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventManager.getEventBadge());
    }
}
