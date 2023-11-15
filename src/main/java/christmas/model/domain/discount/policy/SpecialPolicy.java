package christmas.model.domain.discount.policy;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.event.EventManager;

import java.util.HashMap;

import static christmas.model.domain.discount.DiscountPolicyName.SPECIAL;
import static christmas.util.constant.NumberConstant.SPECIAL_DISCOUNT;

public class SpecialPolicy implements DiscountPolicy {
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();

        benefitDetails.put(SPECIAL,
                benefitDetails.getOrDefault(SPECIAL, 0) + SPECIAL_DISCOUNT);
    }
}
