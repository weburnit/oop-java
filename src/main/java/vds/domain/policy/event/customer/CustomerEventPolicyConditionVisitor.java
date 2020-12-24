package vds.domain.policy.event.customer;

import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyConditionVisitor;

public interface CustomerEventPolicyConditionVisitor<T extends CustomerEvent> extends EventPolicyConditionVisitor<T> {
}
