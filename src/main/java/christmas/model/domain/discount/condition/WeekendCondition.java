package christmas.model.domain.discount.condition;

import christmas.model.domain.event.EventCalendar;

public class WeekendCondition implements DiscountCondition{
    @Override
    public boolean isSatisfied(EventCalendar eventCalendar, int date) {
        return eventCalendar.isWeekend(date);
    }
}
