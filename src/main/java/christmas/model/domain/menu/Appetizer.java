package christmas.model.domain.menu;

public class Appetizer extends Menu {

    public Appetizer(String name, int count ) {
        super(name, count, Category.APPETIZER);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
