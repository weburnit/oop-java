package vds.infrastructure.ruleengine.state.engine;

import lombok.AllArgsConstructor;
import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

import java.util.Map;

@AllArgsConstructor
public class EngineInitialized implements EngineState {
    private final Map<String, Plugin> plugins;

    @Override
    public State state() {
        return State.INITIALIZED;
    }

    @Override
    public void registerPlugin(Plugin plugin) {

    }

    @Override
    public void deregisterPlugin(String pluginName) {

    }

}
