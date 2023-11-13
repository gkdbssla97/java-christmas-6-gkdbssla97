package christmas.model.domain.menu;

import christmas.model.domain.Category;

public class Drink extends Menu {

    public Drink(String name, int price) {
        super(name, price, Category.DRINK);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
