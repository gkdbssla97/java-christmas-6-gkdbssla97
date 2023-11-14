package christmas.model.domain.menu;

import static christmas.model.domain.menu.Price.*;

public abstract class Menu {

    private final String name;
    private final int count;
    private final Category category;
    private final int price;

    public Menu(String name, int count, Category category) {
        this.name = name;
        this.count = count;
        this.category = category;
        this.price = findPrice(name);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
