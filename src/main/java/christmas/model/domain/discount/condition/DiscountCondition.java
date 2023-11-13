package christmas.model.domain.discount.condition;

import christmas.model.domain.event.EventCalendar;

public interface DiscountCondition {

    boolean isSatisfied(EventCalendar eventCalendar, int date);
}
