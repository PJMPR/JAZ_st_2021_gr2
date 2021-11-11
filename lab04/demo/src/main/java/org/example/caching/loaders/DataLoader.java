package org.example.caching.loaders;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.example.model.Dictionary;

public class DataLoader implements DataDelivery{
    @Override
    public List<Dictionary> dataLoad() {
        List<Dictionary> dataList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader("..\\dictionaries.csv"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                var test = Arrays.asList(line.split(","));
                dataList.add(new Dictionary(Integer.parseInt(test.get(0)),Integer.parseInt(test.get(1)), test.get(2), test.get(3), test.get(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}