package christmas.validate;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.util.validate.input.DateError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputDateTest extends NsTest {

    @DisplayName("입력 날짜는 정수형으로 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "-", " ", "1-1", "woowacourse"})
    void validateIntegerFormatByInputDate (String input) {
        assertSimpleTest(() -> {
            runException(input, "제로콜라-a");
            assertThat(output()).contains(DateError.INVALID_DATE.getErrorMessage());
        });
    }

    @DisplayName("입력 날짜는 1 이상 31 이하의 숫자로만 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-100", "1000000", "32", "1.0", " "})
    void validateRangeByInputDate (String input) {
        assertSimpleTest(() -> {
            runException(input, "제로콜라-a");
            assertThat(output()).contains(DateError.INVALID_DATE.getErrorMessage());
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
