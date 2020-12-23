package vds.infrastructure.tranformer.config;

public class TikiConfigStorage implements ConfigStorage{

  @Override
  public void get() {
    System.out.println("Get Tiki config");
  }

  @Override
  public void save() {
    System.out.println("Save Tiki config");
  }
}
