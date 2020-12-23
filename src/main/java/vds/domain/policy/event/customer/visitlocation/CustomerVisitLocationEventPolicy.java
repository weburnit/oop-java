package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicy;

public class CustomerVisitLocationEventPolicy extends CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> {
    private static final CustomerVisitLocationEventVisitor visitor = new CustomerVisitLocationEventVisitor();

    @Override
    public Promotion handle(CustomerVisitLocationEvent event) {
        return visitor.visit(event);
    }
}
