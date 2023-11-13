package christmas.model.domain.event;

import java.util.List;
import java.util.Calendar;

import static java.util.Calendar.*;

public class EventCalendar {

    public boolean isChristmasDDay(int day) {
        return 1 <= day && day <= 25;
    }

    public boolean isWeekend(int day) {
        Calendar calendar = getInstance();
        calendar.set(2023, DECEMBER, day);
        int dayOfWeek = calendar.get(DAY_OF_WEEK);

        return dayOfWeek == FRIDAY || dayOfWeek == SATURDAY;
    }

    public boolean isSpecialDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.DECEMBER, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek == Calendar.SUNDAY || day == 25;
    }
}
