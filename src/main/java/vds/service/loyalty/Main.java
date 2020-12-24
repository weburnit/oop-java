package vds.service.loyalty;

public class Main {
  public static void main(String[] args){
    Policy policy = new Policy(new AgePolicyCondition(),new AgePolicyCondition());
    policy.handleEvent(new TriggerEvent() {
      @Override
      public <T> T getProperty(String key) {
        Integer age = 70;
        return (T) age;
      }
    });
  }
}
