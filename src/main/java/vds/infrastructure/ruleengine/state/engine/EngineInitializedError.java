package vds.infrastructure.ruleengine.state.engine;

import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

public class EngineInitializedError implements EngineState {
    @Override
    public State state() {
        return State.INITIALIZED_ERROR;
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        throw new IllegalStateException("engine initialized with error, unable to do anything");
    }

    @Override
    public void deregisterPlugin(String pluginName) {
        throw new IllegalStateException("engine initialized with error, unable to do anything");
    }

}
