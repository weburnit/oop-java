package vds.domain.policy.event;

import vds.domain.event.Event;
import vds.domain.policy.PolicyConditionVisitor;

public interface EventPolicyConditionVisitor<T extends Event, R> extends PolicyConditionVisitor<T, R> {
}
