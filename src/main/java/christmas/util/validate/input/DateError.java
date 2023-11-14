package christmas.util.validate.input;

public enum DateError {

    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    DateError(String errorMessage) {
        this.errorMessage = ERROR_PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
