package vds.service.policy.demographic;

import lombok.AllArgsConstructor;
import vds.api.TriggerEvent;
import vds.api.interfaces.PolicyCondition;

@AllArgsConstructor
public class EventVisitor implements ConditionVisitor {

    private TriggerEvent triggerEvent;
    
    @Override
    public void visit(PolicyCondition condition) {
        condition.qualifiedEvent(triggerEvent);
    }
    
}
