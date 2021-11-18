package org.example;

import org.apache.log4j.Logger;

public class DefaultHandlerOfErrors implements HandlerOfErrors{
    private final Logger logger = Logger.getLogger(DefaultHandlerOfErrors.class.getName());
    private boolean canHandle = true;

    @Override
    public String getMessage() {
        return "Unknown error occured.";
    }

    @Override
    public boolean canHandle(Exception e) {
        return canHandle;
    }

    @Override
    public boolean handle(Exception e, SupplierOfErrors method) {
        System.out.println(getMessage());
        log();
        return true;
    }

    @Override
    public void log() {
        logger.error(getMessage());
    }

}

