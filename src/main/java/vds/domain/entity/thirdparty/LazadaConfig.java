package vds.domain.entity.thirdparty;

import lombok.Getter;

@Getter
public class LazadaConfig extends ThirdPartyConfig {
    private final boolean laz1;
    private final boolean laz2;
    private final String laz3;
    private final int laz4;

    public LazadaConfig(String generalConfig0, Integer generalConfig1, Double generalConfig2, boolean laz1, boolean laz2, String laz3, int laz4) {
        super(generalConfig0, generalConfig1, generalConfig2);
        this.laz1 = laz1;
        this.laz2 = laz2;
        this.laz3 = laz3;
        this.laz4 = laz4;
    }
}
