package org.example.handlers;

import org.example.Provider;

import java.io.FileNotFoundException;


public class FileNotFound implements ErrorHandler {

    @Override
    public String getMessage() {
        return "File not found";
    }

    @Override
    public void handle(Exception err, Provider method) {
        if(canHandle(err)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception err) {
        return err instanceof FileNotFoundException;
    }
}