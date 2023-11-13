package christmas.model.domain.menu;

public class Main extends Menu{

    public Main(String name, int count) {
        super(name, count, Category.MAIN);
    }

    @Override
    public int getDiscountedPrice() {
        return 0;
    }
}
