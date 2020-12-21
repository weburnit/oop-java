package vds.domain.entity.thirdparty;

import lombok.Getter;

@Getter
public class TikiConfig extends ThirdPartyConfig {
    private final boolean isA;
    private final boolean isB;
    private final String gg;

    public TikiConfig(String partner, boolean isA, boolean isB, String gg) {
        super(partner);
        this.isA = isA;
        this.isB = isB;
        this.gg = gg;
    }
}
