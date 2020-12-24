package vds.domain.policy2.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.PolicyConditionVisitor;
import vds.domain.policy2.event.customer.CustomerEventPolicy;
import vds.domain.policy2.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.List;

@AllArgsConstructor
public class CustomerVisitLocationDemographicPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> {
    private final List<CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent>> visitors;

    @Override
    public Promotion handle(CustomerVisitLocationEvent data) {
        for (PolicyConditionVisitor<CustomerVisitLocationEvent> visitor : visitors) {
            boolean b = visitor.visit(data);
            if (!b) continue;
            if (visitor instanceof CustomerVisitLocationPolicyDemographicSeniorConditionVisitor) {
                return new DiscountPromotion("Hello senior", 84.0, null) {};
            } else if (visitor instanceof CustomerVisitLocationPolicyDemographicJuniorConditionVisitor) {
                return new DiscountPromotion("Hello junior", null, 160_000L) {};
            }
        }
        return null;
    }
}
