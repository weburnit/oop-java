package vds.domain.policy.event;

import vds.domain.event.BaseEvent;
import vds.domain.policy.BasePolicy;

public abstract class BaseEventPolicy<T extends BaseEvent> extends BasePolicy<T> {
}
