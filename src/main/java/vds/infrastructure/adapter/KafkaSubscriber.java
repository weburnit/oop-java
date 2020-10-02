package vds.infrastructure.adapter;

import org.apache.camel.impl.DefaultCamelContext;
import vds.spi.PubSub;

public class KafkaSubscriber implements PubSub {
    public KafkaSubscriber() {
        DefaultCamelContext camelContext = new DefaultCamelContext();
    }

    @Override
    public void send(Object o) {
    }
}
