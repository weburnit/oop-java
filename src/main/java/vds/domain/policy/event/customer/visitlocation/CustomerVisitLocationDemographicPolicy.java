package vds.domain.policy.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicy;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationPolicyDemographicConditionVisitor;

import java.util.List;

@AllArgsConstructor
public class CustomerVisitLocationDemographicPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> {
    private final List<CustomerVisitLocationPolicyDemographicConditionVisitor> visitors;
    private final Promotion promotion;

    @Override
    public Promotion handle(CustomerVisitLocationEvent data) {
        for (CustomerVisitLocationPolicyDemographicConditionVisitor visitor : visitors) {
            boolean b = visitor.visit(data);
            if (!b) {
                return null;
            }
        }
        return promotion;
    }
}
