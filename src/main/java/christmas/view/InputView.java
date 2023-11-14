package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.domain.event.EventMenu;
import christmas.util.constant.ViewConstant;

import static christmas.util.constant.ViewConstant.*;
import static christmas.util.validate.InputValidate.*;

public class InputView {

    public int readDate() {
        System.out.println(WELCOME_EVENT_PLANNER);
        while (true) {
            try {
                System.out.println(INPUT_VISITING_DAY);
                String input = Console.readLine();
                int visitingDate = parseAndValidateInputDate(input);
                validateVisitDateByEventPeriod(visitingDate);
                return visitingDate;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readMenu(EventMenu eventMenu) {
        while (true) {
            try {
                System.out.println(INPUT_ORDERING_MENUS);
                String input = Console.readLine();
                validateInputMenusFormatByOrder(input);
                validateMenusNameByOrder(eventMenu, input);
                validateMenusQuantityByOrder(input);
                validateDuplicateInputMenusNameByOrder(input);
                validateInputMenusByOrderingOnlyDrink(eventMenu, input);
                validateInputMenusMaxQuantityByOrder(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
