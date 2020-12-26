package vds.infrastructure.ruleengine.state;

public enum State {
    UNINITIALIZED,
    INITIALIZED,
    INITIALIZED_ERROR,
    RUNNING,
    PAUSING,
    STOPPED;
}
