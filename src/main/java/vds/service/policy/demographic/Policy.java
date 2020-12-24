package vds.service.policy.demographic;

import vds.api.TriggerEvent;

public interface Policy {
    void handleEvent(TriggerEvent triggerEvent);
}
