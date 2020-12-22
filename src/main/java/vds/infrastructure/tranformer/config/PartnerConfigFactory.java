package vds.infrastructure.tranformer.config;

public interface PartnerConfigFactory {
  ConfigStorage getConfigStorage(String partnerName);
}
