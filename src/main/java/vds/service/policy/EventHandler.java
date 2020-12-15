package vds.service.policy;

import vds.exceptions.PolicyEventException;
import vds.service.events.EventPayload;

public interface EventHandler {

    void setNext(EventHandler next);

    void process(EventPayload event) throws PolicyEventException;

    void onError(EventPayload event) throws PolicyEventException;
}
