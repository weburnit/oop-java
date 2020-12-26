package vds.infrastructure.ruleengine.state.engine;

import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

public class EngineStopped implements EngineState {
    @Override
    public State state() {
        return State.STOPPED;
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        throw new IllegalStateException("engine is stopped");
    }

    @Override
    public void deregisterPlugin(String pluginName) {
        throw new IllegalStateException("engine is stopped");
    }

}
