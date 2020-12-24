package vds.domain.policy.event.customer;

import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyConditionAcceptor;

public interface CustomerEventPolicyConditionAcceptor<T extends CustomerEvent> extends EventPolicyConditionAcceptor<T> {
    boolean accept(CustomerEventPolicyConditionVisitor<T> visitor);
}
