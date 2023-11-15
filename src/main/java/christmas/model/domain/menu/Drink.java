package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Drink extends Menu {

    public Drink(String name, int count) {
        super(name, count, DRINK);
    }

    public Drink(String name, int price, Category category) {
        super(name, price, category);
    }
}
