package christmas.model.domain.discount.policy;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

import static christmas.model.domain.discount.DiscountPolicyName.WEEKEND;
import static christmas.model.domain.menu.Category.MAIN;
import static christmas.util.constant.NumberConstant.EVENT_YEAR;

public class WeekendPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
        List<Menu> orderMenuList = eventManager.getOrderMenuList();

        int discountPrice = 0;
        for(Menu menu : orderMenuList) {
            if(menu.getCategory().equals(MAIN)) {
                discountPrice += EVENT_YEAR;
            }
        }
        benefitDetails.put(WEEKEND,
                benefitDetails.getOrDefault(WEEKEND, 0) + (-discountPrice));
    }
}
