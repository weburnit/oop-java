package vds.domain.policy2.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy2.event.EventPolicyCondition;

public interface CustomerEventPolicyCondition<T extends CustomerEvent> extends EventPolicyCondition<T> {
}
