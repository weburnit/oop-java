package vds.service.loyalty;

import java.util.Arrays;

public class Policy {
  PolicyCondition[] conditions;

  public Policy(PolicyCondition ... conditions) {
    this.conditions = conditions;
  }

  void handleEvent(TriggerEvent event) {
    EventVisitor visitor = new EventVisitor(event);
    Arrays.stream(conditions).forEach(visitor::visit);
  }
}
