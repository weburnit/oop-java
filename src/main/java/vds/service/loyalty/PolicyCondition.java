package vds.service.loyalty;

public interface PolicyCondition {
  String getId();
  boolean qualifiedEvent(TriggerEvent event);
}
