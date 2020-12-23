package vds.infrastructure.adapter;

public class SqlProducerFactory implements ProducerFactoryInterface{

    @Override
    public ProducerStrategyInterface createSQLProducer() {
        return new SqlProducerStrategy();
    }

    @Override
    public ProducerStrategyInterface createPubsubProducer(String topic) {
        throw new UnsupportedOperationException();
    }
    
}
