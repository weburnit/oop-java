package vds.domain.policy2.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.event.customer.CustomerEventPolicyCondition;
import vds.domain.policy2.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.*;

@AllArgsConstructor
public class CustomerVisitLocationPolicyDemographicSeniorConditionVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent> {

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
