package christmas.model.domain.menu;

public class Dessert extends Menu{
    public Dessert(String name, int count) {
        super(name, count, Category.DESSERT);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
