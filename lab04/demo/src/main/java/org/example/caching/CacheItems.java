package org.example.caching;

public class CacheItems {
    Object value;
    String key;

    private Cache cache;
    {
        cache = new Cache();
    }

    public CacheItems(Object value, String key){
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }


    public String getKey() {
        return key;
    }
}
