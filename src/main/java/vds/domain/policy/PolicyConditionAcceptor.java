package vds.domain.policy;

import vds.commons.visitor.Acceptor;

public interface PolicyConditionAcceptor<T, R> extends Acceptor<T, R> {
    R accept(PolicyConditionVisitor<T, R> visitor);
}
