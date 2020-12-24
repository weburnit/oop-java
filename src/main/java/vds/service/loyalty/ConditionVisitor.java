package vds.service.loyalty;

public interface ConditionVisitor {
  void visit(PolicyCondition condition);

}
