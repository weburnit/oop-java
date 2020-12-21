package vds.service;

import vds.domain.entity.thirdparty.ThirdPartyConfig;
import vds.infrastructure.repository.LazadaConfigRepository;
import vds.infrastructure.repository.TikiConfigRepository;
import vds.spi.ConfigStore;
import vds.spi.ThirdPartyConfigStoreFactory;

public class DefaultThirdPartyConfigStoreFactory implements ThirdPartyConfigStoreFactory {
    @Override
    public ConfigStore<? extends ThirdPartyConfig> tikiConfig() {
        return new TikiConfigRepository();
    }

    @Override
    public ConfigStore<? extends ThirdPartyConfig> lazadaConfig() {
        return new LazadaConfigRepository();
    }
}
