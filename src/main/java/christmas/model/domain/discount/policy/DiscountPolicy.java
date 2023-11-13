package christmas.model.domain.discount.policy;

import christmas.model.domain.EventManager;

public interface DiscountPolicy {

    public void discount(EventManager eventManager, int date);
}
