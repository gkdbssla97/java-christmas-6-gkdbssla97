package christmas.model.domain.menu;

import christmas.model.domain.Category;

public class Appetizer extends Menu {

    public Appetizer(String name, int price) {
        super(name, price, Category.APPETIZER);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
