package christmas.model.domain.menu;

import christmas.model.domain.Category;

public abstract class Menu {

    private final String name;
    private final int price;
    private final Category category;

    public abstract int getDiscountedPrice();

    public Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
