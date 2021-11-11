package org.example.caching;

public class CacheItem {
    private String key;
    private Object value;

    CacheItem(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    String getKey() {
        return key;
    }

    Object getValue() {
        return value;
    }
}
