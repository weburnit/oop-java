package vds.domain.policy.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicy;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationPolicyTimeGeoConditionVisitor;

import java.util.List;

@AllArgsConstructor
public class CustomerVisitLocationTimeGeoPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> {
    private final List<CustomerVisitLocationPolicyTimeGeoConditionVisitor> visitors;
    private final Promotion promotion;

    @Override
    public Promotion handle(CustomerVisitLocationEvent data) {
        for (CustomerVisitLocationPolicyTimeGeoConditionVisitor visitor : visitors) {
            boolean b = visitor.visit(data);
            if (!b) {
                return null;
            }
        }
        return promotion;
    }
}