package vds.domain.policy2.event.customer.visitlocation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vds.domain.entity.customer.Profile;
import vds.domain.event.customer.CustomerVisitLocationEvent;
import vds.domain.policy2.event.customer.CustomerEventPolicyCondition;

import java.lang.reflect.Field;
import java.util.*;

@AllArgsConstructor
public class CustomerVisitLocationDemographicBasedCondition implements CustomerEventPolicyCondition<CustomerVisitLocationEvent> {
    private final Map<String, Object> props;

    @Getter
    @AllArgsConstructor
    private enum Operator {
        GT(">"),
        LT("<"),
        EQ("=");

        private final String value;

        private static final Map<String, Operator> map;
        static {
            Map<String, Operator> mx = new HashMap<>();
            for (Operator op : Operator.values()) {
                mx.put(op.getValue(), op);
            }
            map = Collections.unmodifiableMap(mx);
        }

        public static Operator fromString(String s) {
            return map.get(s);
        }
    }

    @Override
    public boolean handle(CustomerVisitLocationEvent data) {
        List<String> targetAttr = (List<String>) props.get("target");
        List<Comparable<Object>> values = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();
        for (String target : targetAttr) {
            values.add((Comparable<Object>) props.get(target + "_value"));
            operators.add(Operator.fromString((String) props.get(target + "_operator")));
        }
        try {
            boolean flag = true;
            for (int i = 0; i < targetAttr.size(); i++) {
                Field targetField = Profile.class.getDeclaredField(targetAttr.get(i));
                targetField.setAccessible(true);
                Object value = targetField.get(data.getCustomer().getProfile());
                switch (operators.get(i)) {
                    case GT:
                        if (values.get(i).compareTo(value) > 0) flag = false;
                        break;
                    case EQ:
                        if (!Objects.equals(value, values.get(i))) flag = false;
                        break;
                    case LT:
                        if (values.get(i).compareTo(value) < 0) flag = false;
                        break;
                }
                targetField.setAccessible(false);
            }
            if (!flag) return flag;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
