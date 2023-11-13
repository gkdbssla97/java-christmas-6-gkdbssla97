package christmas.model.domain.discount.condition;

import christmas.model.domain.EventCalendar;

public class DDayCondition implements DiscountCondition{

    @Override
    public boolean isSatisfied(EventCalendar eventCalendar, int date) {
        return eventCalendar.isChristmasDDay(date);
    }
}
