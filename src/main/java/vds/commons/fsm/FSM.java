package vds.commons.fsm;

public interface FSM<T, E> {
    T state();

    void transition(E event);

    default void preTransition(T state) {
        // do nothing
    }

    default void doTransition(T state) {
        // do nothing
    }

    default void postTransition(T state) {
        // do nothing
    }
}
