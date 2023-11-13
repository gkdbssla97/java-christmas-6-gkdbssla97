package christmas.model.domain.menu;

public class Drink extends Menu {

    public Drink(String name, int count) {
        super(name, count, Category.DRINK);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
