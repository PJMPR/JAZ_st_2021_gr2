package org.example.caching.loaders;

import org.example.caching.Cache;

import java.util.List;
import java.util.stream.Collectors;

public class DictionaryCacheLoader {
    List<DataDelivery> data = List.of(new DataLoader());

    public void load(){
        data.stream().flatMap(dataProvider -> dataProvider.dataLoad().stream()).collect(Collectors.toList()).forEach(dictionary -> Cache.getInstance().add("dictionaries", dictionary));
    }
}
