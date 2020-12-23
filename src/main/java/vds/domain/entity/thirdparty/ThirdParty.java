package vds.domain.entity.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ThirdParty {
    TIKI("tiki"),
    LAZADA("lazada");

    private final String value;

    private static final Map<String, ThirdParty> map;
    static {
        Map<String, ThirdParty> mx = new HashMap<>();
        for (ThirdParty v : ThirdParty.values()) {
            mx.put(v.getValue(), v);
        }
        map = Collections.unmodifiableMap(mx);
    }

    public static ThirdParty fromStr(String v) {
        return map.get(v);
    }
}
