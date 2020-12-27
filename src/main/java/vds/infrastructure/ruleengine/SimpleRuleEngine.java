package vds.infrastructure.ruleengine;

import vds.commons.fsm.FSM;
import vds.commons.map.DoubleKeyMap;
import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;
import vds.infrastructure.ruleengine.state.StateTransitionEvent;
import vds.infrastructure.ruleengine.state.engine.*;

import java.util.HashMap;
import java.util.Map;

import static vds.infrastructure.ruleengine.state.State.*;
import static vds.infrastructure.ruleengine.state.StateTransitionEvent.*;

public class SimpleRuleEngine implements FSM<State, StateTransitionEvent>, Engine, EnginePluginSocket {
    private static final DoubleKeyMap<State, StateTransitionEvent, State> transitionTable; // transitionTable
    static {
        transitionTable = new DoubleKeyMap<>();
        // initialize
        transitionTable.put(UNINITIALIZED,       INITIALIZE_SUCCESS,         INITIALIZED);
        transitionTable.put(UNINITIALIZED,       ERROR_WHILE_INITIALIZE,     INITIALIZED_ERROR);
        // running-pause-stop
        transitionTable.put(INITIALIZED,         ENGINE_START,               RUNNING);
        transitionTable.put(INITIALIZED,         ENGINE_STOP,                STOPPED);
        transitionTable.put(RUNNING,             ENGINE_STOP,                STOPPED);
        transitionTable.put(PAUSING,             ENGINE_STOP,                STOPPED);
        // running-pause-unpause
        transitionTable.put(RUNNING,             ENGINE_PAUSE,               PAUSING);
        transitionTable.put(PAUSING,             ENGINE_RESUME,              RUNNING);
        // reset
        transitionTable.put(INITIALIZED_ERROR,   RESET,                      UNINITIALIZED);
        transitionTable.put(INITIALIZED,         RESET,                      UNINITIALIZED);
        transitionTable.put(STOPPED,             RESET,                      UNINITIALIZED);
    }

    private Map<String, Plugin> plugins;
    private EngineState engineState = new EngineUninitialized();

    @Override
    public State state() {
        return engineState.state();
    }

    @Override
    public void transition(StateTransitionEvent event) {
        State currentState = state();
        State newState = transitionTable.get(currentState, event);
        if (newState == null) {
            // state not changed
            return;
        }
        preTransition(newState);
        doTransition(newState);
        postTransition(newState);
    }

    @SuppressWarnings({"java:S131", "java:S1301"})
    @Override
    public void preTransition(State state) {
        switch (state) {
            case UNINITIALIZED:
                plugins = null;
        }
    }

    @SuppressWarnings("java:S131")
    @Override
    public void doTransition(State state) {
        for (Map.Entry<String, Plugin> entry : plugins.entrySet()) {
            entry.getValue().onEvent(state); // notify new state to all plugins
        }
        switch (state) {
            case UNINITIALIZED:
                engineState = new EngineUninitialized();
                break;
            case INITIALIZED:
                engineState = new EngineInitialized(plugins);
                break;
            case INITIALIZED_ERROR:
                engineState = new EngineInitializedError();
                break;
            case RUNNING:
                engineState = new EngineRunning();
                break;
            case PAUSING:
                engineState = new EnginePausing();
                break;
            case STOPPED:
                engineState = new EngineStopped();
                break;
        }
    }

    //------------------------------------------------------------------------------------------------

    public void initialize() {
        try {
            plugins = new HashMap<>();
            // 1 + 1 = 2
            transition(INITIALIZE_SUCCESS);
        } catch (Throwable throwable) {
            transition(ERROR_WHILE_INITIALIZE);
        }
    }

    public void reset() {
        transition(RESET);
    }

    public void start() {
        transition(ENGINE_START);
    }

    public void pause() {
        transition(ENGINE_PAUSE);
    }

    public void resume() {
        transition(ENGINE_RESUME);
    }

    public void stop() {
        transition(ENGINE_STOP);
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        this.engineState.registerPlugin(plugin);
    }

    @Override
    public void deregisterPlugin(String identifier) {
        this.engineState.deregisterPlugin(identifier);
    }
}
