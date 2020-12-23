package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicyCondition;

public interface CustomerEventPolicyCondition<T extends CustomerEvent, R extends Promotion> extends EventPolicyCondition<T, R> {
}
