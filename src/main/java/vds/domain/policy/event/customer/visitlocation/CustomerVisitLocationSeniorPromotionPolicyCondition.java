package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.SeniorDiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

public class CustomerVisitLocationSeniorPromotionPolicyCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion> {
    @Override
    public Promotion handle(CustomerVisitLocationEvent event) {
        if (event.getCustomer().getProfile().getAge() > 65) {
            return new SeniorDiscountPromotion();
        } else {
            return null;
        }
    }
}
