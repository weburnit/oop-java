package vds.domain.policy2.event;

import vds.domain.event.Event;
import vds.domain.policy2.PolicyConditionVisitor;

public interface EventPolicyConditionVisitor<T extends Event> extends PolicyConditionVisitor<T> {
}
