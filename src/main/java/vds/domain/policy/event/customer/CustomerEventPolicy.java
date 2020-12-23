package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy.event.EventPolicy;

public abstract class CustomerEventPolicy<T extends CustomerEvent, R extends Promotion> extends EventPolicy<T, R> {
}
