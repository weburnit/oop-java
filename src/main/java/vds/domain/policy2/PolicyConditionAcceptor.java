package vds.domain.policy2;

import vds.commons.visitor.Acceptor;

public interface PolicyConditionAcceptor<T> extends Acceptor<T, Boolean> {
    boolean accept(PolicyConditionVisitor<T> visitor);
}
