package vds.service.loyalty;

public class EventVisitor implements ConditionVisitor{
  private TriggerEvent event;

  public EventVisitor(TriggerEvent event) {
    this.event = event;
  }

  @Override
  public void visit(PolicyCondition condition) {
    condition.qualifiedEvent(event);
  }
}
