package vds.infrastructure.adapter;

public class KafkaProducerFactory implements ProducerFactoryInterface{

    @Override
    public ProducerStrategyInterface createSQLProducer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ProducerStrategyInterface createPubsubProducer(String topic) {
        return new KafkaProducerStrategy(topic);
    }
    
}
