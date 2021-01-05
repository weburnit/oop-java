package vds.api.sm;

import vds.api.sm.State;

public interface SMEntity {
    String getId();
    State getState();
    void setState(State state);
}
