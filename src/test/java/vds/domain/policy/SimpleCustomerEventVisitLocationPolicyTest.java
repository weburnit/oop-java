package vds.domain.policy;

import org.junit.Test;
import vds.domain.entity.customer.Customer;
import vds.domain.entity.customer.Profile;
import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicy;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationDemographicBasedCondition;
import vds.domain.policy.event.customer.visitlocation.CustomerVisitLocationDemographicSeniorPolicy;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationPolicyDemographicConditionVisitor;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCustomerEventVisitLocationPolicyTest {
    private static final PromotionEvaluator promotionEvaluator = new PromotionEvaluator();

    @Test
    public void seniorTest() {
        Profile profile = new Profile(
                "TEST2",
                66,
                "NOJOB",
                "EN"
        );
        Customer customer = new Customer(
                profile,
                new HashMap<>()
        );
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerEventPolicyCondition<CustomerVisitLocationEvent>> conditions;
        conditions = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("target", Arrays.asList("age"));
        m.put("age_operator", ">");
        m.put("age_value", 65);
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m));

        Promotion promotion = new DiscountPromotion("Hello senior", 84.0, null) {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationDemographicSeniorPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyDemographicConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertEquals(promo, new DiscountPromotion("Hello senior", 84.0, null) {});
    }

    @Test
    public void juniorTest() {
        Profile profile = new Profile(
                "TEST2",
                23,
                "NOJOB",
                "EN"
        );
        Customer customer = new Customer(
                profile,
                new HashMap<>()
        );
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerEventPolicyCondition<CustomerVisitLocationEvent>> conditions;
        conditions = new ArrayList<>();
        Map<String, Object> m = new HashMap<>();
        m.put("target", Arrays.asList("age"));
        m.put("age_operator", "<");
        m.put("age_value", 24);
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m));

        Promotion promotion = new DiscountPromotion("Hello junor", null, 170_000L) {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationDemographicSeniorPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyDemographicConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertEquals(promo, new DiscountPromotion("Hello junor", null, 170_000L) {});
    }
}
