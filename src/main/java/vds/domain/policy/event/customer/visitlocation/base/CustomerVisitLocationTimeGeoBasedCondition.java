package vds.domain.policy.event.customer.visitlocation.base;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

import java.util.Map;

@AllArgsConstructor
public class CustomerVisitLocationTimeGeoBasedCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent> {
    private final Map<String, Object> props;

    @Override
    public boolean handle(CustomerVisitLocationEvent data) {
        String loc = data.getCity();
        Integer hour = data.getTimestamp().getHours();
        return StringUtils.equals((CharSequence) props.get("location"), loc) &&
                hour > (Integer) props.get("from_hrs") &&
                hour < (Integer) props.get("to_hrs");
    }
}
