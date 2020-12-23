package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyConditionAcceptor;

public interface CustomerEventPolicyConditionAcceptor<T extends CustomerEvent, R extends Promotion> extends EventPolicyConditionAcceptor<T, R> {
    R accept(CustomerEventPolicyConditionVisitor<T, R> visitor);
}
