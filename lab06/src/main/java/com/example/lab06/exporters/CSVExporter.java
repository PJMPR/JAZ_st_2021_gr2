package com.example.lab06.exporters;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.example.lab06.credit.Credit;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter implements Exporter{

    public void createCSV(Credit credit) throws IOException, IllegalAccessException {

        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter("src/main/resources/generatedCSV.csv"))
                .withSeparator(';')
                .build()) {
            writer.writeAll(createSimpleData(credit));
        }
    }
}