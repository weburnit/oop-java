package vds.api.cor;

import vds.api.sm.Reward;

public interface RewardAllocationProcessor {
    void process(Reward reward, AllocationEmitter emitter);

    void onError(Exception ex);

    boolean hasNext();

    void setNext(RewardAllocationProcessor next);
}
