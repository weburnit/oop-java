package vds.service.policy.demographic;

import vds.api.interfaces.PolicyCondition;

public interface ConditionVisitor {
    void visit(PolicyCondition condition);
}
