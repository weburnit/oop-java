package vds.domain.policy2.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy2.event.EventPolicyConditionVisitor;

public interface CustomerEventPolicyConditionVisitor<T extends CustomerEvent> extends EventPolicyConditionVisitor<T> {
}
