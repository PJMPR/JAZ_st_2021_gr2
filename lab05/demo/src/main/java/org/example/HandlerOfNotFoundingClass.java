package org.example;

import org.apache.log4j.Logger;

public class HandlerOfNotFoundingClass implements HandlerOfErrors {
    private final Logger logger = Logger.getLogger(HandlerOfNotFoundingClass.class.getName());

    @Override
    public String getMessage() {
        return "Class not found.";
    }

    @Override
    public boolean canHandle(Exception e) {
        return e instanceof ClassNotFoundException;
    }

    @Override
    public boolean handle(Exception e, SupplierOfErrors method) {
        if (canHandle(e)){
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
