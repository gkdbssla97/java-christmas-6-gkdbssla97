package christmas.model.service;

import christmas.model.domain.EventCalendar;
import christmas.model.domain.EventManager;
import christmas.model.domain.discount.condition.DDayCondition;
import christmas.model.domain.discount.condition.DiscountCondition;
import christmas.model.domain.discount.policy.DDayPolicy;
import christmas.model.domain.discount.policy.DiscountPolicy;

public class EventManagerService {
    private DiscountPolicy discountPolicy;


    /**
     * 크리스마스 디데이 할인: -1,200원
     * 평일 할인: -4,046원
     * 특별 할인: -1,000원
     * 증정 이벤트: -25,000원
     * @param eventManager
     * @param eventCalendar
     */
    public void calculateBenefitDetails(int date, EventManager eventManager, EventCalendar eventCalendar,
                                        DiscountPolicy discountPolicy, DiscountCondition discountCondition) {
        discountCondition = new DDayCondition();
        discountPolicy = new DDayPolicy();
        if(discountCondition.isSatisfied(eventCalendar, date)) {
            discountPolicy.discount(eventManager, date);
        }

    }
}
