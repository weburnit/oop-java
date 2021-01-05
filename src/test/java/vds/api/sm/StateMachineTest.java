package vds.api.sm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import vds.api.sm.State;

public class StateMachineTest {
    public class TestSMEntity implements SMEntity {
        private State state;
        @Override
        public String getId() {
            return null;
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
    
    @Test
    public void apply_open2resolved_test() {
        State openState = new State("OPEN", "0");
        State resolvedState = new State("RESOLVED", "1");
        StateMachine<TestSMEntity> sm = RewardSM.getInstance();
        TestSMEntity testSMEntity = new TestSMEntity();
        testSMEntity.setState(openState);
        sm.apply(resolvedState, testSMEntity);
        assertEquals(resolvedState.getName(), testSMEntity.getState().getName());
    }
}
