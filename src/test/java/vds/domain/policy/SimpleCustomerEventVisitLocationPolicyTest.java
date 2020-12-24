package vds.domain.policy;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import vds.domain.entity.customer.Customer;
import vds.domain.entity.customer.Profile;
import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.event.customer.CustomerEventPolicyCondition;
import vds.domain.policy2.event.customer.visitlocation.CustomerVisitLocationDemographicBasedCondition;
import vds.domain.policy2.event.customer.visitlocation.CustomerVisitLocationDemographicPolicy;
import vds.domain.policy2.event.customer.visitlocation.CustomerVisitLocationPolicyDemographicJuniorConditionVisitor;
import vds.domain.policy2.event.customer.visitlocation.CustomerVisitLocationPolicyDemographicSeniorConditionVisitor;

import java.util.*;

/**
 * not actually test
 */
public class SimpleCustomerEventVisitLocationPolicyTest {
    private static final PromotionEvaluator promotionEvaluator = new PromotionEvaluator();

    @Test
    public void t1() {
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


        List<CustomerEventPolicyCondition<CustomerVisitLocationEvent>> conditions1;
        conditions1 = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("target", Arrays.asList("age"));
        m1.put("age_operator", "<");
        m1.put("age_value", 24);
        conditions1.add(new CustomerVisitLocationDemographicBasedCondition(m1));

        List<CustomerEventPolicyCondition<CustomerVisitLocationEvent>> conditions2;
        conditions2 = new ArrayList<>();
        Map<String, Object> m2 = new HashMap<>();
        m2.put("target", Arrays.asList("age"));
        m2.put("age_operator", ">");
        m2.put("age_value", 65);
        conditions1.add(new CustomerVisitLocationDemographicBasedCondition(m2));

        CustomerVisitLocationDemographicPolicy policy = new CustomerVisitLocationDemographicPolicy(
                Arrays.asList(
                        new CustomerVisitLocationPolicyDemographicJuniorConditionVisitor(
                                conditions1
                        ),
                        new CustomerVisitLocationPolicyDemographicSeniorConditionVisitor(
                                conditions2
                        )
                )
        );
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }
}
