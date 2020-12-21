package vds.infrastructure.producer;

import vds.spi.Producer;

import java.io.Serializable;

public interface ProducerFactory {
    <T extends Serializable> Producer<T> kafkaProducer(String topic);
    <T extends Serializable> Producer<T> sqlProducer(String topic);
}
