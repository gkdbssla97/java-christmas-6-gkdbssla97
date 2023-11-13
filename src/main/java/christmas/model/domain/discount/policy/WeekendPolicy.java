package christmas.model.domain.discount.policy;

import christmas.model.domain.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

public class WeekendPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<String, Integer> benefitDetails = eventManager.getBenefitDetails();
        List<Menu> orderMenuList = eventManager.getOrderMenuList();

        int discountPrice = 0;
        for(Menu menu : orderMenuList) {
            if(menu.getCategory().equals(Category.MAIN)) {
                discountPrice += menu.getCount() * 2023;
            }
        }
        benefitDetails.put(DiscountPolicyName.WEEKEND.getDiscountPolicy(),
                benefitDetails.getOrDefault(DiscountPolicyName.WEEKEND.getDiscountPolicy(), 0) + (-discountPrice));
    }
}
