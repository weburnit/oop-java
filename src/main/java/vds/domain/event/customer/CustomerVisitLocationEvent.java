package vds.domain.event.customer;

import lombok.Getter;
import vds.domain.entity.customer.Customer;

@Getter
public class CustomerVisitLocationEvent extends CustomerEvent {
    private final String city;

    public CustomerVisitLocationEvent(Customer customer, String city, long ts) {
        super(customer, ts);
        this.city = city;
    }
}
