package org.example.caching;

import org.example.model.Dictionary;
import org.example.caching.CacheComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {
    //unchangeable "final" variable cache
    private static final Cache cache = new Cache();
    //list of cache components
    private List<CacheComponent> cacheComponents = new ArrayList<>();

    public static Cache getInstance(){
        return cache;
    }


    public <T> void add(String key, T item){

        CacheComponent cache = new CacheComponent();
        cache.Key = key;
        cache.item = item;
        cacheComponents.add(cache);

    }

    public <T> T get(String key, Class<T> clazz){

        return (T) cacheComponents.stream()
                .filter(element -> key.equals(element.Key) && clazz.equals(element.item.getClass()))
                .findAny().get().item;
    }

    public Object get(String key){

        return cacheComponents.stream()
                .filter(cacheItem -> key.equals(cacheItem.Key))
                .map(cacheItem -> cacheItem.item)
                .collect(Collectors.toList());

    }
}
