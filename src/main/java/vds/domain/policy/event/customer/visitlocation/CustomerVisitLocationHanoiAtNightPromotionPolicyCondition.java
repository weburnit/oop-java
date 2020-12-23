package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.text.HanoiNightPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

public class CustomerVisitLocationHanoiAtNightPromotionPolicyCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion> {
    @Override
    public Promotion handle(CustomerVisitLocationEvent event) {
        int hour = event.getTimestamp().getHours();
        if (hour > 12 && "HANOI".equals(event.getCity())) {
            return new HanoiNightPromotion();
        } else {
            return null;
        }
    }
}
