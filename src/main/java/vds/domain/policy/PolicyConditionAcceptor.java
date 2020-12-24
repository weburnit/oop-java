package vds.domain.policy;

import vds.commons.visitor.Acceptor;

public interface PolicyConditionAcceptor<T> extends Acceptor<T, Boolean> {
    boolean accept(PolicyConditionVisitor<T> visitor);
}
