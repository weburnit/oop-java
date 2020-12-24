package vds.domain.policy.event.customer.visitlocation.base;

import lombok.AllArgsConstructor;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.*;

@AllArgsConstructor
public class CustomerVisitLocationPolicyTimeGeoConditionVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent> {
    private final List<CustomerVisitLocationTimeGeoBasedCondition> conditions;

    @Override
    public Boolean visit(CustomerVisitLocationEvent data) {
        for (CustomerVisitLocationTimeGeoBasedCondition condition : conditions) {
            boolean b = condition.handle(data);
            if (b) return true;
        }
        return false;
    }
}
