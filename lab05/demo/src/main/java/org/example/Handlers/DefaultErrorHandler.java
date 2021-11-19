package org.example.Handlers;

import org.apache.log4j.Logger;
import org.example.Provider.Provider;

public class DefaultErrorHandler implements Handler {
    private final Logger logger = Logger.getLogger(DefaultErrorHandler.class.getName());
    private boolean canHandle = true;

    @Override
    public String getMessage() {
        return "Unknown error";
    }

    @Override
    public boolean canHandle(Exception exception) {
        return canHandle;
    }

    @Override
    public boolean handle(Exception exception, Provider method) {
        System.out.println(getMessage());
        log();
        return true;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }
}