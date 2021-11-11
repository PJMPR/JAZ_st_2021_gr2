package org.example.caching;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Cache {

    private static final Cache cache = new Cache();
    private List<CacheElement> cacheElements = new ArrayList<>();

    public static Cache getInstance(){

        return cache;

    }


    public <T> void add(String key, T element){

        CacheElement cache = new CacheElement();
        cache.key = key;
        cache.item = element;
        cacheElements.add(cache);

    }

    public <T> T get(String key, Class<T> clazz){

        return (T) cacheElements.stream()
                .filter(element -> key.equals(element.key) && clazz.equals(element.item.getClass()))
                .findAny().get().item;

    }

    public Object get(String key){

        return cacheElements.stream()
                .filter(cacheItem -> key.equals(cacheItem.key))
                .map(cacheItem -> cacheItem.item)
                .collect(Collectors.toList());

    }
}
