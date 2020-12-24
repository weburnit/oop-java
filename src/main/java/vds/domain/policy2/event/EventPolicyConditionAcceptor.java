package vds.domain.policy2.event;

import vds.domain.event.Event;
import vds.domain.policy2.PolicyConditionAcceptor;

public interface EventPolicyConditionAcceptor<T extends Event> extends PolicyConditionAcceptor<T> {
    boolean accept(EventPolicyConditionVisitor<T> visitor);
}
