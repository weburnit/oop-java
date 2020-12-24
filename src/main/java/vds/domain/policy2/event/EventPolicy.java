package vds.domain.policy2.event;

import vds.domain.event.Event;
import vds.domain.policy2.Policy;

public abstract class EventPolicy<T extends Event, R> extends Policy<T, R> {
}
