package org.example.caching;

import org.example.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    List<CacheItem> cacheItemList = new ArrayList<>();


    public static Cache getInstance(){
        return new Cache();
    }


    public <T> void add(String key, T item){

    }

    public <T> T get(String key, Class<T> clazz){

        return (T) clazz.cast(new Object());
    }

    public Object get(String key){
        return null;
    }
}
