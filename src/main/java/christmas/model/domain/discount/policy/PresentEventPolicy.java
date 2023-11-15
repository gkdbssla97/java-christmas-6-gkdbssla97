package christmas.model.domain.discount.policy;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.event.EventManager;

import java.util.HashMap;

import static christmas.model.domain.discount.DiscountPolicyName.PRESENT_EVENT;
import static christmas.util.constant.NumberConstant.PRESENT_DISCOUNT;

public class PresentEventPolicy implements DiscountPolicy {
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();

        benefitDetails.put(PRESENT_EVENT,
                benefitDetails.getOrDefault(PRESENT_EVENT, 0) + PRESENT_DISCOUNT);
    }
}
