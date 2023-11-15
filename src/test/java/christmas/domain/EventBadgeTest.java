package christmas.domain;

import christmas.model.domain.event.EventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBadgeTest {

    @DisplayName("최소 혜택 금액별 뱃지를 부여한다.")
    @ParameterizedTest
    @MethodSource("provideInputForMinimumPrice")
    void grantBadgeAccordingToMinPrice(int input, String expectedMessage) {
        EventBadge eventBadge = EventBadge.grantEventBadge(input);
        assertThat(eventBadge.getCategory()).isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> provideInputForMinimumPrice() {
        return Stream.of(
                Arguments.of(20000, EventBadge.SANTA.getCategory()),
                Arguments.of(10000, EventBadge.TREE.getCategory()),
                Arguments.of(5000, EventBadge.STAR.getCategory()),
                Arguments.of(0, EventBadge.NONE.getCategory()),
                Arguments.of(30000, EventBadge.SANTA.getCategory())
        );
    }
}
