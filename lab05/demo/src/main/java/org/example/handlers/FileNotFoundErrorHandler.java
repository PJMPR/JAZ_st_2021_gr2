package org.example.handlers;

import org.example.supplier.BasicSupplier;
import java.io.FileNotFoundException;

public class FileNotFoundErrorHandler implements ErrorHandler{

    @Override
    public String getMessage() {
        return "File was not found.";
    }

    @Override
    public void handle(Exception error, BasicSupplier method) {
        if(canHandle(error)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception error) {
        return error instanceof FileNotFoundException;
    }

}
