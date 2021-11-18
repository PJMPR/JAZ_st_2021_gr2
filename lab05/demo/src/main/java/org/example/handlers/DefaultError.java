package org.example.handlers;

import org.example.Provider;

public class DefaultError implements ErrorHandler{

    @Override
    public String getMessage() {
        return "default error";
    }

    @Override
    public void handle(Exception err, Provider method) {
        System.out.println(getMessage());
        logger.log(getMessage(),err);
    }

    @Override
    public boolean canHandle(Exception err) {
        return true;
    }
}