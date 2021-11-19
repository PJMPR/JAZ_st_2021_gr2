package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider.Provider;

public class ClassNotFoundHandler implements Handler {
    private final Logger logger = Logger.getLogger(ClassNotFoundHandler.class.getName());

    @Override
    public String getMessage() {
        return "Class not found";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof ClassNotFoundException;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        if (canHandle(exception)){
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