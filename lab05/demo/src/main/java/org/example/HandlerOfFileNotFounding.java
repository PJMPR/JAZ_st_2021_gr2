package org.example;

import org.apache.log4j.Logger;
import java.io.FileNotFoundException;

public class HandlerOfFileNotFounding implements HandlerOfErrors {
    private final Logger logger = Logger.getLogger(HandlerOfFileNotFounding.class.getName());

    @Override
    public String getMessage() {
        return "File not found. Maybe the file path is wrong?";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof FileNotFoundException;
    }

    @Override
    public boolean handle(Exception e, SupplierOfErrors method) {
        if(canHandle(e)){
            System.out.println(getMessage());
            log();
            return true;
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}
