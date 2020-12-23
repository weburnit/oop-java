package vds.domain.policy;

public abstract class Policy<T, R> {
    public abstract R handle(T data);
}
