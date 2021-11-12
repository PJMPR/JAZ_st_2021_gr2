package org.example.caching.loaders;

import org.example.caching.Cache;
import org.example.caching.providers.ItemsProvider;
import org.example.model.Dictionary;

import java.util.List;

public class DictionaryCacheLoader implements CacheLoader {
    public final Cache cache = Cache.getInstance();

    public void load() {
        ItemsProvider provider = new ItemsProvider();
        List<org.example.model.Dictionary> records = provider.providedList();
        String file = provider.file();
        for (Dictionary record :
                records) {
            cache.add(file, record);
        }
    }
}