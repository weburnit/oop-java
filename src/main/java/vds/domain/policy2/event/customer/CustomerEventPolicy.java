package vds.domain.policy2.event.customer;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerEvent;
import vds.domain.policy2.event.EventPolicy;

public abstract class CustomerEventPolicy<T extends CustomerEvent, R extends Promotion> extends EventPolicy<T, R> {
}
