package org.example.handlers;

import org.example.supplier.BasicSupplier;

public class ClassNotFoundErrorHandler implements ErrorHandler{

    @Override
    public String getMessage() {
        return "Could not find that class.";
    }

    @Override
    public void handle(Exception error, BasicSupplier method) {
        if (canHandle(error)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception error) {
        return error instanceof ClassNotFoundException;

    }

}
