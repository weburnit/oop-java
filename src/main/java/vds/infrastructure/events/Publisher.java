package vds.infrastructure.events;

import vds.infrastructure.adapter.PubSubFactoryInterface;
import vds.spi.PubSub;

public class Publisher {
    PubSub producer;

    public Publisher(PubSubFactoryInterface factory, String topic) {
        this.producer = factory.createSubscriberWithTopic(topic);
    }

    public void sendMessage(Object o) {
        this.producer.send(o);
    }
}
