package vds.api.sm;

public class OnResolveState<S extends SMEntity> implements OnApplyState<S>{

    @Override
    public void apply(S s) {
        s.setState(new State("RESOLVED", "1"));
    }
}
