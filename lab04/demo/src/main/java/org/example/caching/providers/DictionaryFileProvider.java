package org.example.caching.providers;

import org.example.caching.readers.FileReader;
import org.example.model.Dictionary;
import java.util.List;
import java.util.stream.Collectors;


public class DictionaryFileProvider implements DictionaryProvider{

    String pathToFile, delimeter;

    public DictionaryFileProvider(String pathToFile, String delimeter) {
        this.pathToFile = pathToFile;
        this.delimeter = delimeter;
    }

    @Override
    public List<Dictionary> provide() {
        return new FileReader(pathToFile).splitingToColumns(delimeter).stream()
                .map(data -> new Dictionary(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        data[2],
                        data[3],
                        data[4]))
                .collect(Collectors.toList());
    }
}
