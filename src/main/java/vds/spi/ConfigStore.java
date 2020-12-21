package vds.spi;

import vds.domain.entity.thirdparty.ThirdPartyConfig;

public interface ConfigStore<T extends ThirdPartyConfig> {
    void save(T config);
    void get(String partner);
}
