package christmas.model.domain.discount.policy;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.util.constant.NumberConstant;

import java.util.HashMap;

import static christmas.model.domain.discount.DiscountPolicyName.*;
import static christmas.util.constant.NumberConstant.*;

public class DDayPolicy implements DiscountPolicy {
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
        benefitDetails.put(CHRISTMAS_D_DAY,
                benefitDetails.getOrDefault(CHRISTMAS_D_DAY, 0) + (-discountAlgorithm(date)));
    }

    public int discountAlgorithm(int day) {
        return (day - 1) * DISCOUNT_PER_DAY + INITIAL_DISCOUNT_MONEY;
    }
}

