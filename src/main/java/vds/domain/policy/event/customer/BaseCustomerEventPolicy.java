package vds.domain.policy.event.customer;

import vds.domain.event.customer.BaseCustomerEvent;
import vds.domain.policy.event.BaseEventPolicy;

public abstract class BaseCustomerEventPolicy<T extends BaseCustomerEvent> extends BaseEventPolicy<T> {
}
