package christmas.model.domain.event;

import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.List;

import static christmas.util.validate.input.MenuError.NOT_FOUND_MENU_NAME;

public class EventMenu {

    private List<Menu> eventMenus;

    public void initializeMenuList(List<Menu> eventMenus) {
        this.eventMenus = eventMenus;
    }

    public Category findMenuCategory(String name) {
        for (Menu menu : eventMenus) {
            if (menu.getName().equals(name)) {
                return menu.getCategory();
            }
        }
        throw new IllegalArgumentException(NOT_FOUND_MENU_NAME.getErrorMessage());
    }

    public List<Menu> getEventMenus() {
        return eventMenus;
    }
}
