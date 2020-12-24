package vds.domain.policy;

import vds.commons.visitor.Visitor;

public interface PolicyConditionVisitor<T> extends Visitor<T, Boolean> {
    Boolean visit(T data);
}
