package org.example.errors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.*;

public class FileNotFound implements ErrorHandler {

    private Logger logger = LogManager.getLogger(getClass().getSimpleName());

    @Override
    public String errorMessage() {
        return "File not found!";
    }

    @Override
    public boolean tryDoIt() {
        File file = new File("someRandomName.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bfReader = new BufferedReader(fileReader);
            bfReader.lines().forEach(System.out::println);
            return true;
        } catch (FileNotFoundException e) {

            return false;
        }
    }


    @Override
    public void fix() {
        if (!tryDoIt()) {
            System.out.println(errorMessage());
            for (int i = 0; i < 5; i++) {
                System.out.printf("Trying again... [%d,5]", i+1);
                System.out.println();
                tryDoIt();
                System.out.println(errorMessage());
            }
            logger.info(errorMessage());
        }
    }
    }

