package org.example.caching;

import org.example.caching.loaders.DictionaryCacheLoader;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    public static Cache getInstance(){
        return new Cache();
    }

    public <T> void add(String key, T item){
        Map<String,T> caches = new HashMap<>();
        if (! caches.containsKey(key)){
            caches.put(key, item);}
    }

    public <T> T get(String key, Class<T> clazz){
        new DictionaryCacheLoader().load();
        DictionaryCacheLoader.items.stream()
                .filter(x->x.getStringKey().equals(key));
        if (DictionaryCacheLoader.items.isEmpty() == false) {
            return (T) clazz.cast(new Object());
        }
        return null;
    }

    public Object get(String key) {
        new DictionaryCacheLoader().load();
        DictionaryCacheLoader.items.stream()
                .filter(x->x.getStringKey().equals(key));
        if (DictionaryCacheLoader.items.isEmpty() == false){
            return DictionaryCacheLoader.items;
        }
        return null;
    }
}
