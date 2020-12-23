package vds.infrastructure.adapter;

public interface ProducerStrategyInterface {
    Error send(Object object);
}
