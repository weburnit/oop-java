package vds.domain.policy.event;

import vds.domain.event.Event;
import vds.domain.policy.PolicyConditionAcceptor;

public interface EventPolicyConditionAcceptor<T extends Event, R> extends PolicyConditionAcceptor<T, R> {
    R accept(EventPolicyConditionVisitor<T, R> visitor);
}
