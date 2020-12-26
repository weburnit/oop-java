package vds.commons.map;

import java.util.HashMap;
import java.util.Map;

public final class DoubleKeyMap<K1, K2, V> {
    private Map<K1, Map<K2, V>> internalMap = new HashMap<>();

    public void put(K1 k1, K2 k2, V value) {
        Map<K2, V> k2vMap = internalMap.get(k1);
        if (k2vMap == null) {
            Map<K2, V> newK2vMap = new HashMap<>();
            newK2vMap.put(k2, value);
            internalMap.put(k1, newK2vMap);
        } else {
            k2vMap.put(k2, value);
        }
    }

    public V get(K1 k1, K2 k2) {
        Map<K2, V> k2vMap = internalMap.get(k1);
        if (k2vMap == null) {
            return null;
        } else {
            return k2vMap.get(k2);
        }
    }
}
