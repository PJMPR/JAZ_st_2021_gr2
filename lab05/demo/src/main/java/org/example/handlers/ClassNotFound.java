package org.example.handlers;

import org.apache.log4j.Logger;
import org.example.Provider;

public class ClassNotFound implements Handler {
    private final Logger logger = Logger.getLogger(ClassNotFound.class.getName());

    @Override
    public String info() {return "NOT FOUND";}

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof ClassNotFoundException;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        if (canHandle(exception)){
            System.out.println(info());
            log();
            return true;
        }
        return false;
    }

    @Override
    public void log() {
        logger.error(info());
    }
}