package vds.infrastructure.repository;

import vds.domain.entity.thirdparty.TikiConfig;
import vds.spi.ConfigStore;

public class TikiConfigRepository implements ConfigStore<TikiConfig> {

    // Inject blahblah

    @Override
    public void save(TikiConfig config) {
        // save
    }

    @Override
    public void get(String partner) {
        // get
    }
}
