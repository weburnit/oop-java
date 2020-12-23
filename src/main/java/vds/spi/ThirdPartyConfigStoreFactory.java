package vds.spi;

import vds.domain.entity.thirdparty.ThirdPartyConfig;

@SuppressWarnings("java:S1452")
public interface ThirdPartyConfigStoreFactory {
    ConfigStore<? extends ThirdPartyConfig> create(String partner);
}
