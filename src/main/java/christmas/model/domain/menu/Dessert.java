package christmas.model.domain.menu;

import static christmas.model.domain.menu.Category.*;

public class Dessert extends Menu{
    public Dessert(String name, int count) {
        super(name, count, DESSERT);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
