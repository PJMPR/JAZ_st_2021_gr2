package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider.Provider;

import java.io.FileNotFoundException;

public class FileNotFoundHandler implements Handler {
    private final Logger logger = Logger.getLogger(FileNotFoundHandler.class.getName());

    @Override
    public String getMessage() {
        return "File not found, check file path";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof FileNotFoundException;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        if (canHandle(exception)) {
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