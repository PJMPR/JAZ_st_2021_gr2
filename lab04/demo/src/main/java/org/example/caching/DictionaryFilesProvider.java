package org.example.caching;

import org.example.model.Dictionary;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DictionaryFilesProvider implements DictionaryProvider{

    @Override
    public List<Dictionary> providedList() {

        String file = "dictionaries.csv";
        return readItems(file);

    }

    @Override
    public String file() {

        File file = new File("dictionaries.csv");
        return file.getName().replaceFirst("[.][^.]+$", "");

    }

    private static Dictionary makeItem(String[] param) {

        int id = Integer.parseInt(param[0]);
        int intKey = Integer.parseInt(param[1]);
        String stringKey = param[2];
        String value = param[3];
        String dictionaryName = param[4];
        return new Dictionary(id, intKey, stringKey, value, dictionaryName);

    }

    private static List<Dictionary> readItems(String file) {

        List<Dictionary> dictionaries = new ArrayList<>();
        Path path = Paths.get(file);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while (line != null) {
                String[] params = line.split(",");
                Dictionary item = makeItem(params);
                dictionaries.add(item);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionaries;

    }

}
