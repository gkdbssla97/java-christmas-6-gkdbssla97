package christmas.util.validate;

import christmas.model.domain.event.EventMenu;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;
import christmas.util.validate.input.MenuError;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static christmas.util.constant.NumberConstant.*;
import static christmas.util.validate.input.DateError.*;
import static christmas.util.validate.input.MenuError.*;

public class InputValidate {

    public static int parseAndValidateInputDate(String input) {
        int parsingIntegerInput;

        try {
            parsingIntegerInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATE.getErrorMessage());
        }
        return parsingIntegerInput;
    }

    public static void validateVisitDateByEventPeriod(int input) {
        if (EVENT_END_DAY < input || input < EVENT_BEGIN_DAY) {
            throw new IllegalArgumentException(INVALID_DATE.getErrorMessage());
        }
    }

    public static void validateMenusNameByOrder(EventMenu eventMenu, String input) {
        List<Menu> eventMenuList = eventMenu.getEventMenuList();
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] menu = menuInfo.split("-");
            String name = menu[0];
            if (findMenuByName(eventMenuList, name).isEmpty()) {
                throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
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
            try {
                int quantity = Integer.parseInt(menu[1]);
                if (quantity < 1) {
                    throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
            }
        }
    }

    public static void validateInputMenusFormatByOrder(String input) {
        String[] menusInfos = input.split(",");

        for (String menuInfo : menusInfos) {
            String[] split = menuInfo.split("-");

            if (split.length != 2) {
                throw new IllegalArgumentException(INVALID_MENU_FORMAT.getErrorMessage());
            }

            String name = split[0];
            String quantity = split[1];

            if (name.isEmpty() || quantity.isEmpty()) {
                throw new IllegalArgumentException(INVALID_MENU_NAME_WITH_QUANTITY.getErrorMessage());
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
                throw new IllegalArgumentException(INVALID_DUPLICATE_MENU_NAME.getErrorMessage());
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
            throw new IllegalArgumentException(INVALID_MAX_MENU_QUANTITY.getErrorMessage());
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
        } throw new IllegalArgumentException(INVALID_ORDERING_ONLY_DRINK.getErrorMessage());
    }
}
