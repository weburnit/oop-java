package vds.infrastructure.adapter;

public class SQLProducer implements ProducerStrategyInterface{

  @Override
  public void save(Object o) {
    System.out.println("Save to DB");
  }
}
