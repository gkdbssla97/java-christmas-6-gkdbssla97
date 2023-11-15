package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Main extends Menu {

    public Main(String name, int count) {
        super(name, count, MAIN);
    }

    public Main(String name, int price, Category category) {
        super(name, price, category);
    }
}
