package vds.infrastructure.ruleengine;

import vds.infrastructure.ruleengine.plugin.Plugin;

public interface EnginePluginSocket {
    void registerPlugin(Plugin plugin);
    void deregisterPlugin(String identifier);
}
