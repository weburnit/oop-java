package vds.infrastructure.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import vds.spi.Producer;
import vds.spi.Serializer;

import java.io.IOException;
import java.io.Serializable;

@AllArgsConstructor
public class KafkaProducer<T extends Serializable> implements Producer<T> {
    private final String topic;
    private final KafkaTemplate<byte[], byte[]> kafkaTemplate;
    private final Serializer<T, byte[]> serializer;

    @Override
    public void send(T data) throws IOException {
        final byte[] dataBytes = serializer.serialize(data);
        kafkaTemplate.send(topic, dataBytes);
    }
}
