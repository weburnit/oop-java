package vds.service.loyalty;

public class AgePolicyCondition implements PolicyCondition{

  @Override
  public String getId() {
    return "AgePolicyCondition";
  }

  @Override
  public boolean qualifiedEvent(TriggerEvent event) {
    Integer age = event.getProperty("age");
    if(age > 60){
      System.out.println("Hello senior!");
    } else if (age < 18){
      System.out.println("Hi guy!");
    }
    return true;
  }

//  public class ComparisonOperation{
//
//    @Override
//    public boolean compareTo(Integer expected, Integer condition) {
//      return true;
//    }
//  }

}
