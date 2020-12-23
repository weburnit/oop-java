package vds.domain.event.customer;

import lombok.Getter;
import vds.domain.entity.customer.Customer;

import java.util.Date;

@Getter
public class CustomerVisitLocationEvent extends CustomerEvent {
    private final String city;

    public CustomerVisitLocationEvent(Customer customer, String city, Date eventTime) {
        super(customer, eventTime);
        this.city = city;
    }
}
