package vds.api.cor.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vds.api.cor.AllocationEmitter.EventEmitter;

@Getter
@Setter
@AllArgsConstructor
public class KafkaEventEmitter implements EventEmitter{
    private String address;
    private Object value;
}
