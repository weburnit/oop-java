package vds.api.interfaces;

import vds.api.TriggerEvent;

public interface PolicyCondition {
    String getId();
    boolean qualifiedEvent(TriggerEvent triggerEvent);
}
