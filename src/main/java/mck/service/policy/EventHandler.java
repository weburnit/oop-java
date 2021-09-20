package mck.service.policy;

import mck.exceptions.PolicyEventException;
import mck.service.events.EventPayload;

public interface EventHandler {

    void setNext(EventHandler next);

    void process(EventPayload event) throws PolicyEventException;

    void onError(EventPayload event) throws PolicyEventException;
}
