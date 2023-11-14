package christmas.model.domain.event;

import christmas.model.domain.menu.Menu;

import java.util.List;

public class EventMenu {

    private List<Menu> eventMenuList;

    public void initializeMenuList(List<Menu> eventMenuList) {
        this.eventMenuList = eventMenuList;
    }

    public List<Menu> getEventMenuList() {
        return eventMenuList;
    }
}
