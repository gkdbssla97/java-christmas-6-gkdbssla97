package christmas.model.domain.discount.policy;

import christmas.model.domain.event.EventManager;

public interface DiscountPolicy {

    void discount(EventManager eventManager, int date);
}
