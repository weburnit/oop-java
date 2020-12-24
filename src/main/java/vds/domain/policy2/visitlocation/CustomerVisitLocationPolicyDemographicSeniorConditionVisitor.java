package vds.domain.policy2.visitlocation;

import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.PolicyCondition;
import vds.domain.policy2.PolicyConditionVisitor;

import java.util.*;

public class CustomerVisitLocationPolicyDemographicSeniorConditionVisitor implements PolicyConditionVisitor<CustomerVisitLocationEvent> {
    private static final List<PolicyCondition<CustomerVisitLocationEvent>> conditions;
    static {
        conditions = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("target", Arrays.asList("age"));
        m1.put("age_operator", ">");
        m1.put("age_value", 65);
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
