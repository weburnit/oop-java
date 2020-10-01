package vds.infrastructure.events;

import vds.infrastructure.adapter.PubSubFactoryInterface;

class Publisher {
    PubSubFactoryInterface factory;

    public Publisher(PubSubFactoryInterface factory) {
        this.factory = factory;
    }

    public void Publish(Object o) {
        this.factory.createSubscriberWithTopic("my_topic").Publish(o);
    }

}

