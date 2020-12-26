package vds.infrastructure.ruleengine.plugin;

import vds.commons.observer.Listener;
import vds.infrastructure.ruleengine.state.State;

public interface Plugin extends Listener<State> {
    String name();
}
