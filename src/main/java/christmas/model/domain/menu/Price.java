package christmas.model.domain.menu;

import static christmas.util.validate.input.MenuError.INVALID_ORDER;

public enum Price {

    양송이수프(6000), 타파스(5500), 시저샐러드(8000),
    티본스테이크(55000), 바비큐립(54000), 해산물파스타(35000), 크리스마스파스타(25000),
    초코케이크(15000), 아이스크림(5000),
    제로콜라(3000), 레드와인(60000), 샴페인(25000);


    private final int price;

    Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static int findPrice(String name) {
        for(Price p : Price.values()) {
            if(p.name().equals(name)) {
                return p.getPrice();
            }
        }
        throw new IllegalArgumentException(INVALID_ORDER.getErrorMessage());
    }
}
