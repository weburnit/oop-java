package vds.commons.observer;

public interface Listener<T> {
    void onEvent(T event);
}
