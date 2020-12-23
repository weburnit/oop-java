package vds.domain.entity.thirdparty;

import lombok.Getter;

@Getter
public class TikiConfig extends ThirdPartyConfig {
    private final boolean isA;
    private final boolean isB;
    private final String gg;

    public TikiConfig(String generalConfig0, Integer generalConfig1, Double generalConfig2, boolean isA, boolean isB, String gg) {
        super(generalConfig0, generalConfig1, generalConfig2);
        this.isA = isA;
        this.isB = isB;
        this.gg = gg;
    }
}
