package christmas.model.domain.discount;

public enum DiscountPolicyName {
    CHRISTMAS_D_DAY("크리스마스 디데이"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    PRESENT_EVENT("증정 이벤트");

    private final String discountPolicy;

    DiscountPolicyName(String discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public String getDiscountPolicy() {
        return discountPolicy;
    }
}
