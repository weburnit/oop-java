package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyConditionVisitor;

public interface CustomerEventPolicyConditionVisitor<T extends CustomerEvent, R extends Promotion> extends EventPolicyConditionVisitor<T, R> {
}
