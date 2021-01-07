package vds.api.cor;

import lombok.Getter;

public abstract class AbstractRewardProcessor implements RewardAllocationProcessor {
    @Getter
    private RewardAllocationProcessor next;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void setNext(RewardAllocationProcessor next) {
        this.next = next;
    }
}
