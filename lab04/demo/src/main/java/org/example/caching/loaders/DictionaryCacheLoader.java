
package org.example.caching.loaders;

import org.example.caching.*;
import org.example.model.*;
import org.example.provider.*;

import java.util.List;

public class DictionaryCacheLoader implements CacheLoader{

    public static Cache cache=Cache.getInstance();

    public DictionaryProvider dictionaryProvider;

    public void load() {
        DictionaryFileProvider provider = new DictionaryFileProvider();
        List<Dictionary> listOfItems = provider.provide();
        String fileName = provider.fileName();

        System.out.println("");

        for (Dictionary listOfItem : listOfItems) {
            cache.add(fileName, listOfItem);
        }
    }
}