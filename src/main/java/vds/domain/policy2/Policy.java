package vds.domain.policy2;

public abstract class Policy<T, R> {
    public abstract R handle(T data);
}
