package vds.infrastructure.tranformer.config;

public class LazadaConfigStorage implements ConfigStorage{

  @Override
  public void get() {
    System.out.println("Get Lazada config");
  }

  @Override
  public void save() {
    System.out.println("Save Lazada config");
  }
}
