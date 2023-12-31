package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Appetizer extends Menu {

    public Appetizer(String name, int count) {
        super(name, count, APPETIZER);
    }

    public Appetizer(String name, int price, Category category) {
        super(name, price, category);
    }
}
