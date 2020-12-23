package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.text.HcmcDayPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

public class CustomerVisitLocationHcmcAtDayPromotionPolicyCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion> {
    @Override
    public Promotion handle(CustomerVisitLocationEvent event) {
        int hour = event.getTimestamp().getHours();
        if (hour > 0 && hour < 12 && "HCMC".equals(event.getCity())) {
            return new HcmcDayPromotion();
        } else {
            return null;
        }
    }
}
