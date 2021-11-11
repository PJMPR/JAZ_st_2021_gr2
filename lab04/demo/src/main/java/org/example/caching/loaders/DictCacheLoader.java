package org.example.caching.loaders;

import org.example.caching.loaders.CacheLoader;
import org.example.caching.DictFromFile;
import org.example.model.Dictionary;
import org.example.caching.Cache;

import java.util.List;

public class DictCacheLoader implements CacheLoader {

    public final Cache cache = Cache.getInstance();
    public void load(){

        DictFromFile dictFromFile = new DictFromFile();
        List<Dictionary> records = dictFromFile.newList();
        String file = dictFromFile.file();
        for (Dictionary record: records) {
            cache.add(file, record);
        }

    }
}
