package vds.infrastructure.repository;

import vds.domain.entity.thirdparty.LazadaConfig;
import vds.spi.ConfigStore;

public class LazadaConfigRepository implements ConfigStore<LazadaConfig> {

    // Inject blahblah

    @Override
    public void save(LazadaConfig config) {
        // save
    }

    @Override
    public void get(String partner) {
        // get
    }
}
