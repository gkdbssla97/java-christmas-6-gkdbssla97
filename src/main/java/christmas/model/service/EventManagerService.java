package christmas.model.service;

import christmas.model.domain.event.EventCalendar;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.discount.condition.*;
import christmas.model.domain.discount.policy.*;

public class EventManagerService {

    public void processBenefitDetails(int date, EventManager eventManager, EventCalendar eventCalendar) {

        applyDDayBenefit(date, eventManager, eventCalendar);
        applyWeekdayBenefit(date, eventManager, eventCalendar);
        applyWeekendBenefit(date, eventManager, eventCalendar);
        applySpecialDayBenefit(date, eventManager, eventCalendar);
        applyPresentEventBenefit(date, eventManager);
    }

    private void applyDDayBenefit(int date, EventManager eventManager, EventCalendar eventCalendar) {
        DiscountCondition discountCondition = new DDayCondition();
        DiscountPolicy discountPolicy = new DDayPolicy();
        if(discountCondition.isSatisfied(eventCalendar, date)) {
            discountPolicy.discount(eventManager, date);
        }
    }

    private void applyWeekdayBenefit(int date, EventManager eventManager, EventCalendar eventCalendar) {
        DiscountCondition discountCondition = new WeekdayCondition();
        DiscountPolicy discountPolicy = new WeekdayPolicy();
        if(discountCondition.isSatisfied(eventCalendar, date)) {
            discountPolicy.discount(eventManager, date);
        }
    }

    private void applyWeekendBenefit(int date, EventManager eventManager, EventCalendar eventCalendar) {
        DiscountCondition discountCondition = new WeekendCondition();
        DiscountPolicy discountPolicy = new WeekendPolicy();
        if(discountCondition.isSatisfied(eventCalendar, date)) {
            discountPolicy.discount(eventManager, date);
        }
    }

    private void applySpecialDayBenefit(int date, EventManager eventManager, EventCalendar eventCalendar) {
        DiscountCondition discountCondition = new SpecialCondition();
        DiscountPolicy discountPolicy = new SpecialPolicy();
        if(discountCondition.isSatisfied(eventCalendar, date)) {
            discountPolicy.discount(eventManager, date);
        }
    }

    private void applyPresentEventBenefit(int date, EventManager eventManager) {
        DiscountPolicy discountPolicy = new PresentEventPolicy();
        if(eventManager.isEligibleForPresentMenu()) {
            discountPolicy.discount(eventManager, date);
        }
    }
}
