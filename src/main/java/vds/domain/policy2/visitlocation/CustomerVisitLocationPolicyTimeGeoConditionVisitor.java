package vds.domain.policy2.visitlocation;

import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.PolicyCondition;
import vds.domain.policy2.PolicyConditionVisitor;

import java.util.*;

public class CustomerVisitLocationPolicyTimeGeoConditionVisitor implements PolicyConditionVisitor<CustomerVisitLocationEvent> {
    private static final List<PolicyCondition<CustomerVisitLocationEvent>> conditions;
    static {
        conditions = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("location", "HANOI");
        m1.put("from_hrs", 0);
        m1.put("to_hrs", 12);
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m1));
    }

    @Override
    public Boolean visit(CustomerVisitLocationEvent data) {
        for (PolicyCondition<CustomerVisitLocationEvent> condition : conditions) {
            boolean b = condition.handle(data);
            if (b) return true;
        }
        return false;
    }
}
