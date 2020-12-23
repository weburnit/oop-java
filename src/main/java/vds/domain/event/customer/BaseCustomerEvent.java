package vds.domain.event.customer;

import lombok.Getter;
import vds.domain.entity.customer.Customer;
import vds.domain.event.BaseEvent;

@Getter
public abstract class BaseCustomerEvent extends BaseEvent {
    private final Customer customer;

    protected BaseCustomerEvent(Customer customer, long ts) {
        super(ts);
        this.customer = customer;
    }
}
