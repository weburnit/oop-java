package vds.domain.policy.event.customer;

import vds.domain.entity.promotion.Promotions;
import vds.domain.event.customer.CustomerVisitLocationEvent;

public class CustomerVisitLocationEventVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent, Promotions> {

    @Override
    public Promotions visit(CustomerVisitLocationEvent event) {
        return null;
    }
}
