package vds.domain.policy.event;

import vds.domain.event.Event;
import vds.domain.policy.PolicyConditionAcceptor;

public interface EventPolicyConditionAcceptor<T extends Event> extends PolicyConditionAcceptor<T> {
    boolean accept(EventPolicyConditionVisitor<T> visitor);
}
