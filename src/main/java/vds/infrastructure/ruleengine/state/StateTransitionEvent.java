package vds.infrastructure.ruleengine.state;

public enum StateTransitionEvent {
    INITIALIZE_SUCCESS,
    ERROR_WHILE_INITIALIZE,
    RESET,
    ENGINE_START,
    ENGINE_PAUSE,
    ENGINE_RESUME,
    ENGINE_STOP
}
