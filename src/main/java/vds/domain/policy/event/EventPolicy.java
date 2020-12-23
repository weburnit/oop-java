package vds.domain.policy.event;

import vds.domain.event.Event;
import vds.domain.policy.Policy;

public abstract class EventPolicy<T extends Event, R> extends Policy<T, R> {
}
