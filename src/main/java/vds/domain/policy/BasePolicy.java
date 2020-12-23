package vds.domain.policy;

public abstract class BasePolicy<T> {
    public abstract void handle(T data);
}
