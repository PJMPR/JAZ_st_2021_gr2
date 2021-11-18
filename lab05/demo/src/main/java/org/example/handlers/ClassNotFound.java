package org.example.handlers;

import org.example.Provider;

public class ClassNotFound implements ErrorHandler {
    @Override
    public String getMessage() {
        return "class not found";
    }

    @Override
    public void handle(Exception err, Provider method) {
        if (canHandle(err)){
            System.out.println(getMessage());
            logger.log(getMessage());
        }
    }

    @Override
    public boolean canHandle(Exception err) {
        return err instanceof ClassNotFoundException;
    }

}
