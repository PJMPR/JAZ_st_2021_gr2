package org.example.caching;

import org.example.model.Dictionary;
import java.util.List;

public interface DictionaryProvider {

    List<Dictionary> providedList();
    public String file();

}
