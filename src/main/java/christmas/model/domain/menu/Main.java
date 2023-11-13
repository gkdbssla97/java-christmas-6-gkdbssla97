package christmas.model.domain.menu;

import christmas.model.domain.Category;

public class Main extends Menu{

    public Main(String name, int price) {
        super(name, price, Category.MAIN);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
