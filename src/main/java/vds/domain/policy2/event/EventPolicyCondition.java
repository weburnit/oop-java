package vds.domain.policy2.event;

import vds.domain.event.Event;
import vds.domain.policy2.PolicyCondition;

public interface EventPolicyCondition<T extends Event> extends PolicyCondition<T> {
}
