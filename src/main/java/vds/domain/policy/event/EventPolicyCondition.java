package vds.domain.policy.event;

import vds.domain.event.Event;
import vds.domain.policy.PolicyCondition;

public interface EventPolicyCondition<T extends Event, R> extends PolicyCondition<T, R> {
}
