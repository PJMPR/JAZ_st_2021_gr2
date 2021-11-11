package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.model.Dictionary;
import org.example.provider.DictionaryFileProvider;

import java.util.List;

public class DictionaryCacheLoader implements CacheLoader {
    private Cache cache = Cache.getInstance();

    public void load() {
        DictionaryFileProvider provider = new DictionaryFileProvider();
        List<Dictionary> items = provider.provide();
        String fileName = provider.fileName();

        for (Dictionary listOfItems : items) {
            cache.add(fileName, listOfItems);
        }
    }
}
