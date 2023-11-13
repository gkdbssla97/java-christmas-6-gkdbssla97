package christmas.util.validate;

public class InputValidate {

    public static int parseAndValidateIntegerInput(String input) {
        int parsingIntegerInput;
        try {
            parsingIntegerInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값 '" + input + "'은 숫자로만 입력해야합니다.");
        }
        return parsingIntegerInput;
    }
}
