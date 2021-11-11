package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DictionaryFileProvider implements DictionaryProvider {
    @Override
    public List<Dictionary> provide() {
        return csvReader();
    }

    private static List<Dictionary> csvReader() {
        List<Dictionary> items = new ArrayList<>();
        Path pathToFile = Paths.get("org/example/dictionaries.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {

                String[] attributes = line.split(",");

                Dictionary value = createDictionary(attributes);

                items.add(value);

                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return items;
    }

    private static Dictionary createDictionary(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        int intKey = Integer.parseInt(metadata[1]);
        String stringKey = metadata[2];
        String value = metadata[3];
        String dictionaryName = metadata[5];

        return new Dictionary(id, intKey, stringKey, value, dictionaryName);
    }


}


