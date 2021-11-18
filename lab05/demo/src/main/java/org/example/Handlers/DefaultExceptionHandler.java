package org.example.Handlers;

import org.example.Supplier.Supplier;

public class DefaultExceptionHandler implements ExceptionHandler{
    @Override
    public String getMessage() {
        return "Something went wrong!!";
    }

    @Override
    public void handle(Supplier method, Exception exc) {
        System.out.println(getMessage());
        logger.log(getMessage(),exc);
    }

    @Override
    public boolean canHandle(Exception err) {
        return true;
    }
}
