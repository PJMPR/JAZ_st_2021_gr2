package org.example.provider;

import org.example.model.Dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DictionaryFileProvider implements DictionaryProvider {
    @Override
    public List<Dictionary> provide() {
        String filepath = "src/main/java/org/example/dictionaries/dictionaries.csv";
        List<Dictionary> dictionaries = new ArrayList<>();
        Path path = Paths.get(filepath);

        try  {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                int id = Integer.parseInt(attributes[0]);
                int intKey = Integer.parseInt(attributes[1]);

                Dictionary item = new Dictionary(id, intKey, attributes[2], attributes[3], attributes[4]);
                dictionaries.add(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dictionaries;
    }

    public String fileName() {
        File f = new File("/dictionaries.csv");
        return f.getName().replaceFirst("[.][^.]+$", "");
    }
}
