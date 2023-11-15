package christmas.util.validate.input;

public enum MenuError {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_FORMAT("메뉴 정보 형식이 잘못되었습니다. 메뉴 이름과 메뉴 갯수는 '-'로 구분되어야 합니다."),
    INVALID_MENU_NAME_WITH_QUANTITY("메뉴 이름과 메뉴 갯수는 필수입니다."),
    INVALID_DUPLICATE_MENU_NAME("중복된 메뉴 이름이 있습니다. 다시 입력해 주세요."),
    INVALID_MAX_MENU_QUANTITY("주문 가능한 메뉴 갯수를 초과하였습니다. 다시 입력해 주세요."),
    INVALID_ORDERING_ONLY_DRINK("주문한 모든 메뉴가 음료입니다. 다시 입력해 주세요."),
    NOT_FOUND_MENU_NAME("해당 이름의 메뉴가 존재하지 않습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String errorMessage;

    MenuError(String errorMessage) {
        this.errorMessage = ERROR_PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
