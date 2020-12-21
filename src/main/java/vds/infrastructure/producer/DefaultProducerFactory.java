package vds.infrastructure.producer;

import vds.service.ByteSerializer;

import java.io.Serializable;

public class DefaultProducerFactory implements ProducerFactory {

    // Inject blahblah

    @Override
    public <T extends Serializable> KafkaProducer<T> kafkaProducer(String topic) {
        return new KafkaProducer<>(
                topic,
                null, // FIXME mockup value (will not works)
                new ByteSerializer<T>()
        );
    }

    @Override
    public <T extends Serializable> SQLProducer<T> sqlProducer(String topic) {
        return new SQLProducer<>(
                topic,
                null, // FIXME mockup value (will not works)
                new ByteSerializer<T>()
        );
    }
}
