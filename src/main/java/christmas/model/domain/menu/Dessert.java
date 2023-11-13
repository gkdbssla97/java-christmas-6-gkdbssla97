package christmas.model.domain.menu;

public class Dessert extends Menu{
    public Dessert(String name, int price) {
        super(name, price, Category.DESSERT);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
