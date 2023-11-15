package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Dessert extends Menu {
    public Dessert(String name, int count) {
        super(name, count, DESSERT);
    }

    public Dessert(String name, int price, Category category) {
        super(name, price, category);
    }
}
