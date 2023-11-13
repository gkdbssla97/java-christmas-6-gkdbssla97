package christmas.model.domain.discount.policy;

import christmas.model.domain.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

public class PresentEventPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<String, Integer> benefitDetails = eventManager.getBenefitDetails();

        benefitDetails.put(DiscountPolicyName.PRESENT_EVENT.getDiscountPolicy(),
                benefitDetails.getOrDefault(DiscountPolicyName.PRESENT_EVENT.getDiscountPolicy(), 0) + (-25000));
    }
}
