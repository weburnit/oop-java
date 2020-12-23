package vds.infrastructure.adapter;

import lombok.Getter;
import lombok.Setter;

public class KafkaProducerStrategy implements ProducerStrategyInterface {

    @Getter
    @Setter
    private String topic;

    public KafkaProducerStrategy(String topic) {
        this.topic = topic;
    }

    @Override
    public Error send(Object object) {
        return null;
    }

}
