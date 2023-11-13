package christmas.model.domain.discount.policy;

import christmas.model.domain.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;

import java.util.HashMap;

import static christmas.model.domain.discount.DiscountPolicyName.*;

public class DDayPolicy implements DiscountPolicy {
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<String, Integer> benefitDetails = eventManager.getBenefitDetails();
        benefitDetails.putIfAbsent(CHRISTMAS_D_DAY.getDiscountPolicy(),
                benefitDetails.getOrDefault(CHRISTMAS_D_DAY.getDiscountPolicy(), 0) + (-discountAlgorithm(date)));
    }

    public int discountAlgorithm(int day) {
        int money = 1000;
        return (day - 1) * 100 + money;
    }
}

