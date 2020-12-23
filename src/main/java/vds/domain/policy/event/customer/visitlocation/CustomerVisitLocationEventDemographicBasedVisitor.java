package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;
import vds.domain.policy.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.Arrays;
import java.util.List;

public class CustomerVisitLocationEventDemographicBasedVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent, Promotion> {
    private static final List<CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion>> conditions = Arrays.asList(
            new CustomerVisitLocationJuniorPromotionPolicyCondition(),
            new CustomerVisitLocationSeniorPromotionPolicyCondition()
    );

    @Override
    public Promotion visit(CustomerVisitLocationEvent event) {
        for (CustomerEventPolicyCondition<CustomerVisitLocationEvent, Promotion> condition : conditions) {
            Promotion promo = condition.handle(event);
            if (promo != null) {
                return promo;
            }
        }
        return null;
    }
}
