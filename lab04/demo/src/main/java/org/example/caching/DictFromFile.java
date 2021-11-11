package org.example.caching;

import org.example.caching.DictSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.example.model.Dictionary;

public class DictFromFile implements DictSource {

    private static Dictionary createItem(String[] parameter) {
        int id = Integer.parseInt(parameter[0]);
        int intKey = Integer.parseInt(parameter[1]);
        String stringKey = parameter[2];
        String value = parameter[3];
        String dictionaryName = parameter[4];
        return new Dictionary(id, intKey, stringKey, value, dictionaryName);
    }

    private static List<Dictionary> readElements(String file) {
        //List of Dictionaries (holder)
        List<Dictionary> dictionariesList = new ArrayList<>();
        //absolute path to file
        Path path = Paths.get(file);
        //try and check for errors and wrap them
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            //read line by line
            String line = bufferedReader.readLine();
            while(line != null) {
                String[] params = line.split(",");
                Dictionary item = createItem(params);
                dictionariesList.add(item);
                line = bufferedReader.readLine();
            }
        } catch(IOException e) {
            //print where
            e.printStackTrace();
        }
        //return taken from file list
        return dictionariesList;
    }

    @Override
    public List<Dictionary> newList(){

        String file = "dictionaries.csv";
        return readElements(file);
    }

    @Override
    public String file() {

        File file = new File("dictionaries.csv");
        return file.getName().replaceFirst("[.][^.]+$", "");
    }
}
