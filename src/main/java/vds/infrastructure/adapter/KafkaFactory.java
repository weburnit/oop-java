package vds.infrastructure.adapter;

import vds.spi.PubSub;

public class KafkaFactory implements PubSubFactoryInterface {
    @Override
    public PubSub createSubscriberWithTopic(String topic) {
        return new KafkaSubscriber();
    }
}
