package mck.infrastructure.adapter;

public interface PubSubFactoryInterface {
    PubSub createSubscriberWithTopic(String topic);
}
