package vds.domain.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEvent {
    private final long ts; // timestamp
}
