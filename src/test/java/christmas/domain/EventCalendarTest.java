package christmas.domain;

import christmas.model.domain.event.EventCalendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCalendarTest {

    @DisplayName("입력 날짜의 크리스마스 디데이 할인 여부를 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 15, 25})
    void isChristmasDDayEventByEnteringDate(int date) {
        EventCalendar eventCalendar = new EventCalendar();
        boolean christmasDDay = eventCalendar.isChristmasDDay(date);
        assertThat(christmasDDay).isTrue();
    }

    @DisplayName("입력 날짜의 평일 할인 여부를 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 12, 13, 20, 21, 28})
    void isWeekdayEventByEnteringDate(int date) {
        EventCalendar eventCalendar = new EventCalendar();
        boolean eventCalendarWeekday = eventCalendar.isWeekend(date);
        assertThat(eventCalendarWeekday).isFalse();
    }

    @DisplayName("입력 날짜의 주말 할인 여부를 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {8, 16, 23, 29, 30})
    void isWeekendEventByEnteringDate(int date) {
        EventCalendar eventCalendar = new EventCalendar();
        boolean eventCalendarWeekend = eventCalendar.isWeekend(date);
        assertThat(eventCalendarWeekend).isTrue();
    }

    @DisplayName("입력 날짜의 특별 할인 여부를 테스트한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 25})
    void isSpecialEventByEnteringDate(int date) {
        EventCalendar eventCalendar = new EventCalendar();
        boolean eventCalendarSpecialDay = eventCalendar.isSpecialDay(date);
        assertThat(eventCalendarSpecialDay).isTrue();
    }
}
