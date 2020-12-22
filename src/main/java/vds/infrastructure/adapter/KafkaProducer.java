package vds.infrastructure.adapter;

public class KafkaProducer implements ProducerStrategyInterface{

  @Override
  public void save(Object o) {
    System.out.println("Save to Kafka");
  }
}
