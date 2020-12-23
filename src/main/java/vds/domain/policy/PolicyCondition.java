package vds.domain.policy;

public interface PolicyCondition<T, R> {
    R handle(T data);
}
