package org.example.caching;

import org.example.SafeCaster;
import java.util.ArrayList;
import java.util.List;

public class Cache {
    private static final Cache instance = new Cache();
    List<CacheItem> cacheItems = new ArrayList<>();

    public static Cache getInstance(){
        return instance;
    }


    public <T> void add(String key, T item){
        cacheItems.add(new CacheItem(key,item));
    }

    public <T> T get(String key, Class<T> clazz){

        return SafeCaster.cast(get(key), clazz);
    }

    public Object get(String key){
        return cacheItems.stream()
                .filter(cacheItem -> cacheItem.getDataSet().equals(key))
                .map(CacheItem::getData)
                .findAny()
                .orElse(null);
    }
}
