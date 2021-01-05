package vds.api.sm;

public class RewardSM<S extends SMEntity> extends StateMachine<S> {
    private RewardSM() {
        super();
    }
    
    private static RewardSM instance = new RewardSM();
    
    public static RewardSM getInstance() {
        return instance;    
    }

    @Override
    protected void pre(S s) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void post(S s) {
        // TODO Auto-generated method stub

    }
}
