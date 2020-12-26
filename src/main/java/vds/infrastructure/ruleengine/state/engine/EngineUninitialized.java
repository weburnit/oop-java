package vds.infrastructure.ruleengine.state.engine;

import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

public class EngineUninitialized implements EngineState {
    @Override
    public State state() {
        return State.UNINITIALIZED;
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        throw new IllegalStateException("engine uninitialized");
    }

    @Override
    public void deregisterPlugin(String pluginName) {
        throw new IllegalStateException("engine uninitialized");
    }

}
