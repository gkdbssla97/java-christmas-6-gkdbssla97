package christmas.model.domain.event;

import java.util.Calendar;

import static christmas.util.constant.NumberConstant.*;
import static java.util.Calendar.*;

public class EventCalendar {

    public boolean isChristmasDDay(int day) {
        return D_DAY_MIN <= day && day <= D_DAY_MAX;
    }

    public boolean isWeekend(int day) {
        Calendar calendar = getInstance();
        calendar.set(EVENT_YEAR, DECEMBER, day);
        int dayOfWeek = calendar.get(DAY_OF_WEEK);

        return dayOfWeek == FRIDAY || dayOfWeek == SATURDAY;
    }

    public boolean isSpecialDay(int day) {
        Calendar calendar = getInstance();
        calendar.set(EVENT_YEAR, DECEMBER, day);
        int dayOfWeek = calendar.get(DAY_OF_WEEK);

        return dayOfWeek == SUNDAY || day == CHRISTMAS_DAY;
    }
}
