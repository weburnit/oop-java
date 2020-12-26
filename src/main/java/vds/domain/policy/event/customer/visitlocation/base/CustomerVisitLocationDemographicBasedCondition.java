package vds.domain.policy.event.customer.visitlocation.base;

import lombok.AllArgsConstructor;
import vds.commons.condition.Condition;
import vds.domain.entity.customer.Profile;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

import java.lang.reflect.Field;
import java.util.*;

@AllArgsConstructor
public class CustomerVisitLocationDemographicBasedCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent> {
    private final Map<String, Condition> props;

    @Override
    public boolean handle(CustomerVisitLocationEvent data) {
        try {
            for (Map.Entry<String, Condition> entry : props.entrySet()) {
                Field targetField = Profile.class.getDeclaredField(entry.getKey());
                targetField.setAccessible(true);
                Object value = targetField.get(data.getCustomer().getProfile());
                boolean b = entry.getValue().evaluate((Comparable) value);
                if (!b) {
                    return false;
                }
                targetField.setAccessible(false);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
