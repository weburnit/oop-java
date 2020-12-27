package vds.infrastructure.ruleengine.state.engine;

import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

public class EngineRunning implements EngineState {
    @Override
    public State state() {
        return State.RUNNING;
    }

    @Override
    public void registerPlugin(Plugin plugin) {
        throw new IllegalStateException("could not add plugin after engine start");
    }

    @Override
    public void deregisterPlugin(String pluginName) {
        throw new IllegalStateException("could not add plugin after engine start");
    }

}