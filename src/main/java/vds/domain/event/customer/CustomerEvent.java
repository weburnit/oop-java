package vds.domain.event.customer;

import lombok.Getter;
import vds.domain.entity.customer.Customer;
import vds.domain.event.Event;

@Getter
public abstract class CustomerEvent extends Event {
    private final Customer customer;

    protected CustomerEvent(Customer customer, long ts) {
        super(ts);
        this.customer = customer;
    }
}
