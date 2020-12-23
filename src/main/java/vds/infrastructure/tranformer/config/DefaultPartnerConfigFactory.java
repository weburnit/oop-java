package vds.infrastructure.tranformer.config;

public class DefaultPartnerConfigFactory implements PartnerConfigFactory{

  @Override
  public ConfigStorage getConfigStorage(String partnerName) {
    switch (partnerName) {
      case "TIKI":
        return new TikiConfigStorage();
      case "LAZADA":
        return new LazadaConfigStorage();
      default:
        throw new RuntimeException("Not Found");
    }
  }
}
