package org.example.caching.readers;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private Scanner sc;

    public FileReader(String pathToFile) {
        try {
            sc = new Scanner(Paths.get(pathToFile).toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<String[]> splitingToColumns(String delimeter){
        List<String[]> columns = new ArrayList<>();
        while (sc.hasNext()){
            columns
                    .add(sc.nextLine()
                    .split(delimeter));
        }
        return columns;
    }
}
