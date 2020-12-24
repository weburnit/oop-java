package vds.domain.policy;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import vds.domain.entity.customer.Customer;
import vds.domain.entity.customer.Profile;
import vds.domain.entity.promotion.Promotion;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.visitlocation.CustomerVisitLocationEventPolicy;
import vds.domain.policy2.visitlocation.CustomerVisitLocationDemographicPolicy;

import java.util.Date;
import java.util.HashMap;

/**
 * not actually test
 */
public class SimpleCustomerEventVisitLocationPolicyTest {
    private static final PromotionEvaluator promotionEvaluator = new PromotionEvaluator();

    @Test
    public void seniorHanoiAtNightPromoTest() throws JsonProcessingException {
        Profile profile = new Profile(
                "TEST1",
                66,
                "NOJOB",
                "VN"
        );
        Customer customer = new Customer(
                profile,
                new HashMap<>()
        );
        CustomerVisitLocationEvent event = new CustomerVisitLocationEvent(
                customer,
                "HANOI",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );
        CustomerVisitLocationEventPolicy policy = new CustomerVisitLocationEventPolicy();
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }

    @Test
    public void seniorHcmcAtNightPromoTest() throws JsonProcessingException {
        Profile profile = new Profile(
                "TEST1",
                66,
                "NOJOB",
                "VN"
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
        CustomerVisitLocationEventPolicy policy = new CustomerVisitLocationEventPolicy();
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }

    @Test
    public void juniorHanoiAtNightPromoTest() throws JsonProcessingException {
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
                "HANOI",
                new Date(1608739450) // Wednesday, December 23, 2020 4:04:10 PM
        );
        CustomerVisitLocationEventPolicy policy = new CustomerVisitLocationEventPolicy();
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }

    @Test
    public void juniorHcmcAtNightPromoTest() throws JsonProcessingException {
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
        CustomerVisitLocationEventPolicy policy = new CustomerVisitLocationEventPolicy();
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }

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
        CustomerVisitLocationDemographicPolicy policy = new CustomerVisitLocationDemographicPolicy();
        Promotion promo = policy.handle(event);
        promotionEvaluator.visit(promo);
    }
}
