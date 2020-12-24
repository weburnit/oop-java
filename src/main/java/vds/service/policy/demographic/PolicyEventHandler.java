package vds.service.policy.demographic;

import java.util.ArrayList;
import java.util.List;

import vds.api.TriggerEvent;
import vds.api.interfaces.PolicyCondition;

public class PolicyEventHandler implements Policy {
    private List<PolicyCondition> conditions;

    public PolicyEventHandler(List<PolicyCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public void handleEvent(TriggerEvent triggerEvent) {
        ConditionVisitor visitor = new EventVisitor(triggerEvent);
        for(PolicyCondition condition: conditions) {
            visitor.visit(condition);
        }
    }
}
