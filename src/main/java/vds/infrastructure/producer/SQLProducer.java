package vds.infrastructure.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import vds.spi.Producer;
import vds.spi.Serializer;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.io.Serializable;

@AllArgsConstructor
public class SQLProducer<T extends Serializable> implements Producer<T> {
    private final String topic;
    private final EntityManager entityManager; // this entity manager must add Event class to its entity classes
    private final Serializer<T, byte[]> serializer;

    @Getter
    @Builder
    @AllArgsConstructor
    public static final class Event {
        @Id
        private final String topic;
        @Id
        @GeneratedValue
        private final long offset; // auto increment value
        private final byte[] data;
    }

    @AllArgsConstructor
    public static final class EventId {
        private final String topic;
        private final long offset;
    }

    @Override
    public void send(T data) throws IOException {
        final byte[] dataBytes = serializer.serialize(data);
        entityManager.persist(
                Event.builder()
                        .topic(topic)
                        .data(dataBytes)
                        .build()
        );
    }
}
