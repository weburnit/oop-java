package vds.api.sm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;

public abstract class StateMachine<S extends SMEntity> {

    protected abstract void pre(S s);

    protected abstract void post(S s);

    @Getter
    private Map<State, List<State>> config;

    @Getter
    private Map<State, OnApplyState<S>> executors;

    protected StateMachine() {
        State openState = new State("OPEN", "0");
        State resolvedState = new State("RESOLVED", "1");
        State reopenedState = new State("REOPENED", "2");
        State inprogressState = new State("INPROGRESS", "3");
        State closedState = new State("CLOSED", "4");

        List<State> states = new ArrayList<>();
        states.add(inprogressState);
        states.add(resolvedState);
        states.add(closedState);

        config = new HashMap<>();
        config.put(openState, states);

        executors = new HashMap<>();
        executors.put(resolvedState, new OnResolveState<>());
    }

    public void apply(State state, S s) {
        // TODO: do pre something

        List<State> mappingStates = new ArrayList<>();
        for (Map.Entry<State, List<State>> kv : config.entrySet()) {
            if (kv.getKey().getName().equals(s.getState().getName())) {
                mappingStates = kv.getValue();
            }
        }

        for (Map.Entry<State, OnApplyState<S>> executor : executors.entrySet()) {
            for (State tmpState : mappingStates) {
                if (tmpState.getName().equals(executor.getKey().getName())) {
                    executor.getValue().apply(s);
                    break;
                }
            }
        }

        // TODO: do post something
    }

    public void onEvent(S s) {
        // save complete state and call me
    }   

}
