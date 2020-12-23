package vds.infrastructure.adapter;

public class ProducerFactory implements ProducerFactoryInterface{

  @Override
  public ProducerStrategyInterface createSQLProducer() {
    return new SQLProducer();
  }

  @Override
  public ProducerStrategyInterface createPubsubProducer(String topic) {
    return new KafkaProducer();
  }
}
