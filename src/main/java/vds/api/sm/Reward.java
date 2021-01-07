package vds.api.sm;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import vds.api.cor.AllocationEmitter.EventEmitter;

@NoArgsConstructor
@AllArgsConstructor
public class Reward implements SMEntity, EventEmitter {
    private String id;
    private State state;

    private String getStateString() {
        return state.getName();
    }
    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public State getState() {
        return this.state;
    }
    @Override
    public void setState(State state) {
        this.state = state;
    }
}
