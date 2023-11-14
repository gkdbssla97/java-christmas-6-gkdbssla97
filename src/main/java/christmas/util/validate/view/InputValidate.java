package christmas.util.validate.view;

public class InputValidate {

    public static int parseAndValidateIntegerInput(String input) {
        int parsingIntegerInput;
        try {
            parsingIntegerInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값 '" + input + "'은 숫자로만 입력해야 합니다.");
        }
        return parsingIntegerInput;
    }

    public static void validateVisitDateByEventPeriod(int input) {
        if (31 < input || input < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


}
