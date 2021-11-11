package org.example.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

    private static volatile Cache instance = null;
    List<CacheItems> items = new ArrayList<>();

    public static Cache getInstance(){
        if(instance == null){
            synchronized(Cache.class){
                if(instance == null){
                    instance = new Cache();
                }
            }
        }
        return instance;
    }



    public <T> void add(String key, T item){
        items.add(new CacheItems(item, key));
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) clazz.cast(new Object());
    }

    public Object get(String key){
        return items.stream().filter(item -> item.getKey().equals(key)).map(CacheItems::getValue).collect(Collectors.toList());
    }
}
