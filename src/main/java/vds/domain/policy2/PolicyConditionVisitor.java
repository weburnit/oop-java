package vds.domain.policy2;

import vds.commons.visitor.Visitor;

public interface PolicyConditionVisitor<T> extends Visitor<T, Boolean> {
    Boolean visit(T data);
}
