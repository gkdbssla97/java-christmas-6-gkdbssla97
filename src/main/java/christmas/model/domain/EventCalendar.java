package christmas.model.domain;

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

/**
 * - 크리스마스 디데이 할인
 * - 이벤트 기간: **2023.12.1 ~ 2023.12.25**
 * 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
 * - 평일 할인(일요일~목요일)
 * - 평일에는 **디저트 메뉴**를 메뉴 1개당 2,023원 할인
 * - 주말 할인(금요일, 토요일)
 * - 주말에는 **메인 메뉴**를 메뉴 1개당 2,023원 할인
 * - 특별 할인
 * - 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
 * - 별이 있는 날짜는 매주 일요일 (*3, 10, 17, 24, 31*)과 크리스마스(*25*)이다.
 */
