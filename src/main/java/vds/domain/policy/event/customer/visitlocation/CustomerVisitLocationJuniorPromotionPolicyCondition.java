package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.JuniorDiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

public class CustomerVisitLocationJuniorPromotionPolicyCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion> {
    @Override
    public Promotion handle(CustomerVisitLocationEvent event) {
        if (event.getCustomer().getProfile().getAge() < 24) {
            return new JuniorDiscountPromotion();
        } else {
            return null;
        }
    }
}
