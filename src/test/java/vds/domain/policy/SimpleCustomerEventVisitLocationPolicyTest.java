package vds.domain.policy;

import org.junit.Test;
import vds.commons.condition.Condition;
import vds.commons.condition.Operator;
import vds.domain.entity.customer.Customer;
import vds.domain.entity.customer.Profile;
import vds.domain.entity.promotion.Promotion;
import vds.domain.entity.promotion.discount.DiscountPromotion;
import vds.domain.entity.promotion.text.TextPromotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicy;
import vds.domain.policy.event.customer.visitlocation.CustomerVisitLocationTimeGeoPolicy;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationDemographicBasedCondition;
import vds.domain.policy.event.customer.visitlocation.CustomerVisitLocationDemographicPolicy;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationPolicyDemographicConditionVisitor;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationPolicyTimeGeoConditionVisitor;
import vds.domain.policy.event.customer.visitlocation.base.CustomerVisitLocationTimeGeoBasedCondition;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleCustomerEventVisitLocationPolicyTest {
    private static final PromotionEvaluator promotionEvaluator = new PromotionEvaluator();

    @Test
    public void seniorTest() {
        Profile profile = Profile.builder()
                .name("Jax Sparrow")
                .age(66)
                .job("unemployed")
                .country("US")
                .build();
        Customer customer = Customer.builder().profile(profile).build();
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerVisitLocationDemographicBasedCondition> conditions;
        conditions = new ArrayList<>();
        Map<String, Condition> m = new HashMap<>();
        m.put("age", new Condition<>(Operator.GT, 65));
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m));

        Promotion promotion = new DiscountPromotion("Hello senior", 84.0, null) {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationDemographicPolicy(
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
        Profile profile = Profile.builder()
                .name("Jax Sparrow Jr.")
                .age(23)
                .job("unemployed")
                .country("US")
                .build();
        Customer customer = Customer.builder().profile(profile).build();
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerVisitLocationDemographicBasedCondition> conditions;
        conditions = new ArrayList<>();
        Map<String, Condition> m = new HashMap<>();
        m.put("age", new Condition<>(Operator.LT, 24));
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m));

        Promotion promotion = new DiscountPromotion("Hello junor", null, 170_000L) {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationDemographicPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyDemographicConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertEquals(promo, new DiscountPromotion("Hello junor", null, 170_000L) {});
    }

    @Test(expected = ClassCastException.class)
    public void exceptionTest() {
        Profile profile = Profile.builder()
                .name("Jax Sparrow Jr.")
                .age(23)
                .job("unemployed")
                .country("US")
                .build();
        Customer customer = Customer.builder().profile(profile).build();
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerVisitLocationDemographicBasedCondition> conditions;
        conditions = new ArrayList<>();
        Map<String, Condition> m = new HashMap<>();
        m.put("age", new Condition<>(Operator.LT, "24")); // will throw exception if evaluate
        conditions.add(new CustomerVisitLocationDemographicBasedCondition(m));

        Promotion promotion = new DiscountPromotion("Hello junor", null, 170_000L) {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationDemographicPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyDemographicConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertEquals(promo, new DiscountPromotion("Hello junor", null, 170_000L) {});
    }

    @Test
    public void timeGeoTest1() {
        Profile profile = Profile.builder()
                .name("Jax Sparrow Jr.")
                .age(23)
                .job("unemployed")
                .country("US")
                .build();
        Customer customer = Customer.builder().profile(profile).build();
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerVisitLocationTimeGeoBasedCondition> conditions = new ArrayList<>();

        conditions.add(new CustomerVisitLocationTimeGeoBasedCondition(
                new CustomerVisitLocationTimeGeoBasedCondition.TimeGeoCondition("HCMC", 12, 24)
        ));

        Promotion promotion = new TextPromotion("HCMC at night") {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationTimeGeoPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyTimeGeoConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertEquals(promo, new TextPromotion("HCMC at night") {});
    }

    @Test
    public void timeGeoNoPromoTest1() {
        Profile profile = Profile.builder()
                .name("Jax Sparrow Jr.")
                .age(23)
                .job("unemployed")
                .country("US")
                .build();
        Customer customer = Customer.builder().profile(profile).build();
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HCMC",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );

        List<CustomerVisitLocationTimeGeoBasedCondition> conditions = new ArrayList<>();

        conditions.add(new CustomerVisitLocationTimeGeoBasedCondition(
                new CustomerVisitLocationTimeGeoBasedCondition.TimeGeoCondition("HANOI", 12, 24)
        ));

        Promotion promotion = new TextPromotion("HCMC at night") {};

        CustomerEventPolicy<CustomerVisitLocationEvent, Promotion> policy = new CustomerVisitLocationTimeGeoPolicy(
                Collections.singletonList(
                        new CustomerVisitLocationPolicyTimeGeoConditionVisitor(conditions)
                ),
                promotion
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo); // debug print
        assertNull(promo); // no promotion
    }
}
