package vds.domain.policy;

import vds.commons.visitor.Visitor;

public interface PolicyConditionVisitor<T, R> extends Visitor<T, R> {
    R visit(T data);
}
