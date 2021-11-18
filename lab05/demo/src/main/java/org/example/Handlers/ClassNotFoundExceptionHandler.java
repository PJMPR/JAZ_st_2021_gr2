package org.example.Handlers;

import org.example.Supplier.Supplier;

public class ClassNotFoundExceptionHandler implements ExceptionHandler{

    @Override
    public String getMessage() {
        return "Couldn't find that class";
    }

    @Override
    public void handle(Supplier method, Exception exc) {
        if (canHandle(exc)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception exc) {
        return exc instanceof ClassNotFoundException;
    }
}
