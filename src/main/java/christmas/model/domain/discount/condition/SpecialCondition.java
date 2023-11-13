package christmas.model.domain.discount.condition;

import christmas.model.domain.EventCalendar;

public class SpecialCondition implements DiscountCondition{
    @Override
    public boolean isSatisfied(EventCalendar eventCalendar, int date) {
        return !eventCalendar.isSpecialDay(date);
    }
}
