package vds.domain.policy;

public interface PolicyCondition<T> {
    boolean handle(T data);
}
