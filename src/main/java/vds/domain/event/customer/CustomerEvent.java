package vds.domain.event.customer;

import lombok.Getter;
import vds.domain.entity.customer.Customer;
import vds.domain.event.Event;

import java.util.Date;

@Getter
public abstract class CustomerEvent extends Event {
    private final Customer customer;

    protected CustomerEvent(Customer customer, Date eventTime) {
        super(eventTime);
        this.customer = customer;
    }
}
