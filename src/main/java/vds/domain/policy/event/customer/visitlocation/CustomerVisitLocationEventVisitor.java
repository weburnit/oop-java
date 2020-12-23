package vds.domain.policy.event.customer.visitlocation;

import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.Promotions;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyConditionVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerVisitLocationEventVisitor implements CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent, Promotion> {
    private static final List<CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent, Promotion>> visitors = Arrays.asList(
            new CustomerVisitLocationEventTimeGeoBasedVisitor(),
            new CustomerVisitLocationEventDemographicBasedVisitor()
    );

    @Override
    public Promotion visit(CustomerVisitLocationEvent event) {
        List<Promotion> ls = new ArrayList<>();
        for (CustomerEventPolicyConditionVisitor<CustomerVisitLocationEvent, Promotion> visitor : visitors) {
            Promotion promo = visitor.visit(event);
            if (promo != null) {
                ls.add(promo);
            }
        }
        return new Promotions(ls);
    }
}
