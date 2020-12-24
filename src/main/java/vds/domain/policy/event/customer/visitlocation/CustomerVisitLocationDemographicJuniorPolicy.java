package vds.domain.policy.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.PolicyConditionVisitor;
import vds.domain.policy.event.customer.CustomerEventPolicy;
import vds.domain.policy.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.List;

@AllArgsConstructor
public class CustomerVisitLocationDemographicJuniorPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> {
    private final List<CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent>> visitors;
    private final Promotion promotion;

    @Override
    public Promotion handle(CustomerVisitLocationEvent data) {
        for (PolicyConditionVisitor<CustomerVisitLocationEvent> visitor : visitors) {
            boolean b = visitor.visit(data);
            if (!b) {
                return null;
            }
        }
        return promotion;
    }
}
