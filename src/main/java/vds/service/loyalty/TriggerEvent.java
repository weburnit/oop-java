package vds.service.loyalty;

public interface TriggerEvent {
  <T> T getProperty(String key);
}
