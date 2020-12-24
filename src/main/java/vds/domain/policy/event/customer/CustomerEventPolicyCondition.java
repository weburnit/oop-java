package vds.domain.policy.event.customer;

import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyCondition;

public interface CustomerEventPolicyCondition<T extends CustomerEvent> extends EventPolicyCondition<T> {
}
