package christmas.model.domain.discount.policy;

import christmas.model.domain.discount.DiscountPolicyName;
import christmas.model.domain.event.EventManager;
import christmas.model.domain.menu.Menu;

import java.util.HashMap;
import java.util.List;

import static christmas.model.domain.discount.DiscountPolicyName.WEEKDAY;
import static christmas.model.domain.menu.Category.DESSERT;
import static christmas.util.constant.NumberConstant.EVENT_YEAR;

public class WeekdayPolicy implements DiscountPolicy{
    @Override
    public void discount(EventManager eventManager, int date) {
        HashMap<DiscountPolicyName, Integer> benefitDetails = eventManager.getBenefitDetails();
        List<Menu> orderMenus = eventManager.getOrderMenus();

        int discountPrice = 0;
        for(Menu menu : orderMenus) {
            if(menu.getCategory().equals(DESSERT)) {
                discountPrice += EVENT_YEAR;
            }
        }
        benefitDetails.put(WEEKDAY,
                benefitDetails.getOrDefault(WEEKDAY, 0) + (-discountPrice));
    }
}
