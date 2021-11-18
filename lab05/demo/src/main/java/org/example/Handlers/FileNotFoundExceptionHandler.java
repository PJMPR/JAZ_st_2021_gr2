package org.example.Handlers;

import org.example.Supplier.Supplier;

import java.io.FileNotFoundException;

public class FileNotFoundExceptionHandler implements ExceptionHandler {

    @Override
    public String getMessage() {
        return "File not found in this path!!";
    }

    @Override
    public void handle(Supplier method, Exception exc) {
        if(canHandle(exc)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception exc) {
        return exc instanceof FileNotFoundException;
    }
}
