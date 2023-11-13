package christmas.model.domain.discount.policy;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;

import java.util.HashMap;

import static christmas.model.domain.discount.DiscountPolicyName.*;

public class SpecialPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();

        benefitDetails.putIfAbsent(SPECIAL,
                benefitDetails.getOrDefault(SPECIAL, 0) + (-1000));
    }
}
