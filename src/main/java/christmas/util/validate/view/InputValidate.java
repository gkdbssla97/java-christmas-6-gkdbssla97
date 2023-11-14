package christmas.util.validate.view;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public static void validateMenusNameByOrder(EventMenu eventMenu, String input) {
        List<Menu> eventMenuList = eventMenu.getEventMenuList();
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            String name = menu[0];
            if (findMenuByName(eventMenuList, name).isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static Optional<Menu> findMenuByName(List<Menu> eventMenuList, String name) {
        return eventMenuList.stream()
                .filter(menu -> menu.getName()
                        .equals(name))
                .findFirst();
    }

    public static void validateMenusQuantityByOrder(String input) {
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            int quantity = Integer.parseInt(menu[1]);
            if (quantity < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void validateInputMenusFormatByOrder(String input) {
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] split = menuInfo.split("-");

            if (split.length != 2) {
                throw new IllegalArgumentException("[ERROR] 메뉴 정보 형식이 잘못되었습니다. 메뉴 이름과 메뉴 갯수는 '-'로 구분되어야 합니다.");
            }

            String name = split[0];
            String quantity = split[1];

            if (name.isEmpty() || quantity.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 메뉴 이름과 메뉴 갯수는 필수입니다.");
            }
        }
    }

    public static void validateDuplicateInputMenusNameByOrder(String input) {
        String[] menusInfos = input.split(",");
        Set<String> nameSet = new HashSet<>();

        for (String menuInfo : menusInfos) {
            String[] split = menuInfo.split("-");
            String name = split[0];

            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("[ERROR] 중복된 메뉴 이름이 있습니다. 다시 입력해 주세요.");
            }
        }
    }

    public static void validateInputMenusMaxQuantityByOrder(String input) {
        String[] menusInfos = input.split(",");

        int maxQuantity = 20;
        for (String menuInfo : menusInfos) {
            String[] split = menuInfo.split("-");
            int quantity = Integer.parseInt(split[1]);
            maxQuantity -= quantity;
        }
        if (maxQuantity < 0) {
            throw new IllegalArgumentException("[ERROR] 주문 가능한 메뉴 갯수를 초과하였습니다. 다시 입력해 주세요.");
        }
    }

    public static void validateInputMenusByOrderingOnlyDrink(EventMenu eventMenu, String input) {
        List<Menu> eventMenuList = eventMenu.getEventMenuList();
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] split = menuInfo.split("-");
            String name = split[0];
            Optional<Menu> findMenuByName = findMenuByName(eventMenuList, name);
            if(findMenuByName.isPresent() && !findMenuByName.get().getCategory().equals(Category.DRINK)) {
                return;
            }
        } throw new IllegalArgumentException("[ERROR] 주문한 모든 메뉴가 음료입니다. 다시 입력해 주세요.");
    }
}
