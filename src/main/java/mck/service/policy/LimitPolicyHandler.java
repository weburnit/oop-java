package mck.service.policy;

import mck.exceptions.PolicyEventException;
import mck.service.events.EventPayload;

public class LimitPolicyHandler extends AbstractEventHandler {

    @Override
    public void process(EventPayload event) throws PolicyEventException {

    }

    @Override
    public void onError(EventPayload event) throws PolicyEventException {

    }
}
