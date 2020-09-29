package vds.infrastructure.events;

import vds.infrastructure.adapter.PubSubFactoryInterface;
import vds.spi.IPublisher;

class Publisher implements IPublisher {
    PubSubFactoryInterface factory;

    public Publisher(PubSubFactoryInterface factory) {
        this.factory = factory;
    }

    public void Publish(Object o) {
        this.factory.createSubscriberWithTopic("my_topic").Publish(o);
    }

}

