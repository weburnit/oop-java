package vds.domain.policy.event.customer.visitlocation.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vds.commons.condition.Condition;
import vds.commons.condition.Operator;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy.event.customer.CustomerEventPolicyCondition;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerVisitLocationTimeGeoBasedCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent> {
    private static final String KEY_LOCATION = "location";
    private static final String KEY_FROM_HRS = "from_hrs";
    private static final String KEY_TO_HRS = "to_hrs";

    private final Map<String, Condition> props;

    public CustomerVisitLocationTimeGeoBasedCondition(TimeGeoCondition cond) {
        if (cond == null) {
            this.props = Collections.emptyMap();
        } else {
            this.props = new HashMap<>();
            this.props.put(KEY_LOCATION, new Condition<>(Operator.EQ, cond.getLocation()));
            this.props.put(KEY_FROM_HRS, new Condition<>(Operator.GT, cond.getFromHrs()));
            this.props.put(KEY_TO_HRS, new Condition<>(Operator.LT, cond.getToHrs()));
        }
    }

    @Getter
    @AllArgsConstructor
    public static final class TimeGeoCondition {
        private final String location;
        private final Integer fromHrs;
        private final Integer toHrs;
    }

    @Override
    public boolean handle(CustomerVisitLocationEvent data) {
        String loc = data.getCity();
        Integer hour = data.getTimestamp().getHours();

        Condition<String> valLocation = props.get(KEY_LOCATION);
        Condition<Integer> valFromHrs = props.get(KEY_FROM_HRS);
        Condition<Integer> valToHrs = props.get(KEY_TO_HRS);

        return (valLocation == null || valLocation.evaluate(loc)) &&
                (valFromHrs == null || valFromHrs.evaluate(hour)) &&
                (valToHrs == null || valToHrs.evaluate(hour));
    }
}
