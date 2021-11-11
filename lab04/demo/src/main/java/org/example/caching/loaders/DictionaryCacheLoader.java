package org.example.caching.loaders;

import org.example.model.Dictionary;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class DictionaryCacheLoader {
    public static List<Dictionary> items = new ArrayList<>();
    public void load(){
        try (BufferedReader buf = new BufferedReader(new FileReader("dictionaries.csv"))) {
            String line;
            while ((line = buf.readLine()) != null) {
                String[] pola = line.split(",");
                items.add(new Dictionary(Integer.parseInt(pola[0]), Integer.parseInt(pola[1]), pola[2], pola[3], pola[4]));
            }
        }
        catch (IOException e) {
            System.out.println("nie znaleziono pliku");
            System.exit(1);
        }
    }
}
