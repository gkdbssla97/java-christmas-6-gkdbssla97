package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Drink extends Menu {

    public Drink(String name, int count) {
        super(name, count, DRINK);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
