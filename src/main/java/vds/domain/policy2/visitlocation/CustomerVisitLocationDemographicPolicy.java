package vds.domain.policy2.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.Policy;
import vds.domain.policy2.PolicyConditionVisitor;

import java.util.Arrays;
import java.util.List;

public class CustomerVisitLocationDemographicPolicy extends Policy<CustomerVisitLocationEvent, Promotion> {
    private static final List<PolicyConditionVisitor<CustomerVisitLocationEvent>> visitors = Arrays.asList(
            new CustomerVisitLocationPolicyDemographicSeniorConditionVisitor(),
            new CustomerVisitLocationPolicyDemographicJuniorConditionVisitor()
    );

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
