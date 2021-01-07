package vds.api.cor.impl;

import vds.api.cor.AbstractRewardProcessor;
import vds.api.cor.AllocationEmitter;
import vds.api.sm.Reward;

public class FraudProcessor extends AbstractRewardProcessor {

    @Override
    public void process(Reward reward, AllocationEmitter emitter) {
        emitter.emit(reward);
    }

    @Override
    public void onError(Exception ex) {
        // TODO Auto-generated method stub

    }
    
}
