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
        System.out.printf("%,d원", eventManager.getTotalPriceBeforeDiscount());
    }

    public void printPresentMenu(EventManager eventManager) {
        System.out.println("<증정 메뉴>");
        if(eventManager.isEligibleForPresentMenu()) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    /**
     * <혜택 내역>
     * 크리스마스 디데이 할인: -1,200원
     * 평일 할인: -4,046원
     * 특별 할인: -1,000원
     * 증정 이벤트: -25,000원
     */

    public void printBenefitList(EventManager eventManager) {
        System.out.println("<혜택 내역>");
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
        for(Map.Entry<DiscountPolicyName, Integer> benefitDetail : benefitDetails.entrySet()) {
            System.out.printf("%s: %,d원\n", benefitDetail.getKey(), benefitDetail.getValue());
        }
    }

    public void printTotalBenefitPriceAfterDiscount(EventManager eventManager) {
        System.out.println("<총혜택 금액>");
        System.out.printf("%,d원\n", eventManager.getTotalBenefitAfterDiscount());
    }

    public void printTotalPriceAfterDiscount(EventManager eventManager) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", eventManager.getTotalPriceAfterDiscount());
    }
}
