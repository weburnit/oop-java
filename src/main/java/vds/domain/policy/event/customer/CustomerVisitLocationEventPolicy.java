package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotions;
import vds.domain.event.customer.CustomerVisitLocationEvent;

public class CustomerVisitLocationEventPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotions> {
    private static final CustomerVisitLocationEventVisitor visitor = new CustomerVisitLocationEventVisitor();

    @Override
    public Promotions handle(CustomerVisitLocationEvent event) {
        return visitor.visit(event);
    }
}
