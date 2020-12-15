package vds.service.policy;

import vds.exceptions.PolicyEventException;
import vds.service.events.EventPayload;

public class LimitPolicyHandler extends AbstractEventHandler {

    @Override
    public void process(EventPayload event) throws PolicyEventException {

    }

    @Override
    public void onError(EventPayload event) throws PolicyEventException {

    }
}
