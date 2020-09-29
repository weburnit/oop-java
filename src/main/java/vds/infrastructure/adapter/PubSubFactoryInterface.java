package vds.infrastructure.adapter;

import vds.spi.PubSub;

public interface PubSubFactoryInterface {
    PubSub createSubscriberWithTopic(String topic);
}
