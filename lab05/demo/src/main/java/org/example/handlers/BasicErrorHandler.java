package org.example.handlers;

import org.example.supplier.BasicSupplier;

public class BasicErrorHandler implements ErrorHandler{

    @Override
    public String getMessage() {
        return "Something went wrong sorry.";
    }

    @Override
    public void handle(Exception error, BasicSupplier method) {
            System.out.println(getMessage());
            logger.log(getMessage());
    }

    @Override
    public boolean canHandle(Exception error) {
        return true;
    }

}
