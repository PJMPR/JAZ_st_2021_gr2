package org.example.caching;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static final Cache cacheInstance = new Cache();
    private List<CacheItem> cacheItems = new ArrayList<>();

    public static Cache getInstance(){
        return cacheInstance;
    }


    public <T> void add(String key, T item){
        cacheItems.add(new CacheItem(key, (String) item));
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) cacheItems.stream()
                .filter(item -> key.equals(item.key) && clazz.equals(item.item.getClass()))
                .findAny().get().item;
    }

    public Object get(String key){
        return cacheItems.stream()
                .filter(cache -> key.equals(cache.key))
                .findAny().get().item;
    }
}
