package vds.service;

import vds.domain.entity.thirdparty.ThirdParty;
import vds.domain.entity.thirdparty.ThirdPartyConfig;
import vds.infrastructure.repository.LazadaConfigRepository;
import vds.infrastructure.repository.TikiConfigRepository;
import vds.spi.ConfigStore;
import vds.spi.ThirdPartyConfigStoreFactory;

public class DefaultThirdPartyConfigStoreFactory implements ThirdPartyConfigStoreFactory {
    @Override
    public ConfigStore<? extends ThirdPartyConfig> create(String partner) {
        ThirdParty pt = ThirdParty.fromStr(partner);
        switch (pt) {
            case TIKI:
                return new TikiConfigRepository();
            case LAZADA:
                return new LazadaConfigRepository();
            default:
                throw new IllegalStateException("Party not existed");
        }
    }
}
