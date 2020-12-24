package vds.domain.policy.event.customer.visitlocation.base;

import lombok.AllArgsConstructor;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;
import vds.domain.policy.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.*;

@AllArgsConstructor
public class CustomerVisitLocationPolicyDemographicConditionVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent> {

    private final List<CustomerEventPolicyCondition<CustomerVisitLocationEvent>> conditions;

    @Override
    public Boolean visit(CustomerVisitLocationEvent data) {
        for (CustomerEventPolicyCondition<CustomerVisitLocationEvent> condition : conditions) {
            boolean b = condition.handle(data);
            if (b) return true;
        }
        return false;
    }
}
