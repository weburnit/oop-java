package vds.domain.policy2;

public interface PolicyCondition<T> {
    boolean handle(T data);
}
