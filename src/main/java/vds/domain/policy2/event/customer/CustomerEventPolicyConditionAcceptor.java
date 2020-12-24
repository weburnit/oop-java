package vds.domain.policy2.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy2.event.EventPolicyConditionAcceptor;

public interface CustomerEventPolicyConditionAcceptor<T extends CustomerEvent> extends EventPolicyConditionAcceptor<T> {
    boolean accept(CustomerEventPolicyConditionVisitor<T> visitor);
}
