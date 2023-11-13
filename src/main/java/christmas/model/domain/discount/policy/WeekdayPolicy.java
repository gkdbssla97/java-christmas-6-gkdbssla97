package christmas.model.domain.discount.policy;

import christmas.model.domain.event.EventManager;
import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.menu.Category;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

import static christmas.model.domain.discount.DiscountPolicyName.*;

public class WeekdayPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
        List<Menu> orderMenuList = eventManager.getOrderMenuList();

        int discountPrice = 0;
        for(Menu menu : orderMenuList) {
            if(menu.getCategory().equals(Category.DESSERT)) {
                discountPrice += menu.getCount() * 2023;
            }
        }
        benefitDetails.put(WEEKDAY,
                benefitDetails.getOrDefault(WEEKDAY, 0) + (-discountPrice));
    }
}
