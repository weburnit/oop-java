package vds.infrastructure.ruleengine.state.engine;

import vds.infrastructure.ruleengine.plugin.Plugin;
import vds.infrastructure.ruleengine.state.State;

public interface EngineState {
    State state();

    void registerPlugin(Plugin plugin);

    void deregisterPlugin(String pluginName);
}
